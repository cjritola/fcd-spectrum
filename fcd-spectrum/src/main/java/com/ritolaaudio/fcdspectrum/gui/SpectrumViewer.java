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
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import com.ritolaaudio.fcdspectrum.SpectrumData;
import com.ritolaaudio.fcdspectrum.guides.OverallFrequencyGuide;
import com.ritolaaudio.fcdspectrum.guides.UHFFrequencyGuide;

public class SpectrumViewer extends JFrame
	{

	private JPanel contentPane;
	private double zoomLevel=1;
	private final JLayeredPane layeredGraphPane;
	private SweepGraph sweepGraph;
	private Grid sweepGrid;
	private FrequencyGuideOverlay frequencyGuideOverlay;
	private JScrollBar frequencyScroll;
	private final JButton zoomInButton = new JButton("Zoom In");
	private final JButton zoomOutButton = new JButton("Zoom Out");

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
						SpectrumViewer frame = new SpectrumViewer(new File("output.csv"));
						frame.setVisible(true);
						}
					catch (Exception e)
						{
						e.printStackTrace();
						}
					}
			});
		}

	/**
	 * Create the frame.
	 */
	public SpectrumViewer(File csv)
		{
		setTitle("Spectrum Viewer");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		final JPanel rootPanel = new JPanel();
		contentPane.add(rootPanel);
		final CardLayout pleaseWaitCard = new CardLayout(0,0);
		rootPanel.setLayout(pleaseWaitCard);
		
		JPanel waitPanel = new JPanel();
		rootPanel.add(waitPanel, "waitPanel");
		waitPanel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblLoadingDataPlease = new JLabel("Loading data; please wait...");
		lblLoadingDataPlease.setHorizontalAlignment(SwingConstants.CENTER);
		waitPanel.add(lblLoadingDataPlease, BorderLayout.CENTER);
		
		JPanel workPanel = new JPanel();
		rootPanel.add(workPanel, "workPanel");
		GridBagLayout gbl_workPanel = new GridBagLayout();
		gbl_workPanel.columnWidths = new int[]{155, 0};
		gbl_workPanel.rowHeights = new int[]{31, 0, 0, 0, 0};
		gbl_workPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_workPanel.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		workPanel.setLayout(gbl_workPanel);
		
		JToolBar toolBar = new JToolBar();
		GridBagConstraints gbc_toolBar = new GridBagConstraints();
		gbc_toolBar.anchor = GridBagConstraints.NORTHWEST;
		gbc_toolBar.insets = new Insets(0, 0, 5, 0);
		gbc_toolBar.gridx = 0;
		gbc_toolBar.gridy = 0;
		workPanel.add(toolBar, gbc_toolBar);
		toolBar.setFloatable(false);
		
		toolBar.add(zoomInButton);
		zoomInButton.addActionListener(new ActionListener()
			{
			@Override
			public void actionPerformed(ActionEvent evt)
				{
				zoomLevel*=2;
				updateZoom();
				}
			});
		
		toolBar.add(zoomOutButton);
		zoomOutButton.addActionListener(new ActionListener()
			{
			@Override
			public void actionPerformed(ActionEvent evt)
				{zoomLevel/=2;
				if(zoomLevel<1)zoomLevel=1;
				updateZoom();
				}
			});
		
		layeredGraphPane = new JLayeredPane();
		GridBagConstraints gbc_layeredGraphPane = new GridBagConstraints();
		gbc_layeredGraphPane.fill = GridBagConstraints.BOTH;
		gbc_layeredGraphPane.insets = new Insets(0, 0, 5, 0);
		gbc_layeredGraphPane.gridx = 0;
		gbc_layeredGraphPane.gridy = 1;
		workPanel.add(layeredGraphPane, gbc_layeredGraphPane);
		JPanel backgroundPanel = new JPanel();
		backgroundPanel.setBackground(Color.black);
		layeredGraphPane.setLayer(backgroundPanel, 0);
		layeredGraphPane.add(backgroundPanel);
		try {
			SpectrumData data = new SpectrumData(new FileInputStream(csv));
			sweepGraph = new SweepGraph(data);
			data.addSpectrumLoadProcessListener(new SpectrumLoadProcessListener()
				{
				@Override
				public void loadingSpectrum()
					{
					SwingUtilities.invokeLater(new Runnable()
						{
						@Override
						public void run()
							{
							pleaseWaitCard.show(rootPanel, "waitPanel");
							}
						});
					}//end loadingSpectrum()

				@Override
				public void spectrumLoaded()
					{
					SwingUtilities.invokeLater(new Runnable()
						{
						@Override
						public void run()
							{
							int viewportWidthInHz=(int)(sweepGraph.getData().getBandwidth()/zoomLevel);
							frequencyScroll.setMaximum(sweepGraph.getData().getEndFreq()-viewportWidthInHz);
							frequencyScroll.setMinimum(sweepGraph.getData().getStartFreq());
							pleaseWaitCard.show(rootPanel, "workPanel");
							SpectrumViewer.this.repaint();
							}
						});
					}//end spectrumLoaded()

				@Override
				public void exception(Exception ex)
					{
					new ShowstopperDialog("Could not extract sweep data from the specified CSV File.",ex).setVisible(true);
					SpectrumViewer.this.setVisible(false);
					SpectrumViewer.this.dispose();
					return;
					}
				});
			}//end try{}
		catch(FileNotFoundException e){e.printStackTrace();}
		/*	
		catch(IOException e)
			{
			new ShowstopperDialog("Could not extract sweep data from the specified CSV File.",e);
			this.setVisible(false);
			this.dispose();
			return;
			}
		*/
		frequencyGuideOverlay = new FrequencyGuideOverlay();
		frequencyGuideOverlay.setFrequencyGuide(new OverallFrequencyGuide());
		
		sweepGrid = new Grid(
				sweepGraph.getData().getStartFreq(),
				sweepGraph.getData().getEndFreq(),
				sweepGraph.getData().getBandwidth()/10,
				sweepGraph.getData().getMinPower(),
				sweepGraph.getData().getMaxPower(),
				sweepGraph.getData().getDynamicRange()/10,new HertzFormatter(),new DBMFormatter());
		layeredGraphPane.setLayout(new FillerLayout(layeredGraphPane));
		layeredGraphPane.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		layeredGraphPane.setBackground(Color.black);
		layeredGraphPane.setLayer(sweepGraph, 4);
		layeredGraphPane.setLayer(sweepGrid, 5);
		layeredGraphPane.setLayer(frequencyGuideOverlay, 6);
		layeredGraphPane.add(sweepGraph);
		layeredGraphPane.add(sweepGrid);
		layeredGraphPane.add(frequencyGuideOverlay);
		
		frequencyScroll = new JScrollBar();
		GridBagConstraints gbc_frequencyScroll = new GridBagConstraints();
		gbc_frequencyScroll.fill = GridBagConstraints.HORIZONTAL;
		gbc_frequencyScroll.insets = new Insets(0, 0, 5, 0);
		gbc_frequencyScroll.gridx = 0;
		gbc_frequencyScroll.gridy = 2;
		workPanel.add(frequencyScroll, gbc_frequencyScroll);
		frequencyScroll.setOrientation(JScrollBar.HORIZONTAL);
		frequencyScroll.addAdjustmentListener(new AdjustmentListener()
			{
			@Override
			public void adjustmentValueChanged(AdjustmentEvent evt)
				{if(evt.getAdjustmentType()==AdjustmentEvent.TRACK)updateScroll();}
			});
		
		sweepGraph.setStartX(frequencyScroll.getValue());
		sweepGrid.setStartX(((double)frequencyScroll.getValue()));
		frequencyGuideOverlay.setStartFreq(frequencyScroll.getValue());
		
		JPanel infoPanel = new JPanel();
		GridBagConstraints gbc_infoPanel = new GridBagConstraints();
		gbc_infoPanel.anchor = GridBagConstraints.WEST;
		gbc_infoPanel.gridx = 0;
		gbc_infoPanel.gridy = 3;
		workPanel.add(infoPanel, gbc_infoPanel);
		infoPanel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		GridBagLayout gbl_infoPanel = new GridBagLayout();
		gbl_infoPanel.columnWidths = new int[]{0, 0, 0};
		gbl_infoPanel.rowHeights = new int[]{0, 0};
		gbl_infoPanel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_infoPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		infoPanel.setLayout(gbl_infoPanel);
		/*
		JLabel lblDiv = new JLabel("Div:");
		GridBagConstraints gbc_lblDiv = new GridBagConstraints();
		gbc_lblDiv.insets = new Insets(0, 0, 0, 5);
		gbc_lblDiv.gridx = 0;
		gbc_lblDiv.gridy = 0;
		infoPanel.add(lblDiv, gbc_lblDiv);
		
		JLabel lblDivvalue = new JLabel("DIV_VALUE");
		GridBagConstraints gbc_lblDivvalue = new GridBagConstraints();
		gbc_lblDivvalue.gridx = 1;
		gbc_lblDivvalue.gridy = 0;
		infoPanel.add(lblDivvalue, gbc_lblDivvalue);
		*/
		updateZoom();
		}
	
	private void updateZoom()
		{
		//double oldScrollPos=(double)(frequencyScroll.getValue()-frequencyScroll.getMinimum())/(double)(frequencyScroll.getMaximum()-frequencyScroll.getMinimum());
		zoomOutButton.setEnabled(zoomLevel>1);
		sweepGraph.setZoom(zoomLevel);
		int viewportWidthInHz=(int)(sweepGraph.getData().getBandwidth()/zoomLevel);
		frequencyScroll.setBlockIncrement(viewportWidthInHz);
		frequencyScroll.setUnitIncrement(viewportWidthInHz/20);
		//frequencyScroll.setValue((int)(oldScrollPos*(frequencyScroll.getMaximum()-frequencyScroll.getMinimum())+frequencyScroll.getMinimum()));
		//System.out.println("viewportWidthInHz="+viewportWidthInHz);
		updateScroll();
		}
	
	private void updateScroll()
		{
		int viewportWidthInHz=(int)(sweepGraph.getData().getBandwidth()/zoomLevel);
		frequencyScroll.setMaximum(sweepGraph.getData().getEndFreq()-viewportWidthInHz);
		frequencyScroll.setMinimum(sweepGraph.getData().getStartFreq());
		sweepGraph.setStartX(frequencyScroll.getValue());
		sweepGrid.setStartX(((double)frequencyScroll.getValue()));
		sweepGrid.setEndX((double)frequencyScroll.getValue()+viewportWidthInHz);
		sweepGrid.setDivX(viewportWidthInHz/10);
		sweepGrid.setStartY(sweepGraph.getRawData().getMinPower());
		sweepGrid.setEndY(sweepGraph.getRawData().getMaxPower());
		sweepGrid.setDivY(sweepGraph.getRawData().getDynamicRange()/10);
		frequencyGuideOverlay.setStartFreq((int)sweepGrid.getStartX());
		frequencyGuideOverlay.setEndFreq((int)sweepGrid.getEndX());
		updateGraphView();
		}
	
	private void updateGraphView()
		{
		layeredGraphPane.repaint();
		//System.out.println("lo="+frequencyScroll.getMinimum()+" val="+frequencyScroll.getValue()+" hi="+frequencyScroll.getMaximum());
		}
	}
