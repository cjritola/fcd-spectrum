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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import com.ritolaaudio.fcdspectrum.COPYING_CREDITS;

public abstract class CopyingCredits
	{
	public static final COPYING_CREDITS credits = new COPYING_CREDITS();
	
	public static boolean attemptLicenseDeployment(String [] args)
		{
		COPYING_CREDITS crd = new COPYING_CREDITS();
		if(args.length==1)
			{
			if(args[0].toUpperCase().contentEquals("LICENSESANDCREDITS"))
				{
				//Do it.
				File creditsFile = new File("CREDITS");
				if(!creditsFile.exists())
					{
					try
						{
					creditsFile.createNewFile();
					PrintStream ps=new PrintStream(new FileOutputStream(creditsFile));
					printIntro(ps);
					if(credits.get().length>0)
						{
						ps.println("\n\nProjects involved in "+credits.getProjectName()+" include:\n\n");
						for(LicenseEntry subProject:credits.get())
							{
							ps.println("="+subProject.getEntryName()+"=");
							ps.println(subProject.getCredits());
							for(License l:subProject.getLicenses())
								{
								ps.println(l.getLicenseName());
								File licenseFile = new File("COPYING."+l.getShortLicenseName()+".html");
								if(!licenseFile.exists())
									{
									licenseFile.createNewFile();
									PrintStream licenseWriter = new PrintStream(new FileOutputStream(licenseFile));
									licenseWriter.print(l.getHTML());
									licenseWriter.close();
									}
								else
									{System.out.println("COPYING."+l.getShortLicenseName()+".html file already exists, will not overwrite. To re-deploy COPYING."+l.getShortLicenseName()+".html file, remove existing COPYING."+l.getShortLicenseName()+".html file and try again.\n" +
											"If multiple included libraries use this license, the correct license may have already been deployed and this is simply an unnecessary attempt to deploy it again and this warning should be disregarded.");}
								}//end for(licenses)
							}//end for(subProjects)
						System.out.println();
						}//end if(credits)
						ps.close();
						}//end try{}
					catch(IOException e)
						{e.printStackTrace();}
					}//end if(write credits file)
				else{System.out.println("CREDITS file already exists, will not overwrite. To re-deploy CREDITS file, remove existing CREDITS file and try again.");}
				return true;
				}//end DO IT
			}//end if(1)
		return false;
		}//end attemptLicenseDeployment(...)
	
	public static void printIntro(PrintStream ps)
		{
		COPYING_CREDITS crd = new COPYING_CREDITS();
		System.out.println("==="+crd.getProjectName()+"===");
		System.out.println(crd.getProjectDescription());
		System.out.print("Copyright (c) ");
		for(int i=0; i<crd.getCopyrightYears().length; i++)
			{
			System.out.print(crd.getCopyrightYears()[i]);
			if(i<crd.getCopyrightYears().length-1){System.out.print(",");}
			System.out.print(" ");
			}//end for(years)
		for(int i=0; i<crd.getAuthors().length; i++)
			{
			if(i==crd.getAuthors().length-1 && crd.getAuthors().length>1){System.out.println("and ");}
			System.out.print(crd.getAuthors()[i]);
			if(i<crd.getAuthors().length-1){System.out.print(", ");}
			//System.out.print(" ");
			}
		System.out.println(".\n");
		System.out.println(crd.getIntroDisclaimer());
		System.out.println("See source for author-specific credits and copyright information.");
		System.out.println("Source can be found at "+crd.getSourceURL()+".");
		System.out.println("This software contains components distributed under the terms of one or more licenses.\n" +
				"Run this program with `licensesAndCredits` (no quotes) as its only argument, to deploy credits and license text/html files to the current working directory.");
		}//end printIntro()
	
	public abstract String getProjectName();
	public abstract String [] getAuthors();
	public abstract String getContactInfo();
	public abstract int [] getCopyrightYears();
	public abstract String getProjectDescription();
	public abstract String getIntroDisclaimer();
	public abstract String getSourceURL();
	}
