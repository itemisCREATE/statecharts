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
#include "PriorityValues.h"
#include "sc_types.h"
PriorityValues* statechart = new PriorityValues();

TEST(StatemachineTest, transitionPriority) {
	
	
	statechart->init();
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(PriorityValues::main_region_A));
	
	statechart->raise_event1();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(PriorityValues::main_region_C));
	
	delete statechart;
}
TEST(StatemachineTest, regionPriority) {
	
	
	statechart->init();
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(PriorityValues::someRegion_A));
	
	statechart->raise_event2();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(PriorityValues::someRegion_B));
	
	EXPECT_TRUE(!statechart->isStateActive(PriorityValues::main_region_E));
	
	delete statechart;
}
