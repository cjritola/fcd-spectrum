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
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CLI implements SweepProcessFeedback
	{
	Logger log = new CLILogger();
	private static final String COMMAND_NAME="java -jar FCDSpectrum.jar";
	private SweepProcess sweep;
	private final Map<String,String>argMap;
	private boolean goodToGo=true;
	
	public CLI(String [] args){
	    	System.out.println();
	    	int startFreq=0,endFreq=0,fftSize;
	    	File outputFile;
	    	Integer manualGain=null;
	    	argMap = argumentMap(args);
	    	
	    	if(goodToGo){
	    	 log.setLevel(Level.ALL);
		 Log.setLogger(log);
		
		 startFreq=intArg("start_freq_hz",0,true);
		 endFreq=intArg("end_freq_hz",0,true);
		 outputFile=new File(stringArg("output_file","test.csv",false));
		 manualGain=intArg("manual_gain",-9999,false);
		 fftSize=intArg("fft_size",1024,false);
		 if((fftSize & (fftSize - 1)) != 0){
		    log.warning("fft_size="+fftSize+" is not a power of two. Defaulting to 1024");
		    fftSize=1024;}
		 if(manualGain==-9999)manualGain=null;
	    	}//end if(goodToGo)
	    	else{
	    	 printUsageInstructions("");
		 return;
	    	}//end fail
		
		try {
		    Configuration.CONFIGURATION.setFftSize(fftSize);
		    Configuration.CONFIGURATION.setManualGain(manualGain);
		    Configuration.CONFIGURATION.setStartFreq(startFreq);
		    Configuration.CONFIGURATION.setEndFreq(endFreq);
		    
		    sweep = new SweepProcess(new SweepJob(startFreq,endFreq,manualGain,outputFile,fftSize,log));}
		catch(IllegalArgumentException e){log.severe(e.getLocalizedMessage());return;}
		try{sweep.startSweep(this);}
		catch(Exception e){log.severe(e.getLocalizedMessage());return;}
		}
	
	private int intArg(String argName, int defaultValue, boolean required){
	    int result=defaultValue;
	    try{result=Integer.parseInt(argMap.get(argName));}
		catch(NumberFormatException e){System.out.println(argName+" must be a whole number with no unit label.");}
		catch(NullPointerException e){if(required){printUsageInstructions("Must specify "+argName);goodToGo=false;}}
	    return result;
	}
	
	private String stringArg(String argName, String defaultValue, boolean required){
	    String result=defaultValue;
	    result=(argMap.get(argName));
	    if(result==null){
		result=defaultValue;
		if(required){printUsageInstructions("Must specify "+argName);
		goodToGo=false;}}
	    return result;
	}
	
	private void printUsageInstructions(String comment)
		{System.out.println(comment+"\nUSAGE: "+COMMAND_NAME+" start_freq_hz=int  end_freq_hz=int\n"+
			"Optional args:\n"+
			"\tmanual_gain=int\n"+
			"\toutput_file=string (defaults to test.csv)\n"+
			"\tfft_size=int (defaults to 1024) must be a power of two (64,128,256, etc)");}
	
	private Map<String,String> argumentMap(String [] args){
	    final HashMap<String,String> result = new HashMap<String,String>(); 
	    for(String s:args){
		if(!s.contains("=")){
		    log.severe("Invalid argument '"+s+"' Entries must be formatted as `variable=value` expression.");
		    goodToGo=false;
		    result.clear();
		    return result;}
		final int pos=s.indexOf('=');
		final String left=s.substring(0, pos);
		final String right=s.substring(pos+1, s.length());
		if(left.length()==0){
		    log.severe("Invalid argument '"+s+"' Entries must have a left operand in expression `variable=value`. Check for extra spaces.");
		    goodToGo=false;
		    result.clear();
		    return result;}
		if(right.length()==0){
		    log.severe("Invalid argument '"+s+"' Entries must have a right operand in expression `variable=value`. Check for extra spaces.");
		    goodToGo=false;
		    result.clear();
		    return result;}
		result.put(left, right);
	    }
	    return result;
	}//end argumentMap
	
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
