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

#ifndef CROSSINGWIDGET_H_
#define CROSSINGWIDGET_H_

#include <QWidget>
#include <QPushButton>
#include <QPaintEvent>
#include <QPainter>

class CrossingWidget: public QWidget {


public:
	CrossingWidget(QWidget *parent = 0);
	virtual ~CrossingWidget();

protected:
	void paintEvent(QPaintEvent *event);

private:
	static const int WIDTH = 399;
	static const int HEIGHT = 399;
};

#endif /* CROSSINGWIDGET_H_ */
