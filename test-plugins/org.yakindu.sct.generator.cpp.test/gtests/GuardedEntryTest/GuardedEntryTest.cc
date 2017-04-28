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
#include "GuardedEntry.h"
#include "sc_types.h"
GuardedEntry* statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new GuardedEntry();
		statechart->init();
	}
	virtual void TearDown() {
		delete statechart;
	}
};

void initEntryInTransition(bool guardVar, bool doneVar){
	statechart->enter();
	EXPECT_TRUE(statechart->isStateActive(GuardedEntry::main_region_A));
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isStateActive(GuardedEntry::main_region_B));
	statechart->getDefaultSCI()->set_guard(guardVar);
	statechart->getDefaultSCI()->set_done(doneVar);
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isStateActive(GuardedEntry::main_region_A));
}

TEST_F(StatemachineTest, EntryNotTakenOnStatechartEnter) {
	
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_guard()== false);
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(GuardedEntry::main_region_A));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_done()== false);
	
}
TEST_F(StatemachineTest, EntryTakenOnStatechartEnter) {
	
	
	statechart->getDefaultSCI()->set_guard(true);
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(GuardedEntry::main_region_A));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_done()== true);
	
}
TEST_F(StatemachineTest, EntryTakenInTransition) {
	
	
	initEntryInTransition(true,false);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_done());
	
}
TEST_F(StatemachineTest, EntryNotTakenInTransition) {
	
	
	initEntryInTransition(false,false);
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_done());
	
}
