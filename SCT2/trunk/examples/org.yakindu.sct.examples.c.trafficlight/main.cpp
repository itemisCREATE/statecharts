#include "org_yakindu_sct_examples_c_trafficlight.h"

#include <QtGui>
#include <QApplication>
#include "src-gen/sc_types.h"
#include "src-gen/TrafficLightWaiting.h"
#include "statemachine/TrafficLightTimer.h"
#include "statemachine/TrafficLightRunner.h"

TrafficLightTimer *timer;

int main(int argc, char *argv[]) {
	TrafficLightWaiting handle;
	trafficLightWaiting_init(&handle);
	timer = new TrafficLightTimer(&handle);
	trafficLightWaiting_enter(&handle);
	QApplication a(argc, argv);
	TrafficLightRunner *runner = new TrafficLightRunner(&handle, 100);
	org_yakindu_sct_examples_c_trafficlight w(0, runner);
	w.show();
	int ret = a.exec();
	return ret;
}

void trafficLightWaiting_setTimer(const sc_eventid evid,
		const sc_integer time_ms, const sc_boolean periodic) {
	timer->setTimer(evid, time_ms, periodic);
}

void trafficLightWaiting_unsetTimer(const sc_eventid evid) {
	timer->unsetTimer(evid);
}
