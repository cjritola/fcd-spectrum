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

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Configuration
	{
	private double dbCalibrationOffset=0;
	private String outputCSVPath="output.csv";
	private int startFreq=88000000;
	private int endFreq=108000000;
	
	public static final Configuration CONFIGURATION = loadConfiguration();
	static
		{
		Runtime.getRuntime().addShutdownHook(new Thread()
			{
			@Override
			public void run()
				{Configuration.saveConfiguration();}
			});
		}//end static
	
	private static Configuration loadConfiguration()
		{
		File cFile=new File("config.xml");
		try {
			FileInputStream fis = new FileInputStream(cFile);
			XMLDecoder dec = new XMLDecoder(fis);
			return (Configuration)dec.readObject();
			}
		catch(FileNotFoundException e)
			{return new Configuration();}//Go with default
		}//end configuration()
	
	static void saveConfiguration()
		{
		File cFile=new File("config.xml");
		if(!cFile.exists()){try{cFile.createNewFile();}catch(Exception e){e.printStackTrace();}}
		try {
			FileOutputStream fos = new FileOutputStream(cFile);
			XMLEncoder enc = new XMLEncoder(fos);
			enc.writeObject(CONFIGURATION);
			enc.close();
			fos.close();
			}
		catch(Exception e)
			{e.printStackTrace();}//Shouldn't happen.
		}//end saveConfiguration
	
	public Configuration(){}

	/**
	 * @return the dbCalibrationOffset
	 */
	public double getDbCalibrationOffset()
		{
		return dbCalibrationOffset;
		}

	/**
	 * @param dbCalibrationOffset the dbCalibrationOffset to set
	 */
	public void setDbCalibrationOffset(double dbCalibrationOffset)
		{
		this.dbCalibrationOffset = dbCalibrationOffset;
		}

	/**
	 * @return the outputCSVPath
	 */
	public String getOutputCSVPath()
		{
		return outputCSVPath;
		}

	/**
	 * @param outputCSVPath the outputCSVPath to set
	 */
	public void setOutputCSVPath(String outputCSVPath)
		{
		this.outputCSVPath = outputCSVPath;
		}

	/**
	 * @return the startFreq
	 */
	public int getStartFreq()
		{
		return startFreq;
		}

	/**
	 * @param startFreq the startFreq to set
	 */
	public void setStartFreq(int startFreq)
		{
		this.startFreq = startFreq;
		}

	/**
	 * @return the endFreq
	 */
	public int getEndFreq()
		{
		return endFreq;
		}

	/**
	 * @param endFreq the endFreq to set
	 */
	public void setEndFreq(int endFreq)
		{
		this.endFreq = endFreq;
		}
	}//end Configuration
