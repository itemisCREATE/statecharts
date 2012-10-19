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

#ifndef TRAFFICLIGHTTIMER_H_
#define TRAFFICLIGHTTIMER_H_

#include <QObject>
#include <QMap>
#include "TimeEvent.h"
#include "src-gen/sc_types.h"
#include "src-gen/TrafficLightWaitingRequired.h"
#include "src-gen/TrafficLightWaiting.h"

class TrafficLightTimer: public QObject {

Q_OBJECT

public:
	TrafficLightTimer(TrafficLightWaiting *sc_handle);
	virtual ~TrafficLightTimer();

	void setTimer(const sc_eventid evid, const sc_integer time_ms,
			const sc_boolean periodic);

	void unsetTimer(const sc_eventid evid);

public slots:
	void raiseTimeEvent(sc_eventid evid);

private:
	QMap<sc_eventid, TimeEvent*> timerMap;
	TrafficLightWaiting *sc_handle;

};

#endif /* TRAFFICLIGHTTIMER_H_ */
