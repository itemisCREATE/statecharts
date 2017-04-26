/**
* Copyright (c) 2017 committers of YAKINDU and others.
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
#include "sc_types.h"
OutEventLifeCycle* statechart = new OutEventLifeCycle();

TEST(StatemachineTest, availableAfterCycle) {
	
	
	statechart->init();
	statechart->enter();
	
	statechart->raise_e();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->getDefaultSCI()->isRaised_f());
	
	delete statechart;
}
TEST(StatemachineTest, availableWithinCycle) {
	
	
	statechart->init();
	statechart->enter();
	
	statechart->raise_e();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_f_available_in_cycle());
	
	delete statechart;
}
TEST(StatemachineTest, unvailableWithin2ndCycle) {
	
	
	statechart->init();
	statechart->enter();
	
	statechart->raise_e();
	
	statechart->runCycle();
	
	statechart->runCycle();
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_f_available_in_next_cycle());
	
	delete statechart;
}
TEST(StatemachineTest, unvailableAfter2ndCycle) {
	
	
	statechart->init();
	statechart->enter();
	
	statechart->raise_e();
	
	statechart->runCycle();
	
	statechart->runCycle();
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->isRaised_f());
	
	delete statechart;
}
