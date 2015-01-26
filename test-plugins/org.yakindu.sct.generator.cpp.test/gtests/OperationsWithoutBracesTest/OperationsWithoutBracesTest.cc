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
#include "OperationsWithoutBraces.h"

TEST(StatemachineTest, OperationsWithoutBracesTest) {
	OperationsWithoutBraces* statechart = new OperationsWithoutBraces();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(OperationsWithoutBraces::main_region_A));
	EXPECT_TRUE(statechart->isActive(OperationsWithoutBraces::another_region_A));
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(OperationsWithoutBraces::main_region_B));
	EXPECT_TRUE(statechart->isActive(OperationsWithoutBraces::another_region_B));
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(OperationsWithoutBraces::main_region_C));
	EXPECT_TRUE(statechart->isActive(OperationsWithoutBraces::another_region_C));
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(OperationsWithoutBraces::main_region_D));
	EXPECT_TRUE(statechart->isActive(OperationsWithoutBraces::another_region_D));
	delete statechart;
}
