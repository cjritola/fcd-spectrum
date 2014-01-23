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

public class LGPL3 implements License
	{

	@Override
	public String getHTML()
		{
		return //"<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n" + 
				//"\n" + 
				//"<html><head>\n" + 
				//" <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\">\n" + 
				" <title>GNU Lesser General Public License v3.0 - GNU Project - Free Software Foundation (FSF)</title>\n" + 
				" <link rel=\"alternate\" type=\"application/rdf+xml\"\n" + 
				"       href=\"http://www.gnu.org/licenses/lgpl-3.0.rdf\" /> \n" + 
				"</head>\n" + 
				"<body>\n" + 
				"<h3 style=\"text-align: center;\">GNU LESSER GENERAL PUBLIC LICENSE</h3>\n" + 
				"<p style=\"text-align: center;\">Version 3, 29 June 2007</p>\n" + 
				"\n" + 
				"<p>Copyright &copy; 2007 Free Software Foundation, Inc.\n" + 
				" &lt;<a href=\"http://fsf.org/\">http://fsf.org/</a>&gt;</p><p>\n" + 
				" Everyone is permitted to copy and distribute verbatim copies\n" + 
				" of this license document, but changing it is not allowed.</p>\n" + 
				"\n" + 
				"<p>This version of the GNU Lesser General Public License incorporates\n" + 
				"the terms and conditions of version 3 of the GNU General Public\n" + 
				"License, supplemented by the additional permissions listed below.</p>\n" + 
				"\n" + 
				"<h4><a name=\"section0\"></a>0. Additional Definitions.</h4>\n" + 
				"\n" + 
				"<p>As used herein, &ldquo;this License&rdquo; refers to version 3 of the GNU Lesser\n" + 
				"General Public License, and the &ldquo;GNU GPL&rdquo; refers to version 3 of the GNU\n" + 
				"General Public License.</p>\n" + 
				"\n" + 
				"<p>&ldquo;The Library&rdquo; refers to a covered work governed by this License,\n" + 
				"other than an Application or a Combined Work as defined below.</p>\n" + 
				"\n" + 
				"<p>An &ldquo;Application&rdquo; is any work that makes use of an interface provided\n" + 
				"by the Library, but which is not otherwise based on the Library.\n" + 
				"Defining a subclass of a class defined by the Library is deemed a mode\n" + 
				"of using an interface provided by the Library.</p>\n" + 
				"\n" + 
				"<p>A &ldquo;Combined Work&rdquo; is a work produced by combining or linking an\n" + 
				"Application with the Library.  The particular version of the Library\n" + 
				"with which the Combined Work was made is also called the &ldquo;Linked\n" + 
				"Version&rdquo;.</p>\n" + 
				"\n" + 
				"<p>The &ldquo;Minimal Corresponding Source&rdquo; for a Combined Work means the\n" + 
				"Corresponding Source for the Combined Work, excluding any source code\n" + 
				"for portions of the Combined Work that, considered in isolation, are\n" + 
				"based on the Application, and not on the Linked Version.</p>\n" + 
				"\n" + 
				"<p>The &ldquo;Corresponding Application Code&rdquo; for a Combined Work means the\n" + 
				"object code and/or source code for the Application, including any data\n" + 
				"and utility programs needed for reproducing the Combined Work from the\n" + 
				"Application, but excluding the System Libraries of the Combined Work.</p>\n" + 
				"\n" + 
				"<h4><a name=\"section1\"></a>1. Exception to Section 3 of the GNU GPL.</h4>\n" + 
				"\n" + 
				"<p>You may convey a covered work under sections 3 and 4 of this License\n" + 
				"without being bound by section 3 of the GNU GPL.</p>\n" + 
				"\n" + 
				"<h4><a name=\"section2\"></a>2. Conveying Modified Versions.</h4>\n" + 
				"\n" + 
				"<p>If you modify a copy of the Library, and, in your modifications, a\n" + 
				"facility refers to a function or data to be supplied by an Application\n" + 
				"that uses the facility (other than as an argument passed when the\n" + 
				"facility is invoked), then you may convey a copy of the modified\n" + 
				"version:</p>\n" + 
				"\n" + 
				"<ul>\n" + 
				"<li>a) under this License, provided that you make a good faith effort to\n" + 
				"   ensure that, in the event an Application does not supply the\n" + 
				"   function or data, the facility still operates, and performs\n" + 
				"   whatever part of its purpose remains meaningful, or</li>\n" + 
				"\n" + 
				"<li>b) under the GNU GPL, with none of the additional permissions of\n" + 
				"   this License applicable to that copy.</li>\n" + 
				"</ul>\n" + 
				"\n" + 
				"<h4><a name=\"section3\"></a>3. Object Code Incorporating Material from Library Header Files.</h4>\n" + 
				"\n" + 
				"<p>The object code form of an Application may incorporate material from\n" + 
				"a header file that is part of the Library.  You may convey such object\n" + 
				"code under terms of your choice, provided that, if the incorporated\n" + 
				"material is not limited to numerical parameters, data structure\n" + 
				"layouts and accessors, or small macros, inline functions and templates\n" + 
				"(ten or fewer lines in length), you do both of the following:</p>\n" + 
				"\n" + 
				"<ul>\n" + 
				"<li>a) Give prominent notice with each copy of the object code that the\n" + 
				"   Library is used in it and that the Library and its use are\n" + 
				"   covered by this License.</li>\n" + 
				"\n" + 
				"<li>b) Accompany the object code with a copy of the GNU GPL and this license\n" + 
				"   document.</li>\n" + 
				"</ul>\n" + 
				"\n" + 
				"<h4><a name=\"section4\"></a>4. Combined Works.</h4>\n" + 
				"\n" + 
				"<p>You may convey a Combined Work under terms of your choice that,\n" + 
				"taken together, effectively do not restrict modification of the\n" + 
				"portions of the Library contained in the Combined Work and reverse\n" + 
				"engineering for debugging such modifications, if you also do each of\n" + 
				"the following:</p>\n" + 
				"\n" + 
				"<ul>\n" + 
				"<li>a) Give prominent notice with each copy of the Combined Work that\n" + 
				"   the Library is used in it and that the Library and its use are\n" + 
				"   covered by this License.</li>\n" + 
				"\n" + 
				"<li>b) Accompany the Combined Work with a copy of the GNU GPL and this license\n" + 
				"   document.</li>\n" + 
				"\n" + 
				"<li>c) For a Combined Work that displays copyright notices during\n" + 
				"   execution, include the copyright notice for the Library among\n" + 
				"   these notices, as well as a reference directing the user to the\n" + 
				"   copies of the GNU GPL and this license document.</li>\n" + 
				"\n" + 
				"<li>d) Do one of the following:\n" + 
				"\n" + 
				"<ul>\n" + 
				"<li>0) Convey the Minimal Corresponding Source under the terms of this\n" + 
				"       License, and the Corresponding Application Code in a form\n" + 
				"       suitable for, and under terms that permit, the user to\n" + 
				"       recombine or relink the Application with a modified version of\n" + 
				"       the Linked Version to produce a modified Combined Work, in the\n" + 
				"       manner specified by section 6 of the GNU GPL for conveying\n" + 
				"       Corresponding Source.</li>\n" + 
				"\n" + 
				"<li>1) Use a suitable shared library mechanism for linking with the\n" + 
				"       Library.  A suitable mechanism is one that (a) uses at run time\n" + 
				"       a copy of the Library already present on the user's computer\n" + 
				"       system, and (b) will operate properly with a modified version\n" + 
				"       of the Library that is interface-compatible with the Linked\n" + 
				"       Version.</li>\n" + 
				"</ul></li>\n" + 
				"\n" + 
				"<li>e) Provide Installation Information, but only if you would otherwise\n" + 
				"   be required to provide such information under section 6 of the\n" + 
				"   GNU GPL, and only to the extent that such information is\n" + 
				"   necessary to install and execute a modified version of the\n" + 
				"   Combined Work produced by recombining or relinking the\n" + 
				"   Application with a modified version of the Linked Version. (If\n" + 
				"   you use option 4d0, the Installation Information must accompany\n" + 
				"   the Minimal Corresponding Source and Corresponding Application\n" + 
				"   Code. If you use option 4d1, you must provide the Installation\n" + 
				"   Information in the manner specified by section 6 of the GNU GPL\n" + 
				"   for conveying Corresponding Source.)</li>\n" + 
				"</ul>\n" + 
				"\n" + 
				"<h4><a name=\"section5\"></a>5. Combined Libraries.</h4>\n" + 
				"\n" + 
				"<p>You may place library facilities that are a work based on the\n" + 
				"Library side by side in a single library together with other library\n" + 
				"facilities that are not Applications and are not covered by this\n" + 
				"License, and convey such a combined library under terms of your\n" + 
				"choice, if you do both of the following:</p>\n" + 
				"\n" + 
				"<ul>\n" + 
				"<li>a) Accompany the combined library with a copy of the same work based\n" + 
				"   on the Library, uncombined with any other library facilities,\n" + 
				"   conveyed under the terms of this License.</li>\n" + 
				"\n" + 
				"<li>b) Give prominent notice with the combined library that part of it\n" + 
				"   is a work based on the Library, and explaining where to find the\n" + 
				"   accompanying uncombined form of the same work.</li>\n" + 
				"</ul>\n" + 
				"\n" + 
				"<h4><a name=\"section6\"></a>6. Revised Versions of the GNU Lesser General Public License.</h4>\n" + 
				"\n" + 
				"<p>The Free Software Foundation may publish revised and/or new versions\n" + 
				"of the GNU Lesser General Public License from time to time. Such new\n" + 
				"versions will be similar in spirit to the present version, but may\n" + 
				"differ in detail to address new problems or concerns.</p>\n" + 
				"\n" + 
				"<p>Each version is given a distinguishing version number. If the\n" + 
				"Library as you received it specifies that a certain numbered version\n" + 
				"of the GNU Lesser General Public License &ldquo;or any later version&rdquo;\n" + 
				"applies to it, you have the option of following the terms and\n" + 
				"conditions either of that published version or of any later version\n" + 
				"published by the Free Software Foundation. If the Library as you\n" + 
				"received it does not specify a version number of the GNU Lesser\n" + 
				"General Public License, you may choose any version of the GNU Lesser\n" + 
				"General Public License ever published by the Free Software Foundation.</p>\n" + 
				"\n" + 
				"<p>If the Library as you received it specifies that a proxy can decide\n" + 
				"whether future versions of the GNU Lesser General Public License shall\n" + 
				"apply, that proxy's public statement of acceptance of any version is\n" + 
				"permanent authorization for you to choose that version for the\n" + 
				"Library.</p>\n" + 
				"\n" + 
				//"</body></html>\n" + 
				"";
		}

	@Override
	public String getLicenseName()
		{
		return "LGPL Version 3";
		}

	@Override
	public String getShortLicenseName()
		{
		return "LGPL3";
		}

	}
