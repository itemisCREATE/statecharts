/**
* Copyright (c) 2015 committers of YAKINDU and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     committers of YAKINDU - initial API and implementation
*/
#include <string>
#include "gtest/gtest.h"
#include "SyncJoin.h"


SyncJoin handle;

TEST(StatemachineTest, syncJoin_C2_Waits) {
	syncJoin_init(&handle);
	syncJoin_enter(&handle);
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B));
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B_r1_C1));
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B_r2_D1));
	syncJoinIface_raise_e(&handle);
	syncJoin_runCycle(&handle);
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B_r1_C2));
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B_r2_D1));
	syncJoinIface_raise_jc(&handle);
	syncJoin_runCycle(&handle);
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B_r1_C2));
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B_r2_D1));
	syncJoinIface_raise_jd(&handle);
	syncJoin_runCycle(&handle);
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B_r1_C2));
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B_r2_D1));
	syncJoinIface_raise_jc(&handle);
	syncJoinIface_raise_jd(&handle);
	syncJoin_runCycle(&handle);
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B_r1_C2));
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B_r2_D1));
	syncJoinIface_raise_f(&handle);
	syncJoin_runCycle(&handle);
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B_r1_C2));
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B_r2_D2));
	syncJoinIface_raise_jc(&handle);
	syncJoin_runCycle(&handle);
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B_r1_C2));
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B_r2_D2));
	syncJoinIface_raise_jd(&handle);
	syncJoin_runCycle(&handle);
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B_r1_C2));
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B_r2_D2));
	syncJoinIface_raise_jc(&handle);
	syncJoinIface_raise_jd(&handle);
	syncJoin_runCycle(&handle);
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_A));
}
TEST(StatemachineTest, syncJoin_D2_Waits) {
	syncJoin_init(&handle);
	syncJoin_enter(&handle);
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B));
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B_r1_C1));
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B_r2_D1));
	syncJoinIface_raise_f(&handle);
	syncJoin_runCycle(&handle);
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B_r1_C1));
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B_r2_D2));
	syncJoinIface_raise_jc(&handle);
	syncJoin_runCycle(&handle);
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B_r1_C1));
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B_r2_D2));
	syncJoinIface_raise_jd(&handle);
	syncJoin_runCycle(&handle);
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B_r1_C1));
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B_r2_D2));
	syncJoinIface_raise_jc(&handle);
	syncJoinIface_raise_jd(&handle);
	syncJoin_runCycle(&handle);
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B_r1_C1));
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B_r2_D2));
	syncJoinIface_raise_e(&handle);
	syncJoin_runCycle(&handle);
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B_r1_C2));
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_B_r2_D2));
}
TEST(StatemachineTest, doubleEntryActionBug) {
	syncJoin_init(&handle);
	syncJoin_enter(&handle);
	syncJoinIface_raise_e(&handle);
	syncJoinIface_raise_f(&handle);
	syncJoin_runCycle(&handle);
	syncJoinIface_raise_jc(&handle);
	syncJoinIface_raise_jd(&handle);
	syncJoin_runCycle(&handle);
	EXPECT_TRUE(syncJoin_isActive(&handle, SyncJoin_main_region_A));
	EXPECT_TRUE(syncJoinIface_get_x(&handle) == 1l);
}

		
