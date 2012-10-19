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

#include "PedestrianLightWidget.h"

PedestrianLightWidget::PedestrianLightWidget(QWidget *parent) :
		QWidget(parent) {
	white = false;
	red = false;
	green = false;
}

void PedestrianLightWidget::setSignals(bool white, bool red, bool green) {
	this->white = white;
	this->red = red;
	this->green = green;
}

void PedestrianLightWidget::paintEvent(QPaintEvent *event) {
	QWidget::paintEvent(event);

	QPainter painter(this);
	painter.setBrush(Qt::darkGray);
	painter.drawRect(this->rect());

	QRect rect = this->rect().translated(0, 0);

	painter.setBrush(white ? Qt::white : Qt::black);
	int size = rect.width() / 5;
	painter.drawRect(rect.width() / 5 - size / 2, (rect.height() - size) / 2,
			size, size);

	painter.setBrush(red ? Qt::red : Qt::black);
	painter.drawEllipse(QPoint(rect.width() / 2, rect.height() / 2),
			rect.width() / 8, rect.width() / 8);

	painter.setBrush(green ? Qt::green : Qt::black);
	painter.drawEllipse(QPoint(rect.width() * 4 / 5, rect.height() / 2),
			rect.width() / 8, rect.width() / 8);
}

PedestrianLightWidget::~PedestrianLightWidget() {
}
