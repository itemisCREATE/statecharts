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
