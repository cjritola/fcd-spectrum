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

import com.ritolaaudio.jfcdpp.TunerException;

import edu.emory.mathcs.jtransforms.fft.DoubleFFT_1D;

public class FFTReader
	{
	private final SampleReader reader;
	private final int bufferSizeInFrames;
	private final double [] buffer;
	private final DoubleFFT_1D fft;
	private final double FFT_DIV_SIZE;
	
	public FFTReader(SampleReader nsReader, int bufferSizeInFrames) throws TunerException
		{
		this.reader=nsReader;
		this.bufferSizeInFrames=bufferSizeInFrames;
		buffer=new double[bufferSizeInFrames*2];
		fft = new DoubleFFT_1D(bufferSizeInFrames);
		FFT_DIV_SIZE=nsReader.getTuner().getTargetDataLine().getFormat().getSampleRate()/bufferSizeInFrames;
		//System.out.println("Created FFT for buffer size of "+bufferSizeInFrames);
		}
	
	public double [] readFFT()
		{
		reader.readNormalized(buffer);
		fft.complexForward(buffer);
		//Maybe my FFT understanding is cloudy but it seems that this FFT is performing a summation rather than an integration and causing uuber-high coeffs? - chuck
		//Kludge to scale down to sane values on assumption that the final division necessary for integration was not included in calculation.
		for(int i=0; i<buffer.length;i++){buffer[i]/=bufferSizeInFrames;}
		return buffer;
		}
	
	/**
	 * The size of each FFT frame, in hertz.<br>
	 * Defined by sampleRate / bufferSizeInFrames;
	 * @return
	 * @since Jun 27, 2013
	 */
	public double getFFTDivSize()
		{
		return FFT_DIV_SIZE;
		}
	
	public int getBufferSizeInFrames()
		{return bufferSizeInFrames;}
	
	public SampleReader getReader()
		{return reader;}
	}
