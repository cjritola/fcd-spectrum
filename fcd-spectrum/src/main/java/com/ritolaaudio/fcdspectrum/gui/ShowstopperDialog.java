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
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.ritolaaudio.fcdspectrum.Log;

public class ShowstopperDialog extends JDialog
	{

	private final JPanel contentPanel = new JPanel();
	private JTextArea errorDetailsArea, stackTraceArea;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args)
		{
		try
			{
			//System.out.println("foo");
			ShowstopperDialog dialog = new ShowstopperDialog("Specific message here",new Exception("This is the exception which caused it."));
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			//System.out.println("bar");
			}
		catch (Exception e)
			{
			e.printStackTrace();
			}
		}

	/**
	 * Create the dialog.
	 */
	public ShowstopperDialog(String message, Exception causativeException)
		{
		Log.getLogger().severe(message);
		causativeException.printStackTrace();
		setTitle("Showstopper");
		setBounds(100, 100, 672, 425);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{109, 124, 480, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setIcon(new ImageIcon(ShowstopperDialog.class.getResource("/javax/swing/plaf/metal/icons/Error.gif")));
			GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
			gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
			gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
			gbc_lblNewLabel.gridx = 0;
			gbc_lblNewLabel.gridy = 0;
			contentPanel.add(lblNewLabel, gbc_lblNewLabel);
		}
		{
			JLabel lblAnExceptionHas = new JLabel("An exception has occurred. The operation cannot be continued.");
			GridBagConstraints gbc_lblAnExceptionHas = new GridBagConstraints();
			gbc_lblAnExceptionHas.anchor = GridBagConstraints.WEST;
			gbc_lblAnExceptionHas.gridwidth = 2;
			gbc_lblAnExceptionHas.insets = new Insets(0, 0, 5, 0);
			gbc_lblAnExceptionHas.gridx = 1;
			gbc_lblAnExceptionHas.gridy = 0;
			contentPanel.add(lblAnExceptionHas, gbc_lblAnExceptionHas);
		}
		{
			JLabel lblMessageHere = new JLabel(causativeException.getLocalizedMessage());
			GridBagConstraints gbc_lblMessageHere = new GridBagConstraints();
			gbc_lblMessageHere.insets = new Insets(0, 0, 5, 0);
			gbc_lblMessageHere.anchor = GridBagConstraints.WEST;
			gbc_lblMessageHere.gridwidth = 3;
			gbc_lblMessageHere.gridx = 0;
			gbc_lblMessageHere.gridy = 1;
			contentPanel.add(lblMessageHere, gbc_lblMessageHere);
		}
		{
			JPanel errorMsgPanel = new JPanel();
			errorMsgPanel.setBorder(new TitledBorder(null, "Error Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GridBagConstraints gbc_errorMsgPanel = new GridBagConstraints();
			gbc_errorMsgPanel.gridwidth = 3;
			gbc_errorMsgPanel.insets = new Insets(0, 0, 5, 5);
			gbc_errorMsgPanel.fill = GridBagConstraints.BOTH;
			gbc_errorMsgPanel.gridx = 0;
			gbc_errorMsgPanel.gridy = 2;
			contentPanel.add(errorMsgPanel, gbc_errorMsgPanel);
			errorMsgPanel.setLayout(new BorderLayout(0, 0));
			{
				errorDetailsArea = new JTextArea();
				JScrollPane edScrollPane = new JScrollPane(errorDetailsArea);
				errorDetailsArea.setText(message);
				errorMsgPanel.add(edScrollPane, BorderLayout.CENTER);
			}
		}
		{
			JPanel stackTracePanel = new JPanel();
			stackTracePanel.setBorder(new TitledBorder(null, "Stacktrace", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GridBagConstraints gbc_stackTracePanel = new GridBagConstraints();
			gbc_stackTracePanel.gridwidth = 3;
			gbc_stackTracePanel.fill = GridBagConstraints.BOTH;
			gbc_stackTracePanel.gridx = 0;
			gbc_stackTracePanel.gridy = 3;
			contentPanel.add(stackTracePanel, gbc_stackTracePanel);
			stackTracePanel.setLayout(new BorderLayout(0, 0));
			{
				stackTraceArea = new JTextArea();
				JScrollPane stScrollPane = new JScrollPane(stackTraceArea);
				StringWriter sw = new StringWriter();
				PrintWriter pw = new PrintWriter(sw);
				causativeException.printStackTrace(pw);
				stackTraceArea.setText(sw.toString());
				stackTracePanel.add(stScrollPane, BorderLayout.CENTER);
			}
		}
			{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
				{
				JButton copy2ClipboardButton = new JButton("Copy To Clipboard");
				buttonPane.add(copy2ClipboardButton);
				copy2ClipboardButton.addActionListener(new ActionListener()
					{
					@Override
					public void actionPerformed(ActionEvent arg0)
						{
						StringSelection dataToTransfer = new StringSelection(errorDetailsArea.getText()+"\n\n\n\n"+stackTraceArea.getText());
						Toolkit.getDefaultToolkit().getSystemClipboard().setContents(dataToTransfer, dataToTransfer);
						}
					});
				}
				{
				JButton abortButton = new JButton("Abort");
				buttonPane.add(abortButton);
				getRootPane().setDefaultButton(abortButton);
				abortButton.addActionListener(new ActionListener()
					{
					@Override
					public void actionPerformed(ActionEvent arg0)
						{
						ShowstopperDialog.this.setVisible(false);
						ShowstopperDialog.this.dispose();
						}
					});
				}
			}
		}//end constructor
	}//end ShowstopperDialog
