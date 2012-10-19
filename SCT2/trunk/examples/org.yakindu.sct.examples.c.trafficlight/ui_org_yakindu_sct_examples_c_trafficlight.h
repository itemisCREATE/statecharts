/********************************************************************************
** Form generated from reading UI file 'org_yakindu_sct_examples_c_trafficlight.ui'
**
** Created: Fri Oct 19 14:59:19 2012
**      by: Qt User Interface Compiler version 4.8.1
**
** WARNING! All changes made in this file will be lost when recompiling UI file!
********************************************************************************/

#ifndef UI_ORG_YAKINDU_SCT_EXAMPLES_C_TRAFFICLIGHT_H
#define UI_ORG_YAKINDU_SCT_EXAMPLES_C_TRAFFICLIGHT_H

#include <QtCore/QVariant>
#include <QtGui/QAction>
#include <QtGui/QApplication>
#include <QtGui/QButtonGroup>
#include <QtGui/QHeaderView>
#include <QtGui/QMainWindow>
#include <QtGui/QMenuBar>
#include <QtGui/QStatusBar>
#include <QtGui/QWidget>

QT_BEGIN_NAMESPACE

class Ui_org_yakindu_sct_examples_c_trafficlightClass
{
public:
    QWidget *centralwidget;
    QMenuBar *menubar;
    QStatusBar *statusbar;

    void setupUi(QMainWindow *org_yakindu_sct_examples_c_trafficlightClass)
    {
        if (org_yakindu_sct_examples_c_trafficlightClass->objectName().isEmpty())
            org_yakindu_sct_examples_c_trafficlightClass->setObjectName(QString::fromUtf8("org_yakindu_sct_examples_c_trafficlightClass"));
        org_yakindu_sct_examples_c_trafficlightClass->resize(300, 300);
        centralwidget = new QWidget(org_yakindu_sct_examples_c_trafficlightClass);
        centralwidget->setObjectName(QString::fromUtf8("centralwidget"));
        org_yakindu_sct_examples_c_trafficlightClass->setCentralWidget(centralwidget);
        menubar = new QMenuBar(org_yakindu_sct_examples_c_trafficlightClass);
        menubar->setObjectName(QString::fromUtf8("menubar"));
        menubar->setGeometry(QRect(0, 0, 300, 25));
        org_yakindu_sct_examples_c_trafficlightClass->setMenuBar(menubar);
        statusbar = new QStatusBar(org_yakindu_sct_examples_c_trafficlightClass);
        statusbar->setObjectName(QString::fromUtf8("statusbar"));
        org_yakindu_sct_examples_c_trafficlightClass->setStatusBar(statusbar);

        retranslateUi(org_yakindu_sct_examples_c_trafficlightClass);

        QMetaObject::connectSlotsByName(org_yakindu_sct_examples_c_trafficlightClass);
    } // setupUi

    void retranslateUi(QMainWindow *org_yakindu_sct_examples_c_trafficlightClass)
    {
        org_yakindu_sct_examples_c_trafficlightClass->setWindowTitle(QApplication::translate("org_yakindu_sct_examples_c_trafficlightClass", "MainWindow", 0, QApplication::UnicodeUTF8));
    } // retranslateUi

};

namespace Ui {
    class org_yakindu_sct_examples_c_trafficlightClass: public Ui_org_yakindu_sct_examples_c_trafficlightClass {};
} // namespace Ui

QT_END_NAMESPACE

#endif // UI_ORG_YAKINDU_SCT_EXAMPLES_C_TRAFFICLIGHT_H
