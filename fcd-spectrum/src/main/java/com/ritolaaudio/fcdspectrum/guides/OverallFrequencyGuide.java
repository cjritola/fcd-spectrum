package com.ritolaaudio.fcdspectrum.guides;

import java.util.Collection;


public class OverallFrequencyGuide implements FrequencyGuide
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
		dest.add(new LFFrequencyGuide());
		dest.add(new MWFrequencyGuide());
		dest.add(new SWFrequencyGuide());
		dest.add(new VHFFrequencyGuide());
		dest.add(new UHFFrequencyGuide());
		dest.add(new SHFFrequencyGuide());
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
