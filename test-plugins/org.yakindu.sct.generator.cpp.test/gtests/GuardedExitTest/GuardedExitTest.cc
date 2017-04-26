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
#include "GuardedExit.h"
#include "sc_types.h"
GuardedExit* statechart = new GuardedExit();
statechart->init();

TEST(StatemachineTest, ExitTaken) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(GuardedExit::main_region_A));
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_guard());
	
	statechart->raise_e();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(GuardedExit::main_region_B));
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_done());
	
	delete statechart;
}
TEST(StatemachineTest, ExitNotTaken) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(GuardedExit::main_region_A));
	
	statechart->getDefaultSCI()->set_guard(true);
	
	statechart->raise_e();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(GuardedExit::main_region_B));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_done());
	
	delete statechart;
}
