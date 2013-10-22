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
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.AbstractListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import com.ritolaaudio.fcdspectrum.license.GPL3;
import com.ritolaaudio.fcdspectrum.license.LGPL21;
import com.ritolaaudio.fcdspectrum.license.License;
import com.ritolaaudio.fcdspectrum.license.LicenseEntry;

public class LicenseDisplay extends JFrame
	{
	private JPanel contentPane;
	private final LicenseEntry [] licenseEntries;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
		{
		EventQueue.invokeLater(new Runnable()
			{
			public void run()
				{
				try
					{
					LicenseDisplay frame = new LicenseDisplay();
					frame.setVisible(true);
					}
				catch (Exception e)
					{
					e.printStackTrace();
					}
				}//end run()
			});
		}

	public LicenseDisplay()
		{this(new LicenseEntry[]
			{new LicenseEntry("Sweeper","Credits here",new License[]
						{new GPL3(), new LGPL21()}),new LicenseEntry("javaHIDAPI","Credits here.",new License[]{new GPL3()})});}
	/**
	 * Create the frame.
	 */
	public LicenseDisplay(LicenseEntry [] licenseEntries)
		{
		this.licenseEntries=licenseEntries;
		setTitle("License");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 678, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		final String [] entryNames = new String[licenseEntries.length];
		for(int i=0; i<licenseEntries.length; i++){entryNames[i]=licenseEntries[i].getEntryName();}
		
		JSplitPane splitPane = new JSplitPane();
		contentPane.add(splitPane, BorderLayout.CENTER);
		
		JScrollPane scrollPane = new JScrollPane();
		splitPane.setLeftComponent(scrollPane);
		splitPane.setDividerLocation(120);
		
		final JList list = new JList();
		list.setModel(new AbstractListModel() {
			String[] values = entryNames;
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		scrollPane.setViewportView(list);
		
		final CardLayout licenseDisplayPanelLayout;
		
		final JPanel licenseDisplayPanel = new JPanel();
		splitPane.setRightComponent(licenseDisplayPanel);
		licenseDisplayPanel.setLayout(licenseDisplayPanelLayout =new CardLayout(0, 0));
		
		for(int i=0; i<licenseEntries.length;i++)
			{licenseDisplayPanel.add(new LicenseItem(licenseEntries[i]),i+"");}
		
		list.addListSelectionListener(new ListSelectionListener()
			{
			@Override
			public void valueChanged(ListSelectionEvent event)
				{licenseDisplayPanelLayout.show(licenseDisplayPanel, ""+list.getSelectedIndex());}
			});
		}
	}
