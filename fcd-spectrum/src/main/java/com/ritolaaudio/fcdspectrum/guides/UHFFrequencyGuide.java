package com.ritolaaudio.fcdspectrum.guides;

import java.util.Collection;

public class UHFFrequencyGuide implements FrequencyGuide
	{

	@Override
	public String getName()
		{
		// TODO Auto-generated method stub
		return null;
		}

	@Override
	public void getSubguides(Collection<FrequencyGuide> dest)
		{
		dest.add(new DefaultFrequencyGuide(312000000L,315000000L,new String[]{"Fixed","Mobile","Mobile-satellite (Earth-to-space)"}));
		dest.add(new DefaultFrequencyGuide(315000000L,322000000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(322000000L,328600000L,new String[]{"Fixed","Mobile","Radio","Astronomy"}));
		dest.add(new DefaultFrequencyGuide(328600000L,335400000L,new String[]{"Aeronautical","Radionavigation"}));
		dest.add(new DefaultFrequencyGuide(335400000L,387000000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(387000000L,390000000L,new String[]{"Fixed","Mobile","Mobile-satellite (space-to-Earth)"}));
		dest.add(new DefaultFrequencyGuide(390000000L,399900000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(399900000L,400050000L,new String[]{"Mobile-Satellite (Earth-to-space)","Us319","Us320","Radionavigation-Satellite"}));
		dest.add(new DefaultFrequencyGuide(400150000L,401000000L,new String[]{"Meteorological","Aids (","radiosonde",")","Us70","Meteorological-Satellite (","space","-to-Earth)","Mobile-Satellite (space-to-","Earth",")","Us319","Us320","Us324","Space","Research (","space","-to-Earth)","Space","operation (space-to-Earth)"}));
		dest.add(new DefaultFrequencyGuide(401000000L,402000000L,new String[]{"Meteorological","Aids (","radiosonde",")","Us70","Space","Operation (","space","-to-Earth)","Earth","Exploration-","Satellite (Earth-to-space)","Meteorological-Satellite (Earth-to-space)","Us64","Us384"}));
		dest.add(new DefaultFrequencyGuide(402000000L,403000000L,new String[]{"Meteorological","Aids (","radiosonde",")","Us70","Earth","Exploration-","Satellite (Earth-to-space)","Meteorological-Satellite (Earth-to-space)","Us64","Us384"}));
		dest.add(new DefaultFrequencyGuide(403000000L,406000000L,new String[]{"Meteorological","Aids (","radiosonde",")","Us70","Us64","G6"}));
		dest.add(new DefaultFrequencyGuide(406000000L,406100000L,new String[]{"Mobile-Satellite (Earth-to-space) 266"}));
		dest.add(new DefaultFrequencyGuide(406100000L,410000000L,new String[]{"Fixed","Mobile","Radio","Astronomy","Us74","Us13","Us117","G5","G6"}));
		dest.add(new DefaultFrequencyGuide(410000000L,420000000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile","Space","Research (space-to-space)"}));
		dest.add(new DefaultFrequencyGuide(420000000L,430000000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(430000000L,432000000L,new String[]{"Radiolocation","Amateur"}));
		dest.add(new DefaultFrequencyGuide(432000000L,438000000L,new String[]{"Radiolocation","Amateur","Earth","exploration-satellite (active)"}));
		dest.add(new DefaultFrequencyGuide(438000000L,440000000L,new String[]{"Radiolocation","Amateur"}));
		dest.add(new DefaultFrequencyGuide(440000000L,450000000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(450000000L,455000000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(455000000L,456000000L,new String[]{"Fixed","Mobile","Mobile-Satellite (Earth-to-","space)"}));
		dest.add(new DefaultFrequencyGuide(456000000L,459000000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(459000000L,460000000L,new String[]{"Fixed","Mobile","Mobile-Satellite (Earth-to-","space)"}));
		dest.add(new DefaultFrequencyGuide(460000000L,470000000L,new String[]{"Fixed","Mobile","Meteorological-satellite (space-to-Earth)"}));
		//dest.add(new DefaultFrequencyGuide(470000000L,512000000L,new String[]{"Broadcasting","Fixed","Mobile"}));
		//dest.add(new DefaultFrequencyGuide(512000000L,608000000L,new String[]{"Broadcasting"}));
		dest.add(new DefaultFrequencyGuide(608000000L,614000000L,new String[]{"Radio","Astronomy","Mobile-satellite","except","aeronautical","mobile-satellite (Earth-to-space)"}));
		dest.add(new DefaultFrequencyGuide(614000000L,698000000L,new String[]{"Broadcasting","Fixed","Mobile 309"}));
		dest.add(new DefaultFrequencyGuide(698000000L,806000000L,new String[]{"Fixed","Mobile","Broadcasting"}));
		dest.add(new DefaultFrequencyGuide(806000000L,890000000L,new String[]{"Fixed","Mobile","Broadcasting"}));
		dest.add(new DefaultFrequencyGuide(890000000L,902000000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(902000000L,928000000L,new String[]{"Fixed","Amateur","Mobile","except","aeronautical","mobile","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(928000000L,942000000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(942000000L,960000000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(960000000L,1164000000L,new String[]{"Aeronautical","Mobile (R)","Aeronautical","Radionavigation"}));
		dest.add(new DefaultFrequencyGuide(1164000000L,1215000000L,new String[]{"Aeronautical","Radionavigation","Radionavigation-Satellite (space-to-Earth) (space-to-space)"}));
		dest.add(new DefaultFrequencyGuide(1215000000L,1240000000L,new String[]{"Earth","Exploration-Satellite (active)","Radiolocation","Radionavigation-Satellite (space-to-Earth) (space-to-space)","Space","Research (active)"}));
		dest.add(new DefaultFrequencyGuide(1240000000L,1300000000L,new String[]{"Earth","Exploration-Satellite (active)","Radiolocation","Radionavigation-Satellite (space-to-Earth) (space-to-space)","Space","Research (active)","Amateur"}));
		dest.add(new DefaultFrequencyGuide(1300000000L,1350000000L,new String[]{"Radiolocation","Aeronautical","Radionavigation","Radionavigation-Satellite (Earth-to-space)"}));
		dest.add(new DefaultFrequencyGuide(1350000000L,1400000000L,new String[]{"Fixed","Mobile","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(1400000000L,1427000000L,new String[]{"Earth","Exploration-Satellite (passive)","Radio","Astronomy","Space","Research (passive)"}));
		dest.add(new DefaultFrequencyGuide(1427000000L,1429000000L,new String[]{"Space","Operation (Earth-to-space)","Fixed","Mobile","except","aeronautical","mobile"}));
		dest.add(new DefaultFrequencyGuide(1429000000L,1452000000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile"}));
		dest.add(new DefaultFrequencyGuide(1452000000L,1492000000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile","Broadcasting","Broadcasting-Satellite"}));
		dest.add(new DefaultFrequencyGuide(1492000000L,1518000000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(1518000000L,1525000000L,new String[]{"Fixed","Mobile","Mobile-Satellite (space-to-Earth)"}));
		dest.add(new DefaultFrequencyGuide(1525000000L,1530000000L,new String[]{"Space","Operation (space-to-Earth)","Mobile-Satellite (space-to-Earth)","Earth","exploration-satellite","Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(1530000000L,1535000000L,new String[]{"Space","Operation (space-to-Earth)","Mobile-Satellite (space-to-Earth)","Earth","exploration-satellite","Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(1535000000L,1559000000L,new String[]{"Mobile-Satellite (space-to-Earth)"}));
		dest.add(new DefaultFrequencyGuide(1559000000L,1610000000L,new String[]{"Aeronautical","Radionavigation","Radionavigation-Satellite (space-to-Earth) (space-to-space)"}));
		dest.add(new DefaultFrequencyGuide(1610000000L,1610600000L,new String[]{"Mobile-Satellite (Earth-to-space)","Aeronautical","Radionavigation","Radiodetermination-Satellite (Earth-to-space)"}));
		dest.add(new DefaultFrequencyGuide(1610600000L,1613800000L,new String[]{"Mobile-Satellite (Earth-to-space)","Radio","Astronomy","Aeronautical","Radionavigation","Radiodetermination-","Satellite (Earth-to-space)"}));
		dest.add(new DefaultFrequencyGuide(1613800000L,1626500000L,new String[]{"Mobile-Satellite (Earth-to-space)","Aeronautical","Radionavigation","Radiodetermination-Satellite (Earth-to-space)","Mobile-satellite (space-to-Earth)"}));
		dest.add(new DefaultFrequencyGuide(1626500000L,1660000000L,new String[]{"Mobile-Satellite (Earth-to-space)"}));
		dest.add(new DefaultFrequencyGuide(1660000000L,1660500000L,new String[]{"Mobile-Satellite (Earth-to-space)","Radio","Astronomy"}));
		dest.add(new DefaultFrequencyGuide(1660500000L,1668000000L,new String[]{"Radio","Astronomy","Space","Research (passive)","Fixed","Mobile","except","aeronautical","mobile"}));
		dest.add(new DefaultFrequencyGuide(1668000000L,1668400000L,new String[]{"Mobile-Satellite (Earth-to-space)","Radio","Astronomy","Space","Research (passive)","Fixed","Mobile","except","aeronautical","mobile"}));
		dest.add(new DefaultFrequencyGuide(1668400000L,1670000000L,new String[]{"Meteorological","Aids","Fixed","Mobile","except","aeronautical","mobile","Mobile-Satellite (Earth-to-space)","Radio","Astronomy"}));
		dest.add(new DefaultFrequencyGuide(1670000000L,1675000000L,new String[]{"Meteorological","Aids","Fixed","Meteorological-Satellite (space-to-Earth)","Mobile","Mobile-Satellite (Earth-to-space)"}));
		dest.add(new DefaultFrequencyGuide(1675000000L,1690000000L,new String[]{"Meteorological","Aids","Fixed","Meteorological-Satellite (space-to-Earth)","Mobile","except","aeronautical","mobile"}));
		dest.add(new DefaultFrequencyGuide(1690000000L,1700000000L,new String[]{"Meteorological","Aids","Meteorological-Satellite (space-to-Earth)"}));
		dest.add(new DefaultFrequencyGuide(1700000000L,1710000000L,new String[]{"Fixed","Meteorological-Satellite (space-to-Earth)","Mobile","except","aeronautical","mobile"}));
		dest.add(new DefaultFrequencyGuide(1710000000L,1930000000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(1930000000L,1970000000L,new String[]{"Fixed","Mobile","Mobile-satellite (Earth-to-space)"}));
		dest.add(new DefaultFrequencyGuide(1970000000L,1980000000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(1980000000L,2010000000L,new String[]{"Fixed","Mobile","Mobile-Satellite (Earth-to-space)"}));
		dest.add(new DefaultFrequencyGuide(2010000000L,2025000000L,new String[]{"Fixed","Mobile","Mobile-Satellite (Earth-to-space)"}));
		dest.add(new DefaultFrequencyGuide(2025000000L,2110000000L,new String[]{"Space","Operation (Earth-to-space) (space-to-space)","Earth","Exploration-Satellite (Earth-to-space) (space-to-space)","Fixed","Mobile","Space","Research (Earth-to-space) (space-to-space)"}));
		dest.add(new DefaultFrequencyGuide(2110000000L,2120000000L,new String[]{"Fixed","Mobile","Space","Research (deep","space) (Earth-to-space)"}));
		dest.add(new DefaultFrequencyGuide(2120000000L,2160000000L,new String[]{"Fixed","Mobile","Mobile-satellite (space-to-Earth)"}));
		dest.add(new DefaultFrequencyGuide(2160000000L,2170000000L,new String[]{"Fixed","Mobile","Mobile-Satellite (space-to-Earth)"}));
		dest.add(new DefaultFrequencyGuide(2170000000L,2200000000L,new String[]{"Fixed","Mobile","Mobile-Satellite (space-to-Earth)"}));
		dest.add(new DefaultFrequencyGuide(2200000000L,2290000000L,new String[]{"Space","Operation (space-to-Earth) (space-to-space)","Earth","Exploration-Satellite (space-to-Earth) (space-to-space)","Fixed","Mobile","Space","Research (space-to-Earth) (space-to-space)"}));
		dest.add(new DefaultFrequencyGuide(2290000000L,2300000000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile","Space","Research (deep","space) (space-to-Earth)"}));
		dest.add(new DefaultFrequencyGuide(2300000000L,2450000000L,new String[]{"Fixed","Mobile","Radiolocation","Amateur"}));
		dest.add(new DefaultFrequencyGuide(2450000000L,2483500000L,new String[]{"Fixed","Mobile","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(2483500000L,2500000000L,new String[]{"Fixed","Mobile","Mobile-Satellite (space-to-Earth)","Radiodetermination-","Satellite (space-to-Earth)","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(2500000000L,2520000000L,new String[]{"Fixed","Fixed-Satellite (space-to-","Earth)","Mobile","except","aeronautical","mobile"}));
		dest.add(new DefaultFrequencyGuide(2520000000L,2655000000L,new String[]{"Fixed","Fixed-Satellite (space-to-Earth)","Mobile","except","aeronautical","mobile","Broadcasting-Satellite"}));
		dest.add(new DefaultFrequencyGuide(2655000000L,2670000000L,new String[]{"Fixed","Fixed-Satellite (Earth-to-space) (space-to-Earth)","Mobile","except","aeronautical","mobile","Broadcasting-Satellite","Earth","exploration-satellite (passive)","Radio","astronomy","Space","research (passive)"}));
		dest.add(new DefaultFrequencyGuide(2670000000L,2690000000L,new String[]{"Fixed","Fixed-Satellite (Earth-to-space) (space-to-Earth)","Mobile","except","aeronautical","mobile","Earth","exploration-satellite (passive)","Radio","astronomy","Space","research (passive)"}));
		dest.add(new DefaultFrequencyGuide(2690000000L,2700000000L,new String[]{"Earth","Exploration-Satellite (passive)","Radio","Astronomy","Space","Research (passive)"}));
		dest.add(new DefaultFrequencyGuide(2700000000L,2900000000L,new String[]{"Aeronautical","Radionavigation","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(2900000000L,3100000000L,new String[]{"Radiolocation","Radionavigation"}));
		
		// FRS/GMRS
		for(int i=0; i<14;i++)
			{dest.add(new DefaultFrequencyGuide(462550000L+i*25000L,462550000L+(i+1)*25000L,new String[]
						{"FRS"+(i<8?"/GMRS":"")+" Ch"+(i+1)}));}
		
		//ATSC HI
		for(int i=0; i<37; i++){dest.add(new DefaultFrequencyGuide(470000000+i*6000000,470000000+(i+1)*6000000,new String[]{"ATSC Ch"+(int)(i+14)}));}
		}

	@Override
	public long startFreq()
		{
		return 312000000L;
		}

	@Override
	public long endFreq()
		{
		return 3100000000L;
		}

	}
