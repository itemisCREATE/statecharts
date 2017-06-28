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
#include "SimpleEvent.h"

static SimpleEvent statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		simpleEvent_init(&statechart);
	}
};


TEST_F(StatemachineTest, simpleEventTest) {					
	simpleEvent_enter(&statechart);
	EXPECT_TRUE(simpleEvent_isStateActive(&statechart, SimpleEvent_main_region_A)) << "Expected A to be active" ;
	EXPECT_TRUE(5l== 5l);
	simpleEventIface_raise_event1(&statechart);
	simpleEvent_runCycle(&statechart);
	EXPECT_TRUE(simpleEvent_isStateActive(&statechart, SimpleEvent_main_region_B)) << "Expected B to be active" ;
	simpleEvent_runCycle(&statechart);
	EXPECT_TRUE(!simpleEvent_isStateActive(&statechart, SimpleEvent_main_region_B));
}


