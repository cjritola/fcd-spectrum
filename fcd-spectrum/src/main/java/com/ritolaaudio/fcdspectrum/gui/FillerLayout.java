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

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;

public class FillerLayout implements LayoutManager
	{
	private final Container parentContainer;
	public FillerLayout(Container parentContainer)
		{
		this.parentContainer=parentContainer;
		}
	
	@Override
	public void addLayoutComponent(String arg0, Component arg1)
		{
		//Nothing to do.
		}

	@Override
	public void layoutContainer(Container ctr)
		{
		for(Component cmp:ctr.getComponents())
			{
			cmp.setBounds(0, 0, parentContainer.getWidth(), parentContainer.getHeight());
			cmp.setVisible(true);
			}
		}

	@Override
	public Dimension minimumLayoutSize(Container arg0)
		{//Don't care.
		return new Dimension(0,0);
		}

	@Override
	public Dimension preferredLayoutSize(Container arg0)
		{
		return new Dimension(arg0.getSize());
		}

	@Override
	public void removeLayoutComponent(Component arg0)
		{
		//Nothing to do.
		}

	}
