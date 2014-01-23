package com.ritolaaudio.fcdspectrum.guides;

import java.util.Collection;

public class SHFFrequencyGuide implements FrequencyGuide
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
		dest.add(new DefaultFrequencyGuide(3100000000L,3300000000L,new String[]{"Radiolocation","Earth","exploration-satellite (active)","Space","research (active)"}));
		dest.add(new DefaultFrequencyGuide(3300000000L,3400000000L,new String[]{"Radiolocation","Amateur","Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(3400000000L,3500000000L,new String[]{"Fixed","Fixed-Satellite (space-to-Earth)","Amateur","Mobile","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(3500000000L,3700000000L,new String[]{"Fixed","Fixed-Satellite (space-to-Earth)","Mobile","except","aeronautical","mobile","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(3700000000L,4200000000L,new String[]{"Fixed","Fixed-Satellite (space-to-Earth)","Mobile","except","aeronautical","mobile"}));
		dest.add(new DefaultFrequencyGuide(4200000000L,4400000000L,new String[]{"Aeronautical","Radionavigation"}));
		dest.add(new DefaultFrequencyGuide(4400000000L,4500000000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(4500000000L,4800000000L,new String[]{"Fixed","Fixed-Satellite (space-to-Earth)","Mobile"}));
		dest.add(new DefaultFrequencyGuide(4800000000L,4990000000L,new String[]{"Fixed","Mobile","Radio","astronomy"}));
		dest.add(new DefaultFrequencyGuide(4990000000L,5000000000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile","Radio","Astronomy","Space","research (passive)"}));
		dest.add(new DefaultFrequencyGuide(5000000000L,5010000000L,new String[]{"Aeronautical","Radionavigation","Radionavigation-Satellite (Earth-to-space)"}));
		dest.add(new DefaultFrequencyGuide(5010000000L,5030000000L,new String[]{"Aeronautical","Radionavigation","Radionavigation-Satellite (space-to-Earth) (space-to-space)"}));
		dest.add(new DefaultFrequencyGuide(5030000000L,5091000000L,new String[]{"Aeronautical","Radionavigation"}));
		dest.add(new DefaultFrequencyGuide(5091000000L,5150000000L,new String[]{"Aeronautical","Radionavigation","Aeronautical","Mobile"}));
		dest.add(new DefaultFrequencyGuide(5150000000L,5250000000L,new String[]{"Aeronautical","Radionavigation","Fixed-Satellite (Earth-to-space)","Mobile","except","aeronautical","mobile"}));
		dest.add(new DefaultFrequencyGuide(5250000000L,5255000000L,new String[]{"Earth","Exploration-Satellite (active)","Radiolocation","Space","Research","Mobile","except","aeronautical","mobile"}));
		dest.add(new DefaultFrequencyGuide(5255000000L,5350000000L,new String[]{"Earth","Exploration-Satellite (active)","Radiolocation","Space","Research (active)","Mobile","except","aeronautical","mobile"}));
		dest.add(new DefaultFrequencyGuide(5350000000L,5460000000L,new String[]{"Earth","Exploration-Satellite (active)","Space","Research (active)","Aeronautical","Radionavigation","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(5460000000L,5470000000L,new String[]{"Radionavigation","Earth","Exploration-Satellite (active)","Space","Research (active)","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(5470000000L,5570000000L,new String[]{"Maritime","Radionavigation","Mobile","except","aeronautical","mobile","Earth","Exploration-Satellite (active)","Space","Research (active)","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(5570000000L,5650000000L,new String[]{"Maritime","Radionavigation","Mobile","except","aeronautical","mobile","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(5650000000L,5725000000L,new String[]{"Mobile","except","aeronautical","mobile","Radiolocation","Amateur","Space","research (deep","space)"}));
		dest.add(new DefaultFrequencyGuide(5725000000L,5830000000L,new String[]{"Radiolocation","Amateur"}));
		dest.add(new DefaultFrequencyGuide(5830000000L,5850000000L,new String[]{"Radiolocation","Amateur","Amateur-satellite (space-to-Earth)"}));
		dest.add(new DefaultFrequencyGuide(5850000000L,5925000000L,new String[]{"Fixed","Fixed-Satellite (Earth-to-space)","Mobile","Amateur","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(5925000000L,6700000000L,new String[]{"Fixed","Fixed-Satellite (Earth-to-space)","Mobile"}));
		dest.add(new DefaultFrequencyGuide(6700000000L,7075000000L,new String[]{"Fixed","Fixed-Satellite (Earth-to-space) (space-to-Earth)","Mobile"}));
		dest.add(new DefaultFrequencyGuide(7075000000L,7145000000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(7145000000L,7235000000L,new String[]{"Fixed","Mobile","Space","Research (Earth-to-space)"}));
		dest.add(new DefaultFrequencyGuide(7235000000L,7250000000L,new String[]{"Fixed"}));
		dest.add(new DefaultFrequencyGuide(7250000000L,7300000000L,new String[]{"Fixed-Satellite (space-to-Earth)","Mobile-Satellite (space-to-Earth)","Fixed","G117"}));
		dest.add(new DefaultFrequencyGuide(7300000000L,7450000000L,new String[]{"Fixed","Fixed-Satellite (space-to-Earth)","Mobile-satellite (space-to-Earth)","G117"}));
		dest.add(new DefaultFrequencyGuide(7450000000L,7550000000L,new String[]{"Fixed","Fixed-Satellite (space-to-Earth)","Meteorological-Satellite (space-to-Earth)","Mobile-satellite (space-to-Earth)","G104","G117"}));
		dest.add(new DefaultFrequencyGuide(7550000000L,7750000000L,new String[]{"Fixed","Fixed-Satellite (space-to-Earth)","Mobile-satellite (space-to-Earth)","G117"}));
		dest.add(new DefaultFrequencyGuide(7750000000L,7850000000L,new String[]{"Fixed","Meteorological-Satellite (space-to-Earth)"}));
		dest.add(new DefaultFrequencyGuide(7850000000L,7900000000L,new String[]{"Fixed"}));
		dest.add(new DefaultFrequencyGuide(7900000000L,8025000000L,new String[]{"Fixed-Satellite (Earth-to-space)","Mobile-Satellite (Earth-to-space)","Fixed","G117"}));
		dest.add(new DefaultFrequencyGuide(8025000000L,8175000000L,new String[]{"Earth","Exploration-Satellite (space-to-Earth)","Fixed","Fixed-Satellite (Earth-to-space)","Mobile"}));
		dest.add(new DefaultFrequencyGuide(8175000000L,8215000000L,new String[]{"Earth","Exploration-Satellite (space-to-Earth)","Fixed","Fixed-Satellite (Earth-to-space)","Meteorological-Satellite (Earth-to-space)","Mobile"}));
		dest.add(new DefaultFrequencyGuide(8215000000L,8400000000L,new String[]{"Earth","Exploration-Satellite (space-to-Earth)","Fixed","Fixed-Satellite (Earth-to-space)","Mobile"}));
		dest.add(new DefaultFrequencyGuide(8400000000L,8500000000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile","Space","Research (space-to-Earth)"}));
		dest.add(new DefaultFrequencyGuide(8500000000L,8550000000L,new String[]{"Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(8550000000L,8650000000L,new String[]{"Earth","Exploration-Satellite (active)","Radiolocation","Space","Research (active)"}));
		dest.add(new DefaultFrequencyGuide(8650000000L,9000000000L,new String[]{"Radiolocation","G59"}));
		dest.add(new DefaultFrequencyGuide(9000000000L,9200000000L,new String[]{"Aeronautical","Radionavigation","Radiolocation","G2","Us48","G19"}));
		dest.add(new DefaultFrequencyGuide(9200000000L,9300000000L,new String[]{"Maritime","Radionavigation","Radiolocation","Us110","G59"}));
		dest.add(new DefaultFrequencyGuide(9300000000L,9500000000L,new String[]{"Radionavigation","Us66","Radiolocation","Us51","G56","Meteorological","aids","Us67","Us71"}));
		dest.add(new DefaultFrequencyGuide(9500000000L,9800000000L,new String[]{"Earth","Exploration-Satellite (active)","Space","Research (active)","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(9800000000L,10000000000L,new String[]{"Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(10000000000L,10450000000L,new String[]{"Radiolocation","Amateur"}));
		dest.add(new DefaultFrequencyGuide(10450000000L,10500000000L,new String[]{"Radiolocation","Amateur","Amateur-satellite"}));
		dest.add(new DefaultFrequencyGuide(10500000000L,10550000000L,new String[]{"Fixed","Mobile","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(10550000000L,10600000000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(10600000000L,10680000000L,new String[]{"Earth","Exploration-Satellite (passive)","Fixed","Mobile","except","aeronautical","mobile","Radio","Astronomy","Space","Research (passive)","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(10680000000L,10700000000L,new String[]{"Earth","Exploration-Satellite (passive)","Radio","Astronomy","Space","Research (passive)"}));
		dest.add(new DefaultFrequencyGuide(10700000000L,11700000000L,new String[]{"Fixed","Fixed-Satellite (space-to-Earth)","Mobile","except","aeronautical","mobile"}));
		dest.add(new DefaultFrequencyGuide(11700000000L,12100000000L,new String[]{"Fixed","Fixed-Satellite (space-to-Earth)","Mobile","except","aeronautical","mobile"}));
		dest.add(new DefaultFrequencyGuide(12100000000L,12200000000L,new String[]{"Fixed-Satellite (space-to-Earth)"}));
		dest.add(new DefaultFrequencyGuide(12200000000L,12700000000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile","Broadcasting","Broadcasting-Satellite"}));
		dest.add(new DefaultFrequencyGuide(12700000000L,12750000000L,new String[]{"Fixed","Fixed-Satellite (Earth-to-space)","Mobile","except","aeronautical","mobile"}));
		dest.add(new DefaultFrequencyGuide(12750000000L,13250000000L,new String[]{"Fixed","Fixed-Satellite (Earth-to-space)","Mobile","Space","research (deep","space) (space-to-Earth)"}));
		dest.add(new DefaultFrequencyGuide(13250000000L,13400000000L,new String[]{"Earth","Exploration-Satellite (active)","Aeronautical","Radionavigation","Space","Research (active)"}));
		dest.add(new DefaultFrequencyGuide(13400000000L,13750000000L,new String[]{"Earth","Exploration-Satellite (active)","Radiolocation","Space","Research","Standard","frequency and time","signal-satellite (Earth-to-space)"}));
		dest.add(new DefaultFrequencyGuide(13750000000L,14000000000L,new String[]{"Fixed-Satellite (Earth-to-space)","Radiolocation","Earth","exploration-satellite","Standard","frequency and time","signal-satellite (Earth-to-space)","Space","research"}));
		dest.add(new DefaultFrequencyGuide(14000000000L,14250000000L,new String[]{"Fixed-Satellite (Earth-to-space)","Radionavigation","Mobile-satellite (Earth-to-space)","Space","research"}));
		dest.add(new DefaultFrequencyGuide(14250000000L,14300000000L,new String[]{"Fixed-Satellite (Earth-to-space)","Radionavigation","Mobile-satellite (Earth-to-space)","Space","research"}));
		dest.add(new DefaultFrequencyGuide(14300000000L,14400000000L,new String[]{"Fixed-Satellite (Earth-to-space)","Mobile-satellite (Earth-to-space)","Radionavigation-satellite"}));
		dest.add(new DefaultFrequencyGuide(14400000000L,14470000000L,new String[]{"Fixed","Fixed-Satellite (Earth-to-space)","Mobile","except","aeronautical","mobile","Mobile-satellite (Earth-to-space)","Space","research (space-to-Earth)"}));
		dest.add(new DefaultFrequencyGuide(14470000000L,14500000000L,new String[]{"Fixed","Fixed-Satellite (Earth-to-space)","Mobile","except","aeronautical","mobile","Mobile-satellite (Earth-to-space)","Radio","astronomy"}));
		dest.add(new DefaultFrequencyGuide(14500000000L,14800000000L,new String[]{"Fixed","Fixed-Satellite (Earth-to-space)","Mobile","Space","research"}));
		dest.add(new DefaultFrequencyGuide(14800000000L,15350000000L,new String[]{"Fixed","Mobile","Space","research"}));
		dest.add(new DefaultFrequencyGuide(15350000000L,15400000000L,new String[]{"Earth","Exploration-Satellite (passive)","Radio","Astronomy","Space","Research (passive)"}));
		dest.add(new DefaultFrequencyGuide(15400000000L,15430000000L,new String[]{"Aeronautical","Radionavigation"}));
		dest.add(new DefaultFrequencyGuide(15430000000L,15630000000L,new String[]{"Fixed-Satellite (Earth-to-space)","Aeronautical","Radionavigation"}));
		dest.add(new DefaultFrequencyGuide(15630000000L,15700000000L,new String[]{"Aeronautical","Radionavigation"}));
		dest.add(new DefaultFrequencyGuide(15700000000L,16600000000L,new String[]{"Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(16600000000L,17100000000L,new String[]{"Radiolocation","Space","research (deep","space) (Earth-to-space)"}));
		dest.add(new DefaultFrequencyGuide(17100000000L,17200000000L,new String[]{"Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(17200000000L,17300000000L,new String[]{"Earth","Exploration-Satellite (active)","Radiolocation","Space","Research (active)"}));
		dest.add(new DefaultFrequencyGuide(17300000000L,17700000000L,new String[]{"Fixed-Satellite (Earth-to-space)","Broadcasting-Satellite","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(17700000000L,17800000000L,new String[]{"Fixed","Fixed-Satellite (space-to-Earth) (Earth-to-space)","Broadcasting-Satellite","Mobile"}));
		dest.add(new DefaultFrequencyGuide(17800000000L,18100000000L,new String[]{"Fixed","Fixed-Satellite (space-to-Earth) (Earth-to-space)","Mobile"}));
		dest.add(new DefaultFrequencyGuide(18100000000L,18400000000L,new String[]{"Fixed","Fixed-Satellite (space-to-Earth) (Earth-to-space)","Mobile"}));
		dest.add(new DefaultFrequencyGuide(18400000000L,18600000000L,new String[]{"Fixed","Fixed-Satellite (space-to-Earth)","Mobile"}));
		dest.add(new DefaultFrequencyGuide(18600000000L,18800000000L,new String[]{"Earth","Exploration-Satellite (passive)","Fixed","Fixed-Satellite (space-to-Earth)","Mobile","except","aeronautical","mobile","Space","Research (passive)"}));
		dest.add(new DefaultFrequencyGuide(18800000000L,19300000000L,new String[]{"Fixed","Fixed-Satellite (space-to-Earth)","Mobile"}));
		dest.add(new DefaultFrequencyGuide(19300000000L,19700000000L,new String[]{"Fixed","Fixed-Satellite (space-to-Earth) (Earth-to-space)","Mobile"}));
		dest.add(new DefaultFrequencyGuide(19700000000L,20100000000L,new String[]{"Fixed-Satellite (space-to-Earth)","Mobile-Satellite (space-to-Earth)"}));
		dest.add(new DefaultFrequencyGuide(20100000000L,20200000000L,new String[]{"Fixed-Satellite (space-to-Earth)","Mobile-Satellite (space-to-Earth)"}));
		dest.add(new DefaultFrequencyGuide(20200000000L,21200000000L,new String[]{"Fixed-Satellite (space-to-Earth)","Mobile-Satellite (space-to-Earth)","Standard","frequency and time","signal-satellite (space-to-Earth)"}));
		dest.add(new DefaultFrequencyGuide(21200000000L,21400000000L,new String[]{"Earth","Exploration-Satellite (passive)","Fixed","Mobile","Space","Research (passive)"}));
		dest.add(new DefaultFrequencyGuide(21400000000L,22000000000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(22000000000L,22210000000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile"}));
		dest.add(new DefaultFrequencyGuide(22210000000L,22500000000L,new String[]{"Earth","Exploration-Satellite (passive)","Fixed","Mobile","except","aeronautical","mobile","Radio","Astronomy","Space","Research (passive)"}));
		dest.add(new DefaultFrequencyGuide(22500000000L,22550000000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(22550000000L,23550000000L,new String[]{"Fixed","Inter-Satellite","Mobile"}));
		dest.add(new DefaultFrequencyGuide(23550000000L,23600000000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(23600000000L,24000000000L,new String[]{"Earth","Exploration-Satellite (passive)","Radio","Astronomy","Space","Research (passive)"}));
		dest.add(new DefaultFrequencyGuide(24000000000L,24050000000L,new String[]{"Amateur","Amateur-Satellite"}));
		dest.add(new DefaultFrequencyGuide(24050000000L,24250000000L,new String[]{"Radiolocation","Amateur","Earth","exploration-satellite (active)"}));
		dest.add(new DefaultFrequencyGuide(24250000000L,24450000000L,new String[]{"Radionavigation"}));
		dest.add(new DefaultFrequencyGuide(24450000000L,24650000000L,new String[]{"Inter-Satellite","Radionavigation"}));
		dest.add(new DefaultFrequencyGuide(24650000000L,24750000000L,new String[]{"Inter-Satellite","Radiolocation-Satellite (Earth-to-space)"}));
		dest.add(new DefaultFrequencyGuide(24750000000L,25250000000L,new String[]{"Fixed-Satellite (Earth-to-space)"}));
		dest.add(new DefaultFrequencyGuide(25250000000L,25500000000L,new String[]{"Fixed","Inter-Satellite","Mobile","Standard","frequency and time","signal-satellite (Earth-to-space)"}));
		dest.add(new DefaultFrequencyGuide(25500000000L,27000000000L,new String[]{"Earth","Exploration-Satellite (space-to-Earth)","Fixed","Inter-Satellite","Mobile","Space","Research (space-to-Earth)","Standard","frequency and time","signal-satellite (Earth-to-space)"}));
		}

	@Override
	public long startFreq()
		{
		return 3100000000L;
		}

	@Override
	public long endFreq()
		{
		return 27000000000L;
		}

	}
