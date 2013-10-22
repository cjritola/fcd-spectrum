package com.ritolaaudio.fcdspectrum.gui;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.logging.Logger;

public class GUILogger extends Logger
	{
	private final LoggingGUI gui;
	public GUILogger(final LoggingGUI gui)
		{
		super("com.ritolaaudio.fcdspectrum.gui", null);
		this.gui=gui;
		}
	
	public void startEatingConsoleOutput()
		{
		PrintStream ps = new PrintStream(new ByteArrayOutputStream()
			{
			@Override
			public void flush() throws IOException
				{
				String data;
				final String LINE_SEP = System.getProperty("line.separator");
				synchronized(this)
					{
					super.flush();
					data = this.toString();
					super.reset();
					if(data.length()!=0 && !data.equals(LINE_SEP))gui.stdout(data);
					}
				}//end flush()
			},true);
		PrintStream es = new PrintStream(new ByteArrayOutputStream()
			{
			@Override
			public void flush() throws IOException
				{
				String data;
				final String LINE_SEP = System.getProperty("line.separator");
				synchronized(this)
					{
					super.flush();
					data = this.toString();
					super.reset();
					if(data.length()!=0 && !data.equals(LINE_SEP))gui.stderr(data);
					}
				}//end flush()
			},true);
		System.setOut(ps);
		System.setErr(es);
		}
	
	@Override
	public void info(String msg)
		{gui.info(msg);}
	@Override
	public void severe(String msg)
		{gui.severe(msg);}
	@Override
	public void warning(String msg)
		{gui.warning(msg);}
	}
