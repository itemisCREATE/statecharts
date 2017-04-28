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
#include "ExitState.h"
#include "sc_types.h"
ExitState* statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new ExitState();
		statechart->init();
	}
	virtual void TearDown() {
		delete statechart;
	}
};


TEST_F(StatemachineTest, defaultExit) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_A));
	
	statechart->raise_e();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_E));
	
}
TEST_F(StatemachineTest, namedExitThroughNamedTransition) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_A));
	
	statechart->raise_f();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_F));
	
}
TEST_F(StatemachineTest, namedExitThroughDefaultTransition) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_A));
	
	statechart->raise_g();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_E));
	
}
TEST_F(StatemachineTest, remainInA) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_A));
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_A));
	
}
