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
#include "EntryReactionAction.h"
#include "sc_types.h"
EntryReactionAction* statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new EntryReactionAction();
		statechart->init();
	}
	virtual void TearDown() {
		delete statechart;
	}
};

void init(){
	statechart->enter();
	statechart->raise_b();
	statechart->runCycle();
	statechart->raise_d();
	statechart->runCycle();
	statechart->getDefaultSCI()->set_enteredR1(false);
	statechart->getDefaultSCI()->set_enteredR2(false);
	statechart->getDefaultSCI()->set_enteredBdefault(false);
	statechart->getDefaultSCI()->set_enteredBother(false);
}

TEST_F(StatemachineTest, entryTransitionActionOnStatechartEnter) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_enteredR1());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_enteredR2());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_enteredBdefault());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_enteredBother());
	
}
TEST_F(StatemachineTest, entryOnRTS) {
	
	
	init();
	
	statechart->raise_b();
	
	statechart->runCycle();
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_enteredR1());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_enteredR2());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_enteredBdefault());
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_enteredBother());
	
}
TEST_F(StatemachineTest, noEntryTransitionActionOnHistory) {
	
	
	init();
	
	statechart->raise_d();
	
	statechart->runCycle();
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_enteredR1());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_enteredR2());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_enteredBdefault());
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_enteredBother());
	
}
