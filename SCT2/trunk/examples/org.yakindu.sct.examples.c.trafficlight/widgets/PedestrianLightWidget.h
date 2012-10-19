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
