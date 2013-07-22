/**
* Copyright (c) 2013 committers of YAKINDU and others.
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

TEST(StatemachineTest, syncJoin_C2_Waits) {
	SyncJoin* statechart = new SyncJoin();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B));
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B_r1_C1));
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B_r2_D1));
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B_r1_C2));
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B_r2_D1));
	statechart->raise_jc();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B_r1_C2));
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B_r2_D1));
	statechart->raise_jd();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B_r1_C2));
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B_r2_D1));
	statechart->raise_jc();
	statechart->raise_jd();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B_r1_C2));
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B_r2_D1));
	statechart->raise_f();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B_r1_C2));
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B_r2_D2));
	statechart->raise_jc();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B_r1_C2));
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B_r2_D2));
	statechart->raise_jd();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B_r1_C2));
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B_r2_D2));
	statechart->raise_jc();
	statechart->raise_jd();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_A));
	delete statechart;
}
TEST(StatemachineTest, syncJoin_D2_Waits) {
	SyncJoin* statechart = new SyncJoin();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B));
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B_r1_C1));
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B_r2_D1));
	statechart->raise_f();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B_r1_C1));
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B_r2_D2));
	statechart->raise_jc();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B_r1_C1));
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B_r2_D2));
	statechart->raise_jd();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B_r1_C1));
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B_r2_D2));
	statechart->raise_jc();
	statechart->raise_jd();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B_r1_C1));
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B_r2_D2));
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B_r1_C2));
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_B_r2_D2));
	delete statechart;
}
TEST(StatemachineTest, doubleEntryActionBug) {
	SyncJoin* statechart = new SyncJoin();
	statechart->init();
	statechart->enter();
	statechart->raise_e();
	statechart->raise_f();
	statechart->runCycle();
	statechart->raise_jc();
	statechart->raise_jd();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(SyncJoin::SyncJoin_main_region_A));
	EXPECT_TRUE(statechart->getSCInterface()->get_x()== 1);
	delete statechart;
}
