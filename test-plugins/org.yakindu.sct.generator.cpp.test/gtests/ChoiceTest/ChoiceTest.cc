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
#include "Choice.h"
#include "sc_types.h"
Choice* statechart = new Choice();

TEST(StatemachineTest, elseChoiceUsingNonDefaultTransition) {
	
	
	statechart->init();
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_A));
	
	statechart->getDefaultSCI()->set_c(true);
	
	statechart->raise_e();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_C));
	
	delete statechart;
}
TEST(StatemachineTest, elseChoiceUsingDefaultTransition) {
	
	
	statechart->init();
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_A));
	
	statechart->getDefaultSCI()->set_c(false);
	
	statechart->raise_e();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_B));
	
	delete statechart;
}
TEST(StatemachineTest, defaultChoiceUsingNonDefaultTransition) {
	
	
	statechart->init();
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_A));
	
	statechart->getDefaultSCI()->set_c(true);
	
	statechart->raise_g();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_C));
	
	delete statechart;
}
TEST(StatemachineTest, defaultChoiceUsingDefaultTransition) {
	
	
	statechart->init();
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_A));
	
	statechart->getDefaultSCI()->set_c(false);
	
	statechart->raise_g();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_B));
	
	delete statechart;
}
TEST(StatemachineTest, uncheckedChoiceUsingNonDefaultTransition) {
	
	
	statechart->init();
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_A));
	
	statechart->getDefaultSCI()->set_c(true);
	
	statechart->raise_f();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_C));
	
	delete statechart;
}
TEST(StatemachineTest, uncheckedChoiceUsingDefaultTransition) {
	
	
	statechart->init();
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_A));
	
	statechart->getDefaultSCI()->set_c(false);
	
	statechart->raise_f();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_B));
	
	delete statechart;
}
TEST(StatemachineTest, alwaysTrueTransitionInChoice) {
	
	
	statechart->init();
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_A));
	
	statechart->getDefaultSCI()->set_c(true);
	
	statechart->raise_h();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_C));
	
	delete statechart;
}
