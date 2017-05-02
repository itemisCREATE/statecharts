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
#include "DynamicChoice.h"
#include "sc_types.h"
DynamicChoice* statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new DynamicChoice();
		statechart->init();
	}
	virtual void TearDown() {
		delete statechart;
	}
};


TEST_F(StatemachineTest, DynamicChoiceTest) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(DynamicChoice::main_region_Start));
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(DynamicChoice::main_region_A));
	
}
