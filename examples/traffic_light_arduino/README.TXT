This example is based on the normal traffic_light example, which is made for Java.
It shows how the exact same statechart can be used for a Java application and an arduino sketch written in C.
PLEASE NOTE: You need the Eclipse Arduino plugin.

To install the tool in Yakindu Statechart Tools, go to Help->Install New Software, copy
http://www.baeyens.it/eclipse/V3/
and give it a meaningful name. After that, you can select the plugin and install it. After one restart of YSCT, the plugin is ready to use.

Also, of course, you need an Arduino. The pins where you need to connect the LEDs and buttons can be seen or changed in the software.

Parts list:
- Arduino 1x
- red LED 2x
- green LED 2x
- yellow LED 1x
- white LED 1x
- resistors for the LEDs, 200 to 300 Ohm
- Button 2x
- pull-up resistors for the buttons 2x
- cables and a breadboard

Also, you need to set the correct port for the Arduino in Project->Properties.
