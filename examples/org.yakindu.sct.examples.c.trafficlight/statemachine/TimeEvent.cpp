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
