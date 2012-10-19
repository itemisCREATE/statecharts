/*
 * TimeEvent.cpp
 *
 *  Created on: 19.10.2012
 *      Author: muehlbrandt
 */

#include "TimeEvent.h"

TimeEvent::TimeEvent(sc_eventid evid, sc_integer time_ms, sc_boolean periodic) :
		QObject() {
	timer = new QTimer();
	timer->setSingleShot(!periodic);
	this->evid = evid;
	connect(timer, SIGNAL(timeout()), this, SLOT(timeout()));
	timer->start(time_ms);
}

void TimeEvent::timeout() {
	emit timeout(evid);
}

TimeEvent::~TimeEvent() {
	disconnect(timer, SIGNAL(timeout()), this, SLOT(timeout()));
	timer->stop();
	delete timer;
}
