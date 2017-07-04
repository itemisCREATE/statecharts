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
#include "DeepHistory.h"

static DeepHistory statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		deepHistory_init(&statechart);
	}
};


TEST_F(StatemachineTest, deepHistoryTest) {					
	deepHistory_enter(&statechart);
	deepHistoryIface_raise_event1(&statechart);
	deepHistory_runCycle(&statechart);
	deepHistoryIface_raise_event3(&statechart);
	deepHistory_runCycle(&statechart);
	deepHistoryIface_raise_event5(&statechart);
	deepHistory_runCycle(&statechart);
	deepHistoryIface_raise_event7(&statechart);
	deepHistory_runCycle(&statechart);
	EXPECT_TRUE(!deepHistory_isStateActive(&statechart, DeepHistory_mainRegion_State1));
	EXPECT_TRUE(deepHistory_isStateActive(&statechart, DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9));
	deepHistoryIface_raise_event2(&statechart);
	deepHistory_runCycle(&statechart);
	EXPECT_TRUE(deepHistory_isStateActive(&statechart, DeepHistory_mainRegion_State1));
	EXPECT_TRUE(!deepHistory_isStateActive(&statechart, DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9));
	deepHistoryIface_raise_event1(&statechart);
	deepHistory_runCycle(&statechart);
	EXPECT_TRUE(!deepHistory_isStateActive(&statechart, DeepHistory_mainRegion_State1));
	EXPECT_TRUE(deepHistory_isStateActive(&statechart, DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9));
}


