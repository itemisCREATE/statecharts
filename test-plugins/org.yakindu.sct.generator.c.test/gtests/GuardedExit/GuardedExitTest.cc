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
#include "GuardedExit.h"

static GuardedExit statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		guardedExit_init(&statechart);
	}
};

void checkDone(bool shouldBeDone){
	guardedExitIface_raise_e(&statechart);
	guardedExit_runCycle(&statechart);
	EXPECT_TRUE(guardedExit_isStateActive(&statechart, GuardedExit_main_region_B));
	EXPECT_TRUE(shouldBeDone ? guardedExitIface_get_done(&statechart)  : !guardedExitIface_get_done(&statechart));
}

TEST_F(StatemachineTest, ExitTaken) {					
	guardedExit_enter(&statechart);
	EXPECT_TRUE(guardedExit_isStateActive(&statechart, GuardedExit_main_region_A));
	EXPECT_TRUE(!guardedExitIface_get_guard(&statechart));
	checkDone(false);
}
TEST_F(StatemachineTest, ExitNotTaken) {					
	guardedExit_enter(&statechart);
	EXPECT_TRUE(guardedExit_isStateActive(&statechart, GuardedExit_main_region_A));
	guardedExitIface_set_guard(&statechart,true);
	checkDone(true);
}


