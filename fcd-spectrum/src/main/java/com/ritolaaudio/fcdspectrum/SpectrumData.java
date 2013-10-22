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

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.ritolaaudio.fcdspectrum.gui.SpectrumLoadProcessListener;

public class SpectrumData
	{
	private final ArrayList<Double> powerValues = new ArrayList<Double>();
	private int startFreq,endFreq;
	private double frequencyStep;
	private double bandwidth;
	private double minPower,maxPower;
	private HashMap<Integer,Integer> frequencyToIndexMap = new HashMap<Integer,Integer>();
	private ArrayList<SpectrumLoadProcessListener> spectrumLoadProcessListeners = new ArrayList<SpectrumLoadProcessListener>();
	private static final String MAGIC="Frequency(Hz),Amplitude(dBm)";
	private boolean isLoaded=false;
	private boolean isFailed=false;
	private Exception failureException=null;
	
	public SpectrumData(final InputStream csvData)
		{
		new Thread()
			{
			@Override
			public void run()
				{
				try
					{
					notifyLoading();
					BufferedReader lineReader = new BufferedReader(new InputStreamReader(csvData));
					try{if(!lineReader.readLine().contains(MAGIC)){throw new FileFormatException("CSV file must begin with the line: "+MAGIC);}}
					catch(EOFException e)
						{throw new FileFormatException("File is empty or malformed.");}
					catch(NullPointerException e)
						{throw new FileFormatException("File is empty or malformed.");}
					catch(IOException e)
						{throw new FileFormatException("CSV file must begin with the line: "+MAGIC);}
					
					String line;
					double frequency;
					double minValue=Double.POSITIVE_INFINITY,maxValue=Double.NEGATIVE_INFINITY;
					double minFreq=Double.POSITIVE_INFINITY,maxFreq=Double.NEGATIVE_INFINITY;
					
					while((line = lineReader.readLine())!=null)
						{
						String [] elements = line.split(",");
						final double value=Double.parseDouble(elements[1]);
						minValue=value<minValue&&value!=Double.NEGATIVE_INFINITY?value:minValue;
						maxValue=value>maxValue&&value!=Double.POSITIVE_INFINITY?value:maxValue;
						frequency=Double.parseDouble(elements[0]);
						minFreq=frequency<minFreq?frequency:minFreq;
						maxFreq=frequency>maxFreq?frequency:maxFreq;
						powerValues.add(value);
						}//end while(data available)
					
					//Set up this object
					SpectrumData.this.minPower=(int)minValue; SpectrumData.this.maxPower=(int)maxValue;
					//SpectrumData.this.startFreq=freqSet.first();
					//SpectrumData.this.endFreq=freqSet.last();
					SpectrumData.this.startFreq=(int)minFreq;
					SpectrumData.this.endFreq=(int)maxFreq;
					SpectrumData.this.bandwidth=endFreq-startFreq;
					SpectrumData.this.frequencyStep=bandwidth/(double)powerValues.size();
					isLoaded=true;
					notifyFinishedLoading();
					}
				catch(Exception e)
					{notifyException(e);}
				}//end run()
			}.start();
		}//end constructor()
	
	public SpectrumData(double [] values, int startFreq, int endFreq)
		{
		for(double v:values){powerValues.add(v);}
		this.startFreq=startFreq;
		this.endFreq=endFreq;
		this.bandwidth=endFreq-startFreq;
		this.frequencyStep=bandwidth/(double)values.length;
		int index=0;
		double minValue=Double.POSITIVE_INFINITY,maxValue=Double.NEGATIVE_INFINITY;
		for(double currentFrequency=startFreq; currentFrequency<endFreq;currentFrequency+=frequencyStep)
			{
			try {
				final double value = values[index];
				minValue=value<minValue&&value!=Double.NEGATIVE_INFINITY?value:minValue;
				maxValue=value>maxValue&&value!=Double.POSITIVE_INFINITY?value:maxValue;
				frequencyToIndexMap.put((int)currentFrequency, new Integer(index++));
				}
			catch(ArrayIndexOutOfBoundsException e){System.err.println("SpectrumData.<init> out of bounds.");}
			}
		this.minPower=minValue;
		this.maxPower=maxValue;
		}//end constructor()
	/*
	public SpectrumData subRange(int startFreq, int endFreq)
		{
		System.out.println("Getting subRange of "+startFreq+" to "+endFreq+" with global keyset size of "+frequencyToIndexMap.keySet().size());
		final TreeSet<Integer>newFrequencySet = new TreeSet<Integer>(
				new TreeSet<Integer>(frequencyToIndexMap.keySet()).
				subSet(startFreq, endFreq));
		final int numNewValues = newFrequencySet.size();
		System.out.println("Switching to "+numNewValues+" new values.");
		final double [] newValues = new double[numNewValues];
		int index=0;
		for(Integer frequency:newFrequencySet)
			{newValues[index++]=powerValues[frequencyToIndexMap.get(frequency)];}
		return new SpectrumData(newValues, startFreq,endFreq);
		}
*/
	/**
	 * @return the values
	 */
	public List<Double> getPowerValues()
		{
		return powerValues;
		}

	/**
	 * @return the startFreq
	 */
	public int getStartFreq()
		{
		return startFreq;
		}

	/**
	 * @return the endFreq
	 */
	public int getEndFreq()
		{
		return endFreq;
		}

	/**
	 * @return the bandwidth
	 */
	public double getBandwidth()
		{
		return bandwidth;
		}

	/**
	 * @return the minPower
	 */
	public double getMinPower()
		{
		return minPower;
		}

	/**
	 * @return the maxPower
	 */
	public double getMaxPower()
		{
		return maxPower;
		}

	/**
	 * @return the frequencyStep
	 */
	public double getFrequencyStep()
		{
		return frequencyStep;
		}

	public double getDynamicRange()
		{
		return getMaxPower()-getMinPower();
		}
	
	private synchronized void notifyLoading()
		{
		for(SpectrumLoadProcessListener l:spectrumLoadProcessListeners)
			{l.loadingSpectrum();}
		}
	
	private synchronized void notifyFinishedLoading()
		{
		for(SpectrumLoadProcessListener l:spectrumLoadProcessListeners)
			{l.spectrumLoaded();}
		}
	private synchronized void notifyException(Exception ex)
		{
		for(SpectrumLoadProcessListener l:spectrumLoadProcessListeners)
			{l.exception(ex);}
		failureException=ex;
		isFailed=true;
		}
	
	public synchronized void addSpectrumLoadProcessListener(
			SpectrumLoadProcessListener spectrumLoadProcessListener)
		{
		spectrumLoadProcessListeners .add(spectrumLoadProcessListener);
		if(isLoaded)spectrumLoadProcessListener.spectrumLoaded();
		else spectrumLoadProcessListener.loadingSpectrum();
		if(isFailed)spectrumLoadProcessListener.exception(failureException);
		}//end addSpectrumLoadProcessListener
	}//end SpectrumData
