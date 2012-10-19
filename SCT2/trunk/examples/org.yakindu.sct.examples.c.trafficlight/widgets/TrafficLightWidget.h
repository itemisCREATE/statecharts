/*
 * TrafficLightWidget.h
 *
 *  Created on: 15.10.2012
 *      Author: muehlbrandt
 */

#ifndef TRAFFICLIGHTWIDGET_H_
#define TRAFFICLIGHTWIDGET_H_

#include <QWidget>
#include <QPaintEvent>
#include <QPainter>

class TrafficLightWidget: public QWidget {

Q_OBJECT

public:
	TrafficLightWidget(QWidget *parent = 0);
	virtual ~TrafficLightWidget();

public slots:
	void setSignals(bool red, bool yellow, bool green);

protected:
	void paintEvent(QPaintEvent *event);

private:
	bool red;
	bool yellow;
	bool green;
};

#endif /* TRAFFICLIGHTWIDGET_H_ */
