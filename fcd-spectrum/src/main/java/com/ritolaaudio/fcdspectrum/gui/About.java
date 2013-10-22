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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.ritolaaudio.fcdspectrum.Configuration;
import com.ritolaaudio.fcdspectrum.license.CopyingCredits;

public class About extends JDialog
	{

	private final JPanel contentPanel = new JPanel();

	private static final String creditsText = CopyingCredits.credits.getProjectName()+"\n" +
			CopyingCredits.credits.getProjectDescription()+"\n" +
			"© Copyright 2013 Chuck Ritola <cjritola@gmail.com>\n" +
			"Licensed GPL v3. but uses third-party libraries of\nvarious licenses.\n" +
			"See \"Credits and Licenses\" in the Help menu for details.";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
		{
		try
			{
			About dialog = new About();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			}
		catch (Exception e)
			{
			e.printStackTrace();
			}
		}

	/**
	 * Create the dialog.
	 */
	public About()
		{
		setTitle("About");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
		JEditorPane editorPane = new JEditorPane();
		editorPane.setEditable(false);
		editorPane.setText(creditsText);
		contentPanel.add(editorPane);
			{
			JPanel buttonPane = new JPanel();
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
				buttonPane.setLayout(new BorderLayout(0, 0));
				{
				JButton okButton = new JButton("OK");
				okButton.setToolTipText("Click to close");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				okButton.addActionListener(new ActionListener()
					{public void actionPerformed(ActionEvent evt){About.this.setVisible(false);}});
				}
			}
		}

	}
