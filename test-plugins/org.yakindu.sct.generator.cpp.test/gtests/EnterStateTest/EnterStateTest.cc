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
#include "EnterState.h"
#include "sc_types.h"
EnterState* statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new EnterState();
		statechart->init();
	}
	virtual void TearDown() {
		delete statechart;
	}
};


TEST_F(StatemachineTest, defaultEntry) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(EnterState::r_A));
	
	statechart->raise_e();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(EnterState::r_B_r_E));
	
}
TEST_F(StatemachineTest, namedEntryThroughNamedTransition) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(EnterState::r_A));
	
	statechart->raise_f();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(EnterState::r_B_r_F));
	
}
TEST_F(StatemachineTest, namedEntryThroughDefaultTransition) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(EnterState::r_A));
	
	statechart->raise_g();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(EnterState::r_B_r_E));
	
}
