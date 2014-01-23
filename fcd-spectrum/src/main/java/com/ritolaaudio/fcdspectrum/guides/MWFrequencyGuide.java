package com.ritolaaudio.fcdspectrum.guides;

import java.util.Collection;

public class MWFrequencyGuide implements FrequencyGuide
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
		dest.add(new DefaultFrequencyGuide(315000L,325000L,new String[]{"Maritime","Radionavigation (radiobeacons)","Aeronautical","radionavigation"}));
		dest.add(new DefaultFrequencyGuide(325000L,335000L,new String[]{"Aeronautical","Radionavigation","Aeronautical","mobile","Maritime","radionavigation (radiobeacons)"}));
		dest.add(new DefaultFrequencyGuide(335000L,405000L,new String[]{"Aeronautical","Radionavigation","Aeronautical","mobile"}));
		dest.add(new DefaultFrequencyGuide(405000L,415000L,new String[]{"Radionavigation","Aeronautical","mobile"}));
		dest.add(new DefaultFrequencyGuide(415000L,495000L,new String[]{"Maritime","Mobile","Aeronautical","radionavigation"}));
		dest.add(new DefaultFrequencyGuide(495000L,505000L,new String[]{"Mobile","82b"}));
		dest.add(new DefaultFrequencyGuide(505000L,510000L,new String[]{"Maritime","Mobile"}));
		dest.add(new DefaultFrequencyGuide(510000L,525000L,new String[]{"Mobile","Aeronautical","Radionavigation"}));
		dest.add(new DefaultFrequencyGuide(525000L,535000L,new String[]{"Broadcasting","Aeronautical","Radionavigation"}));
		dest.add(new DefaultFrequencyGuide(535000L,1605000L,new String[]{"Broadcasting"}));
		dest.add(new DefaultFrequencyGuide(1605000L,1625000L,new String[]{"Broadcasting"}));
		dest.add(new DefaultFrequencyGuide(1625000L,1705000L,new String[]{"Fixed","Mobile","Broadcasting","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(1705000L,1800000L,new String[]{"Fixed","Mobile","Radiolocation","Aeronautical","Radionavigation"}));
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
