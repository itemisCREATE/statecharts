TEMPLATE = app
TARGET = org_yakindu_sct_examples_c_trafficlight
QT += core \
    gui
HEADERS += statemachine/TimeEvent.h \
    statemachine/TrafficLightTimer.h \
    statemachine/TrafficLightRunner.h \
    statemachine/stdbool.h \
    src-gen/TrafficLightWaitingRequired.h \
    src-gen/TrafficLightWaiting.h \
    src-gen/sc_types.h \
    widgets/CrossingWidget.h \
    widgets/PedestrianLightWidget.h \
    widgets/TrafficLightWidget.h \
    org_yakindu_sct_examples_c_trafficlight.h
SOURCES += statemachine/TimeEvent.cpp \
    statemachine/TrafficLightTimer.cpp \
    statemachine/TrafficLightRunner.cpp \
    src-gen/TrafficLightWaiting.c \
    widgets/CrossingWidget.cpp \
    widgets/PedestrianLightWidget.cpp \
    widgets/TrafficLightWidget.cpp \
    main.cpp \
    org_yakindu_sct_examples_c_trafficlight.cpp
FORMS += org_yakindu_sct_examples_c_trafficlight.ui
RESOURCES += 
