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

import java.text.DecimalFormat;

public class HertzFormatter implements NumberFormatter
	{
	DecimalFormat df = new DecimalFormat("0.00");
	@Override
	public String format(Number n)
		{
		if(n.intValue()<1E3)
			{
			return df.format(n.doubleValue()/1E3)+"Hz";
			}
		else if(n.doubleValue()<1E6)
			{
			return df.format(n.doubleValue()/1E3)+"kHz";
			}
		else if(n.doubleValue()<1E9)
			{
			return df.format(n.doubleValue()/1E6)+"MHz";
			}
		else if(n.doubleValue()>=1E9)
			{
			return df.format(n.doubleValue()/1E9)+"GHz";
			}
		return n.doubleValue()+"";
		}

	}//end HertzFormatter
