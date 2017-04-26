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
EnterState* statechart = new EnterState();

TEST(StatemachineTest, defaultEntry) {
	
	
	statechart->init();
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(EnterState::r_A));
	
	statechart->raise_e();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(EnterState::r_B_r_E));
	
	delete statechart;
}
TEST(StatemachineTest, namedEntryThroughNamedTransition) {
	
	
	statechart->init();
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(EnterState::r_A));
	
	statechart->raise_f();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(EnterState::r_B_r_F));
	
	delete statechart;
}
TEST(StatemachineTest, namedEntryThroughDefaultTransition) {
	
	
	statechart->init();
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(EnterState::r_A));
	
	statechart->raise_g();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(EnterState::r_B_r_E));
	
	delete statechart;
}
