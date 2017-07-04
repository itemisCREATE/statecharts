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
#include "SyncFork.h"

static SyncFork statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		syncFork_init(&statechart);
	}
};


TEST_F(StatemachineTest, syncForkTest) {					
	syncFork_enter(&statechart);
	EXPECT_TRUE(syncFork_isStateActive(&statechart, SyncFork_main_region_A));
	syncForkIface_raise_f(&statechart);
	syncFork_runCycle(&statechart);
	EXPECT_TRUE(syncFork_isStateActive(&statechart, SyncFork_main_region_B));
	EXPECT_TRUE(syncFork_isStateActive(&statechart, SyncFork_main_region_B_r1_C1));
	EXPECT_TRUE(syncFork_isStateActive(&statechart, SyncFork_main_region_B_r2_D1));
	syncForkIface_raise_f(&statechart);
	syncFork_runCycle(&statechart);
	EXPECT_TRUE(syncFork_isStateActive(&statechart, SyncFork_main_region_B));
	EXPECT_TRUE(syncFork_isStateActive(&statechart, SyncFork_main_region_B_r1_C2));
	EXPECT_TRUE(syncFork_isStateActive(&statechart, SyncFork_main_region_B_r2_D2));
	syncForkIface_raise_e(&statechart);
	syncFork_runCycle(&statechart);
	EXPECT_TRUE(syncFork_isStateActive(&statechart, SyncFork_main_region_A));
	syncForkIface_raise_f(&statechart);
	syncFork_runCycle(&statechart);
	EXPECT_TRUE(syncFork_isStateActive(&statechart, SyncFork_main_region_B));
	EXPECT_TRUE(syncFork_isStateActive(&statechart, SyncFork_main_region_B_r1_C1));
	EXPECT_TRUE(syncFork_isStateActive(&statechart, SyncFork_main_region_B_r2_D1));
}


