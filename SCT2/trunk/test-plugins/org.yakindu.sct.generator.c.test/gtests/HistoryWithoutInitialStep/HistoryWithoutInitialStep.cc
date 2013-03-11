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
#include "HistoryWithoutInitialStep.h"

TEST(StatemachineTest, enterThroughInitialEntry) {
	HistoryWithoutInitialStep handle;
	historyWithoutInitialStep_init(&handle);
	historyWithoutInitialStep_enter(&handle);
	EXPECT_TRUE(historyWithoutInitialStep_isActive(&handle, HistoryWithoutInitialStep_main_region_A));
	historyWithoutInitialStepIface_raise_e1(&handle);
	historyWithoutInitialStep_runCycle(&handle);
	EXPECT_TRUE(historyWithoutInitialStep_isActive(&handle, HistoryWithoutInitialStep_main_region_B_r1_C));
	historyWithoutInitialStepIface_raise_e2(&handle);
	historyWithoutInitialStep_runCycle(&handle);
	EXPECT_TRUE(historyWithoutInitialStep_isActive(&handle, HistoryWithoutInitialStep_main_region_B_r1_D));
}
TEST(StatemachineTest, enterCThroughHistory) {
	HistoryWithoutInitialStep handle;
	historyWithoutInitialStep_init(&handle);
	historyWithoutInitialStep_enter(&handle);
	EXPECT_TRUE(historyWithoutInitialStep_isActive(&handle, HistoryWithoutInitialStep_main_region_A));
	historyWithoutInitialStepIface_raise_e1(&handle);
	historyWithoutInitialStep_runCycle(&handle);
	EXPECT_TRUE(historyWithoutInitialStep_isActive(&handle, HistoryWithoutInitialStep_main_region_B_r1_C));
	historyWithoutInitialStepIface_raise_e1(&handle);
	historyWithoutInitialStep_runCycle(&handle);
	EXPECT_TRUE(historyWithoutInitialStep_isActive(&handle, HistoryWithoutInitialStep_main_region_A));
	historyWithoutInitialStepIface_raise_e2(&handle);
	historyWithoutInitialStep_runCycle(&handle);
	EXPECT_TRUE(historyWithoutInitialStep_isActive(&handle, HistoryWithoutInitialStep_main_region_B_r1_C));
}
TEST(StatemachineTest, enterDThroughHistory) {
	HistoryWithoutInitialStep handle;
	historyWithoutInitialStep_init(&handle);
	historyWithoutInitialStep_enter(&handle);
	EXPECT_TRUE(historyWithoutInitialStep_isActive(&handle, HistoryWithoutInitialStep_main_region_A));
	historyWithoutInitialStepIface_raise_e1(&handle);
	historyWithoutInitialStep_runCycle(&handle);
	historyWithoutInitialStepIface_raise_e2(&handle);
	historyWithoutInitialStep_runCycle(&handle);
	EXPECT_TRUE(historyWithoutInitialStep_isActive(&handle, HistoryWithoutInitialStep_main_region_B_r1_D));
	historyWithoutInitialStepIface_raise_e1(&handle);
	historyWithoutInitialStep_runCycle(&handle);
	EXPECT_TRUE(historyWithoutInitialStep_isActive(&handle, HistoryWithoutInitialStep_main_region_A));
	historyWithoutInitialStepIface_raise_e2(&handle);
	historyWithoutInitialStep_runCycle(&handle);
	EXPECT_TRUE(historyWithoutInitialStep_isActive(&handle, HistoryWithoutInitialStep_main_region_B_r1_D));
}
