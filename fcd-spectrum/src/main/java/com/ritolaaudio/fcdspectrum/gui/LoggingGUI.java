package com.ritolaaudio.fcdspectrum.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import javax.swing.text.BadLocationException;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;

public class LoggingGUI extends JFrame
	{
	private JPanel contentPane;
	private JTextPane textPane;
	private HTMLEditorKit htmlKit = new HTMLEditorKit();
	private JPanel panel;
	private JButton btnCopyToClipboard;
	private JButton btnSaveAshtml;
	
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
					LoggingGUI frame = new LoggingGUI();
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
	public LoggingGUI()
		{
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 750, 700);
		setTitle("Log");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		
		textPane = new JTextPane();
		textPane.setDocument(new HTMLDocument());
		textPane.setEditorKit(htmlKit);
		textPane.setEditable(false);
		scrollPane.setViewportView(textPane);
		
		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		btnCopyToClipboard = new JButton("Copy To Clipboard");
		GridBagConstraints gbc_btnCopyToClipboard = new GridBagConstraints();
		gbc_btnCopyToClipboard.insets = new Insets(0, 0, 0, 5);
		gbc_btnCopyToClipboard.gridx = 0;
		gbc_btnCopyToClipboard.gridy = 0;
		btnCopyToClipboard.addActionListener(new ActionListener()
			{
			@Override
			public void actionPerformed(ActionEvent arg0)
				{
				try {
					final StringSelection selection = new StringSelection(textPane.getDocument().getText(0, textPane.getDocument().getLength()));
					Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, selection);
					}
				catch(BadLocationException e){throw new AssertionError("Unexpected BadLocationException.");}
				}
			
			});
		panel.add(btnCopyToClipboard, gbc_btnCopyToClipboard);
		
		btnSaveAshtml = new JButton("Save...");
		GridBagConstraints gbc_btnSaveAshtml = new GridBagConstraints();
		gbc_btnSaveAshtml.gridx = 1;
		gbc_btnSaveAshtml.gridy = 0;
		btnSaveAshtml.addActionListener(new ActionListener()
			{
			@Override
			public void actionPerformed(ActionEvent arg0)
				{
				final JFileChooser chooser = new JFileChooser();
				chooser.setFileFilter(new FileFilter()
					{
					@Override
					public boolean accept(File file)
						{return(file.getName().toLowerCase().endsWith(".txt") || file.isDirectory());}

					@Override
					public String getDescription()
						{return "Text Files (.TXT)";}
					});
				int result = chooser.showSaveDialog(LoggingGUI.this);
				if(result == JFileChooser.APPROVE_OPTION)
					{
					File outputFile = chooser.getSelectedFile();
					try
						{
						FileOutputStream os = new FileOutputStream(outputFile);
						os.write(textPane.getDocument().getText(0, textPane.getDocument().getLength()).getBytes());
						os.flush();
						os.close();
						}
					catch(Exception e){e.printStackTrace();}
					}
				}//end actionPerformed(...)
			});
		panel.add(btnSaveAshtml, gbc_btnSaveAshtml);
		}
	
	public void info(String msg)
		{log("[<font color=green>INFO</font> <b>"+dateString()+"</b>] "+msg);}
	public void severe(String msg)
		{log("[<font color=red>SEVERE</font> <b>"+dateString()+"</b>] "+msg);}
	public void warning(String msg)
		{log("[<font color=yellow>WARNING</font> <b>"+dateString()+"</b>] "+msg);}
	
	private String dateString()
		{
		final Calendar cal = Calendar.getInstance();
		return 	cal.get(GregorianCalendar.MONTH)+"."
				+cal.get(GregorianCalendar.DAY_OF_MONTH)+"."
				+cal.get(GregorianCalendar.YEAR)+"|"
				
				+cal.get(GregorianCalendar.HOUR)+":"
				+cal.get(GregorianCalendar.MINUTE)
				+(cal.get(GregorianCalendar.AM_PM)==GregorianCalendar.AM?"AM":"PM");
		}
	
	private void log(String html)
		{
		try{htmlKit.insertHTML((HTMLDocument)textPane.getDocument(), textPane.getDocument().getLength(),html, 0, 0, null);}
		catch(Exception e){e.printStackTrace();}// Can't really write to the log here.
		}

	public void stdout(String data)
		{log("[<font color=blue>STDOUT</font> <b>"+dateString()+"</b>] "+data);}

	public void stderr(String data)
		{log("[<font color=orange>STDERR</font> <b>"+dateString()+"</b>] "+data);}

	}//end LoggingGUI
