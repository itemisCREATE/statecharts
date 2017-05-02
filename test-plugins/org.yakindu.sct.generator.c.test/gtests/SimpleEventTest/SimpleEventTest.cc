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

SimpleEvent handle;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		simpleEvent_init(&handle);
	}
};


TEST_F(StatemachineTest, simpleEventTest) {					
	simpleEvent_enter(&handle);
	EXPECT_TRUE(simpleEvent_isStateActive(&handle, SimpleEvent_main_region_A)) << "Expected A to be active" ;
	EXPECT_TRUE(5l== 5l);
	simpleEventIface_raise_event1(&handle);
	simpleEvent_runCycle(&handle);
	EXPECT_TRUE(simpleEvent_isStateActive(&handle, SimpleEvent_main_region_B)) << "Expected B to be active" ;
	simpleEvent_runCycle(&handle);
	EXPECT_TRUE(!simpleEvent_isStateActive(&handle, SimpleEvent_main_region_B));
}


