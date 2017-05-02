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
#include "StatechartLocalReactions.h"
#include "sc_types.h"
StatechartLocalReactions* statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new StatechartLocalReactions();
		statechart->init();
	}
	virtual void TearDown() {
		delete statechart;
	}
};


TEST_F(StatemachineTest, statechartLocalReactionsTest) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(StatechartLocalReactions::main_region_S1));
	
	EXPECT_TRUE(statechart->isStateActive(StatechartLocalReactions::region2_a));
	
	while (statechart->getDefaultSCI()->get_myInt()< 10l) {
		EXPECT_TRUE(statechart->isStateActive(StatechartLocalReactions::region2_a));
		if (statechart->getDefaultSCI()->get_myInt()%2l== 0l) {
			EXPECT_TRUE(statechart->isStateActive(StatechartLocalReactions::main_region_S1));
		}
		else {
			EXPECT_TRUE(statechart->isStateActive(StatechartLocalReactions::main_region_S2));
		}
		statechart->runCycle();
	}
	
}
