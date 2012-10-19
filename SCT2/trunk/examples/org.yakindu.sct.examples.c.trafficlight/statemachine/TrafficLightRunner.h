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

#ifndef TRAFFICLIGHTRUNNER_H_
#define TRAFFICLIGHTRUNNER_H_
#include <QObject>
#include <QTimer>
#include <src-gen/TrafficLightWaiting.h>

class TrafficLightRunner: public QObject {

Q_OBJECT

public:
	TrafficLightRunner(TrafficLightWaiting *handle, int time_ms);
	virtual ~TrafficLightRunner();

public slots:
	void runCycle();
	void raisePedestrianRequest();
	void raiseOnOff();

signals:
	void cycleDone(TrafficLightWaiting *handle);

private:
	QTimer *timer;
	TrafficLightWaiting *handle;
};

#endif /* TRAFFICLIGHTRUNNER_H_ */
