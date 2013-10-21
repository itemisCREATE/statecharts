/*
 * T.h
 *
 *  Created on: 24.06.2013
 *      Author: scholtyssek
 */

#ifndef T_H_
#define T_H_

#include "sc_types.h"
#include "TimeEvent.h"
#include "../src-gen/Trafficlight.h"
#include "avr/interrupt.h"
#include <stdlib.h>
#include <stdio.h>


class Timer{
	public:
		Timer();
		Timer(Trafficlight *sc_handle);
		void trafficlight_setTimer(const sc_eventid evid,
				const sc_integer time_ms, const sc_boolean periodic);
		void trafficlight_unsetTimer(const sc_eventid evid);
		void initTimer();
		void raiseTimeEvent();
		sc_integer getTimerOverflowCount();
		static const sc_integer TIMER_COUNT = 5;
	private:
		~Timer();
		sc_eventid eventId;
		sc_eventid lastEventId;
		sc_integer timeMs;
		sc_boolean periodic;
		Trafficlight *sc_handle;
		volatile uint16_t overflowCount;
		TimeEvent* events[TIMER_COUNT]; // maximum 5 parallel TimeEvents
	};


#endif /* T_H_ */
