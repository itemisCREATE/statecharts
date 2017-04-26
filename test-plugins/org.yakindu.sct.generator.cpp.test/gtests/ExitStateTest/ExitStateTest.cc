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
ExitState* statechart = new ExitState();
statechart->init();

TEST(StatemachineTest, defaultExit) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_A));
	
	statechart->raise_e();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_E));
	
	delete statechart;
}
TEST(StatemachineTest, namedExitThroughNamedTransition) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_A));
	
	statechart->raise_f();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_F));
	
	delete statechart;
}
TEST(StatemachineTest, namedExitThroughDefaultTransition) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_A));
	
	statechart->raise_g();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_E));
	
	delete statechart;
}
TEST(StatemachineTest, remainInA) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_A));
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_A));
	
	delete statechart;
}
