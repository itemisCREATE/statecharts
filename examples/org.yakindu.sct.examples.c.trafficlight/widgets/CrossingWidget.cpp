/*
 * CrossingWidget.cpp
 *
 *  Created on: 15.10.2012
 *      Author: muehlbrandt
 */

#include "CrossingWidget.h"

CrossingWidget::CrossingWidget(QWidget *parent) :
		QWidget(parent) {
	parentWidget()->setFixedSize(WIDTH, HEIGHT);
}

void CrossingWidget::paintEvent(QPaintEvent *event) {
	QWidget::paintEvent(event);
	setFixedSize(parentWidget()->width(), parentWidget()->height());

	QPainter painter(this);
	painter.setBrush(Qt::darkGreen);
	painter.drawRect(0, 0, parentWidget()->width(), parentWidget()->height());

	painter.setBrush(QColor(192, 192, 192));
	painter.drawRect(WIDTH / 3, 0, WIDTH / 3, HEIGHT);

	painter.setBrush(Qt::white);
	for (int i = 0; i <= 10; i += 2) {
		painter.drawRect(WIDTH / 3 + i * WIDTH / 33, HEIGHT / 11, WIDTH / 30,
				HEIGHT / 10);
	}
}

CrossingWidget::~CrossingWidget() {
}
