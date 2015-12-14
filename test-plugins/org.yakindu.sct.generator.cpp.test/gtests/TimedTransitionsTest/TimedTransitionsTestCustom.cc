/**
* Copyright (c) 2015 committers of YAKINDU and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     committers of YAKINDU - initial API and implementation
*/
#include <string>
#include "gtest/gtest.h"
#include "TimedTransitions.h"
#include "Timer.h"

TEST(StatemachineTest, Timer01) {
	TimedTransitions* statechart = new TimedTransitions();
	Timer* timer = new Timer();
	statechart->setTimer(timer);
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isStateActive(TimedTransitions::main_region_Start));
	EXPECT_EQ(2000, timer->getTime());
	EXPECT_FALSE(timer->isPeriodic());
	statechart->runCycle();
	EXPECT_TRUE(statechart->isStateActive(TimedTransitions::main_region_End));
	EXPECT_EQ(timer->getStatemachineSet(), timer->getStatemachineUnset());
	EXPECT_EQ(timer->getEventSet(),timer->getEventUnset());
	delete timer;
	delete statechart;
}

Timer::Timer() {
}

Timer::~Timer() {
}

void Timer::setTimer(TimedStatemachineInterface* statemachine, sc_eventid event, sc_integer time, sc_boolean isPeriodic) {
	statemachineSet = statemachine;
	eventSet = event;
	this->time = time;
	periodic = isPeriodic;
	statemachine->raiseTimeEvent(event);
}

void Timer::unsetTimer(TimedStatemachineInterface* statemachine, sc_eventid event) {
	statemachineUnset = statemachine;
	eventUnset = event;
}

void Timer::cancel() {
}

TimedStatemachineInterface* Timer::getStatemachineSet() {
	return statemachineSet;
}

TimedStatemachineInterface* Timer::getStatemachineUnset() {
	return statemachineUnset;
}

sc_eventid Timer::getEventSet() {
	return eventSet;
}

sc_eventid Timer::getEventUnset() {
	return eventUnset;
}

sc_integer Timer::getTime() {
	return time;
}

sc_boolean Timer::isPeriodic() {
	return periodic;
}


