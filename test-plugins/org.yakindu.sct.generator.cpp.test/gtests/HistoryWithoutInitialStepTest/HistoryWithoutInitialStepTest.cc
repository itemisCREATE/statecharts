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
#include "HistoryWithoutInitialStep.h"
#include "sc_types.h"
HistoryWithoutInitialStep* statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new HistoryWithoutInitialStep();
		statechart->init();
	}
	virtual void TearDown() {
		delete statechart;
	}
};

void init(){
	statechart->enter();
	EXPECT_TRUE(statechart->isStateActive(HistoryWithoutInitialStep::main_region_A));
	statechart->raise_toB();
	statechart->runCycle();
}

TEST_F(StatemachineTest, enterThroughInitialEntry) {
	
	
	init();
	
	EXPECT_TRUE(statechart->isStateActive(HistoryWithoutInitialStep::main_region_B_r1_C));
	
	statechart->raise_next();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(HistoryWithoutInitialStep::main_region_B_r1_D));
	
}
TEST_F(StatemachineTest, enterCThroughHistory) {
	
	
	init();
	
	EXPECT_TRUE(statechart->isStateActive(HistoryWithoutInitialStep::main_region_B_r1_C));
	
	statechart->raise_toA();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(HistoryWithoutInitialStep::main_region_A));
	
	statechart->raise_toHistory();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(HistoryWithoutInitialStep::main_region_B_r1_C));
	
}
TEST_F(StatemachineTest, enterDThroughHistory) {
	
	
	init();
	
	statechart->raise_next();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(HistoryWithoutInitialStep::main_region_B_r1_D));
	
	statechart->raise_toA();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(HistoryWithoutInitialStep::main_region_A));
	
	statechart->raise_toHistory();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(HistoryWithoutInitialStep::main_region_B_r1_D));
	
}
