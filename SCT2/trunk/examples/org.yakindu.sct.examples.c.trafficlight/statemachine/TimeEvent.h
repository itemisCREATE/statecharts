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

#ifndef TIMEEVENT_H_
#define TIMEEVENT_H_

#include <QObject>
#include <QTimer>
#include "src-gen/sc_types.h"

class TimeEvent: public QObject {

Q_OBJECT

public:
	TimeEvent(sc_eventid evid, sc_integer time_ms, sc_boolean periodic);
	virtual ~TimeEvent();

public slots:
	void timeout();

signals:
	void timeout(const sc_eventid evid);

private:
	sc_eventid evid;
	QTimer *timer;
};

#endif /* TIMEEVENT_H_ */
