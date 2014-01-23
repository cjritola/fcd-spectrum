package com.ritolaaudio.fcdspectrum.guides;

import java.util.Collection;

public class SWFrequencyGuide implements FrequencyGuide
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
		dest.add(new DefaultFrequencyGuide(1800000L,1850000L,new String[]{"Amateur"}));
		dest.add(new DefaultFrequencyGuide(1850000L,2000000L,new String[]{"Amateur","Fixed","Mobile","except","aeronautical","mobile","Radiolocation","Radionavigation"}));
		dest.add(new DefaultFrequencyGuide(2000000L,2065000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(2065000L,2107000L,new String[]{"Maritime","Mobile"}));
		dest.add(new DefaultFrequencyGuide(2107000L,2170000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(2170000L,2173500L,new String[]{"Maritime","Mobile"}));
		dest.add(new DefaultFrequencyGuide(2173500L,2190500L,new String[]{"Mobile (distress and calling)"}));
		dest.add(new DefaultFrequencyGuide(2190500L,2194000L,new String[]{"Maritime","Mobile"}));
		dest.add(new DefaultFrequencyGuide(2194000L,2300000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(2300000L,2495000L,new String[]{"Fixed","Mobile","Broadcasting"}));
		dest.add(new DefaultFrequencyGuide(2495000L,2501000L,new String[]{"Standard","Frequency AND","Time","Signal (2500","khz)"}));
		dest.add(new DefaultFrequencyGuide(2501000L,2502000L,new String[]{"Standard","Frequency AND","Time","Signal","Space","research"}));
		dest.add(new DefaultFrequencyGuide(2502000L,2505000L,new String[]{"Standard","Frequency AND","Time","Signal"}));
		dest.add(new DefaultFrequencyGuide(2505000L,2850000L,new String[]{"Fixed","Mobile"}));
		dest.add(new DefaultFrequencyGuide(2850000L,3025000L,new String[]{"Aeronautical","Mobile (R)"}));
		dest.add(new DefaultFrequencyGuide(3025000L,3155000L,new String[]{"Aeronautical","Mobile (OR)"}));
		dest.add(new DefaultFrequencyGuide(3155000L,3200000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile (R)"}));
		dest.add(new DefaultFrequencyGuide(3200000L,3230000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile (R)","Broadcasting"}));
		dest.add(new DefaultFrequencyGuide(3230000L,3400000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile","Broadcasting"}));
		dest.add(new DefaultFrequencyGuide(3400000L,3500000L,new String[]{"Aeronautical","Mobile (R)"}));
		dest.add(new DefaultFrequencyGuide(3500000L,3750000L,new String[]{"Amateur"}));
		dest.add(new DefaultFrequencyGuide(3750000L,4000000L,new String[]{"Amateur","Fixed","Mobile","except","aeronautical","mobile (R)"}));
		dest.add(new DefaultFrequencyGuide(4000000L,4062999L,new String[]{"Fixed","Maritime","Mobile"}));
		dest.add(new DefaultFrequencyGuide(4062999L,4438000L,new String[]{"Maritime","Mobile"}));
		dest.add(new DefaultFrequencyGuide(4438000L,4650000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile (R)"}));
		dest.add(new DefaultFrequencyGuide(4650000L,4700000L,new String[]{"Aeronautical","Mobile (R)"}));
		dest.add(new DefaultFrequencyGuide(4700000L,4750000L,new String[]{"Aeronautical","Mobile (OR)"}));
		dest.add(new DefaultFrequencyGuide(4750000L,4850000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile (R)","Broadcasting"}));
		dest.add(new DefaultFrequencyGuide(4850000L,4995000L,new String[]{"Fixed","Land MOBILE","Broadcasting"}));
		dest.add(new DefaultFrequencyGuide(5003000L,5005000L,new String[]{"Standard","Frequency AND","Time","Signal","Space","research"}));
		dest.add(new DefaultFrequencyGuide(5005000L,5060000L,new String[]{"Fixed","Broadcasting"}));
		dest.add(new DefaultFrequencyGuide(5060000L,5250000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile"}));
		dest.add(new DefaultFrequencyGuide(5250000L,5450000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile"}));
		dest.add(new DefaultFrequencyGuide(5450000L,5480000L,new String[]{"Aeronautical","Mobile (R)"}));
		dest.add(new DefaultFrequencyGuide(5480000L,5680000L,new String[]{"Aeronautical","Mobile (R)"}));
		dest.add(new DefaultFrequencyGuide(5680000L,5730000L,new String[]{"Aeronautical","Mobile (OR)"}));
		dest.add(new DefaultFrequencyGuide(5730000L,5900000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile (R)"}));
		dest.add(new DefaultFrequencyGuide(5900000L,5950000L,new String[]{"Broadcasting"}));
		dest.add(new DefaultFrequencyGuide(5950000L,6200000L,new String[]{"Broadcasting"}));
		dest.add(new DefaultFrequencyGuide(6200000L,6525000L,new String[]{"Maritime","Mobile"}));
		dest.add(new DefaultFrequencyGuide(6525000L,6685000L,new String[]{"Aeronautical","Mobile (R)"}));
		dest.add(new DefaultFrequencyGuide(6685000L,6765000L,new String[]{"Aeronautical","Mobile (OR)"}));
		dest.add(new DefaultFrequencyGuide(6765000L,7000000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile (R)"}));
		dest.add(new DefaultFrequencyGuide(7000000L,7100000L,new String[]{"Amateur","Amateur-Satellite"}));
		dest.add(new DefaultFrequencyGuide(7100000L,7200000L,new String[]{"Amateur"}));
		dest.add(new DefaultFrequencyGuide(7200000L,7300000L,new String[]{"Broadcasting"}));
		dest.add(new DefaultFrequencyGuide(7300000L,7400000L,new String[]{"Broadcasting"}));
		dest.add(new DefaultFrequencyGuide(7400000L,7450000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile (R)"}));
		dest.add(new DefaultFrequencyGuide(7450000L,8100000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile (R)"}));
		dest.add(new DefaultFrequencyGuide(8100000L,8195000L,new String[]{"Fixed","Maritime","Mobile"}));
		dest.add(new DefaultFrequencyGuide(8195000L,8815000L,new String[]{"Maritime","Mobile"}));
		dest.add(new DefaultFrequencyGuide(8815000L,8965000L,new String[]{"Aeronautical","Mobile (R)"}));
		dest.add(new DefaultFrequencyGuide(8965000L,9040000L,new String[]{"Aeronautical","Mobile (OR)"}));
		dest.add(new DefaultFrequencyGuide(9040000L,9400000L,new String[]{"Fixed"}));
		dest.add(new DefaultFrequencyGuide(9400000L,9500000L,new String[]{"Broadcasting"}));
		dest.add(new DefaultFrequencyGuide(9500000L,9900000L,new String[]{"Broadcasting"}));
		dest.add(new DefaultFrequencyGuide(9900000L,9995000L,new String[]{"Fixed"}));
		dest.add(new DefaultFrequencyGuide(10003000L,10005000L,new String[]{"Standard","Frequency AND","Time","Signal","Space","research"}));
		dest.add(new DefaultFrequencyGuide(10005000L,10100000L,new String[]{"Aeronautical","Mobile (R)"}));
		dest.add(new DefaultFrequencyGuide(10100000L,10150000L,new String[]{"Fixed","Amateur"}));
		dest.add(new DefaultFrequencyGuide(10150000L,11175000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile (R)"}));
		dest.add(new DefaultFrequencyGuide(11175000L,11275000L,new String[]{"Aeronautical","Mobile (OR)"}));
		dest.add(new DefaultFrequencyGuide(11275000L,11400000L,new String[]{"Aeronautical","Mobile (R)"}));
		dest.add(new DefaultFrequencyGuide(11400000L,11600000L,new String[]{"Fixed"}));
		dest.add(new DefaultFrequencyGuide(11600000L,11650000L,new String[]{"Broadcasting"}));
		dest.add(new DefaultFrequencyGuide(11650000L,12050000L,new String[]{"Broadcasting"}));
		dest.add(new DefaultFrequencyGuide(12050000L,12100000L,new String[]{"Broadcasting"}));
		dest.add(new DefaultFrequencyGuide(12100000L,12230000L,new String[]{"Fixed"}));
		dest.add(new DefaultFrequencyGuide(12230000L,13200000L,new String[]{"Maritime","Mobile"}));
		dest.add(new DefaultFrequencyGuide(13200000L,13260000L,new String[]{"Aeronautical","Mobile (OR)"}));
		dest.add(new DefaultFrequencyGuide(13260000L,13360000L,new String[]{"Aeronautical","Mobile (R)","Us283","Us340"}));
		dest.add(new DefaultFrequencyGuide(13360000L,13410000L,new String[]{"Radio","Astronomy","Us342","G115"}));
		dest.add(new DefaultFrequencyGuide(13410000L,13570000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile (R)","Us340"}));
		dest.add(new DefaultFrequencyGuide(13570000L,13870000L,new String[]{"Broadcasting"}));
		dest.add(new DefaultFrequencyGuide(13870000L,14000000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile (R)","Us340"}));
		dest.add(new DefaultFrequencyGuide(14350000L,14990000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile (R)","Us340"}));
		dest.add(new DefaultFrequencyGuide(15010000L,15100000L,new String[]{"Aeronautical","Mobile (OR)"}));
		dest.add(new DefaultFrequencyGuide(15100000L,15600000L,new String[]{"Broadcasting"}));
		dest.add(new DefaultFrequencyGuide(15600000L,15800000L,new String[]{"Broadcasting"}));
		dest.add(new DefaultFrequencyGuide(15800000L,16360000L,new String[]{"Fixed"}));
		dest.add(new DefaultFrequencyGuide(16360000L,17410000L,new String[]{"Maritime","Mobile"}));
		dest.add(new DefaultFrequencyGuide(17410000L,17480000L,new String[]{"Fixed"}));
		dest.add(new DefaultFrequencyGuide(17480000L,17550000L,new String[]{"Broadcasting"}));
		dest.add(new DefaultFrequencyGuide(17550000L,17900000L,new String[]{"Broadcasting"}));
		dest.add(new DefaultFrequencyGuide(17900000L,17970000L,new String[]{"Aeronautical","Mobile (R)"}));
		dest.add(new DefaultFrequencyGuide(17970000L,18030000L,new String[]{"Aeronautical","Mobile (OR)"}));
		dest.add(new DefaultFrequencyGuide(18030000L,18052000L,new String[]{"Fixed"}));
		dest.add(new DefaultFrequencyGuide(18052000L,18068000L,new String[]{"Fixed","Space","research"}));
		dest.add(new DefaultFrequencyGuide(18068000L,18168000L,new String[]{"Amateur","Amateur-Satellite"}));
		dest.add(new DefaultFrequencyGuide(18168000L,18780000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile"}));
		dest.add(new DefaultFrequencyGuide(18780000L,18900000L,new String[]{"Maritime","Mobile"}));
		dest.add(new DefaultFrequencyGuide(18900000L,19020000L,new String[]{"Broadcasting"}));
		dest.add(new DefaultFrequencyGuide(19020000L,19680000L,new String[]{"Fixed"}));
		dest.add(new DefaultFrequencyGuide(19680000L,19800000L,new String[]{"Maritime","Mobile"}));
		dest.add(new DefaultFrequencyGuide(19800000L,19990000L,new String[]{"Fixed"}));
		dest.add(new DefaultFrequencyGuide(19990000L,19995000L,new String[]{"Standard","Frequency AND","Time","Signal","Space","research"}));
		dest.add(new DefaultFrequencyGuide(20010000L,21000000L,new String[]{"Fixed","Mobile","Us340"}));
		dest.add(new DefaultFrequencyGuide(21000000L,21450000L,new String[]{"Us340"}));
		dest.add(new DefaultFrequencyGuide(21450000L,21850000L,new String[]{"Broadcasting","Us340"}));
		dest.add(new DefaultFrequencyGuide(21850000L,21924000L,new String[]{"Fixed"}));
		dest.add(new DefaultFrequencyGuide(21924000L,22000000L,new String[]{"Aeronautical","Mobile (R)","Us340"}));
		dest.add(new DefaultFrequencyGuide(22000000L,22855000L,new String[]{"Maritime","Mobile","Us82","Us296","Us340"}));
		dest.add(new DefaultFrequencyGuide(22855000L,23000000L,new String[]{"Fixed"}));
		dest.add(new DefaultFrequencyGuide(23000000L,23200000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile (R)"}));
		dest.add(new DefaultFrequencyGuide(23200000L,23350000L,new String[]{"Fixed","Aeronautical","Mobile (OR)"}));
		dest.add(new DefaultFrequencyGuide(23350000L,24000000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile"}));
		dest.add(new DefaultFrequencyGuide(24000000L,24890000L,new String[]{"Fixed","Land MOBILE"}));
		dest.add(new DefaultFrequencyGuide(24890000L,24990000L,new String[]{"Amateur","Amateur-Satellite"}));
		dest.add(new DefaultFrequencyGuide(25005000L,25010000L,new String[]{"Standard","Frequency AND","Time","Signal","Space","research"}));
		dest.add(new DefaultFrequencyGuide(25010000L,25070000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile"}));
		dest.add(new DefaultFrequencyGuide(25070000L,25210000L,new String[]{"Maritime","Mobile"}));
		dest.add(new DefaultFrequencyGuide(25210000L,25550000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile"}));
		dest.add(new DefaultFrequencyGuide(25550000L,25670000L,new String[]{"Radio","Astronomy","Us74","Us342"}));
		dest.add(new DefaultFrequencyGuide(25670000L,26100000L,new String[]{"Broadcasting","Us25","Us340"}));
		dest.add(new DefaultFrequencyGuide(26100000L,26175000L,new String[]{"Maritime","Mobile","Us25","Us340"}));
		dest.add(new DefaultFrequencyGuide(26175000L,26480000L,new String[]{"Us340"}));
		dest.add(new DefaultFrequencyGuide(26480000L,26950000L,new String[]{"Fixed","Mobile","except","aeronautical","mobile","Us340"}));
		dest.add(new DefaultFrequencyGuide(27410000L,27540000L,new String[]{"Us340"}));
		dest.add(new DefaultFrequencyGuide(27540000L,28000000L,new String[]{"Fixed","Mobile","Us298","Us340"}));
		dest.add(new DefaultFrequencyGuide(28000000L,29700000L,new String[]{"Us340"}));
		dest.add(new DefaultFrequencyGuide(29700000L,30005000L,new String[]{"Fixed","Mobile"}));
		}

	@Override
	public long startFreq()
		{return 1800000L;
		}

	@Override
	public long endFreq()
		{
		return 30005000L;
		}

	}
