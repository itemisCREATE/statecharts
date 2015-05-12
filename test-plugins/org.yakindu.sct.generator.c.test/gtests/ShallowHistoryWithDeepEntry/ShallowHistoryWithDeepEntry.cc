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
#include "ShallowHistoryWithDeepEntry.h"


ShallowHistoryWithDeepEntry handle;

TEST(StatemachineTest, noDeepEntryWithinHistory) {
	shallowHistoryWithDeepEntry_init(&handle);
	shallowHistoryWithDeepEntry_enter(&handle);
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&handle, ShallowHistoryWithDeepEntry_main_region_Y));
	shallowHistoryWithDeepEntryIface_raise_toZ(&handle);
	shallowHistoryWithDeepEntry_runCycle(&handle);
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&handle, ShallowHistoryWithDeepEntry_main_region_Z__region0_A));
	shallowHistoryWithDeepEntryIface_raise_toY(&handle);
	shallowHistoryWithDeepEntry_runCycle(&handle);
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&handle, ShallowHistoryWithDeepEntry_main_region_Y));
	shallowHistoryWithDeepEntryIface_raise_toZ(&handle);
	shallowHistoryWithDeepEntry_runCycle(&handle);
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&handle, ShallowHistoryWithDeepEntry_main_region_Z__region0_A));
}
TEST(StatemachineTest, deepEntryWithinHistory) {
	shallowHistoryWithDeepEntry_init(&handle);
	shallowHistoryWithDeepEntry_enter(&handle);
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&handle, ShallowHistoryWithDeepEntry_main_region_Y));
	shallowHistoryWithDeepEntryIface_raise_toZ(&handle);
	shallowHistoryWithDeepEntry_runCycle(&handle);
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&handle, ShallowHistoryWithDeepEntry_main_region_Z__region0_A));
	shallowHistoryWithDeepEntryIface_raise_toC(&handle);
	shallowHistoryWithDeepEntry_runCycle(&handle);
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&handle, ShallowHistoryWithDeepEntry_main_region_Z__region0_B__region0_C));
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&handle, ShallowHistoryWithDeepEntry_main_region_Z__region0_B));
	shallowHistoryWithDeepEntryIface_raise_toY(&handle);
	shallowHistoryWithDeepEntry_runCycle(&handle);
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&handle, ShallowHistoryWithDeepEntry_main_region_Y));
	shallowHistoryWithDeepEntryIface_raise_toZ(&handle);
	shallowHistoryWithDeepEntry_runCycle(&handle);
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&handle, ShallowHistoryWithDeepEntry_main_region_Z__region0_B__region0_C));
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&handle, ShallowHistoryWithDeepEntry_main_region_Z__region0_B));
}
TEST(StatemachineTest, directDeepEntryIntoHistory) {
	shallowHistoryWithDeepEntry_init(&handle);
	shallowHistoryWithDeepEntry_enter(&handle);
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&handle, ShallowHistoryWithDeepEntry_main_region_Y));
	shallowHistoryWithDeepEntryIface_raise_toC(&handle);
	shallowHistoryWithDeepEntry_runCycle(&handle);
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&handle, ShallowHistoryWithDeepEntry_main_region_Z__region0_B__region0_C));
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&handle, ShallowHistoryWithDeepEntry_main_region_Z__region0_B));
	shallowHistoryWithDeepEntryIface_raise_toY(&handle);
	shallowHistoryWithDeepEntry_runCycle(&handle);
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&handle, ShallowHistoryWithDeepEntry_main_region_Y));
	shallowHistoryWithDeepEntryIface_raise_toZ(&handle);
	shallowHistoryWithDeepEntry_runCycle(&handle);
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&handle, ShallowHistoryWithDeepEntry_main_region_Z__region0_B__region0_C));
	EXPECT_TRUE(shallowHistoryWithDeepEntry_isStateActive(&handle, ShallowHistoryWithDeepEntry_main_region_Z__region0_B));
}

		
