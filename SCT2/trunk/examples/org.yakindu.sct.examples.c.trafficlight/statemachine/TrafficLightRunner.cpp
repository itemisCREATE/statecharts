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

#include "TrafficLightRunner.h"

TrafficLightRunner::TrafficLightRunner(TrafficLightWaiting *handle, int time_ms) :
		QObject() {
	this->handle = handle;
	timer = new QTimer(this);
	connect(timer, SIGNAL(timeout()), this, SLOT(runCycle()));
	timer->start(time_ms);
}

void TrafficLightRunner::runCycle() {
	trafficLightWaiting_runCycle(handle);
	emit cycleDone(handle);
}

void TrafficLightRunner::raisePedestrianRequest() {
	trafficLightWaitingIface_raise_pedestrianRequest(handle);
}

void TrafficLightRunner::raiseOnOff() {
	trafficLightWaitingIface_raise_onOff(handle);
}

TrafficLightRunner::~TrafficLightRunner() {
	timer->stop();
	delete timer;
}
