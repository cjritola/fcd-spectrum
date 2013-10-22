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
import java.util.logging.Level;
import java.util.logging.Logger;

public class CLI implements SweepProcessFeedback
	{
	Logger log = new CLILogger();
	private static final String COMMAND_NAME="java -jar FCDSpectrum.jar";
	private SweepProcess sweep;
	
	public CLI(String [] args)
		{
		if(args.length!=3)
			{printUsageInstructions("");return;}
		log.setLevel(Level.ALL);
		Log.setLogger(log);
		int startFreq=0,endFreq=0;File outputFile;
		try{startFreq=Integer.parseInt(args[0]);}
		catch(NumberFormatException e){printUsageInstructions("start_frequency_hz must be a whole number in hertz, with no unit label.");return;}
		try{endFreq=Integer.parseInt(args[1]);}
		catch(NumberFormatException e){printUsageInstructions("end_frequency_hz must be a whole number in hertz, with no unit label.");return;}
		outputFile=new File(args[2]);
		try {sweep = new SweepProcess(new SweepJob(startFreq,endFreq,new File("test.csv"),log));}
		catch(IllegalArgumentException e){log.severe(e.getLocalizedMessage());return;}
		try{sweep.startSweep(this);}
		catch(Exception e){log.severe(e.getLocalizedMessage());return;}
		}
	
	private void printUsageInstructions(String comment)
		{System.out.println(comment+"\nUSAGE: "+COMMAND_NAME+" start_frequency_hz end_frequency_hz outputFile");}
	
	@Override
	public void initializing()
		{log.info("Initializing sweep..");}

	@Override
	public void ready()
		{
		}

	@Override
	public void performingSample(int startFrequency, int gain, int step)
		{log.info("Performing sample at start frequency: "+startFrequency+"Hz and gain of "+gain+"dB."+" on step "+step+" of "+sweep.getNumSteps());}

	@Override
	public void sweepComplete()
		{
		log.info("Sweep complete.");
		}

	@Override
	public void savingSweep(File target)
		{
		log.info("Saving sweep as:\t"+target.getAbsolutePath());
		}
	
	}
