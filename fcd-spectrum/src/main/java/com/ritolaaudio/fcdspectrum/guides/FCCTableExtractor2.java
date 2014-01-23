package com.ritolaaudio.fcdspectrum.guides;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class FCCTableExtractor2
	{
	private final File SOURCEFILE;
	private int previousHash;//Avoids repeating
	private enum FreqUnit
		{
		KHz(1000),
		MHz(1000000),
		GHz(1000000000);
		
		int multiplier;
		
		FreqUnit(int multiplier)
			{this.multiplier=multiplier;}
		
		public int getMultiplier(){return multiplier;}
		}//end FreqUnit
	
	private String currentLine;
	private Scanner lines;
	
	private FreqUnit currentUnit = FreqUnit.KHz;
	/**
	 * @param args
	 * @since Nov 14, 2013
	 */
	public static void main(String[] args)
		{
		new FCCTableExtractor2("fcc-freqs").go();
		}
	
	public FCCTableExtractor2(final String fileName)
		{
		SOURCEFILE=new File(fileName);
		}
	
	public void go()
		{
		try
			{
			lines = new Scanner(new FileInputStream(SOURCEFILE));
			while(lines.hasNextLine())
				{processTopLevelLine();}
			}
		catch(Exception e){e.printStackTrace();}
		}
	
	private void processTopLevelLine()
		{
		currentLine = lines.nextLine();
		//System.out.println("Top-level line: "+currentLine);
		if(currentLine.length()==0)return;//Ignore empty lines
		else if(currentLine.contains("Table of Frequency Allocations"))
			{frequencyUnitSwitch();}
		else if(currentLine.contains("-")&&currentLine.length()>2&&currentLine.matches(".*\\d.*")&&!currentLine.contains(" "))
			{frequencyRangeEntry();}//Probably a frequency range entry
		}
	
	private boolean isName()
		{
		return !currentLine.matches(".*\\d.*")&&currentLine.length()>2;
		}
	
	private void frequencyUnitSwitch()
		{
		if(currentLine.toUpperCase().contains("KHZ"))
			{currentUnit=FreqUnit.KHz;}
		if(currentLine.toUpperCase().contains("MHZ"))
			{currentUnit=FreqUnit.MHz;}
		if(currentLine.toUpperCase().contains("GHZ"))
			{currentUnit=FreqUnit.GHz;}
		else {/*System.out.println("Could not find frequency unit in line: "+currentLine);*/}
		}
	
	private void frequencyRangeEntry()
		{
		final long lowFreq = (long)(currentUnit.getMultiplier()*Double.parseDouble(currentLine.substring(0, currentLine.indexOf('-'))));
		final long hiFreq = (long)(currentUnit.getMultiplier()*Double.parseDouble(currentLine.substring(1+currentLine.indexOf('-'),currentLine.length())));
		//final ArrayList<String>names = new ArrayList<String>();
		String name = currentLine = lines.nextLine();
		StringBuilder javaCode = new StringBuilder();
		javaCode.append("dest.add(new DefaultFrequencyGuide("+lowFreq+","+hiFreq+","+"new String[]{");
		int currentHash=-1;
		int namesAdded=0;
		while(isName())
			{
			//System.out.println("Range: "+name+" ["+lowFreq+","+hiFreq+"]");
			//Make the text easier on the eyes and not screaming at the user.
			//name = name.replace("-", " ");
			StringBuilder sb = new StringBuilder();
			boolean previousWasSpace=true;
			for(char c:name.toCharArray())
				{
				if(c=='-'||c==' '){sb.append(' ');previousWasSpace=true;}
				else
					{if(previousWasSpace){sb.append(c);previousWasSpace=false;}
					else{sb.append(Character.toLowerCase(c));previousWasSpace=false;}}
				}//end for(chars)
			name = sb.toString();
			javaCode.append("\""+name+"\"");
			currentHash=(int)(lowFreq+hiFreq);
			name = currentLine = lines.nextLine();
			
			if(isName())javaCode.append(",");
			//names.add(name);
			namesAdded++;
			}
		javaCode.append("});\n");
		if(currentHash!=previousHash&&namesAdded>0)System.out.print(javaCode.toString());
		previousHash=currentHash;
		}//end frequencyRangeEntry()
	}//end ExtractFCCTable
