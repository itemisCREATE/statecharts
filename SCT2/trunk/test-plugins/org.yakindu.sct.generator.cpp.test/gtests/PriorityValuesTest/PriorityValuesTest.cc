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
#include "PriorityValues.h"

TEST(StatemachineTest, transitionPriority) {
	PriorityValues* statechart = new PriorityValues();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(PriorityValues::PriorityValues_main_region_A));
	statechart->raise_event1();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(PriorityValues::PriorityValues_main_region_C));
	delete statechart;
}
TEST(StatemachineTest, regionPriority) {
	PriorityValues* statechart = new PriorityValues();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(PriorityValues::PriorityValues_someRegion_A));
	statechart->raise_event2();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(PriorityValues::PriorityValues_someRegion_B));
	EXPECT_TRUE(statechart->!isActive(PriorityValues::PriorityValues_main_region_E));
	delete statechart;
}
