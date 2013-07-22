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
#include "AlwaysOncycle.h"

TEST(StatemachineTest, alwaysOncycleTest) {
	AlwaysOncycle* statechart = new AlwaysOncycle();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(AlwaysOncycle::AlwaysOncycle_main_region_StateA));
	while (statechart->getSCInterface()->get_value()< 5) {
		statechart->runCycle();
		EXPECT_TRUE(statechart->isActive(AlwaysOncycle::AlwaysOncycle_main_region_StateA));
	}
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(AlwaysOncycle::AlwaysOncycle_main_region_StateB));
	while (statechart->getSCInterface()->get_value()< 5) {
		statechart->runCycle();
		EXPECT_TRUE(statechart->isActive(AlwaysOncycle::AlwaysOncycle_main_region_StateB));
	}
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(AlwaysOncycle::AlwaysOncycle_main_region_StateA));
	delete statechart;
}
