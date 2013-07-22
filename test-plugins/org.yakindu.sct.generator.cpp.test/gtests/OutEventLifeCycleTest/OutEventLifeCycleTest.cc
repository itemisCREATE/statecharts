/**
* Copyright (c) 2013 committers of YAKINDU and others.
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
#include "OutEventLifeCycle.h"

TEST(StatemachineTest, availableAfterCycle) {
	OutEventLifeCycle* statechart = new OutEventLifeCycle();
	statechart->init();
	statechart->enter();
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->getSCInterface()->isRaised_f());
	delete statechart;
}
TEST(StatemachineTest, availableWithinCycle) {
	OutEventLifeCycle* statechart = new OutEventLifeCycle();
	statechart->init();
	statechart->enter();
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->getSCInterface()->get_f_available_in_cycle());
	delete statechart;
}
TEST(StatemachineTest, unvailableWithin2ndCycle) {
	OutEventLifeCycle* statechart = new OutEventLifeCycle();
	statechart->init();
	statechart->enter();
	statechart->raise_e();
	statechart->runCycle();
	statechart->runCycle();
	EXPECT_TRUE(!statechart->getSCInterface()->get_f_available_in_next_cycle());
	delete statechart;
}
TEST(StatemachineTest, unvailableAfter2ndCycle) {
	OutEventLifeCycle* statechart = new OutEventLifeCycle();
	statechart->init();
	statechart->enter();
	statechart->raise_e();
	statechart->runCycle();
	statechart->runCycle();
	EXPECT_TRUE(!statechart->getSCInterface()->isRaised_f());
	delete statechart;
}
