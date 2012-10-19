#include "org_yakindu_sct_examples_c_trafficlight.h"

org_yakindu_sct_examples_c_trafficlight::org_yakindu_sct_examples_c_trafficlight(
		QWidget *parent, TrafficLightRunner *runner) :
		QMainWindow(parent) {

	ui.setupUi(this);
	crossing = new CrossingWidget(this);

	trafficLight = new TrafficLightWidget(crossing);
	trafficLight->setGeometry(275, 75, 30, 90);

	pedestrianLight = new PedestrianLightWidget(crossing);
	pedestrianLight->setGeometry(50, 10, 70, 20);

	connect(runner, SIGNAL(cycleDone(TrafficLightWaiting*)), this, SLOT(update(TrafficLightWaiting*)));

	pedestrianReq = new QPushButton("pedestrian request", this);
	pedestrianReq->setGeometry(1, 365, 150, 30);
	connect(pedestrianReq, SIGNAL(released()), runner, SLOT(raisePedestrianRequest()));


	off = new QPushButton("off / on", this);
	off->setGeometry(249, 365, 150, 30);
	connect(off, SIGNAL(released()), runner, SLOT(raiseOnOff()));
}

void org_yakindu_sct_examples_c_trafficlight::update(
		TrafficLightWaiting *handle) {
	trafficLight->setSignals(handle->ifaceTrafficLight.red,
			handle->ifaceTrafficLight.yellow, handle->ifaceTrafficLight.green);
	pedestrianLight->setSignals(handle->ifacePedestrian.request,
			handle->ifacePedestrian.red, handle->ifacePedestrian.green);
	QMainWindow::update();
}

org_yakindu_sct_examples_c_trafficlight::~org_yakindu_sct_examples_c_trafficlight() {

}
