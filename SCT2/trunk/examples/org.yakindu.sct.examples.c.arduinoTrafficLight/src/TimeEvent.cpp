/*
 * TimeEvent.cpp
 *
 *  Created on: 10.07.2013
 *      Author: scholtyssek
 */
#include "include/TimeEvent.h"

	TimeEvent::TimeEvent(){

	}
	TimeEvent::TimeEvent(sc_eventid eventId, sc_integer timeMs, sc_boolean periodic){
		this->eventId = eventId;
		this->timeMs = timeMs;
		this->periodic = periodic;
		this->timerOverflowCount = 0;
	}


