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
#include "TriggerGuardExpressions.h"
#include "sc_types.h"
TriggerGuardExpressions* statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new TriggerGuardExpressions();
		statechart->init();
	}
	virtual void TearDown() {
		delete statechart;
	}
};


TEST_F(StatemachineTest, trueGuard) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(TriggerGuardExpressions::main_region_A));
	
	statechart->raise_e1();
	
	statechart->getDefaultSCI()->set_b(true);
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(TriggerGuardExpressions::main_region_B));
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(TriggerGuardExpressions::main_region_A));
	
	statechart->raise_e2();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(TriggerGuardExpressions::main_region_B));
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(TriggerGuardExpressions::main_region_A));
	
	statechart->raise_e1();
	
	statechart->raise_e2();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(TriggerGuardExpressions::main_region_B));
	
}
TEST_F(StatemachineTest, falseGuard) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(TriggerGuardExpressions::main_region_A));
	
	statechart->getDefaultSCI()->set_b(false);
	
	statechart->raise_e1();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(TriggerGuardExpressions::main_region_A));
	
	statechart->raise_e2();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(TriggerGuardExpressions::main_region_A));
	
	statechart->raise_e1();
	
	statechart->raise_e2();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(TriggerGuardExpressions::main_region_A));
	
}
