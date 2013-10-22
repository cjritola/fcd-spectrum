package com.ritolaaudio.fcdspectrum;

import java.util.logging.Logger;

import com.ritolaaudio.jfcdpp.OperationTimeoutException;

public abstract class LoggingTimeoutFence
	{
	public LoggingTimeoutFence(Logger log, long timeoutInMillis) throws Exception
		{
		try
			{
			new TimeoutFence(timeoutInMillis)
				{
				@Override
				protected void run() throws Exception
					{
					LoggingTimeoutFence.this.run();
					}
				};
			}
		catch(OperationTimeoutException e)
			{
			log.throwing("LoggingTimeoutFence", "run()", e);
			}
		catch(Exception e){throw e;}
		}
	
	protected abstract void run();
	}//end LoggingTimeoutFence
