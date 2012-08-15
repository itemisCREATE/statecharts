/**
* Copyright (c) 2012 committers of YAKINDU and others.
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

TEST(StatemachineTest, choiceTest) {
	Choice handle;
	choice_init(&handle);
	choice_enter(&handle);
	EXPECT_TRUE(choice_isActive(&handle, Choice_main_region_A));
	EXPECT_TRUE(choiceIface_get_value(&handle) == 4);
	choiceIface_raise_pressKey(&handle);
	choice_runCycle(&handle);
	EXPECT_TRUE(choice_isActive(&handle, Choice_main_region_B));
	EXPECT_TRUE(choiceIface_get_value(&handle) == 3);
	choiceIface_raise_pressKey(&handle);
	choice_runCycle(&handle);
	EXPECT_TRUE(choice_isActive(&handle, Choice_main_region_A));
	choiceIface_raise_pressKey(&handle);
	choice_runCycle(&handle);
	EXPECT_TRUE(choice_isActive(&handle, Choice_main_region_C));
	EXPECT_TRUE(choiceIface_get_value(&handle) == 2);
	choiceIface_raise_pressKey(&handle);
	choice_runCycle(&handle);
	EXPECT_TRUE(choice_isActive(&handle, Choice_main_region_B));
	EXPECT_TRUE(choiceIface_get_value(&handle) == 1);
	choiceIface_raise_pressKey(&handle);
	choice_runCycle(&handle);
	EXPECT_TRUE(choice_isActive(&handle, Choice_main_region_A));
	EXPECT_TRUE(choiceIface_get_value(&handle) == 1);
	choiceIface_raise_pressKey(&handle);
	choice_runCycle(&handle);
	EXPECT_TRUE(choice_isActive(&handle, Choice_main_region_C));
	EXPECT_TRUE(choiceIface_get_value(&handle) == 0);
	choiceIface_raise_pressKey(&handle);
	choice_runCycle(&handle);
	EXPECT_TRUE(choice_isActive(&handle, Choice_main_region_A));
}
