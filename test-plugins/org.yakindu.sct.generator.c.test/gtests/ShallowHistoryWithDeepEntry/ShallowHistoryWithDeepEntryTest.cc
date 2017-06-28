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
#include "ShallowHistoryWithDeepEntry.h"

static ShallowHistoryWithDeepEntry statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		shallowHistoryWithDeepEntry_init(&statechart);
	}
};


TEST_F(StatemachineTest, noDeepEntryWithinHistory) {					
	shallowHistoryWithDeepEntry_enter(&statechart);
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&statechart, ShallowHistoryWithDeepEntry_main_region_Y));
	shallowHistoryWithDeepEntryIface_raise_toZ(&statechart);
	shallowHistoryWithDeepEntry_runCycle(&statechart);
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&statechart, ShallowHistoryWithDeepEntry_main_region_Z__region0_A));
	shallowHistoryWithDeepEntryIface_raise_toY(&statechart);
	shallowHistoryWithDeepEntry_runCycle(&statechart);
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&statechart, ShallowHistoryWithDeepEntry_main_region_Y));
	shallowHistoryWithDeepEntryIface_raise_toZ(&statechart);
	shallowHistoryWithDeepEntry_runCycle(&statechart);
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&statechart, ShallowHistoryWithDeepEntry_main_region_Z__region0_A));
}
TEST_F(StatemachineTest, deepEntryWithinHistory) {					
	shallowHistoryWithDeepEntry_enter(&statechart);
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&statechart, ShallowHistoryWithDeepEntry_main_region_Y));
	shallowHistoryWithDeepEntryIface_raise_toZ(&statechart);
	shallowHistoryWithDeepEntry_runCycle(&statechart);
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&statechart, ShallowHistoryWithDeepEntry_main_region_Z__region0_A));
	shallowHistoryWithDeepEntryIface_raise_toC(&statechart);
	shallowHistoryWithDeepEntry_runCycle(&statechart);
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&statechart, ShallowHistoryWithDeepEntry_main_region_Z__region0_B__region0_C));
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&statechart, ShallowHistoryWithDeepEntry_main_region_Z__region0_B));
	shallowHistoryWithDeepEntryIface_raise_toY(&statechart);
	shallowHistoryWithDeepEntry_runCycle(&statechart);
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&statechart, ShallowHistoryWithDeepEntry_main_region_Y));
	shallowHistoryWithDeepEntryIface_raise_toZ(&statechart);
	shallowHistoryWithDeepEntry_runCycle(&statechart);
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&statechart, ShallowHistoryWithDeepEntry_main_region_Z__region0_B__region0_C));
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&statechart, ShallowHistoryWithDeepEntry_main_region_Z__region0_B));
}
TEST_F(StatemachineTest, directDeepEntryIntoHistory) {					
	shallowHistoryWithDeepEntry_enter(&statechart);
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&statechart, ShallowHistoryWithDeepEntry_main_region_Y));
	shallowHistoryWithDeepEntryIface_raise_toC(&statechart);
	shallowHistoryWithDeepEntry_runCycle(&statechart);
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&statechart, ShallowHistoryWithDeepEntry_main_region_Z__region0_B__region0_C));
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&statechart, ShallowHistoryWithDeepEntry_main_region_Z__region0_B));
	shallowHistoryWithDeepEntryIface_raise_toY(&statechart);
	shallowHistoryWithDeepEntry_runCycle(&statechart);
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&statechart, ShallowHistoryWithDeepEntry_main_region_Y));
	shallowHistoryWithDeepEntryIface_raise_toZ(&statechart);
	shallowHistoryWithDeepEntry_runCycle(&statechart);
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&statechart, ShallowHistoryWithDeepEntry_main_region_Z__region0_B__region0_C));
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&statechart, ShallowHistoryWithDeepEntry_main_region_Z__region0_B));
}


