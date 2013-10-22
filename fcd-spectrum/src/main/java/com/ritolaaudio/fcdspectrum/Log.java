package com.ritolaaudio.fcdspectrum;

import java.util.logging.Logger;

public class Log
	{
	private static Logger logger = Logger.getGlobal();
	public static Logger getLogger(){return logger;}
	public static void setLogger(Logger l){logger=l;}
	}
