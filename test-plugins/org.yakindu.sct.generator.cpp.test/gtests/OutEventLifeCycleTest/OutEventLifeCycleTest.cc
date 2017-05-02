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
OutEventLifeCycle* statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new OutEventLifeCycle();
		statechart->init();
	}
	virtual void TearDown() {
		delete statechart;
	}
};

void init(bool sndCycle){
	statechart->enter();
	statechart->raise_e();
	statechart->runCycle();
	if (sndCycle) {
		statechart->runCycle();
	}
}

TEST_F(StatemachineTest, availableAfterCycle) {
	
	
	statechart->enter();
	
	statechart->raise_e();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->getDefaultSCI()->isRaised_f());
	
}
TEST_F(StatemachineTest, availableWithinCycle) {
	
	
	init(false);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_f_available_in_cycle());
	
}
TEST_F(StatemachineTest, unvailableWithin2ndCycle) {
	
	
	init(true);
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_f_available_in_next_cycle());
	
}
TEST_F(StatemachineTest, unvailableAfter2ndCycle) {
	
	
	init(true);
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->isRaised_f());
	
}
