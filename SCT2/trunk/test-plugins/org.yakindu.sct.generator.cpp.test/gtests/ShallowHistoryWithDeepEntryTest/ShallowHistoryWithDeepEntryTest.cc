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

TEST(StatemachineTest, noDeepEntryWithinHistory) {
	ShallowHistoryWithDeepEntry* statechart = new ShallowHistoryWithDeepEntry();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(ShallowHistoryWithDeepEntry::main_region_Y));
	statechart->raise_toZ();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_A));
	statechart->raise_toY();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(ShallowHistoryWithDeepEntry::main_region_Y));
	statechart->raise_toZ();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_A));
	delete statechart;
}
TEST(StatemachineTest, deepEntryWithinHistory) {
	ShallowHistoryWithDeepEntry* statechart = new ShallowHistoryWithDeepEntry();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(ShallowHistoryWithDeepEntry::main_region_Y));
	statechart->raise_toZ();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_A));
	statechart->raise_toC();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_B__region0_C));
	EXPECT_TRUE(statechart->isActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_B));
	statechart->raise_toY();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(ShallowHistoryWithDeepEntry::main_region_Y));
	statechart->raise_toZ();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_B__region0_C));
	EXPECT_TRUE(statechart->isActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_B));
	delete statechart;
}
TEST(StatemachineTest, directDeepEntryIntoHistory) {
	ShallowHistoryWithDeepEntry* statechart = new ShallowHistoryWithDeepEntry();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(ShallowHistoryWithDeepEntry::main_region_Y));
	statechart->raise_toC();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_B__region0_C));
	EXPECT_TRUE(statechart->isActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_B));
	statechart->raise_toY();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(ShallowHistoryWithDeepEntry::main_region_Y));
	statechart->raise_toZ();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_B__region0_C));
	EXPECT_TRUE(statechart->isActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_B));
	delete statechart;
}
