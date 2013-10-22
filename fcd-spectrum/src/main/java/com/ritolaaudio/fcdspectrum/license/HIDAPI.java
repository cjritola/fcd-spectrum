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
package com.ritolaaudio.fcdspectrum.license;

public class HIDAPI implements License
	{

	@Override
	public String getHTML()
		{
		return " HIDAPI - Multi-Platform library for\n" + 
				"communication with HID devices.\n" + 
				"\n" + 
				"Copyright 2009, Alan Ott, Signal 11 Software.\n" + 
				"All Rights Reserved.\n" + 
				"\n" + 
				"This software may be used by anyone for any reason so\n" + 
				"long as the copyright notice in the source files\n" + 
				"remains intact.";
		}

	@Override
	public String getLicenseName()
		{
		return "HIDAPI";
		}

	@Override
	public String getShortLicenseName()
		{
		return "HIDAPI";
		}

	}
