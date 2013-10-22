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
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Grid extends JPanel
	{
	private double startX,endX,startY,endY,divX,divY;
	NumberFormatter formatterX,formatterY;
	private static int LINE_THICKNESS=2;
	
	public static void main(String args[])
		{
		try
			{
			JFrame frame = new JFrame();
			frame.setSize(new Dimension(600,400));
			frame.getContentPane().add(new Grid(0,100,10,-200,10,10,new HertzFormatter(),new DBMFormatter()));
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
		catch(Exception e){e.printStackTrace();}
		}
	
	public Grid(double startX, double endX, double divX, double startY, double endY, double divY, NumberFormatter formatterX, NumberFormatter formatterY)
		{
		super();
		if(formatterX==null)throw new NullPointerException("formatterX must not be null.");
		if(formatterY==null)throw new NullPointerException("formatterY must not be null.");
		this.startX=startX; this.startY=startY;
		this.endX=endX; this.endY=endY;
		this.divX=divX; this.divY=divY;
		this.formatterX=formatterX; this.formatterY=formatterY;
		setOpaque(false);
		}
	@Override
	public void paintComponent(Graphics g)
		{
		super.paintComponent(g);
		int numDivs;
		numDivs=(int)Math.ceil(this.getHeight()/(endY-startY));
		Graphics2D g2=(Graphics2D)g;
		double scaleX=(double)getWidth()/(endX-startX);
		double scaleY=(double)getHeight()/(endY-startY);
		double newStartY=startY%divY;
		double newEndY=Math.ceil((endY-startY)/divY)*divY;
		g2.setFont(new Font(g2.getFont().getName(), Font.BOLD, 10));
		double currentValue=startY;
		//Horizontals
		for(double y=newStartY; y<newEndY; y+=divY)
			{
			g2.setColor(new Color(0,200,0,75));
			//Line
			double newY=this.getHeight()-(scaleY*(y+startY%divY));
			//System.out.println("newY="+newY);
			g2.fillRect(0, (int)newY, this.getWidth(), LINE_THICKNESS);
			g2.setColor(Color.white);
			//Label
			g2.drawString(formatterY.format(currentValue), 0, (int)newY-(int)(g2.getFont().getSize()*.25));
			currentValue+=divY;
			}
		//Verticals
		double newStartX=-startX%divX;
		double newEndX=Math.ceil((endX-startX)/divX)*divX;
		numDivs=(int)Math.ceil(this.getWidth()/(endX-startX));
		g2.setFont(new Font(g2.getFont().getName(), Font.BOLD, 10));
		currentValue=startX;
		for(double x=newStartX; x<newEndX; x+=divX)
			{
			g2.setColor(new Color(0,200,0,75));
			//Line
			double newX=(scaleX*(x+startX%divX));
			//System.out.println("newX="+newX);
			g2.fillRect( (int)newX, 0, LINE_THICKNESS, this.getHeight());
			g2.setColor(Color.white);
			//Label
			g2.drawString(formatterX.format(currentValue), (int)newX, this.getHeight()-g2.getFont().getSize()/4);
			currentValue+=divX;
			}
		}//end paint()

	/**
	 * @return the startX
	 */
	public double getStartX()
		{
		return startX;
		}

	/**
	 * @param startX the startX to set
	 */
	public void setStartX(double startX)
		{
		this.startX = startX;
		}

	/**
	 * @return the endX
	 */
	public double getEndX()
		{
		return endX;
		}

	/**
	 * @param endX the endX to set
	 */
	public void setEndX(double endX)
		{
		this.endX = endX;
		}

	/**
	 * @return the startY
	 */
	public double getStartY()
		{
		return startY;
		}

	/**
	 * @param startY the startY to set
	 */
	public void setStartY(double startY)
		{
		this.startY = startY;
		}

	/**
	 * @return the endY
	 */
	public double getEndY()
		{
		return endY;
		}

	/**
	 * @param endY the endY to set
	 */
	public void setEndY(double endY)
		{
		this.endY = endY;
		}

	/**
	 * @return the divX
	 */
	public double getDivX()
		{
		return divX;
		}

	/**
	 * @param divX the divX to set
	 */
	public void setDivX(double divX)
		{
		this.divX = divX;
		}

	/**
	 * @return the divY
	 */
	public double getDivY()
		{
		return divY;
		}

	/**
	 * @param divY the divY to set
	 */
	public void setDivY(double divY)
		{
		this.divY = divY;
		}
	}//end HorizontalRuler
