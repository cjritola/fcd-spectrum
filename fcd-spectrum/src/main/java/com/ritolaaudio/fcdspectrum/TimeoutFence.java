package com.ritolaaudio.fcdspectrum;

import java.util.concurrent.TimeoutException;

public abstract class TimeoutFence
	{
	private final Object taskFinished = new Object();
	private Exception exception=null;
	private Thread workingThread;
	
	public TimeoutFence(long timeoutInMillis) throws Exception, TimeoutException
		{
		synchronized(taskFinished)
			{
			(workingThread = new Thread()
				{
				@Override
				public void run()
					{try{
						TimeoutFence.this.run();
						synchronized(taskFinished){taskFinished.notifyAll();}
						}
					catch(Exception e)
						{exception=e;}
					}
				}).start();
				try{taskFinished.wait(timeoutInMillis);}
				catch(InterruptedException e)
					{throw new TimeoutException();}
			}//end sync(taskFinished)
		if(exception!=null)throw exception;
		}//end TimeoutFence(...)
	
	protected abstract void run() throws Exception;
	public Thread workingThread(){return workingThread;}
	}
