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
#include "ShallowHistory.h"

static ShallowHistory statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		shallowHistory_init(&statechart);
	}
};


TEST_F(StatemachineTest, shallowHistoryTest) {					
	shallowHistory_enter(&statechart);
	shallowHistoryIface_raise_event1(&statechart);
	shallowHistory_runCycle(&statechart);
	shallowHistoryIface_raise_event3(&statechart);
	shallowHistory_runCycle(&statechart);
	shallowHistoryIface_raise_event5(&statechart);
	shallowHistory_runCycle(&statechart);
	shallowHistoryIface_raise_event7(&statechart);
	shallowHistory_runCycle(&statechart);
	EXPECT_TRUE(!shallowHistory_isStateActive(&statechart, ShallowHistory_mainRegion_State1));
	EXPECT_TRUE(shallowHistory_isStateActive(&statechart, ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9));
	shallowHistoryIface_raise_event6(&statechart);
	shallowHistory_runCycle(&statechart);
	EXPECT_TRUE(!shallowHistory_isStateActive(&statechart, ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9));
	EXPECT_TRUE(shallowHistory_isStateActive(&statechart, ShallowHistory_mainRegion_State2__region0_State4__region0_State6));
	shallowHistoryIface_raise_event5(&statechart);
	shallowHistory_runCycle(&statechart);
	EXPECT_TRUE(!shallowHistory_isStateActive(&statechart, ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State8));
	EXPECT_TRUE(shallowHistory_isStateActive(&statechart, ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9));
	shallowHistoryIface_raise_event2(&statechart);
	shallowHistory_runCycle(&statechart);
	EXPECT_TRUE(!shallowHistory_isStateActive(&statechart, ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9));
	EXPECT_TRUE(shallowHistory_isStateActive(&statechart, ShallowHistory_mainRegion_State1));
	shallowHistoryIface_raise_event1(&statechart);
	shallowHistory_runCycle(&statechart);
	EXPECT_TRUE(shallowHistory_isStateActive(&statechart, ShallowHistory_mainRegion_State2__region0_State4__region0_State6));
	EXPECT_TRUE(!shallowHistory_isStateActive(&statechart, ShallowHistory_mainRegion_State1));
	shallowHistoryIface_raise_event5(&statechart);
	shallowHistory_runCycle(&statechart);
	EXPECT_TRUE(!shallowHistory_isStateActive(&statechart, ShallowHistory_mainRegion_State2__region0_State4__region0_State6));
	EXPECT_TRUE(shallowHistory_isStateActive(&statechart, ShallowHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9));
}


