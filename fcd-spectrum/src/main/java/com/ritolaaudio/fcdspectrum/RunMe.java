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

import com.ritolaaudio.fcdspectrum.gui.GUI;
import com.ritolaaudio.fcdspectrum.license.CopyingCredits;

public class RunMe
	{
	/**
	 * @param args
	 * @since Jun 23, 2013
	 */
	public static void main(String[] args)
		{
		CopyingCredits.printIntro(System.out);
		Configuration.CONFIGURATION.setBackend(com.ritolaaudio.jfcdpp.autoselect.Dongles.class);
		//Configuration.CONFIGURATION.setBackend(com.ritolaaudio.jfcdpp.javahidapi.Dongles.class);
		if(!CopyingCredits.attemptLicenseDeployment(args))
			{if(args.length==0)
				{GUI.main(null);}
			else {new CLI(args);}
			}
		else{}
		}//end main(...)
	}//end RunMe
