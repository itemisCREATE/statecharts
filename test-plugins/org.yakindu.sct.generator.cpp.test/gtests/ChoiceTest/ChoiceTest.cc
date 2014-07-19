/**
* Copyright (c) 2014 committers of YAKINDU and others.
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
	EXPECT_TRUE(statechart->isActive(Choice::A));
	statechart->getSCInterface()->set_c(true);
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(Choice::C));
	delete statechart;
}
TEST(StatemachineTest, elseChoiceUsingDefaultTransition) {
	Choice* statechart = new Choice();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(Choice::A));
	statechart->getSCInterface()->set_c(false);
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(Choice::B));
	delete statechart;
}
TEST(StatemachineTest, defaultChoiceUsingNonDefaultTransition) {
	Choice* statechart = new Choice();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(Choice::A));
	statechart->getSCInterface()->set_c(true);
	statechart->raise_g();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(Choice::C));
	delete statechart;
}
TEST(StatemachineTest, defaultChoiceUsingDefaultTransition) {
	Choice* statechart = new Choice();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(Choice::A));
	statechart->getSCInterface()->set_c(false);
	statechart->raise_g();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(Choice::B));
	delete statechart;
}
TEST(StatemachineTest, uncheckedChoiceUsingNonDefaultTransition) {
	Choice* statechart = new Choice();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(Choice::A));
	statechart->getSCInterface()->set_c(true);
	statechart->raise_f();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(Choice::C));
	delete statechart;
}
TEST(StatemachineTest, uncheckedChoiceUsingDefaultTransition) {
	Choice* statechart = new Choice();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(Choice::A));
	statechart->getSCInterface()->set_c(false);
	statechart->raise_f();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(Choice::B));
	delete statechart;
}
TEST(StatemachineTest, alwaysTrueTransitionInChoice) {
	Choice* statechart = new Choice();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(Choice::A));
	statechart->getSCInterface()->set_c(true);
	statechart->raise_h();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(Choice::C));
	delete statechart;
}
