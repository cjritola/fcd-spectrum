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
package com.ritolaaudio.fcdspectrum;

import com.ritolaaudio.fcdspectrum.license.BSD3Clause;
import com.ritolaaudio.fcdspectrum.license.CopyingCredits;
import com.ritolaaudio.fcdspectrum.license.GPL2;
import com.ritolaaudio.fcdspectrum.license.GPL3;
import com.ritolaaudio.fcdspectrum.license.HIDAPI;
import com.ritolaaudio.fcdspectrum.license.LGPL2;
import com.ritolaaudio.fcdspectrum.license.LGPL21;
import com.ritolaaudio.fcdspectrum.license.License;
import com.ritolaaudio.fcdspectrum.license.LicenseEntry;
import com.ritolaaudio.fcdspectrum.license.MPL2;

public class COPYING_CREDITS extends CopyingCredits
	{
	private static final String PROJECT_NAME="fcd-spectrum";
	private static final String  [] AUTHORS=new String[]{"Chuck Ritola"};
	private static final String CONTACT_INFO="<cjritola@gmail.com>";
	private static final int [] COPYRIGHT_YEARS=new int[]{2013};
	private static final String DESCRIPTION=
			"A sweeping spectrum analyzer for the FunCube Dongle Pro+";
	private static final String INTRO_DISCLAIMER = 
			"THERE IS NO WARRANTY FOR THE PROGRAM, TO THE EXTENT PERMITTED BY APPLICABLE LAW. \n" + 
			"EXCEPT WHEN OTHERWISE STATED IN WRITING THE COPYRIGHT HOLDERS AND/OR OTHER PARTIES \n" + 
			"PROVIDE THE PROGRAM “AS IS” WITHOUT WARRANTY OF ANY KIND, EITHER EXPRESSED OR IMPLIED, \n" + 
			"INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A \n" + 
			"PARTICULAR PURPOSE. THE ENTIRE RISK AS TO THE QUALITY AND PERFORMANCE OF THE PROGRAM IS WITH YOU. \n" + 
			"SHOULD THE PROGRAM PROVE DEFECTIVE, YOU ASSUME THE COST OF ALL NECESSARY \n" + 
			"SERVICING, REPAIR OR CORRECTION.";
	private static String SOURCE_URL="http://code.google.com/p/fcd-spectrum/";
	
	public static final LicenseEntry [] get()
		{
		return new LicenseEntry[]
			{
			new LicenseEntry("fcd-spectrum","Copyright 2013 Chuck Ritola", new License[]{new GPL3()}),
			new LicenseEntry("JTransforms","Piotr Wendykier (http://sites.google.com/site/piotrwendykier/software/jtransforms)",
					new License[]{new GPL2(),new MPL2(), new LGPL2()}),
			new LicenseEntry("jFCDPP","Copyright 2013 Chuck Ritola", new License[]{new LGPL21()}),
			new LicenseEntry("HIDAPI","Alan Ott <alan@signal11.us>:\n" + 
					"Original Author and Maintainer\n" + 
					"Linux, Windows, and Mac implementations\n" + 
					"\n" + 
					"Ludovic Rousseau <rousseau@debian.org>:\n" + 
					"Formatting for Doxygen documentation\n" + 
					"Bug fixes\n" + 
					"Correctness fixes",new License[]{new BSD3Clause(),new GPL3(),new HIDAPI()})
			};
		}//end constructor

	@Override
	public String getProjectName()
		{
		return PROJECT_NAME;
		}

	@Override
	public String [] getAuthors()
		{
		return AUTHORS;
		}

	@Override
	public String getContactInfo()
		{
		return CONTACT_INFO;
		}

	@Override
	public int[] getCopyrightYears()
		{
		return COPYRIGHT_YEARS;
		}

	@Override
	public String getProjectDescription()
		{
		return DESCRIPTION;
		}

	@Override
	public String getIntroDisclaimer()
		{
		return INTRO_DISCLAIMER;
		}

	@Override
	public String getSourceURL()
		{
		return SOURCE_URL;
		}
	}//end COPYING_CREDITS
