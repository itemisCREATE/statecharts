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
Choice* statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new Choice();
		statechart->init();
	}
	virtual void TearDown() {
		delete statechart;
	}
};

void initForEventE(bool valueForC){
	statechart->enter();
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_A));
	statechart->getDefaultSCI()->set_c(valueForC);
	statechart->raise_e();
	statechart->runCycle();
}
void initForEventF(bool valueForC){
	statechart->enter();
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_A));
	statechart->getDefaultSCI()->set_c(valueForC);
	statechart->raise_f();
	statechart->runCycle();
}
void initForEventG(bool valueForC){
	statechart->enter();
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_A));
	statechart->getDefaultSCI()->set_c(valueForC);
	statechart->raise_g();
	statechart->runCycle();
}
void initForEventH(bool valueForC){
	statechart->enter();
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_A));
	statechart->getDefaultSCI()->set_c(valueForC);
	statechart->raise_h();
	statechart->runCycle();
}

TEST_F(StatemachineTest, elseChoiceUsingNonDefaultTransition) {
	
	
	initForEventE(true);
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_C));
	
}
TEST_F(StatemachineTest, elseChoiceUsingDefaultTransition) {
	
	
	initForEventE(false);
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_B));
	
}
TEST_F(StatemachineTest, defaultChoiceUsingNonDefaultTransition) {
	
	
	initForEventG(true);
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_C));
	
}
TEST_F(StatemachineTest, defaultChoiceUsingDefaultTransition) {
	
	
	initForEventG(false);
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_B));
	
}
TEST_F(StatemachineTest, uncheckedChoiceUsingNonDefaultTransition) {
	
	
	initForEventF(true);
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_C));
	
}
TEST_F(StatemachineTest, uncheckedChoiceUsingDefaultTransition) {
	
	
	initForEventF(false);
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_B));
	
}
TEST_F(StatemachineTest, alwaysTrueTransitionInChoice) {
	
	
	initForEventH(true);
	
	EXPECT_TRUE(statechart->isStateActive(Choice::main_region_C));
	
}
