/*
 * PedestrianLightWidget.h
 *
 *  Created on: 16.10.2012
 *      Author: muehlbrandt
 */

#ifndef PEDESTRIANLIGHTWIDGET_H_
#define PEDESTRIANLIGHTWIDGET_H_

#include <QWidget>
#include <QPaintEvent>
#include <QPainter>

class PedestrianLightWidget: public QWidget {

Q_OBJECT

public:
	PedestrianLightWidget(QWidget *parent = 0);
	virtual ~PedestrianLightWidget();

public slots:
	void setSignals(bool white, bool red, bool green);

protected:
	void paintEvent(QPaintEvent *event);

private:
	bool white;
	bool red;
	bool green;
};

#endif /* PEDESTRIANLIGHTWIDGET_H_ */
