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
#include "AlwaysOncycle.h"

static AlwaysOncycle statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		alwaysOncycle_init(&statechart);
	}
};


TEST_F(StatemachineTest, alwaysOnCycleTest) {					
	alwaysOncycle_enter(&statechart);
	EXPECT_TRUE(alwaysOncycle_isStateActive(&statechart, AlwaysOncycle_main_region_StateA));
	while (alwaysOncycleIface_get_value(&statechart)< 5l) {
		alwaysOncycle_runCycle(&statechart);
		EXPECT_TRUE(alwaysOncycle_isStateActive(&statechart, AlwaysOncycle_main_region_StateA));
	}
	alwaysOncycle_runCycle(&statechart);
	EXPECT_TRUE(alwaysOncycle_isStateActive(&statechart, AlwaysOncycle_main_region_StateB));
	while (alwaysOncycleIface_get_value(&statechart)< 5l) {
		alwaysOncycle_runCycle(&statechart);
		EXPECT_TRUE(alwaysOncycle_isStateActive(&statechart, AlwaysOncycle_main_region_StateB));
	}
	alwaysOncycle_runCycle(&statechart);
	EXPECT_TRUE(alwaysOncycle_isStateActive(&statechart, AlwaysOncycle_main_region_StateA));
}


