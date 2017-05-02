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
#include "HistoryWithoutInitialStep.h"

HistoryWithoutInitialStep handle;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		historyWithoutInitialStep_init(&handle);
	}
};

void init(){
	historyWithoutInitialStep_enter(&handle);
	EXPECT_TRUE(historyWithoutInitialStep_isStateActive(&handle, HistoryWithoutInitialStep_main_region_A));
	historyWithoutInitialStepIface_raise_toB(&handle);
	historyWithoutInitialStep_runCycle(&handle);
}

TEST_F(StatemachineTest, enterThroughInitialEntry) {					
	init();
	EXPECT_TRUE(historyWithoutInitialStep_isStateActive(&handle, HistoryWithoutInitialStep_main_region_B_r1_C));
	historyWithoutInitialStepIface_raise_next(&handle);
	historyWithoutInitialStep_runCycle(&handle);
	EXPECT_TRUE(historyWithoutInitialStep_isStateActive(&handle, HistoryWithoutInitialStep_main_region_B_r1_D));
}
TEST_F(StatemachineTest, enterCThroughHistory) {					
	init();
	EXPECT_TRUE(historyWithoutInitialStep_isStateActive(&handle, HistoryWithoutInitialStep_main_region_B_r1_C));
	historyWithoutInitialStepIface_raise_toA(&handle);
	historyWithoutInitialStep_runCycle(&handle);
	EXPECT_TRUE(historyWithoutInitialStep_isStateActive(&handle, HistoryWithoutInitialStep_main_region_A));
	historyWithoutInitialStepIface_raise_toHistory(&handle);
	historyWithoutInitialStep_runCycle(&handle);
	EXPECT_TRUE(historyWithoutInitialStep_isStateActive(&handle, HistoryWithoutInitialStep_main_region_B_r1_C));
}
TEST_F(StatemachineTest, enterDThroughHistory) {					
	init();
	historyWithoutInitialStepIface_raise_next(&handle);
	historyWithoutInitialStep_runCycle(&handle);
	EXPECT_TRUE(historyWithoutInitialStep_isStateActive(&handle, HistoryWithoutInitialStep_main_region_B_r1_D));
	historyWithoutInitialStepIface_raise_toA(&handle);
	historyWithoutInitialStep_runCycle(&handle);
	EXPECT_TRUE(historyWithoutInitialStep_isStateActive(&handle, HistoryWithoutInitialStep_main_region_A));
	historyWithoutInitialStepIface_raise_toHistory(&handle);
	historyWithoutInitialStep_runCycle(&handle);
	EXPECT_TRUE(historyWithoutInitialStep_isStateActive(&handle, HistoryWithoutInitialStep_main_region_B_r1_D));
}


