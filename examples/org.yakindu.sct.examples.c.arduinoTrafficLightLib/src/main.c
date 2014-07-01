/*
 * TrafficLight example for YAKINDU SCT
 *
 * based on official example: org.yakindu.sct.examples.c.arduinoTrafficLight
 *
 * Changes:
 * - use the Arduino core library for pin and time handling
 * - enable debugging with printf() (see uart.c; it uses the Arduino HardwareSerial)
 * - new implementation for timers based on Arduinos millis() function -> no extra timer is used
 * - call runCylce in every iteration of the main loop
 *
 * Author:
 * Axel Utech <axel.utech@gmail.com>
 *
 * Notes:
 * Arduino Core library is from https://github.com/allgood38/Arduino-Blink-Eclipse-Project
 * notes about the original example:
 * 	http://scholtyssek.blogspot.de/2013/10/yakindu-statechart-tools-arduino.html
 */

#include <stdio.h>
#include <wiring.h>

#include "statetimer.h"
#include "uart.h"

#include "sc_types.h"
#include "TrafficlightRequired.h"
#include "Trafficlight.h"

const uint8_t ledPinTrafficRed = 13;      	// the number of the red LED pin
const uint8_t ledPinTrafficYellow = 12;		// the number of the yellow LED pin
const uint8_t ledPinTrafficGreen = 11;		// the number of the green LED pin

const uint8_t ledPinPedestrianRed = 9;		// the number of the red LED pin
const uint8_t ledPinPedestrianGreen = 8;	// the number of the green LED pin
const uint8_t ledPinPedestrianWaitLight = 10;

const uint8_t btnOnOff = 3;
/*
 * Interrupt ID for the pin
 * see http://arduino.cc/en/Reference/AttachInterrupt
 */
const uint8_t btnOnOffIsrID = 1;

const uint8_t btnPedestrian = 2;
const uint8_t btnPedestrianIsrId = 0;

volatile uint8_t raiseOnOffEventFlag = 0;
volatile uint8_t raisePedestrianRequestFlag = 0;

Trafficlight handle;

// helper to call setTimer()
void trafficlight_setTimer(const sc_eventid evid, sc_integer time_ms,
		const sc_boolean periodic) {
	printf("set timer id: %p timeout: %i periodic: %i\n", evid, time_ms, periodic);

	setTimer(&handle, evid, time_ms, periodic,
			(raiseEventCallback_t)trafficlight_raiseTimeEvent);
}

void trafficlight_unsetTimer(const sc_eventid evid) {
	printf("unset timer id: %p\n", evid);
	unsetTimer(evid);
}

static void setTrafficLights() {
	/*
	 * pedestrian waiting light
	 */
	digitalWrite(ledPinPedestrianWaitLight,
			trafficlightIfacePedestrianLight_get_wait(&handle));

	/**
	 * Pedestrian light
	 */
	digitalWrite(ledPinPedestrianGreen,
			trafficlightIfacePedestrianLight_get_green(&handle));
	digitalWrite(ledPinPedestrianRed,
			trafficlightIfacePedestrianLight_get_red(&handle));

	/*
	 *  traffic light
	 */
	digitalWrite(ledPinTrafficRed,
			trafficlightIfaceTrafficLight_get_red(&handle));
	digitalWrite(ledPinTrafficYellow,
			trafficlightIfaceTrafficLight_get_yellow(&handle));
	digitalWrite(ledPinTrafficGreen,
			trafficlightIfaceTrafficLight_get_green(&handle));
}

static void btnOnOffISR(void) {
	raiseOnOffEventFlag = 1;
}

static void btnPedestrianISR(void) {
	raisePedestrianRequestFlag = 1;
}

int main(void) {
	init();

	setup();

	for (;;)
		loop();

	return 0;
}


void setup() {
	uartInit(9600);
	printf("Setup begin!\n");

	pinMode(ledPinPedestrianWaitLight, OUTPUT);
	pinMode(ledPinPedestrianGreen, OUTPUT);
	pinMode(ledPinPedestrianRed, OUTPUT);
	pinMode(ledPinTrafficRed, OUTPUT);
	pinMode(ledPinTrafficYellow, OUTPUT);
	pinMode(ledPinTrafficGreen, OUTPUT);

	pinMode(btnOnOff, INPUT);
	digitalWrite(btnOnOff, HIGH);
	attachInterrupt(btnOnOffIsrID, btnOnOffISR, FALLING);

	pinMode(btnPedestrian, INPUT);
	digitalWrite(btnPedestrian, HIGH);
	attachInterrupt(btnPedestrianIsrId, btnPedestrianISR, FALLING);

	initTimers();

	trafficlight_init(&handle);
	trafficlight_enter(&handle);

	printf("Setup ready!\n");
}

static void checkTimersWrapper(void){
	static unsigned long lastCallTime = 0;
	unsigned long now = millis();

	int deltaT_ms = now - lastCallTime;
	lastCallTime = now;

	if(deltaT_ms)
		checkTimers(deltaT_ms);
}

void loop() {
	if(raiseOnOffEventFlag){
		raiseOnOffEventFlag = 0;
		printf("Raise onOff\n");
		trafficlightIface_raise_onOff(&handle);
	}
	if(raisePedestrianRequestFlag){
		raisePedestrianRequestFlag = 0;
		printf("raise pedestrian request\n");
		trafficlightIface_raise_pedestrianRequest(&handle);
	}

	checkTimersWrapper();

	trafficlight_runCycle(&handle);
	setTrafficLights();
}

