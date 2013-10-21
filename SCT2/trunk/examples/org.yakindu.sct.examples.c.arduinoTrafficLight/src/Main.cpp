/*
 * Main.cpp
 *
 *  Created on: 20.06.2013
 *      Author: scholtyssek
 */

#include "TrafficlightRequired.h"
#include "Trafficlight.h"
#include "include/Timer.h"
#include "include/CycleRunner.h"
#include <avr/io.h>
#include <avr/interrupt.h>
#include <util/delay.h>
#include <stdio.h>
//#include "Arduino.h"

const uint8_t ledPinTrafficRed = DDB5;      	// the number of the red LED pin
const uint8_t ledPinTrafficYellow = DDB4;		// the number of the yellow LED pin
const uint8_t ledPinTrafficGreen = DDB3;		// the number of the green LED pin

const uint8_t ledPinPedestrianRed = DDB1;		// the number of the red LED pin
const uint8_t ledPinPedestrianGreen = DDB0;		// the number of the green LED pin
const uint8_t ledPinPedestrianWaitLight = DDB2;
Timer *timer;
CycleRunner *cycleRunner;
volatile uint8_t raiseOnOffEventFlag = 0;
volatile uint8_t raisePedestrianRequestFlag = 0;

uint8_t counter = 0;
uint8_t runCycleFlag = 0;
uint8_t timerRaiseEventFlag = 0;
Trafficlight handle;

void trafficlight_setTimer(const sc_eventid evid, sc_integer time_ms,
		const sc_boolean periodic) {
	timer->trafficlight_setTimer(evid, time_ms, periodic);
}

void trafficlight_unsetTimer(const sc_eventid evid) {
	timer->trafficlight_unsetTimer(evid);
}

void setLight(uint8_t port, uint8_t pin, sc_boolean value) {
	if (value) {
		PORTB |= (1 << pin);
	} else {
		PORTB &= ~(1 << pin);
	}
}

void setTrafficLights() {
	/*
	 * pedestrian waiting light
	 */
	setLight(PORTB, ledPinPedestrianWaitLight,
			trafficlightIfacePedestrianLight_get_wait(&handle));

	/**
	 * Pedestrian light
	 */
	setLight(PORTB, ledPinPedestrianGreen,
			trafficlightIfacePedestrianLight_get_green(&handle));
	setLight(PORTB, ledPinPedestrianRed,
			trafficlightIfacePedestrianLight_get_red(&handle));

	/*
	 *  traffic light
	 */
	setLight(PORTB, ledPinTrafficRed,
			trafficlightIfaceTrafficLight_get_red(&handle));
	setLight(PORTB, ledPinTrafficYellow,
			trafficlightIfaceTrafficLight_get_yellow(&handle));
	setLight(PORTB, ledPinTrafficGreen,
			trafficlightIfaceTrafficLight_get_green(&handle));
}

void initializePorts() {
	/* set output for pin 13, 12, 11 */
	DDRB |= (1 << ledPinTrafficRed) | (1 << ledPinTrafficYellow)
			| (1 << ledPinTrafficGreen);
	DDRB |= (1 << ledPinPedestrianRed) | (1 << ledPinPedestrianGreen);
	DDRB |= (1 << ledPinPedestrianWaitLight);
	PORTB = 0x00;
}

void initializeInterrupts() {
	// onOff request
	EICRA |= (1 << ISC01);
	EIMSK |= (1 << INT0);
	DDRD &= ~(1 << DDD2);
	PORTD |= (1 << DDD2);

	// pedestrian request
	EICRA |= (1 << ISC11);
	EIMSK |= (1 << INT1);
	DDRD &= ~(1 << DDD3);
	PORTD |= (1 << DDD3);
	sei();
}

void initialize() {
	initializePorts();
	initializeInterrupts();
}

int main(void) {
	initialize();

	timer = new Timer(&handle);
	trafficlight_init(&handle);
	trafficlight_enter(&handle);
	cycleRunner = new CycleRunner(&handle);
	cycleRunner->start();	// the cyclerunner checks for state transitions

	while (1) {
		setTrafficLights();

		if (runCycleFlag) {
			runCycleFlag = 0;
			cycleRunner->runCycle();
		}

		if (timerRaiseEventFlag) {
			timerRaiseEventFlag = 0;
			timer->raiseTimeEvent();
		}

		if (raiseOnOffEventFlag) {
			raiseOnOffEventFlag = 0;
			trafficlightIface_raise_onOff(&handle);
		}

		if (raisePedestrianRequestFlag) {
			raisePedestrianRequestFlag = 0;
			trafficlightIface_raise_pedestrianRequest(&handle);
		}
	}
	return 0;
}

/*
 * the cycleRunner is triggered by this timerinterrupt
 */ISR(TIMER0_OVF_vect) {
	runCycleFlag = 1;
}

// Timer ISR that triggers checking for expired time events
ISR(TIMER1_OVF_vect) {
//	TCNT1 = 59286;	// startvalue for 100ms
	TCNT1 = 64911;	// startvalue for 10ms

	if ((counter++) >= timer->getTimerOverflowCount()) {
		counter = 0;
		timerRaiseEventFlag = 1;
	}
}

/**
 * OnOff switch for the trafficLight
 */
ISR(INT0_vect) {
	raiseOnOffEventFlag = 1;
}

/**
 * pedestrian request triggers INT1 interrupt
 */
ISR(INT1_vect) {
	raisePedestrianRequestFlag = 1;
}
