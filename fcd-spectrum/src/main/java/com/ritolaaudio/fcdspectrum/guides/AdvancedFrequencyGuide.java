package com.ritolaaudio.fcdspectrum.guides;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class AdvancedFrequencyGuide implements FrequencyGuide
	{
	private final FrequencyGuide intrinsic;
	private Collection<FrequencyGuide> subGuides;
	public AdvancedFrequencyGuide(FrequencyGuide intrinsic)
		{
		this.intrinsic=intrinsic;
		}
	@Override
	public String getName()
		{
		return intrinsic.getName();
		}
	@Override
	public void getSubguides(Collection<FrequencyGuide> dest)
		{
		if(subGuides==null)
			{
			subGuides = new ArrayList<FrequencyGuide>();
			intrinsic.getSubguides(subGuides);
			}
		dest.addAll(subGuides);
		}
	public void getSubguides(final Collection<FrequencyGuide> dest, final long startFreq, final long endFreq)
		{
		final long timeAtEvent=System.currentTimeMillis();
		getSubguides(new Collection<FrequencyGuide>()
					{
						@Override
						public boolean add(FrequencyGuide g)
							{
							if(g.startFreq()<=endFreq && g.endFreq()>=startFreq)
								{
								g=g instanceof AdvancedFrequencyGuide?g:new AdvancedFrequencyGuide(g);
								g.getSubguides(dest);
								//System.out.println(timeAtEvent+" Added "+g.getName()+" "+g);
								}
							return true;
							}

						@Override
						public boolean addAll(
								Collection<? extends FrequencyGuide> guides)
							{
							for(FrequencyGuide g:guides)
								{add(g);}
							return true;
							}

						@Override
						public void clear()
							{}

						@Override
						public boolean contains(Object arg0)
							{return false;}

						@Override
						public boolean containsAll(Collection<?> arg0)
							{return false;}

						@Override
						public boolean isEmpty()
							{return true;}

						@Override
						public Iterator<FrequencyGuide> iterator()
							{return null;}

						@Override
						public boolean remove(Object arg0)
							{return false;}

						@Override
						public boolean removeAll(Collection<?> arg0)
							{return false;}

						@Override
						public boolean retainAll(Collection<?> arg0)
							{return false;}

						@Override
						public int size()
							{return 0;}

						@Override
						public Object[] toArray()
							{return null;}

						@Override
						public <T> T[] toArray(T[] arg0)
							{return null;}
					
					});
		}
	@Override
	public long startFreq()
		{
		return intrinsic.startFreq();
		}
	@Override
	public long endFreq()
		{
		return intrinsic.endFreq();
		}
	}//end AdvancedFrequencyGuide
