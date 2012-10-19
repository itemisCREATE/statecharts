/*
 * PedestrianLightWidget.cpp
 *
 *  Created on: 16.10.2012
 *      Author: muehlbrandt
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
