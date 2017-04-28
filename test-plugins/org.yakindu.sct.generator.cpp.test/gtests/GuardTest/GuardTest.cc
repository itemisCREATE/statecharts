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
#include "Guard.h"
#include "sc_types.h"
Guard* statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new Guard();
		statechart->init();
	}
	virtual void TearDown() {
		delete statechart;
	}
};


TEST_F(StatemachineTest, guardTest) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(Guard::main_region_A));
	
	statechart->raise_event1();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(Guard::main_region_A));
	
	statechart->raise_event2();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(Guard::main_region_B));
	
	statechart->raise_return();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(Guard::main_region_A));
	
	statechart->raise_event1();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(Guard::main_region_B));
	
	statechart->raise_return();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(Guard::main_region_A));
	
}
