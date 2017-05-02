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

Choice handle;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		choice_init(&handle);
	}
};

void initForEventE(bool valueForC){
	choice_enter(&handle);
	EXPECT_TRUE(choice_isStateActive(&handle, Choice_main_region_A));
	choiceIface_set_c(&handle,valueForC);
	choiceIface_raise_e(&handle);
	choice_runCycle(&handle);
}
void initForEventF(bool valueForC){
	choice_enter(&handle);
	EXPECT_TRUE(choice_isStateActive(&handle, Choice_main_region_A));
	choiceIface_set_c(&handle,valueForC);
	choiceIface_raise_f(&handle);
	choice_runCycle(&handle);
}
void initForEventG(bool valueForC){
	choice_enter(&handle);
	EXPECT_TRUE(choice_isStateActive(&handle, Choice_main_region_A));
	choiceIface_set_c(&handle,valueForC);
	choiceIface_raise_g(&handle);
	choice_runCycle(&handle);
}
void initForEventH(bool valueForC){
	choice_enter(&handle);
	EXPECT_TRUE(choice_isStateActive(&handle, Choice_main_region_A));
	choiceIface_set_c(&handle,valueForC);
	choiceIface_raise_h(&handle);
	choice_runCycle(&handle);
}

TEST_F(StatemachineTest, elseChoiceUsingNonDefaultTransition) {					
	initForEventE(true);
	EXPECT_TRUE(choice_isStateActive(&handle, Choice_main_region_C));
}
TEST_F(StatemachineTest, elseChoiceUsingDefaultTransition) {					
	initForEventE(false);
	EXPECT_TRUE(choice_isStateActive(&handle, Choice_main_region_B));
}
TEST_F(StatemachineTest, defaultChoiceUsingNonDefaultTransition) {					
	initForEventG(true);
	EXPECT_TRUE(choice_isStateActive(&handle, Choice_main_region_C));
}
TEST_F(StatemachineTest, defaultChoiceUsingDefaultTransition) {					
	initForEventG(false);
	EXPECT_TRUE(choice_isStateActive(&handle, Choice_main_region_B));
}
TEST_F(StatemachineTest, uncheckedChoiceUsingNonDefaultTransition) {					
	initForEventF(true);
	EXPECT_TRUE(choice_isStateActive(&handle, Choice_main_region_C));
}
TEST_F(StatemachineTest, uncheckedChoiceUsingDefaultTransition) {					
	initForEventF(false);
	EXPECT_TRUE(choice_isStateActive(&handle, Choice_main_region_B));
}
TEST_F(StatemachineTest, alwaysTrueTransitionInChoice) {					
	initForEventH(true);
	EXPECT_TRUE(choice_isStateActive(&handle, Choice_main_region_C));
}


