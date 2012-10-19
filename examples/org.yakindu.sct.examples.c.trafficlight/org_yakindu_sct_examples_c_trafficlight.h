#ifndef ORG_YAKINDU_SCT_EXAMPLES_C_TRAFFICLIGHT_H
#define ORG_YAKINDU_SCT_EXAMPLES_C_TRAFFICLIGHT_H

#include <QtGui/QMainWindow>
#include "ui_org_yakindu_sct_examples_c_trafficlight.h"
#include "widgets/CrossingWidget.h"
#include "widgets/TrafficLightWidget.h"
#include "widgets/PedestrianLightWidget.h"
#include "statemachine/TrafficLightRunner.h"

class org_yakindu_sct_examples_c_trafficlight: public QMainWindow {

Q_OBJECT

public:
	org_yakindu_sct_examples_c_trafficlight(QWidget *parent = 0, TrafficLightRunner* runner = 0);
	~org_yakindu_sct_examples_c_trafficlight();

public slots:
	void update(TrafficLightWaiting *handle);

private:
	Ui::org_yakindu_sct_examples_c_trafficlightClass ui;
	CrossingWidget *crossing;
	TrafficLightWidget *trafficLight;
	PedestrianLightWidget *pedestrianLight;
	QPushButton *pedestrianReq;
	QPushButton *off;
};
#endif // ORG_YAKINDU_SCT_EXAMPLES_C_TRAFFICLIGHT_H
