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
#include <string>
#include "gtest/gtest.h"
#include "ShallowHistoryWithDeepEntry.h"
#include "sc_types.h"
ShallowHistoryWithDeepEntry* statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new ShallowHistoryWithDeepEntry();
		statechart->init();
	}
	virtual void TearDown() {
		delete statechart;
	}
};


TEST_F(StatemachineTest, noDeepEntryWithinHistory) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Y));
	
	statechart->raise_toZ();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_A));
	
	statechart->raise_toY();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Y));
	
	statechart->raise_toZ();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_A));
	
}
TEST_F(StatemachineTest, deepEntryWithinHistory) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Y));
	
	statechart->raise_toZ();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_A));
	
	statechart->raise_toC();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_B__region0_C));
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_B));
	
	statechart->raise_toY();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Y));
	
	statechart->raise_toZ();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_B__region0_C));
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_B));
	
}
TEST_F(StatemachineTest, directDeepEntryIntoHistory) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Y));
	
	statechart->raise_toC();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_B__region0_C));
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_B));
	
	statechart->raise_toY();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Y));
	
	statechart->raise_toZ();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_B__region0_C));
	
	EXPECT_TRUE(statechart->isStateActive(ShallowHistoryWithDeepEntry::main_region_Z__region0_B));
	
}
