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
#include "SyncJoin.h"

static SyncJoin statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		syncJoin_init(&statechart);
	}
};


TEST_F(StatemachineTest, syncJoin_C2_Waits) {					
	syncJoin_enter(&statechart);
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B));
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B_r1_C1));
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B_r2_D1));
	syncJoinIface_raise_e(&statechart);
	syncJoin_runCycle(&statechart);
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B_r1_C2));
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B_r2_D1));
	syncJoinIface_raise_jc(&statechart);
	syncJoin_runCycle(&statechart);
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B_r1_C2));
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B_r2_D1));
	syncJoinIface_raise_jd(&statechart);
	syncJoin_runCycle(&statechart);
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B_r1_C2));
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B_r2_D1));
	syncJoinIface_raise_jc(&statechart);
	syncJoinIface_raise_jd(&statechart);
	syncJoin_runCycle(&statechart);
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B_r1_C2));
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B_r2_D1));
	syncJoinIface_raise_f(&statechart);
	syncJoin_runCycle(&statechart);
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B_r1_C2));
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B_r2_D2));
	syncJoinIface_raise_jc(&statechart);
	syncJoin_runCycle(&statechart);
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B_r1_C2));
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B_r2_D2));
	syncJoinIface_raise_jd(&statechart);
	syncJoin_runCycle(&statechart);
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B_r1_C2));
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B_r2_D2));
	syncJoinIface_raise_jc(&statechart);
	syncJoinIface_raise_jd(&statechart);
	syncJoin_runCycle(&statechart);
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_A));
}
TEST_F(StatemachineTest, syncJoin_D2_Waits) {					
	syncJoin_enter(&statechart);
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B));
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B_r1_C1));
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B_r2_D1));
	syncJoinIface_raise_f(&statechart);
	syncJoin_runCycle(&statechart);
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B_r1_C1));
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B_r2_D2));
	syncJoinIface_raise_jc(&statechart);
	syncJoin_runCycle(&statechart);
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B_r1_C1));
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B_r2_D2));
	syncJoinIface_raise_jd(&statechart);
	syncJoin_runCycle(&statechart);
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B_r1_C1));
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B_r2_D2));
	syncJoinIface_raise_jc(&statechart);
	syncJoinIface_raise_jd(&statechart);
	syncJoin_runCycle(&statechart);
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B_r1_C1));
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B_r2_D2));
	syncJoinIface_raise_e(&statechart);
	syncJoin_runCycle(&statechart);
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B_r1_C2));
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_B_r2_D2));
}
TEST_F(StatemachineTest, doubleEntryActionBug) {					
	syncJoin_enter(&statechart);
	syncJoinIface_raise_e(&statechart);
	syncJoinIface_raise_f(&statechart);
	syncJoin_runCycle(&statechart);
	syncJoinIface_raise_jc(&statechart);
	syncJoinIface_raise_jd(&statechart);
	syncJoin_runCycle(&statechart);
	EXPECT_TRUE(syncJoin_isStateActive(&statechart, SyncJoin_main_region_A));
	EXPECT_TRUE(syncJoinIface_get_x(&statechart)== 1l);
}


