package com.ritolaaudio.fcdspectrum.guides;

import java.util.Collection;

public class LFFrequencyGuide implements FrequencyGuide
	{

	@Override
	public String getName()
		{
		// TODO Auto-generated method stub
		return null;
		}

	@Override
	public void getSubguides(Collection<FrequencyGuide> dest)
		{
		dest.add(new DefaultFrequencyGuide(9000L,14000L,new String[]{"Radionavigation"}));
		dest.add(new DefaultFrequencyGuide(14000L,19950L,new String[]{"Fixed","Maritime","Mobile"}));
		dest.add(new DefaultFrequencyGuide(20050L,70000L,new String[]{"Fixed","Maritime","Mobile"}));
		dest.add(new DefaultFrequencyGuide(70000L,90000L,new String[]{"Fixed","Maritime","Mobile","Maritime","Radionavigation 60","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(90000L,110000L,new String[]{"Radionavigation","Fixed"}));
		dest.add(new DefaultFrequencyGuide(110000L,130000L,new String[]{"Fixed","Maritime","Mobile","Maritime","Radionavigation","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(130000L,135700L,new String[]{"Fixed","Maritime","Mobile"}));
		dest.add(new DefaultFrequencyGuide(135700L,137800L,new String[]{"Fixed","Maritime","Mobile","Amateur 64"}));
		dest.add(new DefaultFrequencyGuide(137800L,160000L,new String[]{"Fixed","Maritime","Mobile"}));
		dest.add(new DefaultFrequencyGuide(160000L,190000L,new String[]{"Fixed"}));
		dest.add(new DefaultFrequencyGuide(190000L,200000L,new String[]{"Aeronautical","Radionavigation"}));
		dest.add(new DefaultFrequencyGuide(200000L,275000L,new String[]{"Aeronautical","Radionavigation","Aeronautical","mobile"}));
		dest.add(new DefaultFrequencyGuide(275000L,285000L,new String[]{"Aeronautical","Radionavigation","Aeronautical","mobile","Maritime","radionavigation (radiobeacons)"}));
		dest.add(new DefaultFrequencyGuide(285000L,315000L,new String[]{"Aeronautical","Radionavigation","Maritime","Radionavigation (radiobeacons)"}));
		}

	@Override
	public long startFreq()
		{
		// TODO Auto-generated method stub
		return 0;
		}

	@Override
	public long endFreq()
		{
		// TODO Auto-generated method stub
		return 0;
		}

	}
