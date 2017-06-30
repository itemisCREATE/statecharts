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
#include "gtest/gtest.h"
#include "StatechartLocalReactions.h"

static StatechartLocalReactions statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechartLocalReactions_init(&statechart);
	}
};


TEST_F(StatemachineTest, statechartLocalReactionsTest) {					
	statechartLocalReactions_enter(&statechart);
	EXPECT_TRUE(statechartLocalReactions_isStateActive(&statechart, StatechartLocalReactions_main_region_S1));
	EXPECT_TRUE(statechartLocalReactions_isStateActive(&statechart, StatechartLocalReactions_region2_a));
	while (statechartLocalReactionsIface_get_myInt(&statechart)< 10l) {
		EXPECT_TRUE(statechartLocalReactions_isStateActive(&statechart, StatechartLocalReactions_region2_a));
		if (statechartLocalReactionsIface_get_myInt(&statechart)%2l== 0l) {
			EXPECT_TRUE(statechartLocalReactions_isStateActive(&statechart, StatechartLocalReactions_main_region_S1));
		}
		else {
			EXPECT_TRUE(statechartLocalReactions_isStateActive(&statechart, StatechartLocalReactions_main_region_S2));
		}
		statechartLocalReactions_runCycle(&statechart);
	}
}


