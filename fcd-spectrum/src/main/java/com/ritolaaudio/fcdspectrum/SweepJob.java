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
import java.util.logging.Logger;

public class SweepJob
	{
	private double startFrequency,endFrequency;
	private File targetFile;
	private int bufferSize=1024;
	private Logger log;
	
	public SweepJob(double startFrequency, double endFrequency, File targetFile, Logger log) throws IllegalArgumentException
		{
		if(startFrequency<getMinFrequency() || startFrequency>getMaxFrequency())
			throw new IllegalArgumentException("Start frequency must be between "+getMinFrequency()+" and "+getMaxFrequency()+". Got "+startFrequency);
		if(endFrequency<getMinFrequency() || endFrequency>getMaxFrequency())
			throw new IllegalArgumentException("End frequency must be between "+getMinFrequency()+" and "+getMaxFrequency()+". Got "+startFrequency);
		this.startFrequency=startFrequency;
		this.endFrequency=endFrequency;
		this.targetFile=targetFile;
		this.log=log;
		}
	
	public Logger getLog(){return log;}
	
	protected int getMinFrequency(){return 150000;}
	protected int getMaxFrequency(){return 2050000000;}
	/**
	 * @return the startFrequency
	 */
	public double getStartFrequency()
		{
		return startFrequency;
		}
	/**
	 * @return the endFrequency
	 */
	public double getEndFrequency()
		{
		return endFrequency;
		}
	/**
	 * @return the targetFile
	 */
	public File getTargetFile()
		{
		return targetFile;
		}
	/**
	 * @return the bufferSize
	 */
	public int getBufferSizeInFrames()
		{
		return bufferSize;
		}	
	}//end SweepJob
