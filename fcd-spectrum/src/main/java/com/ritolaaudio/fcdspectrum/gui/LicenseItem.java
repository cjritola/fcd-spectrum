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

import java.awt.BorderLayout;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;

import com.ritolaaudio.fcdspectrum.license.License;
import com.ritolaaudio.fcdspectrum.license.LicenseEntry;

public class LicenseItem extends JPanel
	{

	/**
	 * Create the panel.
	 */
	public LicenseItem(LicenseEntry entry)
		{
		setLayout(new BorderLayout(0, 0));
		
		String nameOfItem=entry.getEntryName();
		License [] licenses = entry.getLicenses();
		
		JPanel rootPanel = new JPanel();
		rootPanel.setBorder(new TitledBorder(null, nameOfItem, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		add(rootPanel,BorderLayout.CENTER);
		rootPanel.setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		JEditorPane creditText = new JEditorPane();
		creditText.setContentType("text/html");
		creditText.setEditable(false);
		creditText.setText(entry.getCredits());
		tabbedPane.addTab("Credits", creditText);
		for(License license:licenses)
			{
			final JEditorPane dtrpnHtmlLicenseText = new JEditorPane();
			dtrpnHtmlLicenseText.setContentType("text/html");
			dtrpnHtmlLicenseText.setEditable(false);
			dtrpnHtmlLicenseText.setText(license.getHTML());
			dtrpnHtmlLicenseText.setCaretPosition(0);
			JScrollPane scrollPane = new JScrollPane(dtrpnHtmlLicenseText);
			
			tabbedPane.addTab(license.getLicenseName(),null,scrollPane,license.getLicenseName());
			}
		rootPanel.add(tabbedPane, BorderLayout.CENTER);
		}
	}
