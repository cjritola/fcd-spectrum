package com.ritolaaudio.fcdspectrum.tuner;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.Control;
import javax.sound.sampled.Control.Type;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.TargetDataLine;

import com.ritolaaudio.fcdspectrum.TimeoutFence;

public class TimeoutFencedTargetDataLine implements TargetDataLine
	{
	private TargetDataLine intrinsic;
	
	public TimeoutFencedTargetDataLine(TargetDataLine intrinsic)
		{this.intrinsic=intrinsic;}
	
	@Override
	public int available()
		{
		return intrinsic.available();
		}

	@Override
	public void drain()
		{
		try {
			new TimeoutFence(1000)
				{
				@Override
				protected void run() throws Exception
					{
					intrinsic.drain();
					}
				};
			}//end try{}
		catch(Exception e)
			{throw new RuntimeException(e);}
		}//end drain()

	@Override
	public void flush()
		{
		try {
		new TimeoutFence(1000)
			{
			@Override
			protected void run() throws Exception
				{
				intrinsic.flush();
				}
			};
		}//end try{}
	catch(Exception e)
		{throw new RuntimeException(e);}
		}

	@Override
	public int getBufferSize()
		{
		return intrinsic.getBufferSize();
		}

	@Override
	public AudioFormat getFormat()
		{
		return intrinsic.getFormat();
		}

	@Override
	public int getFramePosition()
		{
		return intrinsic.getFramePosition();
		}

	@Override
	public float getLevel()
		{
		return intrinsic.getLevel();
		}

	@Override
	public long getLongFramePosition()
		{
		return intrinsic.getLongFramePosition();
		}

	@Override
	public long getMicrosecondPosition()
		{
		return intrinsic.getMicrosecondPosition();
		}

	@Override
	public boolean isActive()
		{
		return intrinsic.isActive();
		}

	@Override
	public boolean isRunning()
		{
		return intrinsic.isRunning();
		}

	@Override
	public void start()
		{
		try {
			new TimeoutFence(1000)
				{
				@Override
				protected void run() throws Exception
					{
					intrinsic.start();
					}
				};
			}//end try{}
		catch(Exception e)
			{throw new RuntimeException(e);}
		}

	@Override
	public void stop()
		{
		try {
			new TimeoutFence(1000)
				{
				@Override
				protected void run() throws Exception
					{
					intrinsic.stop();
					}
				};
			}//end try{}
		catch(Exception e)
			{throw new RuntimeException(e);}
		}

	@Override
	public void addLineListener(LineListener arg0)
		{
		intrinsic.addLineListener(arg0);
		}

	@Override
	public void close()
		{
		try {
		new TimeoutFence(1000)
			{
			@Override
			protected void run() throws Exception
				{
				intrinsic.close();
				}
			};
		}//end try{}
	catch(Exception e)
		{throw new RuntimeException(e);}
		}

	@Override
	public Control getControl(Type arg0)
		{
		return intrinsic.getControl(arg0);
		}

	@Override
	public Control[] getControls()
		{
		return intrinsic.getControls();
		}

	@Override
	public javax.sound.sampled.Line.Info getLineInfo()
		{
		return intrinsic.getLineInfo();
		}

	@Override
	public boolean isControlSupported(Type arg0)
		{
		return intrinsic.isControlSupported(arg0);
		}

	@Override
	public boolean isOpen()
		{
		return intrinsic.isOpen();
		}

	@Override
	public void open() throws LineUnavailableException
		{
		try {
			new TimeoutFence(1000)
				{
				@Override
				protected void run() throws Exception
					{
					intrinsic.open();
					}
				};
			}//end try{}
		catch(LineUnavailableException e)
			{throw e;}
		catch(Exception e)
			{throw new RuntimeException(e);}
		}

	@Override
	public void removeLineListener(LineListener arg0)
		{intrinsic.removeLineListener(arg0);}

	@Override
	public void open(final AudioFormat format) throws LineUnavailableException
		{
		try {
			new TimeoutFence(1000)
				{
				@Override
				protected void run() throws Exception
					{
					intrinsic.open(format);
					}
				};
			}//end try{}
		catch(LineUnavailableException e)
			{throw e;}
		catch(Exception e)
			{throw new RuntimeException(e);}
		}

	@Override
	public void open(final AudioFormat format, final int bufferSize)
			throws LineUnavailableException
		{
		try {
			new TimeoutFence(1000)
				{
				@Override
				protected void run() throws Exception
					{
					intrinsic.open(format,bufferSize);
					}
				};
			}//end try{}
		catch(LineUnavailableException e)
			{throw e;}
		catch(Exception e)
			{throw new RuntimeException(e);}
		}

	@Override
	public int read(final byte[] b, final int off, final int len)
		{
		final int [] result = new int[1];
		try {
			new TimeoutFence(1000)
				{
				@Override
				protected void run() throws Exception
					{
					result[0] = intrinsic.read(b,off,len);
					}
				};
			return result[0];
			}//end try{}
		catch(Exception e)
			{throw new RuntimeException(e);}
		}

	}
