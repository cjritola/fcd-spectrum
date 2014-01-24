/*******************************************************************************
 * Copyright (c) 2013 Chuck Ritola
 * This file is part of fcd-spectrum.
 * A Sweeping Spectrum Analyzer for the FUNCube Dongle Pro+
 * 
 * fcd-spectrum is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 ******************************************************************************/
package com.ritolaaudio.fcdspectrum;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Logger;

import com.ritolaaudio.fcdspectrum.tuner.AudioCaptureAcquisitionException;
import com.ritolaaudio.fcdspectrum.tuner.FCDPPTuner;
import com.ritolaaudio.fcdspectrum.tuner.FuncubeNotFoundException;
import com.ritolaaudio.fcdspectrum.tuner.TimeoutFencedTuner;
import com.ritolaaudio.fcdspectrum.tuner.TrackableTuner;
import com.ritolaaudio.jfcdpp.TunerException;

public class SweepProcess implements SweepControl
	{
	private PrintStream ps;
	private double [] sweepData;
	
	private static final double SATURATION_DBM_NOGAIN = 4;
	private int numSteps;
	private final SweepJob job;
	private TrackableTuner tuner;
	private SampleReader reader;
	private FFTReader fftReader;
	private double [] complexBuffer;
	private double FREQUENCY_FFT_UNIT_SIZE;
	private SweepProcessFeedback feedback;
	private boolean running=true;
	private Logger log;
	
	public SweepProcess(SweepJob job)
		{this.job=job; log=job.getLog();}
	
	@Override
	public void startSweep(final SweepProcessFeedback feedback) throws AudioCaptureAcquisitionException, FuncubeNotFoundException, IOException, TunerException
		{
		log.info("SweepProcess.startSweep() Starting sweep process...");
		SweepProcess.this.feedback=feedback;
		log.info("Creating tuner...");
		tuner = new TrackableTuner(new TimeoutFencedTuner(new FCDPPTuner(log,Configuration.CONFIGURATION.getBackend())));
		log.info("Creating SampleReader...");
		reader = new SampleReader(tuner);
		log.info("Creating FFT Reader...");
		try{fftReader = new FFTReader(reader,job.getFFTSizeInFrames());
		SweepProcess.this.FREQUENCY_FFT_UNIT_SIZE=(double)tuner.getTargetDataLine().getFormat().getSampleRate()/(double)job.getFFTSizeInFrames();}
		catch(TunerException e){e.printStackTrace();}
		log.info("FFT unit size is "+SweepProcess.this.FREQUENCY_FFT_UNIT_SIZE+" Hz");
		complexBuffer = new double[job.getFFTSizeInFrames()*2];
		log.info("Created complexBuffer of size "+complexBuffer.length);
		log.info("Creating PrintStream for target file");
		final File targetFile = job.getTargetFile();
		if(!targetFile.exists())
			{
			log.info("Attempting to create file "+targetFile.getAbsolutePath());
			if(!targetFile.createNewFile())
				{throw new IOException("Failed to create new file:\n"+targetFile.getAbsolutePath());}
			}
		ps = new PrintStream(new FileOutputStream(job.getTargetFile()));
		setupSweep();
		record();
		}//end startSweep(...)
	
	private void setupSweep()
		{
		log.info("setting up sweep...");
		final double width=job.getEndFrequency()-job.getStartFrequency();
		try{numSteps = (int)Math.ceil(width/tuner.getTargetDataLine().getFormat().getSampleRate())+1;}
		catch(TunerException e){e.printStackTrace();}
		sweepData=new double[(int)(width/FREQUENCY_FFT_UNIT_SIZE)];
		log.info("width="+width+", numSteps="+numSteps+" sweepData.length="+sweepData.length);
		//System.out.println("sweepData size: "+sweepData.length);
		}
	
	private void record()
		{
		log.info("SweepProcess.record()");
		final Object captureWait = new Object();
		final Object [] run = new Object[1];
		run[0]=new Object();
		if(job.getManualGain()!=null)totalDongleGainInDb=job.getManualGain();
		try{
		new Thread(){
			public void run(){
				Thread.currentThread().setName("Sweep Thread");
				log.info("Sweep thread started...");
				feedback.initializing();
				try{
				for(int step=0; step<numSteps;step++){
				  for(double subStep=step; subStep<step+.5; subStep+=.25){
				  adjustFrequency(subStep);
				  waitForStabilization();
				  measurePeak();
				  if(job.getManualGain()==null){
				    adjustGain();
				    waitForStabilization();
				   }else{try{
				      tuner.setGain((Integer)job.getManualGain());}
				   catch(TunerException e){e.printStackTrace();}}
						
				   performSample(subStep);
				   if(!running)throw new InterruptedException("Somebody set variable SweepProcess.running to 'false.' Probably clicked `abort`.");
				    }
				}//end while(isActive)
				feedback.sweepComplete();
				feedback.savingSweep(job.getTargetFile());
				ps.println("Frequency(Hz),Amplitude(dBm)");
				for(int i=0; i<sweepData.length;i++)
				 {ps.println((double)i*FREQUENCY_FFT_UNIT_SIZE+job.getStartFrequency()+","+sweepData[i]);}
				}//end try{}
				catch(InterruptedException e){log.warning("Sweep thread loop interrupted due to InterruptedException: "+e.getLocalizedMessage());}
				ps.close();
				synchronized(captureWait){captureWait.notifyAll();}
				}//end run()
			   }.start();
			//Wait for the thread to finish.
			synchronized(captureWait){try{captureWait.wait();}catch(InterruptedException e){e.printStackTrace();}}
			tuner.getTargetDataLine().stop();
			feedback.ready();
			}
		catch(Exception e){e.printStackTrace();}
		try{tuner.release();}
		catch(TunerException e){e.printStackTrace();}
		}//end record()
	
	private void adjustFrequency(final double step)
		{
		try{final int newFrequency = (int)((step)*(double)tuner.getTargetDataLine().getFormat().getSampleRate()+job.getStartFrequency());
		tuner.setFrequency(newFrequency);}
		catch(TunerException e){e.printStackTrace();}
		}//end adjustFrequency(...)
	
	private int framesRead;
	//private double peakMagnitude;
	private int funcubeGainInDb=0;
	private static final double IDEAL_GAIN=0.025;
	private double totalDongleGainInDb=0;
	//private double funcubeFrequency;
	
	private void adjustGain()
		{
				log.info("SweepProcess.adjustGain()...");
				double adjustmentInGain = IDEAL_GAIN/reader.getPeakMagnitude();
				double adjustmentInDb = gain2Db(adjustmentInGain);
				/*System.out.print("peak magnitude: "+reader.getPeakMagnitude()+" ideal magnitude: "+IDEAL_GAIN+"\n"+
							"adjustment total gain (dB): "+adjustmentInDb+" original total gain (dB):"+funcubeGainInDb+"\n");*/
				funcubeGainInDb+=adjustmentInDb;
				//System.out.println("Setting total gain to "+funcubeGainInDb+" dB.");
				if(funcubeGainInDb<0)funcubeGainInDb=0;
				setTotalDongleGain(funcubeGainInDb);
		}//end adjustGain()
	
	private double value2DbM(double value)
		{return gain2Db(value)+SATURATION_DBM_NOGAIN-totalDongleGainInDb;}
	
	private void performSample(final double step)
		{

				feedback.performingSample(tuner.getFrequencyInHz(),tuner.getGainInDb(),(int)step);
				final double [] fftBuffer = fftReader.readFFT();
				//Magnitude is the hypotenuse of real and complex
				final int F_MAX=job.getFFTSizeInFrames()/2;
				for(int s=0; s<framesRead; s++)
					{
					//TODO: Look into if this wraparound may actually be the result of I/Q being backwards.
					final int fIndex=(s+F_MAX)%job.getFFTSizeInFrames();
					final int sweepIndex=(int)(((step-.5)*(double)job.getFFTSizeInFrames()))+s;
					//Double-Triangular weighting
					final double weight = ((framesRead/2)-Math.abs(((2*s)%framesRead)-(framesRead/2)))/(double)(framesRead/2);
					final double valueToWrite = 
							weight*(Configuration.CONFIGURATION.getDbCalibrationOffset()+value2DbM((Math.sqrt(Math.pow(fftBuffer[fIndex*2],2)+(Math.pow(fftBuffer[fIndex*2+1],2))))));
					//if(valueToWrite==Double.NEGATIVE_INFINITY)System.err.println("Neg inf at index="+sweepIndex);
					if(sweepIndex>=0 && sweepIndex<sweepData.length)
						sweepData[sweepIndex]+=
						valueToWrite;
					else{/*System.out.println("Sweepdata index out of range: "+sweepIndex);*/}
					}//end for(s:framesRead)
		}//end performSample(...)
	
	private void setTotalDongleGain(int requestedGainInDb)
		{
		totalDongleGainInDb=requestedGainInDb;
		try{tuner.setGain(requestedGainInDb);}
		catch(TunerException e){e.printStackTrace();}
		}
	
	private static double dB2Gain(double gainInDb)
		{return Math.pow(10,(gainInDb/10));}
	private static double gain2Db(double gain)
		{return 10.*Math.log(gain);}
	
	private void waitForStabilization()
		{
		//System.out.println("Waiting to stabilize...");
		//TODO: Enforce a guaranteed stabilization period.
		readFuncube();
		}
	
	private void measurePeak()
		{readFuncube();}//The read action automatically finds the peak
	
	private void readFuncube()
		{
		reader.flush();
		framesRead=reader.readNormalized(complexBuffer);
		}//end readFuncube()

	@Override
	public void abortSweep()
		{running=false;}
	
	public int getNumSteps(){return numSteps;}
	
	}//end SweepProcess
