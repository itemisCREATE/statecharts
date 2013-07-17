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
#include "SameNameDifferentRegion.hpp"

TEST(StatemachineTest, sameNameDifferenRegionTest) {
	SameNameDifferentRegion* statechart = new SameNameDifferentRegion();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(SameNameDifferentRegion_main_region_StateA));
	statechart->raise_e1();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(SameNameDifferentRegion_main_region_StateB));
	EXPECT_TRUE(statechart->isActive(SameNameDifferentRegion_main_region_StateB_r1_StateA));
	statechart->raise_e1();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(SameNameDifferentRegion_main_region_StateB));
	EXPECT_TRUE(statechart->isActive(SameNameDifferentRegion_main_region_StateB_r1_StateB));
	delete statechart;
}
