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
#include "ExitState.h"

TEST(StatemachineTest, defaultExit) {
	ExitState* statechart = new ExitState();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_A));
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_E));
	delete statechart;
}
TEST(StatemachineTest, namedExitThroughNamedTransition) {
	ExitState* statechart = new ExitState();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_A));
	statechart->raise_f();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_F));
	delete statechart;
}
TEST(StatemachineTest, namedExitThroughDefaultTransition) {
	ExitState* statechart = new ExitState();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_A));
	statechart->raise_g();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_E));
	delete statechart;
}
TEST(StatemachineTest, remainInA) {
	ExitState* statechart = new ExitState();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_A));
	statechart->runCycle();
	EXPECT_TRUE(statechart->isStateActive(ExitState::r_A));
	delete statechart;
}
