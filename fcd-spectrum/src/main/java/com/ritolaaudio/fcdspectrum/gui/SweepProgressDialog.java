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
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.ritolaaudio.jfcdpp.OperationTimeoutException;
import com.ritolaaudio.jfcdpp.TunerNotFoundException;
import com.ritolaaudio.fcdspectrum.SweepJob;
import com.ritolaaudio.fcdspectrum.SweepProcess;
import com.ritolaaudio.fcdspectrum.SweepProcessFeedback;
import com.ritolaaudio.fcdspectrum.tuner.AudioCaptureAcquisitionException;

public class SweepProgressDialog extends JDialog implements SweepProcessFeedback
	{

	private final JPanel contentPanel = new JPanel();
	private final JLabel currentFrequency=new JLabel(),gainInDb=new JLabel(),currentStep=new JLabel();
	private JProgressBar progressBar;
	private final SweepJob job;
	private final SweepProcess funSweep;
	private final Logger log;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args)
		{
		try
			{
			SweepProgressDialog dialog = new SweepProgressDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
			}
		catch (Exception e)
			{
			e.printStackTrace();
			}
		}
	*/

	/**
	 * Create the dialog.
	 */
	public SweepProgressDialog(SweepJob job)
		{
		this.job=job;
		setTitle("Sweep In Progress");
		setBounds(100, 100, 399, 231);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowListener()
			{

				@Override
				public void windowActivated(WindowEvent arg0)
					{}

				@Override
				public void windowClosed(WindowEvent arg0)
					{}

				@Override
				public void windowClosing(WindowEvent arg0)
					{SweepProgressDialog.this.abortProcess();}

				@Override
				public void windowDeactivated(WindowEvent arg0)
					{}

				@Override
				public void windowDeiconified(WindowEvent arg0)
					{}

				@Override
				public void windowIconified(WindowEvent arg0)
					{}

				@Override
				public void windowOpened(WindowEvent arg0)
					{}
			});
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{296, 0};
		gbl_contentPanel.rowHeights = new int[]{0, 116, 0, 0};
		gbl_contentPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JPanel sweepDataTable = new JPanel();
			sweepDataTable.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "Sweep Progress", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			GridBagConstraints gbc_sweepDataTable = new GridBagConstraints();
			gbc_sweepDataTable.insets = new Insets(0, 0, 5, 0);
			gbc_sweepDataTable.fill = GridBagConstraints.BOTH;
			gbc_sweepDataTable.gridx = 0;
			gbc_sweepDataTable.gridy = 1;
			contentPanel.add(sweepDataTable, gbc_sweepDataTable);
			GridBagLayout gbl_sweepDataTable = new GridBagLayout();
			gbl_sweepDataTable.columnWidths = new int[]{237, 104, 17, 0};
			gbl_sweepDataTable.rowHeights = new int[]{0, 0, 0, 0, 0};
			gbl_sweepDataTable.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_sweepDataTable.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			sweepDataTable.setLayout(gbl_sweepDataTable);
			{
				JLabel lblStep = new JLabel("Step");
				GridBagConstraints gbc_lblStep = new GridBagConstraints();
				gbc_lblStep.anchor = GridBagConstraints.WEST;
				gbc_lblStep.insets = new Insets(0, 0, 5, 5);
				gbc_lblStep.gridx = 0;
				gbc_lblStep.gridy = 0;
				sweepDataTable.add(lblStep, gbc_lblStep);
			}
			{
				//JLabel currentStep = new JLabel("CURR_STEP");
				GridBagConstraints gbc_lblCurrstep = new GridBagConstraints();
				gbc_lblCurrstep.anchor = GridBagConstraints.WEST;
				gbc_lblCurrstep.insets = new Insets(0, 0, 5, 5);
				gbc_lblCurrstep.gridx = 1;
				gbc_lblCurrstep.gridy = 0;
				currentStep.setText("X / X");
				sweepDataTable.add(currentStep, gbc_lblCurrstep);
			}
			{
				JLabel lblFrequency = new JLabel("Frequency");
				GridBagConstraints gbc_lblFrequency = new GridBagConstraints();
				gbc_lblFrequency.anchor = GridBagConstraints.WEST;
				gbc_lblFrequency.insets = new Insets(0, 0, 5, 5);
				gbc_lblFrequency.gridx = 0;
				gbc_lblFrequency.gridy = 1;
				sweepDataTable.add(lblFrequency, gbc_lblFrequency);
			}
			{
				//JLabel currentFrequency = new JLabel("CURR_FREQ");
				GridBagConstraints gbc_lblCurrfreq = new GridBagConstraints();
				gbc_lblCurrfreq.anchor = GridBagConstraints.WEST;
				gbc_lblCurrfreq.insets = new Insets(0, 0, 5, 5);
				gbc_lblCurrfreq.gridx = 1;
				gbc_lblCurrfreq.gridy = 1;
				currentFrequency.setText("XXXXXXXXX Hz");
				sweepDataTable.add(currentFrequency, gbc_lblCurrfreq);
			}
			{
				JLabel lblGaindb = new JLabel("Total Dongle Gain");
				GridBagConstraints gbc_lblGaindb = new GridBagConstraints();
				gbc_lblGaindb.anchor = GridBagConstraints.WEST;
				gbc_lblGaindb.insets = new Insets(0, 0, 5, 5);
				gbc_lblGaindb.gridx = 0;
				gbc_lblGaindb.gridy = 2;
				sweepDataTable.add(lblGaindb, gbc_lblGaindb);
			}
			{
				//JLabel gainInDb = new JLabel("GAIN_DB");
				GridBagConstraints gbc_lblGaindb_1 = new GridBagConstraints();
				gbc_lblGaindb_1.anchor = GridBagConstraints.WEST;
				gbc_lblGaindb_1.insets = new Insets(0, 0, 5, 5);
				gbc_lblGaindb_1.gridx = 1;
				gbc_lblGaindb_1.gridy = 2;
				gainInDb.setText("XXXX");
				sweepDataTable.add(gainInDb, gbc_lblGaindb_1);
			}
		}
		{
			progressBar = new JProgressBar();
			progressBar.setMaximum(100);
			//progressBar.setPreferredSize(new Dimension(120,20));
			GridBagConstraints gbc_progressBar = new GridBagConstraints();
			gbc_progressBar.fill = GridBagConstraints.BOTH;
			gbc_progressBar.gridx = 0;
			gbc_progressBar.gridy = 2;
			contentPanel.add(progressBar, gbc_progressBar);
		}
		funSweep = new SweepProcess(job);
		log = job.getLog();
		{
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.CENTER));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		JButton cancelButton = new JButton("Abort");
		cancelButton.setActionCommand("Cancel");
		buttonPane.add(cancelButton);
		cancelButton.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent evt)
				{abortProcess();log.info("SweepProgressDialog: User clicked 'Abort'");}
			});
		}
		setVisible(true);
		new Thread()
			{
			public void run()
				{
				try{funSweep.startSweep(SweepProgressDialog.this);}
				catch(AudioCaptureAcquisitionException e)
					{
					showstopper("Could not acquire an audio capture from the Funcube Dongle.", e);
					cleanup();
					}//end catch(AudioCaptureAcquisitionException)
				catch(TunerNotFoundException e)
					{
					showstopper("Could not find the FunCube Dongle.\n" +
							"If using Linux, check the udev rules for your dongle to ensure you have permissions.\n" +
							"If the dongle has just recently been plugged in, wait a few seconds and try again.", e);
					}//end catch(AudioCaptureAcquisitionException)
				catch(OperationTimeoutException e)
					{showstopper("Could not continue because the tuner is not responding in a timely manner.",e);}
				catch(Exception e)
					{showstopper("An unhandled Exception occurred.",e);}
				}//end run()
			}.start();
		}//end constructor

	
	private void showstopper(final String msg,final Exception e)
		{
		EventQueue.invokeLater(new Runnable()
			{
			public void run()
				{
				new ShowstopperDialog(msg, e).setVisible(true);
				}//end run()
			});//end invokeLater()
		cleanup();
		}
	
	private void abortProcess()
		{
		funSweep.abortSweep();
		log.info("User aborting sweep");
		}
	
	@Override
	public void initializing()
		{}

	@Override
	public void ready()
		{
		log.info("SweepProgressDialog received ready() from SweepProcess");
		cleanup();
		}
	
	private void cleanup()
		{
		this.setVisible(false);
		this.dispose();
		}

	@Override
	public void performingSample(final int startFrequency, final int gain, final int step)
		{
		log.info("SweepProgressDialog received performingSample(...) from SweepProcess. start="+startFrequency+" gain="+gain+" step="+step);
		EventQueue.invokeLater(new Runnable()
			{
				public void run()
					{
					try
						{
						currentFrequency.setText(startFrequency+" Hz");
						gainInDb.setText(gain+" dB");
						progressBar.setValue((int)(((double)(startFrequency-job.getStartFrequency())/(double)(job.getEndFrequency()-job.getStartFrequency()))*100));
						currentStep.setText(""+step+"/"+funSweep.getNumSteps());
						}
					catch (Exception e)
						{
						e.printStackTrace();
						}
					}
			});//end invokeLater()
		}//end performingSample()

	@Override
	public void sweepComplete()
		{log.info("SweepProgressDialog received sweepComplete() from SweepProcess");}

	@Override
	public void savingSweep(File target)
		{log.info("SweepProgressDialog received savingSweep() from SweepProcess");}

	}//end SweepProgressDialog
