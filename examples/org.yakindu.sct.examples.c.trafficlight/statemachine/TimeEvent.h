/*
 * TimeEvent.h
 *
 *  Created on: 19.10.2012
 *      Author: muehlbrandt
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
