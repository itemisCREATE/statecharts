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
