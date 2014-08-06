/**
* Copyright (c) 2014 committers of YAKINDU and others.
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
	HistoryWithoutInitialStep* statechart = new HistoryWithoutInitialStep();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(HistoryWithoutInitialStep::main_region_A));
	statechart->raise_e1();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(HistoryWithoutInitialStep::main_region_B_r1_C));
	statechart->raise_e2();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(HistoryWithoutInitialStep::main_region_B_r1_D));
	delete statechart;
}
TEST(StatemachineTest, enterCThroughHistory) {
	HistoryWithoutInitialStep* statechart = new HistoryWithoutInitialStep();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(HistoryWithoutInitialStep::main_region_A));
	statechart->raise_e1();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(HistoryWithoutInitialStep::main_region_B_r1_C));
	statechart->raise_e1();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(HistoryWithoutInitialStep::main_region_A));
	statechart->raise_e2();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(HistoryWithoutInitialStep::main_region_B_r1_C));
	delete statechart;
}
TEST(StatemachineTest, enterDThroughHistory) {
	HistoryWithoutInitialStep* statechart = new HistoryWithoutInitialStep();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(HistoryWithoutInitialStep::main_region_A));
	statechart->raise_e1();
	statechart->runCycle();
	statechart->raise_e2();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(HistoryWithoutInitialStep::main_region_B_r1_D));
	statechart->raise_e1();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(HistoryWithoutInitialStep::main_region_A));
	statechart->raise_e2();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(HistoryWithoutInitialStep::main_region_B_r1_D));
	delete statechart;
}
