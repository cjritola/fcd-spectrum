package com.ritolaaudio.fcdspectrum.tuner;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import javax.sound.sampled.TargetDataLine;

import com.ritolaaudio.fcdspectrum.TimeoutFence;
import com.ritolaaudio.jfcdpp.OperationTimeoutException;
import com.ritolaaudio.jfcdpp.TunerException;

public class TimeoutFencedTuner implements Tuner
	{
	private int frequencyTimeoutPeriodMillis=500;
	private int gainTimeuotPeriodMillis=500;
	private int lineStartStopTimeoutMillis=500;
	private int releaseTimeoutMillis=500;
	private final Tuner tunerToFence;
	
	public TimeoutFencedTuner(Tuner tunerToFence) throws TunerException
		{
		this.tunerToFence=tunerToFence;
		}
	
	@Override
	public void setFrequency(final int frequencyInHz) throws TunerException
		{
		try {
			new TimeoutFence(frequencyTimeoutPeriodMillis)
				{
				@Override
				protected void run() throws Exception
					{
					tunerToFence.setFrequency(frequencyInHz);
					}
				};
			}
		catch(TimeoutException e)
			{throw new OperationTimeoutException(e);}
		catch(Exception e)
			{throw new TunerException(e);}
		}
	@Override
	public void setGain(final int gainInDb) throws TunerException
		{
		try {
		new TimeoutFence(frequencyTimeoutPeriodMillis)
			{
			@Override
			protected void run() throws Exception
				{
				tunerToFence.setGain(gainInDb);
				}
			};
		}
	catch(TimeoutException e)
		{throw new OperationTimeoutException(e);}
	catch(Exception e)
		{throw new TunerException(e);}
		}
	@Override
	public TargetDataLine getTargetDataLine() throws TunerException
		{
		final TargetDataLine [] result = new TargetDataLine[1];
		try {
			new TimeoutFence((long)frequencyTimeoutPeriodMillis)
				{
				@Override
				protected void run() throws Exception
					{
					result[0]=tunerToFence.getTargetDataLine();
					}
				};
			}//end try{}
		catch(TimeoutException e)
			{throw new OperationTimeoutException(e);}
		catch(Exception e)
			{throw new TunerException(e);}
		return new TimeoutFencedTargetDataLine(result[0]);
		}
	
	enum BufferFormat
		{
		REAL,
		COMPLEX
		}
	
	public void release()
		{
		try {
		new TimeoutFence(1000)
			{
			@Override
			protected void run() throws Exception
				{
				tunerToFence.release();
				}
			};
		}//end try{}
	catch(Exception e)
		{throw new RuntimeException(e);}
		}

	/**
	 * @return the frequencyTimeoutPeriodMillis
	 */
	public int getFrequencyTimeoutPeriodMillis()
		{
		return frequencyTimeoutPeriodMillis;
		}

	/**
	 * @param frequencyTimeoutPeriodMillis the frequencyTimeoutPeriodMillis to set
	 */
	public void setFrequencyTimeoutPeriodMillis(final int frequencyTimeoutPeriodMillis)
		{
		this.frequencyTimeoutPeriodMillis = frequencyTimeoutPeriodMillis;
		}

	/**
	 * @return the gainTimeuotPeriodMillis
	 */
	public int getGainTimeuotPeriodMillis()
		{
		return gainTimeuotPeriodMillis;
		}

	/**
	 * @param gainTimeuotPeriodMillis the gainTimeuotPeriodMillis to set
	 */
	public void setGainTimeuotPeriodMillis(int gainTimeuotPeriodMillis)
		{
		this.gainTimeuotPeriodMillis = gainTimeuotPeriodMillis;
		}

	/**
	 * @return the lineStartStopTimeoutMillis
	 */
	public int getLineStartStopTimeoutMillis()
		{
		return lineStartStopTimeoutMillis;
		}

	/**
	 * @param lineStartStopTimeoutMillis the lineStartStopTimeoutMillis to set
	 */
	public void setLineStartStopTimeoutMillis(int lineStartStopTimeoutMillis)
		{
		this.lineStartStopTimeoutMillis = lineStartStopTimeoutMillis;
		}

	/**
	 * @return the releaseTimeoutMillis
	 */
	public int getReleaseTimeoutMillis()
		{
		return releaseTimeoutMillis;
		}

	/**
	 * @param releaseTimeoutMillis the releaseTimeoutMillis to set
	 */
	public void setReleaseTimeoutMillis(int releaseTimeoutMillis)
		{
		this.releaseTimeoutMillis = releaseTimeoutMillis;
		}

	@Override
	public String getVendor() throws IOException
		{return tunerToFence.getVendor();}

	@Override
	public String getModel() throws IOException
		{return tunerToFence.getModel();}

	@Override
	public String getSerial() throws IOException
		{return tunerToFence.getSerial();}
	}
