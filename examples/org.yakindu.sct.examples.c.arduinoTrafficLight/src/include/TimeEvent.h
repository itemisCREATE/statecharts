/*
 * TimeEvent.h
 *
 *  Created on: 10.07.2013
 *      Author: scholtyssek
 */

#ifndef TIMEEVENT_H_
#define TIMEEVENT_H_

#include "sc_types.h"

class TimeEvent{
	public:
		TimeEvent();
		TimeEvent(sc_eventid eventId, sc_integer timeMs, sc_boolean periodic);

		sc_eventid getEventId() const {
			return eventId;
		}

		bool isPeriodic() const {
			return periodic;
		}

		sc_integer getTimeMs() const {
			return timeMs;
		}

		sc_integer getTimerOverflowCount() const {
			return timerOverflowCount;
		}

		void setTimerOverflowCount(sc_integer timerOverflowCount) {
			this->timerOverflowCount = timerOverflowCount;
		}

	private:
		sc_eventid eventId;
		sc_integer timeMs;
		sc_integer timerOverflowCount;
		sc_boolean periodic;
	};


#endif /* TIMEEVENT_H_ */
