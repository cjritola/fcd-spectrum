package com.ritolaaudio.fcdspectrum.guides;

import java.util.Collection;

public class EHFFrequencyGuide implements FrequencyGuide
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
		dest.add(new DefaultFrequencyGuide(30000000000L,31000000000L,new String[]{"Fixed Satellite (earth to space)","Mobile Satellite (earth to space)","Standard frequency and time","   signal satellite (space to Earth)"}));
		dest.add(new DefaultFrequencyGuide(31000000000L,31300000000L,new String[]{"Standard frequency and time","   signal satellite (space to Earth)"}));
		dest.add(new DefaultFrequencyGuide(31300000000L,31500000000L,new String[]{"Earth Exploration Satellite (passive)","Radio Astronomy","Space Research (passive)"}));
		dest.add(new DefaultFrequencyGuide(31300000000L,31800000000L,new String[]{"Earth Exploration Satellite (passive)"}));
		dest.add(new DefaultFrequencyGuide(31500000000L,31800000000L,new String[]{"Earth Exploration ","   Satellite (passive)","Radio Astronomy","Space Research (passive)","Fixed","Mobile except aeronautical mobile"}));
		dest.add(new DefaultFrequencyGuide(31800000000L,32299999999L,new String[]{"Space Research (deep space)"}));
		dest.add(new DefaultFrequencyGuide(33400000000L,34200000000L,new String[]{"Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(34200000000L,34700000000L,new String[]{"Radiolocation","Space Research (deep space) (earth to space)"}));
		dest.add(new DefaultFrequencyGuide(34700000000L,35200000000L,new String[]{"Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(34700000000L,35500000000L,new String[]{"Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(35200000000L,35500000000L,new String[]{"Meteorological Aids","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(35500000000L,36000000000L,new String[]{"Meteorological Aids","Earth Exploration Satellite (active)","Radiolocation","Space Research (active)"}));
		dest.add(new DefaultFrequencyGuide(36000000000L,37000000000L,new String[]{"Earth Exploration Satellite (passive)","Fixed","Mobile","Space Research (passive)"}));
		dest.add(new DefaultFrequencyGuide(37000000000L,37500000000L,new String[]{"Fixed","Mobile","Space Research (space to Earth)"}));
		dest.add(new DefaultFrequencyGuide(37000000000L,38000000000L,new String[]{"Fixed","Mobile","Space Research (space to Earth)"}));
		dest.add(new DefaultFrequencyGuide(37500000000L,38000000000L,new String[]{"Fixed","Fixed Satellite (space to Earth)","Mobile","Space Research (space to Earth)","Earth exploration satellite (space to Earth)"}));
		dest.add(new DefaultFrequencyGuide(37500000000L,38600000000L,new String[]{"Fixed","Fixed Satellite (space to Earth)","Mobile"}));
		dest.add(new DefaultFrequencyGuide(38000000000L,39500000000L,new String[]{"Fixed","Fixed Satellite (space to Earth)","Mobile","Earth exploration satellite (space to Earth)"}));
		dest.add(new DefaultFrequencyGuide(39500000000L,40000000000L,new String[]{"Fixed"}));
		dest.add(new DefaultFrequencyGuide(40000000000L,40500000000L,new String[]{"Earth Exploration Satellite (earth to space)","Fixed"}));
		dest.add(new DefaultFrequencyGuide(40500000000L,41000000000L,new String[]{"Fixed","Fixed Satellite (space to Earth)","Broadcasting","Broadcasting Satellite","Mobile"}));
		dest.add(new DefaultFrequencyGuide(41000000000L,42500000000L,new String[]{"Fixed"}));
		dest.add(new DefaultFrequencyGuide(42000000000L,42500000000L,new String[]{"Fixed","Mobile","Broadcasting","Broadcasting Satellite"}));
		dest.add(new DefaultFrequencyGuide(42500000000L,43500000000L,new String[]{"Fixed"}));
		dest.add(new DefaultFrequencyGuide(43500000000L,45500000000L,new String[]{"Fixed Satellite (earth to space)","Mobile Satellite (earth to space)"}));
		dest.add(new DefaultFrequencyGuide(45500000000L,46900000000L,new String[]{"Mobile","Mobile Satellite (earth to space)","Radionavigation Satellite"}));
		dest.add(new DefaultFrequencyGuide(46900000000L,47000000000L,new String[]{"Mobile","Mobile Satellite (earth to space)","Radionavigation Satellite"}));
		dest.add(new DefaultFrequencyGuide(47000000000L,47200000000L,new String[]{"Amateur","Amateur Satellite"}));
		dest.add(new DefaultFrequencyGuide(47200000000L,47500000000L,new String[]{"Fixed"}));
		dest.add(new DefaultFrequencyGuide(47200000000L,48200000000L,new String[]{"Fixed","Fixed Satellite (earth to space)"}));
		dest.add(new DefaultFrequencyGuide(47900000000L,48200000000L,new String[]{"Fixed"}));
		dest.add(new DefaultFrequencyGuide(48200000000L,48540000000L,new String[]{"Fixed","Fixed Satellite (earth to space)"}));
		dest.add(new DefaultFrequencyGuide(48200000000L,50200000000L,new String[]{"Fixed"}));
		dest.add(new DefaultFrequencyGuide(48540000000L,49440000000L,new String[]{"Fixed","Fixed Satellite (earth to space)"}));
		dest.add(new DefaultFrequencyGuide(49440000000L,50200000000L,new String[]{"Fixed","Fixed Satellite (earth to space)"}));
		dest.add(new DefaultFrequencyGuide(50200000000L,50400000000L,new String[]{"Earth Exploration Satellite (passive)","Space Research (passive)"}));
		dest.add(new DefaultFrequencyGuide(50400000000L,51400000000L,new String[]{"Fixed"}));
		dest.add(new DefaultFrequencyGuide(51400000000L,52600000000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(52600000000L,54250000000L,new String[]{"Earth Exploration Satellite (passive)","Space Research (passive)"}));
		dest.add(new DefaultFrequencyGuide(54250000000L,55780000000L,new String[]{"Earth Exploration Satellite (passive)"}));
		dest.add(new DefaultFrequencyGuide(55780000000L,56900000000L,new String[]{"Earth Exploration Satellite (passive)"}));
		dest.add(new DefaultFrequencyGuide(56900000000L,57000000000L,new String[]{"Earth Exploration Satellite (passive)","Fixed"}));
		dest.add(new DefaultFrequencyGuide(57000000000L,58200000000L,new String[]{"Earth Exploration Satellite (passive)","Fixed"}));
		dest.add(new DefaultFrequencyGuide(58200000000L,59000000000L,new String[]{"Earth Exploration Satellite (passive)","Fixed","Mobile","Space Research (passive)"}));
		dest.add(new DefaultFrequencyGuide(59000000000L,59300000000L,new String[]{"Earth Exploration Satellite (passive)","Fixed"}));
		dest.add(new DefaultFrequencyGuide(59300000000L,64000000000L,new String[]{"Fixed","Inter Satellite"}));
		dest.add(new DefaultFrequencyGuide(64000000000L,65000000000L,new String[]{"Fixed","Inter Satellite","Mobile except aeronautical mobile"}));
		dest.add(new DefaultFrequencyGuide(65000000000L,66000000000L,new String[]{"Earth Exploration Satellite","Fixed","Inter Satellite","Mobile except aeronautical mobile","Space Research"}));
		dest.add(new DefaultFrequencyGuide(66000000000L,71000000000L,new String[]{"Inter Satellite"}));
		dest.add(new DefaultFrequencyGuide(66000000000L,71000000000L,new String[]{"Inter Satellite"}));
		dest.add(new DefaultFrequencyGuide(71000000000L,74000000000L,new String[]{"Fixed","Fixed Satellite (space to Earth)","Mobile","Mobile Satellite (space to Earth)"}));
		dest.add(new DefaultFrequencyGuide(74000000000L,76000000000L,new String[]{"Fixed","Fixed Satellite (space to Earth)","Mobile","Broadcasting","Broadcasting Satellite","Space research (space to Earth)"}));
		dest.add(new DefaultFrequencyGuide(76000000000L,77500000000L,new String[]{"Radio Astronomy","Radiolocation","Amateur","Amateur satellite","Space research (space to Earth)"}));
		dest.add(new DefaultFrequencyGuide(76000000000L,77000000000L,new String[]{"Radio Astronomy","Radiolocation","Amateur","Space research (space to Earth)"}));
		dest.add(new DefaultFrequencyGuide(77000000000L,77500000000L,new String[]{"Radio Astronomy","Radiolocation","Amateur","Amateur satellite","Space research (space to Earth)"}));
		dest.add(new DefaultFrequencyGuide(77500000000L,78000000000L,new String[]{"Amateur","Amateur Satellite","Radio astronomy","Space research (space to Earth)"}));
		dest.add(new DefaultFrequencyGuide(78000000000L,79000000000L,new String[]{"Radiolocation","Amateur","Amateur satellite","Radio astronomy","Space research (space to Earth)"}));
		dest.add(new DefaultFrequencyGuide(79000000000L,81000000000L,new String[]{"Radio Astronomy","Radiolocation","Amateur","Amateur satellite","Space research (space to Earth)"}));
		dest.add(new DefaultFrequencyGuide(81000000000L,84000000000L,new String[]{"Fixed","Fixed Satellite (earth to space)","Mobile","Mobile Satellite (earth to space)","Radio Astronomy","Space research (space to Earth)"}));
		dest.add(new DefaultFrequencyGuide(84000000000L,86000000000L,new String[]{"Fixed"}));
		dest.add(new DefaultFrequencyGuide(86000000000L,92000000000L,new String[]{"Earth Exploration Satellite (passive)","Radio Astronomy","Space Research (passive)"}));
		dest.add(new DefaultFrequencyGuide(92000000000L,94000000000L,new String[]{"Fixed","Mobile","Radio Astronomy","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(94000000000L,94100000000L,new String[]{"Earth Exploration Satellite (active)","Radiolocation","Space Research (active)","Radio astronomy"}));
		dest.add(new DefaultFrequencyGuide(94100000000L,95000000000L,new String[]{"Fixed","Mobile","Radio Astronomy","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(95000000000L,100000000000L,new String[]{"Fixed","Mobile","Radio Astronomy","Radiolocation","Radionavigation","Radionavigation Satellite"}));
		dest.add(new DefaultFrequencyGuide(100000000000L,102000000000L,new String[]{"Earth Exploration Satellite (passive)","Radio Astronomy","Space Research (passive)"}));
		dest.add(new DefaultFrequencyGuide(102000000000L,105000000000L,new String[]{"Fixed","Mobile","Radio Astronomy"}));
		dest.add(new DefaultFrequencyGuide(105000000000L,109500000000L,new String[]{"Fixed","Mobile","Radio Astronomy"}));
		dest.add(new DefaultFrequencyGuide(109500000000L,111800000000L,new String[]{"Earth Exploration Satellite (passive)","Radio Astronomy","Space Research (passive)"}));
		dest.add(new DefaultFrequencyGuide(111800000000L,114250000000L,new String[]{"Fixed","Mobile","Radio Astronomy"}));
		dest.add(new DefaultFrequencyGuide(114250000000L,116000000000L,new String[]{"Earth Exploration Satellite (passive)","Radio Astronomy","Space Research (passive)"}));
		dest.add(new DefaultFrequencyGuide(116000000000L,119980000000L,new String[]{"Earth Exploration Satellite (passive)"}));
		dest.add(new DefaultFrequencyGuide(116000000000L,122250000000L,new String[]{"Earth Exploration Satellite (passive)"}));
		dest.add(new DefaultFrequencyGuide(119980000000L,122250000000L,new String[]{"Earth Exploration Satellite (passive)"}));
		dest.add(new DefaultFrequencyGuide(122250000000L,123000000000L,new String[]{"Fixed","Inter Satellite"}));
		dest.add(new DefaultFrequencyGuide(123000000000L,130000000000L,new String[]{"Fixed Satellite (space to Earth)","Mobile Satellite (space to Earth)","Radionavigation","Radionavigation Satellite"}));
		dest.add(new DefaultFrequencyGuide(134000000000L,136000000000L,new String[]{"Amateur","Amateur Satellite","Radio astronomy"}));
		dest.add(new DefaultFrequencyGuide(136000000000L,141000000000L,new String[]{"Radio Astronomy","Radiolocation","Amateur","Amateur satellite"}));
		dest.add(new DefaultFrequencyGuide(141000000000L,148500000000L,new String[]{"Fixed","Mobile","Radio Astronomy","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(148500000000L,151500000000L,new String[]{"Earth Exploration Satellite (passive)","Radio Astronomy","Space Research (passive)"}));
		dest.add(new DefaultFrequencyGuide(151500000000L,155500000000L,new String[]{"Fixed","Mobile","Radio Astronomy","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(155500000000L,158500000000L,new String[]{"Earth Exploration Satellite (passive)","Fixed","Mobile","Radio Astronomy"}));
		dest.add(new DefaultFrequencyGuide(158500000000L,164000000000L,new String[]{"Fixed","Fixed Satellite (space to Earth)","Mobile","Mobile Satellite (space to Earth)"}));
		dest.add(new DefaultFrequencyGuide(164000000000L,167000000000L,new String[]{"Earth Exploration Satellite (passive)","Radio Astronomy","Space Research (passive)"}));
		dest.add(new DefaultFrequencyGuide(167000000000L,174500000000L,new String[]{"Fixed","Fixed Satellite (space to Earth)","Inter Satellite"}));
		dest.add(new DefaultFrequencyGuide(174500000000L,174800000000L,new String[]{"Fixed","Inter Satellite"}));
		dest.add(new DefaultFrequencyGuide(174800000000L,182000000000L,new String[]{"Earth Exploration Satellite (passive)"}));
		dest.add(new DefaultFrequencyGuide(182000000000L,185000000000L,new String[]{"Earth Exploration Satellite (passive)","Radio Astronomy","Space Research (passive)"}));
		dest.add(new DefaultFrequencyGuide(185000000000L,190000000000L,new String[]{"Earth Exploration Satellite (passive)"}));
		dest.add(new DefaultFrequencyGuide(190000000000L,191800000000L,new String[]{"Earth Exploration Satellite (passive)","Space Research (passive)"}));
		dest.add(new DefaultFrequencyGuide(191800000000L,200000000000L,new String[]{"Fixed","Inter Satellite"}));
		dest.add(new DefaultFrequencyGuide(200000000000L,209000000000L,new String[]{"Earth Exploration Satellite (passive)","Radio Astronomy","Space Research (passive)"}));
		dest.add(new DefaultFrequencyGuide(209000000000L,217000000000L,new String[]{"Fixed","Fixed Satellite (earth to space)","Mobile","Radio Astronomy"}));
		dest.add(new DefaultFrequencyGuide(217000000000L,226000000000L,new String[]{"Fixed","Fixed Satellite (earth to space)","Mobile","Radio Astronomy"}));
		dest.add(new DefaultFrequencyGuide(226000000000L,231500000000L,new String[]{"Earth Exploration Satellite (passive)","Radio Astronomy","Space Research (passive)"}));
		dest.add(new DefaultFrequencyGuide(231500000000L,232000000000L,new String[]{"Fixed","Mobile","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(232000000000L,235000000000L,new String[]{"Fixed","Fixed Satellite (space to Earth)","Mobile","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(235000000000L,238000000000L,new String[]{"Earth Exploration Satellite (passive)","Fixed Satellite (space to Earth)","Space Research (passive)"}));
		dest.add(new DefaultFrequencyGuide(238000000000L,240000000000L,new String[]{"Fixed","Fixed Satellite (space to Earth)","Mobile","Radiolocation","Radionavigation","Radionavigation Satellite"}));
		dest.add(new DefaultFrequencyGuide(240000000000L,241000000000L,new String[]{"Fixed","Mobile","Radiolocation"}));
		dest.add(new DefaultFrequencyGuide(241000000000L,248000000000L,new String[]{"Radio Astronomy","Radiolocation","Amateur","Amateur satellite"}));
		dest.add(new DefaultFrequencyGuide(248000000000L,250000000000L,new String[]{"Amateur","Amateur Satellite","Radio astronomy"}));
		dest.add(new DefaultFrequencyGuide(250000000000L,252000000000L,new String[]{"Earth Exploration Satellite (passive)","Radio Astronomy","Space Research (passive)"}));
		dest.add(new DefaultFrequencyGuide(252000000000L,265000000000L,new String[]{"Fixed","Mobile","Mobile Satellite (earth to space)","Radio Astronomy","Radionavigation","Radionavigation Satellite"}));
		dest.add(new DefaultFrequencyGuide(265000000000L,275000000000L,new String[]{"Fixed","Fixed Satellite (earth to space)","Mobile","Radio Astronomy"}));
		}

	@Override
	public long startFreq()
		{
		return 30000000000L;
		}

	@Override
	public long endFreq()
		{
		return 275000000000L;
		}

	}
