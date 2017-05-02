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
#include "RaiseEvent.h"
#include "sc_types.h"
RaiseEvent* statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new RaiseEvent();
		statechart->init();
	}
	virtual void TearDown() {
		delete statechart;
	}
};


TEST_F(StatemachineTest, raiseEvent) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(RaiseEvent::second_region_SateA));
	
	EXPECT_TRUE(statechart->isStateActive(RaiseEvent::main_region_StateA));
	
	statechart->raise_e2();
	
	statechart->runCycle();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(RaiseEvent::second_region_StateB));
	
	EXPECT_TRUE(statechart->isStateActive(RaiseEvent::main_region_StateB));
	
}
