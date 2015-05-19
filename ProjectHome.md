Unofficial spectrum analyzer for `FUNCube` Dongle Pro+ written in java, executable from a single .jar file in Windows or Linux.

Performs tuner sweeps in a specified range, writing the data to a .CSV file (units are in dBm at antenna input). Includes a spectrum viewer. Sweeps can be executed via CLI or GUI.

[Download Runnable JAR here](https://docs.google.com/file/d/0BxvD4PHJkNOnLWZRSks0UEVvWmM/edit?usp=sharing)

![http://fcd-spectrum.googlecode.com/git-history/master/fcd-spectrum-012414.png](http://fcd-spectrum.googlecode.com/git-history/master/fcd-spectrum-012414.png)

This is a sweeping analyzer, not an RTA: the measurements are not shown in real time. It takes about a minute for it to scan the 88-108 range and about 2 hours to scan the 150k-2G range.

## Known Issues ##
  * After use in Linux, the FCDPP device may not properly release. This can be spotted if using another program to access the dongle and the FCDPP fails to be detected. Workaround is to unplug/replug the device and wait 5 seconds before retrying.
  * dBm values are doubtfully laboratory-accurate.
  * [Will not work](http://code.google.com/p/fcd-spectrum/issues/detail?id=4) in OS 10.8 and probably not 10.7.x either due to [javahidapi issues](http://code.google.com/p/javahidapi/issues/detail?id=44).

## Help Wanted ##
Feedback from anyone with access to a laboratory-grade spectrum analyzer who can perform a rough verification on the accuracy of the analyzer would be appreciated.

## Credits, Licenses, and Libraries ##
Thanks to Howard at the [FUNCube website](http://www.funcubedongle.com/) for initial measurements used to write this software.

Main program:(c) 2013 Chuck Ritola GPL3

[jTransforms](http://sites.google.com/site/piotrwendykier/software/jtransforms):(c) Piotr Wendykier GPL2, LGPL2, MPL

[jFCDPP](https://code.google.com/p/jfcdpp/):(c) 2013 Chuck Ritola LGPL2.1

[javaHIDAPI](http://code.google.com/p/javahidapi):(c) Alan Ott, Ludovic Rousseau BSD3clause, GPL3, HIDAPI

[usb4java](http://www.usb4java.org):(c) Klaus Reimer, Luca Longinotti LGPL3