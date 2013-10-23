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

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.DoubleBuffer;
import java.nio.ShortBuffer;

import javax.sound.sampled.TargetDataLine;

import com.ritolaaudio.fcdspectrum.tuner.Tuner;
import com.ritolaaudio.jfcdpp.TunerException;

public class SampleReader
	{
	//private final DoubleBuffer complexBuffer = DoubleBuffer.wrap(new double[1024*2]);
	private final ByteBuffer byteBuffer = ByteBuffer.wrap(new byte[4*1024*2]).order(ByteOrder.BIG_ENDIAN);
	private final ShortBuffer shortBuffer = byteBuffer.asShortBuffer();
	private final Tuner tuner;
	private final TargetDataLine line;
	private double peakMagnitude=0;
	//private final int bufferSizeInFrames;
	
	public SampleReader(Tuner t)
		{
		//this.bufferSizeInFrames=bufferSizeInFrames;
		tuner=t;
		TargetDataLine result=null;
		try{result=t.getTargetDataLine();}
		catch(TunerException e){e.printStackTrace();}
		line=result;
		}
	
	public Tuner getTuner(){return tuner;}
	
	public int readNormalized(double [] bufferToUse)
		{
		int framesRead;
		final int bytesToRead=(bufferToUse.length*(line.getFormat().getSampleSizeInBits()/8));
		//System.out.println("bytesToRead="+bytesToRead+" sampleSizeInBits="+line.getFormat().getSampleSizeInBits());
		//for(int i=0; i<30; i++)line.read(byteBuffer.array(), 0, bytesToRead);//This eats the zero chunks.
		//while(line.available()<bytesToRead){try{Thread.sleep(50);System.out.println("avail: "+line.available());}catch(InterruptedException e){e.printStackTrace();}}
		//if(line.available()<bytesToRead)System.out.println("Underflow ahead... "+line.available());
		line.start();
		final int bytesRead=line.read(byteBuffer.array(), 0, bytesToRead);
		framesRead=(bytesRead)/line.getFormat().getFrameSize();
		//System.out.println("frames read: "+framesRead);
		DoubleBuffer complexBuffer = DoubleBuffer.wrap(bufferToUse);
		byteBuffer.clear();
		shortBuffer.clear();
		peakMagnitude=0;
		if(framesRead*2!=bufferToUse.length)System.out.println("Frame size mismatch. Expected "+bufferToUse.length+" got "+framesRead*2);
		//final double WORD_SCALE=(long)Math.pow(2, line.getFormat().getSampleSizeInBits()-1);
		for(int i=0; i<framesRead; i++)
			{
			final double real=(double)shortBuffer.get()/(double)Short.MAX_VALUE;
			final double complex=(double)shortBuffer.get()/(double)Short.MAX_VALUE;
			final double magnitude = Math.sqrt(real*real+complex*complex);
			complexBuffer.put(real);
			complexBuffer.put(complex);
			//if(magnitude==0)System.err.println("Zero magnitude occurrance: i="+real+" j="+complex+" index="+i);
			peakMagnitude=magnitude>peakMagnitude?magnitude:peakMagnitude;
			}
		line.stop();
		return framesRead;
		}
	
	public double getPeakMagnitude(){return peakMagnitude;}
	
	/**
	 * Clears the current buffer state to ensure that the next read is the most recent.
	 * 
	 * @since Jun 27, 2013
	 */
	public void flush()
		{line.flush();}
	
	/**
	 * Closes the audio line
	 * 
	 * @since Jun 27, 2013
	 */
	public void close()
		{line.close();}
	}//end NormalizedSampleReader
