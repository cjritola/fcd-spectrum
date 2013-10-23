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
package com.ritolaaudio.fcdspectrum.tuner;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Line;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.Mixer;
import javax.sound.sampled.Mixer.Info;
import javax.sound.sampled.TargetDataLine;

import com.ritolaaudio.jfcdpp.TunerException;
import com.ritolaaudio.jfcdpp.javahidapi.Dongles;//Change this package to change backends
import com.ritolaaudio.jfcdpp.javahidapi.FCDPP;//Change this package to change backends

public class FCDPPTuner implements Tuner
	{
	private FCDPP dongle;
	private TargetDataLine capture;
	private double dongleTunerFrequency;
	
	//private static final int NUM_CHANNELS=2;
	//private static final int BYTES_PER_SAMPLE=4;
	//private static final int SAMPLE_RATE=192000;
	//private static final int FRAME_SIZE_BYTES=BYTES_PER_SAMPLE*NUM_CHANNELS;
	//private static final int BUFFER_SIZE_FRAMES=1024;
	//private final int BUFFER_SIZE_BYTES=BUFFER_SIZE_FRAMES*FRAME_SIZE_BYTES;
	//private static final double STEP_SIZE=SAMPLE_RATE;
	private Logger log;
	
	//private final byte[] bufferArray = new byte[BUFFER_SIZE_BYTES];
	//private final ByteBuffer byteBuffer = ByteBuffer.wrap(bufferArray).order(ByteOrder.BIG_ENDIAN);
	//private final IntBuffer intBuffer = byteBuffer.asIntBuffer();
	//private BufferFormat bufferFormat;
	
	public FCDPPTuner() throws AudioCaptureAcquisitionException, FuncubeNotFoundException, IOException
		{this(Logger.getGlobal());}
	
	public FCDPPTuner(Logger logger) throws AudioCaptureAcquisitionException, FuncubeNotFoundException, IOException
		{
		List<FCDPP> dongles= Dongles.getDongles();
		log=logger;
		if(dongles.isEmpty()){throw new FuncubeNotFoundException("Failed to find a FunCube Dongle");}
		dongle = dongles.get(0);
		dongle.setFrequency(91900000);
		dongle.setIFGain(0);
		dongle.setLNA(false);
		dongle.setMixerGain(false);
		getAudioDevice();
		}

	public void setLogger(Logger l){log=l;}
	
	private void getAudioDevice() throws AudioCaptureAcquisitionException
		{
		for(Info mixerInfo:AudioSystem.getMixerInfo())
			{
			System.out.println("\n Mixer: "+mixerInfo.getName()+
					"\n Vendor: "+mixerInfo.getVendor()+
					"\n Version: "+mixerInfo.getVersion()+
					"\n Description: "+mixerInfo.getDescription());
			if(mixerInfo.getName().contains("V20") && mixerInfo.getDescription().contains("FUNcube Dongle")||//Linux
					mixerInfo.getName().toUpperCase().contains("FUNCUBE"))//Windows displays it differently
				{//Probably found it.
				Mixer mixer = AudioSystem.getMixer(mixerInfo);
				try
				{mixer.open();}
				catch(LineUnavailableException e){throw new AudioCaptureAcquisitionException(e);}
				//System.out.println("Found candidate: "+mixerInfo.getName()+" "+mixerInfo.getDescription());
				//System.out.println(mixer.getTargetLineInfo().length);
				Line.Info[] lineInfos = mixer.getTargetLineInfo();
				if(lineInfos.length>=1)
					{
					if(lineInfos.length>1){log.warning("Candidate capture card"+mixerInfo.getDescription()+" has more than 1 port! Assuming first port.");}
					Line.Info lineInfo = lineInfos[0];
					try
						{
						TargetDataLine line = (TargetDataLine)mixer.getLine(lineInfo);
						//System.out.println("Line buffer size: "+line.getBufferSize());
						line.open(new AudioFormat(192000, 16, 2, true,true),1024);//16->32
						//System.out.println("Line format: "+line.getFormat());
						capture=line;
						return;
						}
					catch(LineUnavailableException e)
						{throw new AudioCaptureAcquisitionException(e);}
					}
				else
					{
					throw new AudioCaptureAcquisitionException("Found a likely card but it doesn't have any capture ports.");
					}
				/*for(Line.Info lInfo:mixer.getTargetLineInfo())
					{
					System.out.println(lInfo);
					}*/
				}//end if(V20)
			}//end for(MixerInfo)
		if(capture==null){throw new AudioCaptureNotFoundException("Consider unplugging the dongle, wait 5 seconds and re-plugging it in, wait another 5 seconds and retry.");}
		}//end getAudioDevice()
	
	@Override
	public void setFrequency(int frequencyInHz)
		{
		dongleTunerFrequency=frequencyInHz;
		dongle.setFrequency(frequencyInHz);
		}

	@Override
	public void setGain(int requestedGainInDb)
		{
		if(dongleTunerFrequency>32000000){requestedGainInDb-=30;}
		
		if(requestedGainInDb>20)
			{dongle.setLNA(true);requestedGainInDb-=20;}
		else{dongle.setLNA(false);}
		if(requestedGainInDb>12)
			{dongle.setMixerGain(true);
			requestedGainInDb-=12;}
		else{dongle.setMixerGain(false);}
		if(requestedGainInDb>=0)dongle.setIFGain(requestedGainInDb);
		}
	/*
	@Override
	public void read(double [] workBuffer)
		{
		final DoubleBuffer complexBuffer = DoubleBuffer.wrap(workBuffer);
		int framesRead;
		final int bytesRead=capture.read(bufferArray, 0, BUFFER_SIZE_BYTES);
		framesRead=bytesRead/FRAME_SIZE_BYTES;
		complexBuffer.clear();
		byteBuffer.clear();
		intBuffer.clear();
		//peakMagnitude=0;
		for(int i=0; i<framesRead; i++)
			{
			final double real=(double)intBuffer.get()/(double)Integer.MAX_VALUE;
			final double complex=(double)intBuffer.get()/(double)Integer.MAX_VALUE;
			//final double magnitude = Math.sqrt(real*real+complex*complex);
			complexBuffer.put(real);
			complexBuffer.put(complex);
			//peakMagnitude=magnitude>peakMagnitude?magnitude:peakMagnitude;
			}
		}
	*/

	@Override
	public TargetDataLine getTargetDataLine()
		{return capture;}

	@Override
	public void release()
		{dongle.close();}

	@Override
	public String getVendor() throws IOException
		//{return dongle.getVendor();}
		{return "";}

	@Override
	public String getModel() throws IOException
		//{return dongle.getModel();}
		{return "";}

	@Override
	public String getSerial() throws IOException
		//{return dongle.getSerial();}
		{return "";}
	}//end FCDPPTuner
