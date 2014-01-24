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
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.BevelBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileFilter;

import com.ritolaaudio.fcdspectrum.COPYING_CREDITS;
import com.ritolaaudio.fcdspectrum.Configuration;
import com.ritolaaudio.fcdspectrum.Log;
import com.ritolaaudio.fcdspectrum.SweepJob;


public class GUI
	{
	static
		{try{
		for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) 
			{
			if ("Nimbus".equals(info.getName()))
				{
				UIManager.setLookAndFeel(info.getClassName());
				break;
				}
			}//end for(l&f)
		} catch (Exception e) {}}//end static{}
	
	private JFrame frmSweeper;
	private File outputFile=new File(Configuration.CONFIGURATION.getOutputCSVPath());
	private LoggingGUI loggingGUI = new LoggingGUI();//This is the window
	private GUILogger guiLogger = new GUILogger(loggingGUI);//This is the actual Logger

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
						GUI window = new GUI();
						window.frmSweeper.setVisible(true);
						}
					catch (Exception e)
						{
						e.printStackTrace();
						}
					}
			});
		}//end main()

	/**
	 * Create the application.
	 */
	public GUI()
		{
		Log.setLogger(guiLogger);
		guiLogger.info("GUI started.");
		guiLogger.startEatingConsoleOutput();
		initialize();
		}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize()
		{
		frmSweeper = new JFrame();
		frmSweeper.setTitle("Sweeper");
		frmSweeper.setBounds(100, 100, 452, 234);
		frmSweeper.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSweeper.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel root = new JPanel();
		root.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frmSweeper.getContentPane().add(root, BorderLayout.NORTH);
		GridBagLayout gbl_root = new GridBagLayout();
		gbl_root.columnWidths = new int[]{169, 101, 90, 0};
		gbl_root.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_root.columnWeights = new double[]{0.0, 1.0, 1.0, Double.MIN_VALUE};
		gbl_root.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		root.setLayout(gbl_root);
		
		JLabel lblFrequency = new JLabel("Start Frequency");
		GridBagConstraints gbc_lblFrequency = new GridBagConstraints();
		gbc_lblFrequency.anchor = GridBagConstraints.EAST;
		gbc_lblFrequency.insets = new Insets(0, 0, 5, 5);
		gbc_lblFrequency.gridx = 0;
		gbc_lblFrequency.gridy = 0;
		root.add(lblFrequency, gbc_lblFrequency);
		
		final JSpinner startFrequency = new JSpinner();
		startFrequency.setModel(new SpinnerNumberModel(
				Configuration.CONFIGURATION.getStartFreq(), 150000, 2050000000, 1000));
		GridBagConstraints gbc_spinner = new GridBagConstraints();
		gbc_spinner.anchor = GridBagConstraints.EAST;
		gbc_spinner.insets = new Insets(0, 0, 5, 5);
		gbc_spinner.gridx = 1;
		gbc_spinner.gridy = 0;
		startFrequency.addChangeListener(new ChangeListener()
			{
			@Override
			public void stateChanged(ChangeEvent arg0)
				{Configuration.CONFIGURATION.setStartFreq((Integer)startFrequency.getValue());
				}
			});
		root.add(startFrequency, gbc_spinner);
		
		JLabel lblHz = new JLabel("Hz");
		lblHz.setHorizontalAlignment(SwingConstants.LEFT);
		GridBagConstraints gbc_lblHz = new GridBagConstraints();
		gbc_lblHz.anchor = GridBagConstraints.WEST;
		gbc_lblHz.insets = new Insets(0, 0, 5, 0);
		gbc_lblHz.gridx = 2;
		gbc_lblHz.gridy = 0;
		root.add(lblHz, gbc_lblHz);
		
		JLabel lblGain = new JLabel("End Frequency");
		GridBagConstraints gbc_lblGain = new GridBagConstraints();
		gbc_lblGain.anchor = GridBagConstraints.EAST;
		gbc_lblGain.insets = new Insets(0, 0, 5, 5);
		gbc_lblGain.gridx = 0;
		gbc_lblGain.gridy = 1;
		root.add(lblGain, gbc_lblGain);
		
		final JSpinner endFrequency = new JSpinner();
		endFrequency.setModel(new SpinnerNumberModel(
				Configuration.CONFIGURATION.getEndFreq(), 150000, 2050000000, 1));
		GridBagConstraints gbc_endFrequency = new GridBagConstraints();
		gbc_endFrequency.anchor = GridBagConstraints.EAST;
		gbc_endFrequency.insets = new Insets(0, 0, 5, 5);
		gbc_endFrequency.gridx = 1;
		gbc_endFrequency.gridy = 1;
		root.add(endFrequency, gbc_endFrequency);
		endFrequency.addChangeListener(new ChangeListener(){
			@Override
			public void stateChanged(ChangeEvent arg0)
				{Configuration.CONFIGURATION.setEndFreq((Integer)endFrequency.getValue());}
			});
		
		JLabel lblHz_1 = new JLabel("Hz");
		GridBagConstraints gbc_lblHz_1 = new GridBagConstraints();
		gbc_lblHz_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblHz_1.anchor = GridBagConstraints.WEST;
		gbc_lblHz_1.gridx = 2;
		gbc_lblHz_1.gridy = 1;
		root.add(lblHz_1, gbc_lblHz_1);
		
		JLabel lblFftSize = new JLabel("FFT Size");
		GridBagConstraints gbc_lblFftSize = new GridBagConstraints();
		gbc_lblFftSize.anchor = GridBagConstraints.EAST;
		gbc_lblFftSize.insets = new Insets(0, 0, 5, 5);
		gbc_lblFftSize.gridx = 0;
		gbc_lblFftSize.gridy = 2;
		root.add(lblFftSize, gbc_lblFftSize);
		
		final JComboBox<String> fftSizeCombo = new JComboBox<String>();
		fftSizeCombo.setModel(new DefaultComboBoxModel<String>(new String[] {"16","32","64", "128", "256", "512", "1024", "2048", "4096","8192"}));
		fftSizeCombo.setSelectedItem(Configuration.CONFIGURATION.getFftSize());
		GridBagConstraints gbc_comboBox = new GridBagConstraints();
		gbc_comboBox.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox.insets = new Insets(0, 0, 5, 5);
		gbc_comboBox.gridx = 1;
		gbc_comboBox.gridy = 2;
		root.add(fftSizeCombo, gbc_comboBox);
		fftSizeCombo.addActionListener(new ActionListener(){
		    @Override
		    public void actionPerformed(ActionEvent e) {
			final int fftSize =Integer.parseInt((String)fftSizeCombo.getSelectedItem());
			Configuration.CONFIGURATION.setFftSize(fftSize);
			guiLogger.info("User changed fft size to "+fftSize);
		    }
		    
		});
		
		JLabel lblSamples = new JLabel("Samples");
		GridBagConstraints gbc_lblSamples = new GridBagConstraints();
		gbc_lblSamples.anchor = GridBagConstraints.WEST;
		gbc_lblSamples.insets = new Insets(0, 0, 5, 0);
		gbc_lblSamples.gridx = 2;
		gbc_lblSamples.gridy = 2;
		root.add(lblSamples, gbc_lblSamples);
		
		JLabel lblMixerGain = new JLabel("Total Gain");
		GridBagConstraints gbc_lblMixerGain = new GridBagConstraints();
		gbc_lblMixerGain.anchor = GridBagConstraints.EAST;
		gbc_lblMixerGain.insets = new Insets(0, 0, 5, 5);
		gbc_lblMixerGain.gridx = 0;
		gbc_lblMixerGain.gridy = 3;
		root.add(lblMixerGain, gbc_lblMixerGain);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 3;
		root.add(panel, gbc_panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		final JCheckBox chckbxAuto = new JCheckBox("Auto");
		chckbxAuto.setSelected(Configuration.CONFIGURATION.getManualGain()==null);
		panel.add(chckbxAuto);
		
		final JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(0, 0, 50, 1));
		spinner.setEnabled(Configuration.CONFIGURATION.getManualGain()!=null);
		if(spinner.isEnabled()){spinner.setValue(Configuration.CONFIGURATION.getManualGain());}
		panel.add(spinner);
		spinner.addChangeListener(new ChangeListener(){
		    @Override
		    public void stateChanged(ChangeEvent evt) {
			Configuration.CONFIGURATION.setManualGain((Integer)spinner.getValue());
		    }//end stateChanged(...)
		});
		
		chckbxAuto.addChangeListener(new ChangeListener(){
		    @Override
		    public void stateChanged(ChangeEvent evt) {
			spinner.setEnabled(!chckbxAuto.isSelected());
			if(chckbxAuto.isSelected()){
			    Configuration.CONFIGURATION.setManualGain(null);
			}else{Configuration.CONFIGURATION.setManualGain((Integer)spinner.getValue());}
		    }
		});
		
		JLabel lblDb = new JLabel("dB");
		GridBagConstraints gbc_lblDb = new GridBagConstraints();
		gbc_lblDb.anchor = GridBagConstraints.WEST;
		gbc_lblDb.insets = new Insets(0, 0, 5, 0);
		gbc_lblDb.gridx = 2;
		gbc_lblDb.gridy = 3;
		root.add(lblDb, gbc_lblDb);
		
		JLabel lblWriteResultsTo = new JLabel("Write CSV Results To:");
		GridBagConstraints gbc_lblWriteResultsTo = new GridBagConstraints();
		gbc_lblWriteResultsTo.anchor = GridBagConstraints.EAST;
		gbc_lblWriteResultsTo.insets = new Insets(0, 0, 0, 5);
		gbc_lblWriteResultsTo.gridx = 0;
		gbc_lblWriteResultsTo.gridy = 4;
		root.add(lblWriteResultsTo, gbc_lblWriteResultsTo);
		
		final JLabel filePath = new JLabel(Configuration.CONFIGURATION.getOutputCSVPath());
		GridBagConstraints gbc_filePath = new GridBagConstraints();
		gbc_filePath.insets = new Insets(0, 0, 0, 5);
		gbc_filePath.gridx = 1;
		gbc_filePath.gridy = 4;
		root.add(filePath, gbc_filePath);
		
		JButton specifyButton = new JButton("Specify");
		GridBagConstraints gbc_btnSelect = new GridBagConstraints();
		gbc_btnSelect.anchor = GridBagConstraints.WEST;
		gbc_btnSelect.gridx = 2;
		gbc_btnSelect.gridy = 4;
		root.add(specifyButton, gbc_btnSelect);
		specifyButton.addActionListener(new ActionListener()
			{public void actionPerformed(ActionEvent evt)
				{
				final JFileChooser chooser = new JFileChooser();
				chooser.setFileFilter(new FileFilter()
					{
					@Override
					public boolean accept(File file)
						{return(file.getName().toLowerCase().endsWith(".csv") || file.isDirectory());}

					@Override
					public String getDescription()
						{return "Comma-Separated Values (.CSV)";}
					});
				int result = chooser.showSaveDialog(frmSweeper);
				if(result == JFileChooser.APPROVE_OPTION)
					{
					outputFile = chooser.getSelectedFile();
					if(!outputFile.getName().toLowerCase().endsWith(".csv")){outputFile=new File(outputFile.getAbsolutePath()+".csv");}
					Configuration.CONFIGURATION.setOutputCSVPath(outputFile.getAbsolutePath());
					filePath.setText(outputFile.getName());
					}
				}});
		
		JPanel infoPanel = new JPanel();
		frmSweeper.getContentPane().add(infoPanel, BorderLayout.SOUTH);
		infoPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton executeButton = new JButton("Execute");
		infoPanel.add(executeButton);
		executeButton.addActionListener(new ActionListener()
			{public void actionPerformed(ActionEvent evt){
				new SweepProgressDialog(new SweepJob(
					(Integer)startFrequency.getValue(),
					(Integer)endFrequency.getValue(),
					!chckbxAuto.isSelected()?(Integer)spinner.getValue():null,
					outputFile,Integer.parseInt((String)fftSizeCombo.getSelectedItem()),
					guiLogger));
				guiLogger.info("User clicked 'execute'");
				}});
		
		JButton btnViewSweep = new JButton("View Sweep");
		infoPanel.add(btnViewSweep);
		btnViewSweep.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent evt){new SpectrumViewer(new File(filePath.getText()));
			guiLogger.info("User clicked 'view sweep'");
			}});
		
		JMenuBar menuBar = new JMenuBar();
		frmSweeper.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmQuit = new JMenuItem("Quit");
		mnFile.add(mntmQuit);
		mntmQuit.addActionListener(new ActionListener()
			{public void actionPerformed(ActionEvent evt){System.exit(0);}});
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(Box.createHorizontalGlue());
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About...");
		mnHelp.add(mntmAbout);
		mntmAbout.addActionListener(new ActionListener()
			{public void actionPerformed(ActionEvent evt){new About().setVisible(true);}});
		
		JMenuItem mntmLicense = new JMenuItem("Credits and Licenses");
		mnHelp.add(mntmLicense);
		mntmLicense.addActionListener(new ActionListener()
			{public void actionPerformed(ActionEvent evt){new LicenseDisplay(COPYING_CREDITS.get()).setVisible(true);}});
		
		JMenuItem debugLog = new JMenuItem("Log");
		mnHelp.add(debugLog);
		debugLog.addActionListener(new ActionListener()
			{public void actionPerformed(ActionEvent evt){loggingGUI.setVisible(true);}});
		}
	}//end GUI
