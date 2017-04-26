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
#include "StatechartActive.h"
#include "sc_types.h"
StatechartActive* statechart = new StatechartActive();

TEST(StatemachineTest, inactiveBeforeEnter) {
	
	
	statechart->init();
	EXPECT_TRUE(!statechart->isActive());
	
	delete statechart;
}
TEST(StatemachineTest, activeAfterEnter) {
	
	
	statechart->init();
	statechart->enter();
	
	EXPECT_TRUE(statechart->isActive());
	
	delete statechart;
}
TEST(StatemachineTest, inactiveAfterExit) {
	
	
	statechart->init();
	statechart->enter();
	
	statechart->exit();
	
	EXPECT_TRUE(!statechart->isActive());
	
	delete statechart;
}
TEST(StatemachineTest, activeAfterReenter) {
	
	
	statechart->init();
	statechart->enter();
	
	statechart->exit();
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isActive());
	
	delete statechart;
}
