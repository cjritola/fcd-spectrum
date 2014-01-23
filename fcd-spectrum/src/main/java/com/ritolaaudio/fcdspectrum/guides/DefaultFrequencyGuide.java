package com.ritolaaudio.fcdspectrum.guides;

import java.util.Collection;

public class DefaultFrequencyGuide implements FrequencyGuide
	{
	private final String name;
	private final long startFreq;
	private final long endFreq;
	public DefaultFrequencyGuide(String name, long startFreq, long endFreq)
		{
		this.name=name;
		this.startFreq=startFreq;
		this.endFreq=endFreq;
		}
	public DefaultFrequencyGuide(long startFreq, long endFreq, String [] names)
		{
		StringBuilder sb = new StringBuilder();
		for(String s:names){sb.append(s+",");}
		sb.deleteCharAt(sb.length()-1);
		this.name=sb.toString();
		this.startFreq=startFreq;
		this.endFreq=endFreq;
		}
	@Override
	public String getName()
		{return name;}

	@Override
	public void getSubguides(Collection<FrequencyGuide> dest)
		{dest.add(this);}

	@Override
	public long startFreq()
		{return startFreq;}

	@Override
	public long endFreq()
		{return endFreq;}
	}//end DefaultFrequencyGuide
