package com.ritolaaudio.fcdspectrum;

import java.util.logging.Logger;

public class CLILogger extends Logger
	{

	protected CLILogger()
		{super("com.ritolaaudio.fcdspectrum", null);}

	@Override
	public void info(String text)
		{System.out.println("INFO: "+text);}
	@Override
	public void warning(String text)
		{System.out.println("WARN: "+text);}
	@Override
	public void severe(String text)
		{System.out.println("SEVERE: "+text);}
	}
