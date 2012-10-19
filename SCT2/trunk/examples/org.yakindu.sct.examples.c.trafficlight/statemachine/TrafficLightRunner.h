/*
 * RuntimeService.h
 *
 *  Created on: 18.10.2012
 *      Author: muehlbrandt
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
