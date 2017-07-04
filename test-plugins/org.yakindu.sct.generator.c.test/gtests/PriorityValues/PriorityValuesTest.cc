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
#include "PriorityValues.h"

static PriorityValues statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		priorityValues_init(&statechart);
	}
};


TEST_F(StatemachineTest, transitionPriority) {					
	priorityValues_enter(&statechart);
	EXPECT_TRUE(priorityValues_isStateActive(&statechart, PriorityValues_main_region_A));
	priorityValuesIface_raise_event1(&statechart);
	priorityValues_runCycle(&statechart);
	EXPECT_TRUE(priorityValues_isStateActive(&statechart, PriorityValues_main_region_C));
}
TEST_F(StatemachineTest, regionPriority) {					
	priorityValues_enter(&statechart);
	EXPECT_TRUE(priorityValues_isStateActive(&statechart, PriorityValues_someRegion_A));
	priorityValuesIface_raise_event2(&statechart);
	priorityValues_runCycle(&statechart);
	EXPECT_TRUE(priorityValues_isStateActive(&statechart, PriorityValues_someRegion_B));
	EXPECT_TRUE(!priorityValues_isStateActive(&statechart, PriorityValues_main_region_E));
}


