/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	m.muehlbrandt - initial API and implementation
 *
 */

#include "TrafficLightTimer.h"

TrafficLightTimer::TrafficLightTimer(TrafficLightWaiting *sc_handle) :
		QObject() {
	this->sc_handle = sc_handle;
}

void TrafficLightTimer::setTimer(const sc_eventid evid,
		const sc_integer time_ms, const sc_boolean periodic) {

	TimeEvent *timeEvent = new TimeEvent(evid, time_ms, periodic);
	timerMap.insert(evid, timeEvent);
	connect(timeEvent, SIGNAL(timeout(sc_eventid)), this,
			SLOT(raiseTimeEvent(sc_eventid)));
}

void TrafficLightTimer::unsetTimer(const sc_eventid evid) {
	if (timerMap.contains(evid)) {
		TimeEvent *timeEvent = timerMap.value(evid);
		disconnect(timeEvent, SIGNAL(timeout(sc_eventid)), this,
					SLOT(raiseTimeEvent(sc_eventid)));
		delete timeEvent;
		timerMap.remove(evid);
	}
}

void TrafficLightTimer::raiseTimeEvent(sc_eventid evid) {
	trafficLightWaiting_raiseTimeEvent(sc_handle, evid);
}

TrafficLightTimer::~TrafficLightTimer() {
}
