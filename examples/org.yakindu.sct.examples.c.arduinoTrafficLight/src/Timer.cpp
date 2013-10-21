/*
 * Timer.c
 *
 *  Created on: 20.06.2013
 *      Author: scholtyssek
 */

#include "include/Timer.h"
#include <stdio.h>

Timer::Timer(Trafficlight *sc_handle) {
	this->lastEventId = NULL;
	this->timeMs = 0;
	this->eventId = NULL;
	this->periodic = bool_false;
	this->sc_handle = sc_handle;
	for(int i=0;i<TIMER_COUNT;i++){
		events[i] = NULL;
	}
	initTimer();
}

void Timer::trafficlight_setTimer(const sc_eventid evid,
		const sc_integer time_ms, const sc_boolean periodic) {
	this->eventId = evid;
	this->timeMs = time_ms;
	this->periodic = periodic;


	TimeEvent *event = new TimeEvent(evid, time_ms, periodic);

	for(int i=0;i<TIMER_COUNT;i++){
		if(events[i] == NULL){
			events[i] = event;
			break;
		}
	}
}

/**
 * Timer1 will be used for the events
 */
void Timer::initTimer() {
	//	TCCR1B = (1 << CS12) | (1 << CS10); // Prescaler 1024
	//  TCNT1 = 2^16 - ((timeMs / 1000) * 16 * 10000000 /1024)
	//	TCNT1 = 65536 - ((timeMs / 1000) * F_CPU / 1024 );


	// 49911 corresponds to 1s
	//TCNT1 = 49911;	// Startvalue for the 16-Bit Timer with CTC.
					//	comparevalue = 2^16 - (triggerTime * quartzfrequency / Prescaler)
					//	comparevalue = 2^16 - (1s * 16*10^6 Hz / 1024) ) = 49911

	TCCR1B |= (1<<CS12); // Prescaler 256
//	TCNT1 = 59286; 	// 	comparevalue = 2^16 - (0.1s * 16*10^6 Hz / 256) ) = 59286
//					// corresponds 99,9999ms, but here is an error because the calculated counter startvalue has to be integer
//	this->overflowCount = (timeMs / 100);
	TCNT1 = 64911; // comparevalue for 10ms
	this->overflowCount = (timeMs / 10);

	TIMSK1 |= (1 << TOIE1);	// overflow interrupt
}

/**
 * Returns the counted overflows for this counter. An overflow is released every 100ms.
 */
sc_integer Timer::getTimerOverflowCount(){
	return this->overflowCount;
}

void Timer::trafficlight_unsetTimer(const sc_eventid evid) {
//	TCCR1B = 0; // turn off the timer
	for(int i=0;i<TIMER_COUNT;i++){
		if(events[i]->getEventId() == evid){
			delete events[i];
			events[i] = NULL;
			break;
		}
	}
}


void Timer::raiseTimeEvent() {
	for(int i=0;i<TIMER_COUNT;i++){
		if(events[i] == NULL)
			continue;

		if((events[i]->getTimeMs()/10) <= events[i]->getTimerOverflowCount()){
			trafficlight_raiseTimeEvent(sc_handle, events[i]->getEventId());
			events[i]->setTimerOverflowCount(0);
		}

		events[i]->setTimerOverflowCount(events[i]->getTimerOverflowCount() + 1);
	}
}

Timer::~Timer() {

}
