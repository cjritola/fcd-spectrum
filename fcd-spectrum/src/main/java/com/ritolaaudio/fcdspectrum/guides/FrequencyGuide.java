package com.ritolaaudio.fcdspectrum.guides;

import java.util.Collection;

public interface FrequencyGuide
	{
	public String getName();
	public void getSubguides(Collection<FrequencyGuide> dest);
	public long startFreq();
	public long endFreq();
	}
