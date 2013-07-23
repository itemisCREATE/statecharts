/**
* Copyright (c) 2013 committers of YAKINDU and others.
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
	Choice handle;
	choice_init(&handle);
	choice_enter(&handle);
	EXPECT_TRUE(choice_isActive(&handle, Choice_main_region_A));
	choiceIface_set_c(&handle, true);
	choiceIface_raise_e(&handle);
	choice_runCycle(&handle);
	EXPECT_TRUE(choice_isActive(&handle, Choice_main_region_C));
}
TEST(StatemachineTest, elseChoiceUsingDefaultTransition) {
	Choice handle;
	choice_init(&handle);
	choice_enter(&handle);
	EXPECT_TRUE(choice_isActive(&handle, Choice_main_region_A));
	choiceIface_set_c(&handle, false);
	choiceIface_raise_e(&handle);
	choice_runCycle(&handle);
	EXPECT_TRUE(choice_isActive(&handle, Choice_main_region_B));
}
TEST(StatemachineTest, defaultChoiceUsingNonDefaultTransition) {
	Choice handle;
	choice_init(&handle);
	choice_enter(&handle);
	EXPECT_TRUE(choice_isActive(&handle, Choice_main_region_A));
	choiceIface_set_c(&handle, true);
	choiceIface_raise_g(&handle);
	choice_runCycle(&handle);
	EXPECT_TRUE(choice_isActive(&handle, Choice_main_region_C));
}
TEST(StatemachineTest, defaultChoiceUsingDefaultTransition) {
	Choice handle;
	choice_init(&handle);
	choice_enter(&handle);
	EXPECT_TRUE(choice_isActive(&handle, Choice_main_region_A));
	choiceIface_set_c(&handle, false);
	choiceIface_raise_g(&handle);
	choice_runCycle(&handle);
	EXPECT_TRUE(choice_isActive(&handle, Choice_main_region_B));
}
TEST(StatemachineTest, uncheckedChoiceUsingNonDefaultTransition) {
	Choice handle;
	choice_init(&handle);
	choice_enter(&handle);
	EXPECT_TRUE(choice_isActive(&handle, Choice_main_region_A));
	choiceIface_set_c(&handle, true);
	choiceIface_raise_f(&handle);
	choice_runCycle(&handle);
	EXPECT_TRUE(choice_isActive(&handle, Choice_main_region_C));
}
TEST(StatemachineTest, uncheckedChoiceUsingDefaultTransition) {
	Choice handle;
	choice_init(&handle);
	choice_enter(&handle);
	EXPECT_TRUE(choice_isActive(&handle, Choice_main_region_A));
	choiceIface_set_c(&handle, false);
	choiceIface_raise_f(&handle);
	choice_runCycle(&handle);
	EXPECT_TRUE(choice_isActive(&handle, Choice_main_region_B));
}
TEST(StatemachineTest, alwaysTrueTransitionInChoice) {
	Choice handle;
	choice_init(&handle);
	choice_enter(&handle);
	EXPECT_TRUE(choice_isActive(&handle, Choice_main_region_A));
	choiceIface_set_c(&handle, true);
	choiceIface_raise_h(&handle);
	choice_runCycle(&handle);
	EXPECT_TRUE(choice_isActive(&handle, Choice_main_region_C));
}
