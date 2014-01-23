package com.ritolaaudio.fcdspectrum.guides;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.AttributeSet;
import javax.swing.text.Element;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

import org.apache.commons.lang3.StringUtils;

public class FCCTableExtractor
	{
	private final File SOURCEFILE;
	private int x=0,y=0;
	private int previousHash=0;//Avoids repeating
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
	
	//private String currentLine;
	//private Scanner lines;
	HashMap<XYPosition,Object> table = new HashMap<XYPosition,Object>();
	
	private class XYPosition
		{
		public int x,y;
		public XYPosition(int x, int y)
			{
			this.x=x;this.y=y;
			}
		@Override
		public int hashCode(){return x+y*4096;}
		@Override
		public String toString(){return "x="+x+" y="+y;}
		//public int hashCode(){return 1;}
		@Override
		public boolean equals(Object o)
			{return o.hashCode()==this.hashCode();}
		}
	
	private FreqUnit currentUnit = FreqUnit.KHz;
	/**
	 * @param args
	 * @since Nov 14, 2013
	 */
	public static void main(String[] args)
		{
		new FCCTableExtractor("freq-alloc").go();
		}
	
	public FCCTableExtractor(final String fileName)
		{SOURCEFILE=new File(fileName);}
	
	public void go()
		{try{
			Reader stringReader = new FileReader(SOURCEFILE);
			
			HTMLDocument html = (HTMLDocument) new HTMLEditorKit().createDefaultDocument();
			HTMLEditorKit.Parser parser = new ParserDelegator();
			parser.parse(stringReader, html.getReader(0), true);
			Element elm = html.getDefaultRootElement();
			for(int i=0; i< elm.getElementCount();i++)
				{
				Element elm2 = elm.getElement(i);
				//System.out.println(elm2.getName());
				for(int j=0; j< elm2.getElementCount();j++)
					{
					Element elm3 = elm2.getElement(j);
					//System.out.println(elm3.getName());
					if(elm3.getName().contentEquals("table"))
						{processTable(elm3);}
					}//end for(j)
				}//end for(i)
			}
		catch(Exception e){e.printStackTrace();}
		}
	
	private static Iterable<Element> getChildren(final Element parent)
		{
		final int numChildren=parent.getElementCount();
		return new Iterable<Element>()
			{
			@Override
			public Iterator<Element> iterator()
				{
				return new Iterator<Element>()
					{
					private int iterationIndex=0;
					@Override
					public boolean hasNext()
						{return iterationIndex<numChildren;}

					@Override
					public Element next()
						{
						return parent.getElement(iterationIndex++);
						}

					@Override
					public void remove()
						{
						//Do nothing
						}
					};
				}
			};
		}//end getChildren(...)
	
	private void processTable(Element elm)
		{
		for(int i=0; i< elm.getElementCount();i++)
			{
			Element row = elm.getElement(i);
			if(row.getName().contentEquals("tr"))
				{//It is definitely a row
				tr();
				processElement(row);
				/*try{Thread.sleep(50);}
				catch(InterruptedException e){e.printStackTrace();}*/
				}
			}//end for(j)
		//printCSV();
		printJava();
		}//end processTable(...)
	
	private int rowSpan=1,colSpan=1;
	private boolean tdVisited=false;
	
	private void processElement(Element elm)
		{
		//System.out.println(elm.getName());
		//AttributeSet attribs = elm.getAttributes();
		
		try {
			//System.out.println("off="+elm.getStartOffset()+" name="+elm.getName());
			if(elm.getName().contentEquals("td"))
				{
				final AttributeSet attrs = elm.getAttributes();
				try{rowSpan = Integer.parseInt(attrs.getAttribute(HTML.Attribute.ROWSPAN).toString());}
				catch(NullPointerException e){rowSpan=1;}
				try{colSpan = Integer.parseInt(attrs.getAttribute(HTML.Attribute.COLSPAN).toString());}
				catch(NullPointerException e){colSpan=1;}
				tdVisited=true;
				//System.out.println(attrs.getAttribute(HTML.Attribute.));
				//System.out.println("rowSpan="+rowSpan+" colSpan="+colSpan);
				}
			if(elm.getName().contentEquals("content")&&tdVisited)
				{
				td(colSpan,rowSpan,elm.getDocument().getText(elm.getStartOffset(), 
						elm.getEndOffset()-elm.getStartOffset()));
				tdVisited=false;//This is because some TDs give multiple 'content' nodes, the second+ being empty.
				}
			else for(Element sub:getChildren(elm))
				{processElement(sub);}
			}
		catch(Exception e){e.printStackTrace();}
		}
	
	private void tr()
		{
		y++;//Newline, so to speak.
		x=0;//Carriage return, so to speak.
		}
	
	private void td(int spanX,int spanY, Object data)
		{findNextBlank();
		fillCells(spanX,spanY,data);}
	
	private void findNextBlank()
		{while(!isCurrentLocationEmpty()){x++;}}
	
	private void fillCells(int spanX, int spanY, Object data)
		{
		//System.out.println("fillCells spanX="+spanX+" spanY="+spanY+" x="+x+" y="+y+" data="+data);
		for(int _y=0; _y<spanY; _y++)
			{
			for(int _x=0; _x<spanX; _x++)
				{
				setAt(x+_x,y+_y,data);
				}
			}
		}//end fillCells(...)
	
	private boolean isCurrentLocationEmpty()
		{return this.getAt(x, y)==null;}
	
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
	
	private void setAt(int x, int y, Object obj)
		{
		//System.out.println(obj.toString().length());
		//System.out.println("setAt x="+x+" y="+y+" val="+obj);
		//System.out.println(":::::   "+obj.toString());
		//table.put(new XYPosition(x,y), null);
		table.put(new XYPosition(x,y), obj.toString());
		}
	
	private Object getAt(int x, int y)
		{return table.get(new XYPosition(x,y));}
	
	private boolean isName()
		{return !currentLine.matches(".*\\d.*")&&currentLine.length()>2;}
	
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
	
	private static String prettyText(String orig)
		{
		final StringBuilder sb = new StringBuilder();
		boolean previousWasSpace=true;
		for(char c:orig.toCharArray())
			{
			if(c=='-'||c==' '){sb.append(c);previousWasSpace=true;}
			else
				{if(previousWasSpace){sb.append(c);previousWasSpace=false;}
				else{sb.append(Character.toLowerCase(c));previousWasSpace=false;}}
			}//end for(chars)
		return sb.toString();
		}
	
	private void printJava()
		{
		for(int row=0; row<y; row++)
			{
			final String itu2 = (String)getAt(1,row);
			
			if(checkForFrequencyHint(row))
				{}//meh.
			else if(itu2!=null&&itu2.length()>0&&itu2.contains(" ")){//Null means column2 doesn't exist in that row
				//System.out.println("ITU2="+itu2);
				final String possibleFrequencyRangeLabel = itu2.substring(0,itu2.indexOf(' '));
				final String restOfString = itu2.substring(itu2.indexOf(' '));
				if(possibleFrequencyRangeLabel.contains("-"))
					{
					final String left=possibleFrequencyRangeLabel.substring(0,possibleFrequencyRangeLabel.indexOf('-'));
					final String right=possibleFrequencyRangeLabel.substring(possibleFrequencyRangeLabel.indexOf('-')+1,possibleFrequencyRangeLabel.length());
					//System.out.println("Left="+left+" right="+right);
					final long low=(long)(Double.parseDouble(left)*currentUnit.getMultiplier());
					final long high=(long)(Double.parseDouble(right)*currentUnit.getMultiplier());
					//For rest of string, remove words which are just numbers and periods.
					final Scanner wordScanner = new Scanner(restOfString);
					final StringBuilder descriptionBuilder = new StringBuilder();
					descriptionBuilder.append("dest.add(new DefaultFrequencyGuide("+low+"L,"+high+"L,new String[]{");
					while(wordScanner.hasNext())
						{
						final String word = wordScanner.next();
						if(!word.contains("."))
							{
							//descriptionBuilder.append(word);
							if(word.charAt(0)=='(' || word.toUpperCase().contentEquals("AND") || 
									descriptionBuilder.toString().endsWith("and\",")
									|| StringUtils.isNumeric(word))
								{//Delete closing quote and comma
								descriptionBuilder.deleteCharAt(descriptionBuilder.length()-1);
								descriptionBuilder.deleteCharAt(descriptionBuilder.length()-1);
								descriptionBuilder.append(" "+word+"\",");
								}//Part of previous word
							else{descriptionBuilder.append("\""+prettyText(word)+"\",");}
							}
						}//end while(hasNext())
					descriptionBuilder.deleteCharAt(descriptionBuilder.length()-1);
					descriptionBuilder.append("}));");
					final String description = descriptionBuilder.toString();
					
					if(previousHash!=description.hashCode())System.out.println(description);
					previousHash=description.hashCode();
					//System.out.println("ENTRY: LO="+low+" HI="+high+" DESC="+prettyText(description));
					}
				}//end !frequencyHint
			}//end for(rows)
		}
	
	private void printCSV()
		{
		System.out.println("Printing CSV...");
		
		ArrayList<String>rowElements = new ArrayList<String>();
		for(int row=0; row<y; row++)
			{for(int col=0; col<6; col++)
				{
				String s=(String)getAt(col,row);
				if(s!=null)
					{
					if(s.length()==1&&s.charAt(0)==10){s="";}
					if(s.length()>0){System.out.print(s);if(col<5){System.out.print(',');}}
					else{System.out.print("[empty] ");}
					rowElements.add(s);
					}
				else rowElements.add("null");
				}
			submitRow(rowElements);
			rowElements.clear();
			System.out.print("\n");
			}//end for(rows)
		
		/*
		for(XYPosition pos:table.keySet())
			{
			System.out.println(pos.toString()+" "+table.get(new XYPosition(pos.x,pos.y)));
			}
		*/
		}//end printCSV()
	
	private boolean checkForFrequencyHint(int row)
		{
		final XYPosition coord=new XYPosition(0,row);
		final String cell =(String)table.get(coord);
		if(cell==null)return false;
		if((cell).toUpperCase().contains("KHZ"))
			{currentUnit=FreqUnit.KHz;}
		else if(((String)table.get(coord)).toUpperCase().contains("MHZ"))
			{currentUnit=FreqUnit.MHz;}
		else if(((String)table.get(coord)).toUpperCase().contains("GHZ"))
			{currentUnit=FreqUnit.GHz;}
		else return false;
		return true;
		}
	
	private void submitRow(List<String>row)
		{
		if(row.size()==0)return;
		if(row.get(0).toUpperCase().contains("KHZ"))
			{currentUnit=FreqUnit.KHz;}
		else if(row.get(0).toUpperCase().contains("MHZ"))
			{currentUnit=FreqUnit.MHz;}
		else if(row.get(0).toUpperCase().contains("GHZ"))
			{currentUnit=FreqUnit.GHz;}
		
		}
	
	/*
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
		*/
	}//end ExtractFCCTable
