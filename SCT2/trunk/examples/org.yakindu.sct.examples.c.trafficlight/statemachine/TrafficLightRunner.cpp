/*
 * TrafficLightRunner.cpp
 *
 *  Created on: 18.10.2012
 *      Author: muehlbrandt
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
