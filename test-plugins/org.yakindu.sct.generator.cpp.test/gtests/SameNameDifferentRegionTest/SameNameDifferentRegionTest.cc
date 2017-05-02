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
#include "SameNameDifferentRegion.h"
#include "sc_types.h"
SameNameDifferentRegion* statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new SameNameDifferentRegion();
		statechart->init();
	}
	virtual void TearDown() {
		delete statechart;
	}
};


TEST_F(StatemachineTest, sameNameDifferenRegionTest) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(SameNameDifferentRegion::main_region_StateA));
	
	statechart->raise_e1();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(SameNameDifferentRegion::main_region_StateB));
	
	EXPECT_TRUE(statechart->isStateActive(SameNameDifferentRegion::main_region_StateB_r1_StateA));
	
	statechart->raise_e1();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(SameNameDifferentRegion::main_region_StateB));
	
	EXPECT_TRUE(statechart->isStateActive(SameNameDifferentRegion::main_region_StateB_r1_StateB));
	
}
