/**
* Copyright (c) 2015 committers of YAKINDU and others.
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

TEST(StatemachineTest, ExitOnSelfTransitionTest) {
	ExitOnSelfTransition* statechart = new ExitOnSelfTransition();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(ExitOnSelfTransition::main_region_A));
	EXPECT_TRUE(statechart->getDefaultSCI()->get_entryCount()== 1);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_exitCount()== 0);
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->getDefaultSCI()->get_entryCount()== 2);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_exitCount()== 1);
	statechart->raise_f();
	statechart->runCycle();
	EXPECT_TRUE(statechart->getDefaultSCI()->get_entryCount()== 2);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_exitCount()== 2);
	delete statechart;
}
