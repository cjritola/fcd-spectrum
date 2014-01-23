package com.ritolaaudio.fcdspectrum.gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Collection;
import java.util.Iterator;

import javax.swing.JPanel;

import com.ritolaaudio.fcdspectrum.guides.AdvancedFrequencyGuide;
import com.ritolaaudio.fcdspectrum.guides.FrequencyGuide;

public class FrequencyGuideOverlay extends JPanel
	{
	private int startFreq,endFreq;
	private AdvancedFrequencyGuide frequencyGuide;
	
	public FrequencyGuideOverlay()
		{setOpaque(false);}
	
	@Override
	public void paint(final Graphics g)
		{
		final int []itemCount=new int[1];
		frequencyGuide.getSubguides(new Collection<FrequencyGuide>()
					{

						@Override
						public boolean add(FrequencyGuide e)
							{
							final double width=getWidth();
							final double height=getHeight();
							final double windowFreqLen=endFreq-startFreq;
							final double guideFreqLen=e.endFreq()-e.startFreq();
							final double freq2PixelScalar = width/windowFreqLen;
							final int x=(int)((e.startFreq()-startFreq)*freq2PixelScalar);
							final int guideWidth= (int)(guideFreqLen*freq2PixelScalar);
							final int labelHash = e.getName().hashCode();
							final Color labelRawColor = new Color(labelHash);
							itemCount[0]++;
							System.out.println("item "+e.getName()+" x="+x+" guideWidt="+guideWidth+" width="+width);
							System.out.println("startfreq="+e.startFreq());
							System.out.println("windowFreqLen="+windowFreqLen+" freq2PixScale="+freq2PixelScalar);
							g.setColor(new Color(
									labelRawColor.getRed(),
									labelRawColor.getGreen(),
									labelRawColor.getBlue(),
									20));
							//Draw each
							Graphics2D g2d=(Graphics2D)g;
							g2d.setStroke(new BasicStroke(10));
							g.fillRect(x, 0, guideWidth, (int)height);
							g.drawRect(x, 0, guideWidth, (int)height);
							g.setColor(new Color(
									labelRawColor.getRed(),
									labelRawColor.getGreen(),
									labelRawColor.getBlue(),
									255));
							
							int degrees = 90; // rotate text counter-clockwise
							AffineTransform at = AffineTransform.getRotateInstance(Math.toRadians(degrees));
							Font f = new Font("Arial", Font.PLAIN, 14);
							g2d.setFont(f.deriveFont(at));
							g.drawString(e.getName(), (int)(x+(guideWidth/2.)), 30);
							return true;
							}

						@Override
						public boolean addAll(
								Collection<? extends FrequencyGuide> c)
							{
							for(FrequencyGuide g:c){add(g);}
							return true;
							}

						@Override
						public void clear()
							{}

						@Override
						public boolean contains(Object o)
							{
							return false;
							}

						@Override
						public boolean containsAll(Collection<?> c)
							{
							return false;
							}

						@Override
						public boolean isEmpty()
							{
							return false;
							}

						@Override
						public Iterator<FrequencyGuide> iterator()
							{
							return null;
							}

						@Override
						public boolean remove(Object o)
							{
							return false;
							}

						@Override
						public boolean removeAll(Collection<?> c)
							{
							return false;
							}

						@Override
						public boolean retainAll(Collection<?> c)
							{
							return false;
							}

						@Override
						public int size()
							{
							return 0;
							}

						@Override
						public Object[] toArray()
							{
							return null;
							}

						@Override
						public <T> T[] toArray(T[] a)
							{
							return null;
							}
					
					}, getStartFreq(), getEndFreq());
		}
	
	/**
	 * @return the startFreq
	 */
	public int getStartFreq()
		{
		return startFreq;
		}
	/**
	 * @param startFreq the startFreq to set
	 */
	public void setStartFreq(int startFreq)
		{
		this.startFreq = startFreq;
		}
	/**
	 * @return the endFreq
	 */
	public int getEndFreq()
		{
		return endFreq;
		}
	/**
	 * @param endFreq the endFreq to set
	 */
	public void setEndFreq(int endFreq)
		{
		this.endFreq = endFreq;
		}
	/**
	 * @return the frequencyGuide
	 */
	public FrequencyGuide getFrequencyGuide()
		{
		return frequencyGuide;
		}
	/**
	 * @param frequencyGuide the frequencyGuide to set
	 */
	public void setFrequencyGuide(FrequencyGuide frequencyGuide)
		{
		this.frequencyGuide = new AdvancedFrequencyGuide(frequencyGuide);
		}
	}
