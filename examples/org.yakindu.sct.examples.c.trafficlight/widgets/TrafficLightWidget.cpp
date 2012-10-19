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

#include "TrafficLightWidget.h"

TrafficLightWidget::TrafficLightWidget(QWidget *parent) :
		QWidget(parent) {
	red = false;
	yellow = false;
	green = false;
}

void TrafficLightWidget::setSignals(bool red, bool yellow, bool green) {
	this->red = red;
	this->yellow = yellow;
	this->green = green;
}

void TrafficLightWidget::paintEvent(QPaintEvent *event) {
	QWidget::paintEvent(event);

	QPainter painter(this);
	painter.setBrush(Qt::darkGray);
	painter.drawRect(this->rect());

	QRect rect = this->rect().translated(0, 0);

	//red signal
	painter.setBrush(red ? Qt::red : Qt::black);
	painter.drawEllipse(QPoint(rect.width() / 2, rect.height() / 5),
			rect.width() / 3, rect.width() / 3);

	//yellow signal
	painter.setBrush(yellow ? Qt::yellow : Qt::black);
	painter.drawEllipse(QPoint(rect.width() / 2, rect.height() / 2),
			rect.width() / 3, rect.width() / 3);

	//green signal
	painter.setBrush(green ? Qt::green : Qt::black);
	painter.drawEllipse(QPoint(rect.width() / 2, rect.height() * 4 / 5),
			rect.width() / 3, rect.width() / 3);
}

TrafficLightWidget::~TrafficLightWidget() {
}
