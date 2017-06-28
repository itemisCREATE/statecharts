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
#include "gtest/gtest.h"
#include "Choice.h"

static Choice statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		choice_init(&statechart);
	}
};

void initForEventE(bool valueForC){
	choice_enter(&statechart);
	EXPECT_TRUE(choice_isStateActive(&statechart, Choice_main_region_A));
	choiceIface_set_c(&statechart,valueForC);
	choiceIface_raise_e(&statechart);
	choice_runCycle(&statechart);
}
void initForEventF(bool valueForC){
	choice_enter(&statechart);
	EXPECT_TRUE(choice_isStateActive(&statechart, Choice_main_region_A));
	choiceIface_set_c(&statechart,valueForC);
	choiceIface_raise_f(&statechart);
	choice_runCycle(&statechart);
}
void initForEventG(bool valueForC){
	choice_enter(&statechart);
	EXPECT_TRUE(choice_isStateActive(&statechart, Choice_main_region_A));
	choiceIface_set_c(&statechart,valueForC);
	choiceIface_raise_g(&statechart);
	choice_runCycle(&statechart);
}
void initForEventH(bool valueForC){
	choice_enter(&statechart);
	EXPECT_TRUE(choice_isStateActive(&statechart, Choice_main_region_A));
	choiceIface_set_c(&statechart,valueForC);
	choiceIface_raise_h(&statechart);
	choice_runCycle(&statechart);
}

TEST_F(StatemachineTest, elseChoiceUsingNonDefaultTransition) {					
	initForEventE(true);
	EXPECT_TRUE(choice_isStateActive(&statechart, Choice_main_region_C));
}
TEST_F(StatemachineTest, elseChoiceUsingDefaultTransition) {					
	initForEventE(false);
	EXPECT_TRUE(choice_isStateActive(&statechart, Choice_main_region_B));
}
TEST_F(StatemachineTest, defaultChoiceUsingNonDefaultTransition) {					
	initForEventG(true);
	EXPECT_TRUE(choice_isStateActive(&statechart, Choice_main_region_C));
}
TEST_F(StatemachineTest, defaultChoiceUsingDefaultTransition) {					
	initForEventG(false);
	EXPECT_TRUE(choice_isStateActive(&statechart, Choice_main_region_B));
}
TEST_F(StatemachineTest, uncheckedChoiceUsingNonDefaultTransition) {					
	initForEventF(true);
	EXPECT_TRUE(choice_isStateActive(&statechart, Choice_main_region_C));
}
TEST_F(StatemachineTest, uncheckedChoiceUsingDefaultTransition) {					
	initForEventF(false);
	EXPECT_TRUE(choice_isStateActive(&statechart, Choice_main_region_B));
}
TEST_F(StatemachineTest, alwaysTrueTransitionInChoice) {					
	initForEventH(true);
	EXPECT_TRUE(choice_isStateActive(&statechart, Choice_main_region_C));
}


