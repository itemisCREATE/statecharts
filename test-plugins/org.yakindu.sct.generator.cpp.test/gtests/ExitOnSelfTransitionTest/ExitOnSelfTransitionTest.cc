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
#include "ExitOnSelfTransition.h"
#include "sc_types.h"
ExitOnSelfTransition* statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new ExitOnSelfTransition();
		statechart->init();
	}
	virtual void TearDown() {
		delete statechart;
	}
};


TEST_F(StatemachineTest, ExitOnSelfTransitionTest) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(ExitOnSelfTransition::main_region_A));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_entryCount()== 1l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_exitCount()== 0l);
	
	statechart->raise_e();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_entryCount()== 2l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_exitCount()== 1l);
	
	statechart->raise_f();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_entryCount()== 2l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_exitCount()== 2l);
	
}
