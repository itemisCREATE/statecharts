/**
* Copyright (c) 2014 committers of YAKINDU and others.
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

TEST(StatemachineTest, defaultEntry) {
	EnterState* statechart = new EnterState();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(EnterState::r_A));
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(EnterState::r_B_r_E));
	delete statechart;
}
TEST(StatemachineTest, namedEntryThroughNamedTransition) {
	EnterState* statechart = new EnterState();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(EnterState::r_A));
	statechart->raise_f();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(EnterState::r_B_r_F));
	delete statechart;
}
TEST(StatemachineTest, namedEntryThroughDefaultTransition) {
	EnterState* statechart = new EnterState();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(EnterState::r_A));
	statechart->raise_g();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(EnterState::r_B_r_E));
	delete statechart;
}
