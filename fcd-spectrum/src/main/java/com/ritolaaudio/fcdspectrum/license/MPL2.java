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

public class MPL2 implements License
	{

	@Override
	public String getHTML()
		{
		return "<!DOCTYPE html>\n" + 
				"<html>\n" + 
				"<head>\n" + 
				"  <meta charset=\"utf-8\" />\n" + 
				"  <meta name=\"generator\" content=\"pandoc\" />\n" + 
				"  <title>Mozilla Public License, version 2.0</title>\n" + 
				"  <!--[if lt IE 9]>\n" + 
				"    <script src=\"http://html5shim.googlecode.com/svn/trunk/html5.js\"></script>\n" + 
				"  <![endif]-->\n" + 
				"\n" + 
				"  <link href='http://fonts.googleapis.com/css?family=Crimson+Text' rel='stylesheet' type='text/css'>\n" + 
				"  <link href='http://fonts.googleapis.com/css?family=Lora' rel='stylesheet' type='text/css'>\n" + 
				"  <link href='http://fonts.googleapis.com/css?family=Droid+Sans+Mono' rel='stylesheet' type='text/css'>\n" + 
				"\n" + 
				"  <style type=\"text/css\">\n" + 
				"	body { 	font-family: 'Crimson Text', serif; \n" + 
				"		max-width: 30em; \n" + 
				"		margin-left:auto;\n" + 
				"		margin-right:auto;\n" + 
				"		text-align: justify;\n" + 
				"		-moz-hyphens: auto;\n" + 
				"		font-size: 110%\n" + 
				"		}\n" + 
				"\n" + 
				"	h1, h2, h3 { \n" + 
				"		font-family: 'Lora', serif;\n" + 
				"	     	font-variant: small-caps;\n" + 
				"		}\n" + 
				"\n" + 
				"	h1 { \n" + 
				"		text-align: center;\n" + 
				"		-moz-hyphens: none;\n" + 
				"		font-size: 160%;\n" + 
				"		}\n" + 
				"	h2 {\n" + 
				"		font-size: 140%;\n" + 
				"		-moz-hyphens: none;\n" + 
				"		text-align: left;\n" + 
				"		}\n" + 
				"	h3 {	\n" + 
				"		font-size: 120%;\n" + 
				"		-moz-hyphens: none;\n" + 
				"		text-align: left;		\n" + 
				"		}\n" + 
				"\n" + 
				"	blockquote { 	\n" + 
				"		font-family: 'Droid Sans Mono', mono;\n" + 
				"		text-align: left; \n" + 
				"		-moz-hyphens: none;\n" + 
				"		}\n" + 
				"	\n" + 
				"	code {\n" + 
				"		font-family: 'Droid Sans Mono', mono;\n" + 
				"		}\n" + 
				"\n" + 
				"	em {\n" + 
				"		background: #FEFD80;\n" + 
				"		border: 30px solid #FEFD80;\n" + 
				"		float: left;\n" + 
				"		line-height: 1.25em;\n" + 
				"    		margin-left: 10px;\n" + 
				"		margin-right: 10px;\n" + 
				"		margin-bottom: 10px;\n" + 
				"		margin-top:-10px;\n" + 
				"/*		text-transform: uppercase; */\n" + 
				"		font-style: normal;\n" + 
				"	}\n" + 
				"\n" + 
				"	dt {	font-family: 'Lora', serif;\n" + 
				"		font-weight: bold; \n" + 
				"		font-size: 100%;\n" + 
				"		}\n" + 
				"\n" + 
				"  </style>\n" + 
				"</head>\n" + 
				"<body>\n" + 
				"<h1 id=\"mozilla-public-license-version-2.0\">Mozilla Public License<br>Version 2.0</h1>\n" + 
				"<h2 id=\"definitions\">1. Definitions</h2>\n" + 
				"<dl>\n" + 
				"<dt>1.1. “Contributor”</dt>\n" + 
				"<dd><p>means each individual or legal entity that creates, contributes to the creation of, or owns Covered Software.</p>\n" + 
				"</dd>\n" + 
				"<dt>1.2. “Contributor Version”</dt>\n" + 
				"<dd><p>means the combination of the Contributions of others (if any) used by a Contributor and that particular Contributor’s Contribution.</p>\n" + 
				"</dd>\n" + 
				"<dt>1.3. “Contribution”</dt>\n" + 
				"<dd><p>means Covered Software of a particular Contributor.</p>\n" + 
				"</dd>\n" + 
				"<dt>1.4. “Covered Software”</dt>\n" + 
				"<dd><p>means Source Code Form to which the initial Contributor has attached the notice in Exhibit A, the Executable Form of such Source Code Form, and Modifications of such Source Code Form, in each case including portions thereof.</p>\n" + 
				"</dd>\n" + 
				"<dt>1.5. “Incompatible With Secondary Licenses”</dt>\n" + 
				"<dd><p>means</p>\n" + 
				"<ol type=\"a\">\n" + 
				"<li><p>that the initial Contributor has attached the notice described in Exhibit B to the Covered Software; or</p></li>\n" + 
				"<li><p>that the Covered Software was made available under the terms of version 1.1 or earlier of the License, but not also under the terms of a Secondary License.</p></li>\n" + 
				"</ol>\n" + 
				"</dd>\n" + 
				"<dt>1.6. “Executable Form”</dt>\n" + 
				"<dd><p>means any form of the work other than Source Code Form.</p>\n" + 
				"</dd>\n" + 
				"<dt>1.7. “Larger Work”</dt>\n" + 
				"<dd><p>means a work that combines Covered Software with other material, in a separate file or files, that is not Covered Software.</p>\n" + 
				"</dd>\n" + 
				"<dt>1.8. “License”</dt>\n" + 
				"<dd><p>means this document.</p>\n" + 
				"</dd>\n" + 
				"<dt>1.9. “Licensable”</dt>\n" + 
				"<dd><p>means having the right to grant, to the maximum extent possible, whether at the time of the initial grant or subsequently, any and all of the rights conveyed by this License.</p>\n" + 
				"</dd>\n" + 
				"<dt>1.10. “Modifications”</dt>\n" + 
				"<dd><p>means any of the following:</p>\n" + 
				"<ol type=\"a\">\n" + 
				"<li><p>any file in Source Code Form that results from an addition to, deletion from, or modification of the contents of Covered Software; or</p></li>\n" + 
				"<li><p>any new file in Source Code Form that contains any Covered Software.</p></li>\n" + 
				"</ol>\n" + 
				"</dd>\n" + 
				"<dt>1.11. “Patent Claims” of a Contributor</dt>\n" + 
				"<dd><p>means any patent claim(s), including without limitation, method, process, and apparatus claims, in any patent Licensable by such Contributor that would be infringed, but for the grant of the License, by the making, using, selling, offering for sale, having made, import, or transfer of either its Contributions or its Contributor Version.</p>\n" + 
				"</dd>\n" + 
				"<dt>1.12. “Secondary License”</dt>\n" + 
				"<dd><p>means either the GNU General Public License, Version 2.0, the GNU Lesser General Public License, Version 2.1, the GNU Affero General Public License, Version 3.0, or any later versions of those licenses.</p>\n" + 
				"</dd>\n" + 
				"<dt>1.13. “Source Code Form”</dt>\n" + 
				"<dd><p>means the form of the work preferred for making modifications.</p>\n" + 
				"</dd>\n" + 
				"<dt>1.14. “You” (or “Your”)</dt>\n" + 
				"<dd><p>means an individual or a legal entity exercising rights under this License. For legal entities, “You” includes any entity that controls, is controlled by, or is under common control with You. For purposes of this definition, “control” means (a) the power, direct or indirect, to cause the direction or management of such entity, whether by contract or otherwise, or (b) ownership of more than fifty percent (50%) of the outstanding shares or beneficial ownership of such entity.</p>\n" + 
				"</dd>\n" + 
				"</dl>\n" + 
				"<h2 id=\"license-grants-and-conditions\">2. License Grants and Conditions</h2>\n" + 
				"<h3 id=\"grants\">2.1. Grants</h3>\n" + 
				"<p>Each Contributor hereby grants You a world-wide, royalty-free, non-exclusive license:</p>\n" + 
				"<ol type=\"a\">\n" + 
				"<li><p>under intellectual property rights (other than patent or trademark) Licensable by such Contributor to use, reproduce, make available, modify, display, perform, distribute, and otherwise exploit its Contributions, either on an unmodified basis, with Modifications, or as part of a Larger Work; and</p></li>\n" + 
				"<li><p>under Patent Claims of such Contributor to make, use, sell, offer for sale, have made, import, and otherwise transfer either its Contributions or its Contributor Version.</p></li>\n" + 
				"</ol>\n" + 
				"<h3 id=\"effective-date\">2.2. Effective Date</h3>\n" + 
				"<p>The licenses granted in Section&nbsp;2.1 with respect to any Contribution become effective for each Contribution on the date the Contributor first distributes such Contribution.</p>\n" + 
				"<h3 id=\"limitations-on-grant-scope\">2.3. Limitations on Grant Scope</h3>\n" + 
				"<p>The licenses granted in this Section&nbsp;2 are the only rights granted under this License. No additional rights or licenses will be implied from the distribution or licensing of Covered Software under this License. Notwithstanding Section&nbsp;2.1(b) above, no patent license is granted by a Contributor:</p>\n" + 
				"<ol type=\"a\">\n" + 
				"<li><p>for any code that a Contributor has removed from Covered Software; or</p></li>\n" + 
				"<li><p>for infringements caused by: (i) Your and any other third party’s modifications of Covered Software, or (ii) the combination of its Contributions with other software (except as part of its Contributor Version); or</p></li>\n" + 
				"<li><p>under Patent Claims infringed by Covered Software in the absence of its Contributions.</p></li>\n" + 
				"</ol>\n" + 
				"<p>This License does not grant any rights in the trademarks, service marks, or logos of any Contributor (except as may be necessary to comply with the notice requirements in Section&nbsp;3.4).</p>\n" + 
				"<h3 id=\"subsequent-licenses\">2.4. Subsequent Licenses</h3>\n" + 
				"<p>No Contributor makes additional grants as a result of Your choice to distribute the Covered Software under a subsequent version of this License (see Section&nbsp;10.2) or under the terms of a Secondary License (if permitted under the terms of Section&nbsp;3.3).</p>\n" + 
				"<h3 id=\"representation\">2.5. Representation</h3>\n" + 
				"<p>Each Contributor represents that the Contributor believes its Contributions are its original creation(s) or it has sufficient rights to grant the rights to its Contributions conveyed by this License.</p>\n" + 
				"<h3 id=\"fair-use\">2.6. Fair Use</h3>\n" + 
				"<p>This License is not intended to limit any rights You have under applicable copyright doctrines of fair use, fair dealing, or other equivalents.</p>\n" + 
				"<h3 id=\"conditions\">2.7. Conditions</h3>\n" + 
				"<p>Sections 3.1, 3.2, 3.3, and 3.4 are conditions of the licenses granted in Section&nbsp;2.1.</p>\n" + 
				"<h2 id=\"responsibilities\">3. Responsibilities</h2>\n" + 
				"<h3 id=\"distribution-of-source-form\">3.1. Distribution of Source Form</h3>\n" + 
				"<p>All distribution of Covered Software in Source Code Form, including any Modifications that You create or to which You contribute, must be under the terms of this License. You must inform recipients that the Source Code Form of the Covered Software is governed by the terms of this License, and how they can obtain a copy of this License. You may not attempt to alter or restrict the recipients’ rights in the Source Code Form.</p>\n" + 
				"<h3 id=\"distribution-of-executable-form\">3.2. Distribution of Executable Form</h3>\n" + 
				"<p>If You distribute Covered Software in Executable Form then:</p>\n" + 
				"<ol type=\"a\">\n" + 
				"<li><p>such Covered Software must also be made available in Source Code Form, as described in Section&nbsp;3.1, and You must inform recipients of the Executable Form how they can obtain a copy of such Source Code Form by reasonable means in a timely manner, at a charge no more than the cost of distribution to the recipient; and</p></li>\n" + 
				"<li><p>You may distribute such Executable Form under the terms of this License, or sublicense it under different terms, provided that the license for the Executable Form does not attempt to limit or alter the recipients’ rights in the Source Code Form under this License.</p></li>\n" + 
				"</ol>\n" + 
				"<h3 id=\"distribution-of-a-larger-work\">3.3. Distribution of a Larger Work</h3>\n" + 
				"<p>You may create and distribute a Larger Work under terms of Your choice, provided that You also comply with the requirements of this License for the Covered Software. If the Larger Work is a combination of Covered Software with a work governed by one or more Secondary Licenses, and the Covered Software is not Incompatible With Secondary Licenses, this License permits You to additionally distribute such Covered Software under the terms of such Secondary License(s), so that the recipient of the Larger Work may, at their option, further distribute the Covered Software under the terms of either this License or such Secondary License(s).</p>\n" + 
				"<h3 id=\"notices\">3.4. Notices</h3>\n" + 
				"<p>You may not remove or alter the substance of any license notices (including copyright notices, patent notices, disclaimers of warranty, or limitations of liability) contained within the Source Code Form of the Covered Software, except that You may alter any license notices to the extent required to remedy known factual inaccuracies.</p>\n" + 
				"<h3 id=\"application-of-additional-terms\">3.5. Application of Additional Terms</h3>\n" + 
				"<p>You may choose to offer, and to charge a fee for, warranty, support, indemnity or liability obligations to one or more recipients of Covered Software. However, You may do so only on Your own behalf, and not on behalf of any Contributor. You must make it absolutely clear that any such warranty, support, indemnity, or liability obligation is offered by You alone, and You hereby agree to indemnify every Contributor for any liability incurred by such Contributor as a result of warranty, support, indemnity or liability terms You offer. You may include additional disclaimers of warranty and limitations of liability specific to any jurisdiction.</p>\n" + 
				"<h2 id=\"inability-to-comply-due-to-statute-or-regulation\">4. Inability to Comply Due to Statute or Regulation</h2>\n" + 
				"<p>If it is impossible for You to comply with any of the terms of this License with respect to some or all of the Covered Software due to statute, judicial order, or regulation then You must: (a) comply with the terms of this License to the maximum extent possible; and (b) describe the limitations and the code they affect. Such description must be placed in a text file included with all distributions of the Covered Software under this License. Except to the extent prohibited by statute or regulation, such description must be sufficiently detailed for a recipient of ordinary skill to be able to understand it.</p>\n" + 
				"<h2 id=\"termination\">5. Termination</h2>\n" + 
				"<p>5.1. The rights granted under this License will terminate automatically if You fail to comply with any of its terms. However, if You become compliant, then the rights granted under this License from a particular Contributor are reinstated (a) provisionally, unless and until such Contributor explicitly and finally terminates Your grants, and (b) on an ongoing basis, if such Contributor fails to notify You of the non-compliance by some reasonable means prior to 60 days after You have come back into compliance. Moreover, Your grants from a particular Contributor are reinstated on an ongoing basis if such Contributor notifies You of the non-compliance by some reasonable means, this is the first time You have received notice of non-compliance with this License from such Contributor, and You become compliant prior to 30 days after Your receipt of the notice.</p>\n" + 
				"<p>5.2. If You initiate litigation against any entity by asserting a patent infringement claim (excluding declaratory judgment actions, counter-claims, and cross-claims) alleging that a Contributor Version directly or indirectly infringes any patent, then the rights granted to You by any and all Contributors for the Covered Software under Section&nbsp;2.1 of this License shall terminate.</p>\n" + 
				"<p>5.3. In the event of termination under Sections&nbsp;5.1 or 5.2 above, all end user license agreements (excluding distributors and resellers) which have been validly granted by You or Your distributors under this License prior to termination shall survive termination.</p>\n" + 
				"<h2 id=\"disclaimer-of-warranty\">6. Disclaimer of Warranty</h2>\n" + 
				"<p><em>Covered Software is provided under this License on an “as is” basis, without warranty of any kind, either expressed, implied, or statutory, including, without limitation, warranties that the Covered Software is free of defects, merchantable, fit for a particular purpose or non-infringing. The entire risk as to the quality and performance of the Covered Software is with You. Should any Covered Software prove defective in any respect, You (not any Contributor) assume the cost of any necessary servicing, repair, or correction. This disclaimer of warranty constitutes an essential part of this License. No use of any Covered Software is authorized under this License except under this disclaimer.</em></p>\n" + 
				"<h2 id=\"limitation-of-liability\">7. Limitation of Liability</h2>\n" + 
				"<p><em>Under no circumstances and under no legal theory, whether tort (including negligence), contract, or otherwise, shall any Contributor, or anyone who distributes Covered Software as permitted above, be liable to You for any direct, indirect, special, incidental, or consequential damages of any character including, without limitation, damages for lost profits, loss of goodwill, work stoppage, computer failure or malfunction, or any and all other commercial damages or losses, even if such party shall have been informed of the possibility of such damages. This limitation of liability shall not apply to liability for death or personal injury resulting from such party’s negligence to the extent applicable law prohibits such limitation. Some jurisdictions do not allow the exclusion or limitation of incidental or consequential damages, so this exclusion and limitation may not apply to You.</em></p>\n" + 
				"<h2 id=\"litigation\">8. Litigation</h2>\n" + 
				"<p>Any litigation relating to this License may be brought only in the courts of a jurisdiction where the defendant maintains its principal place of business and such litigation shall be governed by laws of that jurisdiction, without reference to its conflict-of-law provisions. Nothing in this Section shall prevent a party’s ability to bring cross-claims or counter-claims.</p>\n" + 
				"<h2 id=\"miscellaneous\">9. Miscellaneous</h2>\n" + 
				"<p>This License represents the complete agreement concerning the subject matter hereof. If any provision of this License is held to be unenforceable, such provision shall be reformed only to the extent necessary to make it enforceable. Any law or regulation which provides that the language of a contract shall be construed against the drafter shall not be used to construe this License against a Contributor.</p>\n" + 
				"<h2 id=\"versions-of-the-license\">10. Versions of the License</h2>\n" + 
				"<h3 id=\"new-versions\">10.1. New Versions</h3>\n" + 
				"<p>Mozilla Foundation is the license steward. Except as provided in Section&nbsp;10.3, no one other than the license steward has the right to modify or publish new versions of this License. Each version will be given a distinguishing version number.</p>\n" + 
				"<h3 id=\"effect-of-new-versions\">10.2. Effect of New Versions</h3>\n" + 
				"<p>You may distribute the Covered Software under the terms of the version of the License under which You originally received the Covered Software, or under the terms of any subsequent version published by the license steward.</p>\n" + 
				"<h3 id=\"modified-versions\">10.3. Modified Versions</h3>\n" + 
				"<p>If you create software not governed by this License, and you want to create a new license for such software, you may create and use a modified version of this License if you rename the license and remove any references to the name of the license steward (except to note that such modified license differs from this License).</p>\n" + 
				"<h3 id=\"distributing-source-code-form-that-is-incompatible-with-secondary-licenses\">10.4. Distributing Source Code Form that is Incompatible With Secondary Licenses</h3>\n" + 
				"<p>If You choose to distribute Source Code Form that is Incompatible With Secondary Licenses under the terms of this version of the License, the notice described in Exhibit B of this License must be attached.</p>\n" + 
				"<h2 id=\"exhibit-a---source-code-form-license-notice\">Exhibit A - Source Code Form License Notice</h2>\n" + 
				"<blockquote>\n" + 
				"<p>This Source Code Form is subject to the terms of the Mozilla Public License, v. 2.0. If a copy of the MPL was not distributed with this file, You can obtain one at http://mozilla.org/MPL/2.0/.</p>\n" + 
				"</blockquote>\n" + 
				"<p>If it is not possible or desirable to put the notice in a particular file, then You may include the notice in a location (such as a LICENSE file in a relevant directory) where a recipient would be likely to look for such a notice.</p>\n" + 
				"<p>You may add additional accurate notices of copyright ownership.</p>\n" + 
				"<h2 id=\"exhibit-b---incompatible-with-secondary-licenses-notice\">Exhibit B - “Incompatible With Secondary Licenses” Notice</h2>\n" + 
				"<blockquote>\n" + 
				"<p>This Source Code Form is “Incompatible With Secondary Licenses”, as defined by the Mozilla Public License, v. 2.0.</p>\n" + 
				"</blockquote>\n" + 
				"</body>\n" + 
				"</html>\n" + 
				"";
		}

	@Override
	public String getLicenseName()
		{
		return "Mozilla Public License v2";
		}

	@Override
	public String getShortLicenseName()
		{
		return "MPL2";
		}

	}
