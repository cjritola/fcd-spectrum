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
package com.ritolaaudio.fcdspectrum.gui;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.ritolaaudio.fcdspectrum.FileFormatException;
import com.ritolaaudio.fcdspectrum.SpectrumData;

public class SweepGraph extends JPanel
	{
	//private SpectrumData currentData;
	private final SpectrumData data;
	private double startX;
	private double zoom=1;
	private boolean isReadyToDisplay=false;
	
	/*
	public static void main(String args[])
		{
		try {
			JFrame frame = new JFrame();
			frame.setSize(new Dimension(200,100));
			frame.getContentPane().add(new SweepGraph(new File("output.csv")));
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		catch(Exception e){e.printStackTrace();}
		}
	*/
	//private int minPower,maxPower,minFreq,maxFreq;
	//private final TreeSet<Integer> keySet;
	//private final Map<Integer,Double> values;
	
	public SweepGraph(SpectrumData data)
		{
		super();
		this.data=data;
		this.setOpaque(false);
		data.addSpectrumLoadProcessListener(new SpectrumLoadProcessListener()
			{
			@Override
			public void loadingSpectrum()
				{
				isReadyToDisplay=false;
				}

			@Override
			public void spectrumLoaded()
				{
				isReadyToDisplay=true;
				SwingUtilities.invokeLater(new Runnable()
					{
					@Override
					public void run()
						{
						SweepGraph.this.repaint();
						}
					});
				}

			@Override
			public void exception(Exception ex)
				{
				/*
				String message="A unhandled problem was encountered loading spectrum data.";
				if(ex instanceof FileFormatException)message="The file format was not recognized.";
				else if(ex instanceof IOException)message="Failed to load the spectrum file.";
				new ShowstopperDialog(message,ex).setVisible(true);
				*/
				}
			});
		}//end constructor()
	
	public SpectrumData getData(){return data;}
	
	public double getMinPower(){return data.getMinPower();}
	public double getMaxPower(){return data.getMaxPower();}
	
	public void setZoom(double zoom){this.zoom=zoom;}
	public void setStartX(double x){this.startX=x;}
	
	@Override
	public void paintComponent(Graphics g)
		{
		super.paintComponent(g);
		if(!isReadyToDisplay)return;
		g.setColor(Color.red);
		Color c0=new Color(0,25,105);
		Color c1=Color.red;
		GradientPaint gp = new GradientPaint(0,0,c1,0,this.getHeight(),c0);
		((Graphics2D)g).setPaint(gp);
		//int rectWidth=(int)Math.ceil((double)this.getWidth()/(double)keySet.size());
		final List<Double> powerValues = data.getPowerValues(); 
		double elementWidthInPix=(double)(this.getWidth()/(double)powerValues.size())*zoom;
		double indexIncrement;
		if(elementWidthInPix>=1)
			{indexIncrement=1;}
		else
			{
			indexIncrement=1./elementWidthInPix;
			elementWidthInPix=1;
			}
		double index=(startX-data.getStartFreq())/data.getFrequencyStep();
				
		for(double x=0; x<this.getWidth()-1; x+=elementWidthInPix)
			{
			final double power = powerValues.get((int)index);
			//System.out.print(power+" ");
			if(power>=getMinPower() && power<=getMaxPower())
				{
				final double normPower=power/getMinPower();
				//System.out.print(normPower+" "+" power="+power);
				final int y = (int)((normPower*(double)this.getHeight()));
				final int height = this.getHeight()-y;
				//System.out.print(y+" ");
				colorRect(g,(int)x,y, (int)Math.ceil(elementWidthInPix), height,normPower);
				}//end if(sane)
			index+=indexIncrement;
			}
		/*
		for(Integer i:keySet.subSet(minFreq, maxFreq))
			{
			final double value = values.get(i);
			final double normX = (double)(i-minFreq)/(double)(maxFreq-minFreq);
			final double normY = (double)(value-minPower)/(double)(maxPower-minPower);
			final int height = (int)(normY*(double)this.getHeight())+1;
			if(value>=minPower && value<=maxPower)
				{
				colorRect(g,(int)(int)((double)(this.getWidth()-(normX*(double)this.getWidth()))), 
						(int)((double)(this.getHeight()-(normY*(double)this.getHeight()))), rectWidth, height,normY);
				}//end if(!sane)
			//System.out.println("X="+);
			}
		*/
		}//end paint(...)
	
	private void colorRect(Graphics g, int x, int y, int width, int height, double intensity)
		{g.fillRect(x, y, width, height);}

	public SpectrumData getRawData()
		{
		return data;
		}
	}///end SweepGraph
