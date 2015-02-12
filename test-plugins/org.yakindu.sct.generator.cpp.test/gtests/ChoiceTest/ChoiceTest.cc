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
#include "Choice.h"

TEST(StatemachineTest, elseChoiceUsingNonDefaultTransition) {
	Choice* statechart = new Choice();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(Choice::main_region_A));
	statechart->getDefaultSCI()->set_c(true);
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(Choice::main_region_C));
	delete statechart;
}
TEST(StatemachineTest, elseChoiceUsingDefaultTransition) {
	Choice* statechart = new Choice();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(Choice::main_region_A));
	statechart->getDefaultSCI()->set_c(false);
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(Choice::main_region_B));
	delete statechart;
}
TEST(StatemachineTest, defaultChoiceUsingNonDefaultTransition) {
	Choice* statechart = new Choice();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(Choice::main_region_A));
	statechart->getDefaultSCI()->set_c(true);
	statechart->raise_g();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(Choice::main_region_C));
	delete statechart;
}
TEST(StatemachineTest, defaultChoiceUsingDefaultTransition) {
	Choice* statechart = new Choice();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(Choice::main_region_A));
	statechart->getDefaultSCI()->set_c(false);
	statechart->raise_g();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(Choice::main_region_B));
	delete statechart;
}
TEST(StatemachineTest, uncheckedChoiceUsingNonDefaultTransition) {
	Choice* statechart = new Choice();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(Choice::main_region_A));
	statechart->getDefaultSCI()->set_c(true);
	statechart->raise_f();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(Choice::main_region_C));
	delete statechart;
}
TEST(StatemachineTest, uncheckedChoiceUsingDefaultTransition) {
	Choice* statechart = new Choice();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(Choice::main_region_A));
	statechart->getDefaultSCI()->set_c(false);
	statechart->raise_f();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(Choice::main_region_B));
	delete statechart;
}
TEST(StatemachineTest, alwaysTrueTransitionInChoice) {
	Choice* statechart = new Choice();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(Choice::main_region_A));
	statechart->getDefaultSCI()->set_c(true);
	statechart->raise_h();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(Choice::main_region_C));
	delete statechart;
}
