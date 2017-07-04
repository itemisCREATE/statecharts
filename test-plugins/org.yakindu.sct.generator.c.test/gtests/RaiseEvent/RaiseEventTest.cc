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
#include "RaiseEvent.h"

static RaiseEvent statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		raiseEvent_init(&statechart);
	}
};


TEST_F(StatemachineTest, raiseEvent) {					
	raiseEvent_enter(&statechart);
	EXPECT_TRUE(raiseEvent_isStateActive(&statechart, RaiseEvent_second_region_SateA));
	EXPECT_TRUE(raiseEvent_isStateActive(&statechart, RaiseEvent_main_region_StateA));
	raiseEventIface_raise_e2(&statechart);
	raiseEvent_runCycle(&statechart);
	raiseEvent_runCycle(&statechart);
	EXPECT_TRUE(raiseEvent_isStateActive(&statechart, RaiseEvent_second_region_StateB));
	EXPECT_TRUE(raiseEvent_isStateActive(&statechart, RaiseEvent_main_region_StateB));
}


