/*
 * CrossingWidget.h
 *
 *  Created on: 15.10.2012
 *      Author: muehlbrandt
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
