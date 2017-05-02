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
#include "DeepEntry.h"
#include "sc_types.h"
DeepEntry* statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new DeepEntry();
		statechart->init();
	}
	virtual void TearDown() {
		delete statechart;
	}
};


TEST_F(StatemachineTest, enterToSubstate) {
	
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_x()== 0l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_y()== 0l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_z()== 0l);
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_x()== 1l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_y()== 1l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_z()== 2l);
	
	statechart->raise_e();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(DeepEntry::r2_B_r_BB));
	
	statechart->raise_f();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(DeepEntry::r2_C));
	
	statechart->raise_f();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(DeepEntry::r2_B_r_BB));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_y()== 1l);
	
}
