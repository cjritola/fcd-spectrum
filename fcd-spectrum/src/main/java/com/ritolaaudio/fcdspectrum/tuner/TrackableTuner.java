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

import javax.sound.sampled.TargetDataLine;

import com.ritolaaudio.jfcdpp.TunerException;

public class TrackableTuner implements Tuner
	{
	Tuner tuner;
	int frequency,gain;
	public TrackableTuner(Tuner tunerToWrap) throws AudioCaptureAcquisitionException
		{this.tuner=tunerToWrap;}
	@Override
	public void setFrequency(int frequencyInHz) throws TunerException
		{
		tuner.setFrequency(frequencyInHz);
		frequency=frequencyInHz;
		}
	@Override
	public void setGain(int gainInDb) throws TunerException
		{
		tuner.setGain(gainInDb);
		gain=gainInDb;
		}
	@Override
	public TargetDataLine getTargetDataLine() throws TunerException
		{return tuner.getTargetDataLine();}
	
	public int getFrequencyInHz(){return frequency;}
	public int getGainInDb(){return gain;}
	@Override
	public void release() throws TunerException
		{
		tuner.release();
		tuner.getTargetDataLine().close();
		}
	@Override
	public String getVendor() throws IOException
		{return tuner.getVendor();}
	@Override
	public String getModel() throws IOException
		{return tuner.getModel();}
	@Override
	public String getSerial() throws IOException
		{return tuner.getSerial();}
	}//end Track
