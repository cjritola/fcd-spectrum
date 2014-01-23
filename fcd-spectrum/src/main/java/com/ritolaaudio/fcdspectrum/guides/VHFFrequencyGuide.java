package com.ritolaaudio.fcdspectrum.guides;

import java.util.Collection;

public class VHFFrequencyGuide implements FrequencyGuide
	{
	
	@Override
	public String getName()
		{
		return "VHF";
		}

	@Override
	public void getSubguides(Collection<FrequencyGuide> dest)
		{
		dest.add(new DefaultFrequencyGuide(30005000L,30010000L,new String[]{"Space","Operation (satellite","identification)","Fixed","Mobile","Space","Research"}));
		dest.add(new DefaultFrequencyGuide(30010000L,37500000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(36000000L,37000000L,new String[]{"Fixed","Mobile","Us220"}));
		dest.add(new DefaultFrequencyGuide(37500000L,38000000L,new String[]{"Radio","astronomy","Us342"}));
		dest.add(new DefaultFrequencyGuide(38000000L,38250000L,new String[]{"Fixed","Mobile","Radio","Astronomy","Us81","Us342"}));
		dest.add(new DefaultFrequencyGuide(38250000L,39000000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(40000000L,42000000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(46600000L,47000000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(47000000L,50000000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(50000000L,54000000L,new String[]{"Amateur"}));
		dest.add(new DefaultFrequencyGuide(54000000L,68000000L,new String[]{"Broadcasting","Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(68000000L,72000000L,new String[]{"Broadcasting","Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(72000000L,73000000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(73000000L,74600000L,new String[]{"Radio","Astronomy"}));
		dest.add(new DefaultFrequencyGuide(74600000L,74800000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(74800000L,75200000L,new String[]{"Aeronautical","Radionavigation"}));
		dest.add(new DefaultFrequencyGuide(75200000L,75400000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(75400000L,76000000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(76000000L,88000000L,new String[]{"Broadcasting","Fixed","Mobile"}));
		//dest.add(new DefaultFrequencyGuide(88000000L,100000000L,new String[]{"Broadcasting"}));
		dest.add(new DefaultFrequencyGuide(88000000L,108000000L,new String[]{"Broadcasting"}));
		dest.add(new DefaultFrequencyGuide(108000000L,117975000L,new String[]{"Aeronautical","Radionavigation"}));
		dest.add(new DefaultFrequencyGuide(117975000L,137000000L,new String[]{"Aeronautical","Mobile (R)"}));
		dest.add(new DefaultFrequencyGuide(137000000L,137025000L,new String[]{"Space","Operation (space-to-Earth)","Meteorological-Satellite (space-to-Earth)","Mobile-Satellite (space-to-Earth)","Space","Research (space-to-Earth)","Fixed","Mobile","except","aeronautical","mobile (R)"}));
		dest.add(new DefaultFrequencyGuide(137025000L,137175000L,new String[]{"Space","Operation (space-to-Earth)","Meteorological-Satellite (space-to-Earth)","Space","Research (space-to-Earth)","Fixed","Mobile-satellite (space-to-Earth)","Mobile","except","aeronautical","mobile (R)"}));
		dest.add(new DefaultFrequencyGuide(137175000L,137825000L,new String[]{"Space","Operation (space-to-Earth)","Meteorological-Satellite (space-to-Earth)","Mobile-Satellite (space-to-Earth)","Space","Research (space-to-Earth)","Fixed","Mobile","except","aeronautical","mobile (R)"}));
		dest.add(new DefaultFrequencyGuide(137825000L,138000000L,new String[]{"Space","Operation (space-to-Earth)","Meteorological-Satellite (space-to-Earth)","Space","Research (space-to-Earth)","Fixed","Mobile-satellite (space-to-Earth)","Mobile","except","aeronautical","mobile (R)"}));
		dest.add(new DefaultFrequencyGuide(138000000L,143600000L,new String[]{"Fixed","Mobile","Radiolocation","Space","research (space-to-Earth)"}));
		dest.add(new DefaultFrequencyGuide(143600000L,143650000L,new String[]{"Fixed","Mobile","Radiolocation","Space","Research (space-to-Earth)"}));
		dest.add(new DefaultFrequencyGuide(143650000L,144000000L,new String[]{"Fixed","Mobile","Radiolocation","Space","research (space-to-Earth)"}));
		dest.add(new DefaultFrequencyGuide(144000000L,146000000L,new String[]{"Amateur","Amateur-Satellite"}));
		dest.add(new DefaultFrequencyGuide(146000000L,148000000L,new String[]{"Amateur"}));
		dest.add(new DefaultFrequencyGuide(148000000L,149900000L,new String[]{"Fixed","Mobile","Mobile-Satellite (Earth-to-space)"}));
		dest.add(new DefaultFrequencyGuide(149900000L,150050000L,new String[]{"Mobile-Satellite (Earth-to-space)","Radionavigation-Satellite"}));
		dest.add(new DefaultFrequencyGuide(150050000L,156487500L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(156487500L,156562500L,new String[]{"Maritime","Mobile (distress and calling","via","Dsc)"}));
		dest.add(new DefaultFrequencyGuide(156562500L,156762500L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(156762500L,156837500L,new String[]{"Maritime","Mobile (distress and calling)"}));
		dest.add(new DefaultFrequencyGuide(156837500L,174000000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(174000000L,216000000L,new String[]{"Broadcasting","Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(216000000L,220000000L,new String[]{"Fixed","Maritime","Mobile","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(220000000L,225000000L,new String[]{"Amateur","Fixed","Mobile","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(225000000L,235000000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(235000000L,267000000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(267000000L,272000000L,new String[]{"Fixed","Mobile","Space","operation (space-to-Earth)"}));
		dest.add(new DefaultFrequencyGuide(272000000L,273000000L,new String[]{"Space","Operation (space-to-Earth)","Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(273000000L,312000000L,new String[]{"Fixed","Mobile"}));
		
		dest.add(new DefaultFrequencyGuide("ATSC Ch2",54000000,60000000));
		dest.add(new DefaultFrequencyGuide("ATSC Ch3",60000000,66000000));
		dest.add(new DefaultFrequencyGuide("ATSC Ch4",66000000,72000000));
		
		dest.add(new DefaultFrequencyGuide("ATSC Ch5",76000000,82000000));
		dest.add(new DefaultFrequencyGuide("ATSC Ch6",82000000,88000000));
		
		//ATSC MID
		for(int i=0; i<7; i++){dest.add(new DefaultFrequencyGuide(174000000+i*6000000,174000000+(i+1)*6000000,new String[]{"ATSC Ch"+(int)(i+7)}));}
		}

	@Override
	public long startFreq()
		{
		return 30005000L;
		}

	@Override
	public long endFreq()
		{
		return 312000000L;
		}

	}
