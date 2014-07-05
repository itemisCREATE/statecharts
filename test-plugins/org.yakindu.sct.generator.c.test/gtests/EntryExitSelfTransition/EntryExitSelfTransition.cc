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
#include "EntryExitSelfTransition.h"


EntryExitSelfTransition handle;

TEST(StatemachineTest, SelfTransitionToChildState) {
	entryExitSelfTransition_init(&handle);
	entryExitSelfTransition_enter(&handle);
	entryExitSelfTransition_runCycle(&handle);
	EXPECT_TRUE(entryExitSelfTransitionIface_get_entries(&handle) == 1);
	EXPECT_TRUE(entryExitSelfTransition_isActive(&handle, EntryExitSelfTransition_B));
	entryExitSelfTransitionIface_set_entries(&handle, 0);
	entryExitSelfTransitionIface_raise_e(&handle);
	entryExitSelfTransition_runCycle(&handle);
	EXPECT_TRUE(entryExitSelfTransitionIface_get_entries(&handle) == 1);
	EXPECT_TRUE(entryExitSelfTransitionIface_get_exits(&handle) == 1);
	EXPECT_TRUE(entryExitSelfTransition_isActive(&handle, EntryExitSelfTransition_C));
}
TEST(StatemachineTest, SelfTransitionFromChildState) {
	entryExitSelfTransition_init(&handle);
	entryExitSelfTransition_enter(&handle);
	entryExitSelfTransition_runCycle(&handle);
	EXPECT_TRUE(entryExitSelfTransitionIface_get_entries(&handle) == 1);
	entryExitSelfTransitionIface_set_entries(&handle, 0);
	entryExitSelfTransitionIface_raise_e1(&handle);
	entryExitSelfTransition_runCycle(&handle);
	EXPECT_TRUE(entryExitSelfTransitionIface_get_entries(&handle) == 0);
	EXPECT_TRUE(entryExitSelfTransitionIface_get_exits(&handle) == 0);
	EXPECT_TRUE(entryExitSelfTransition_isActive(&handle, EntryExitSelfTransition_C));
	entryExitSelfTransitionIface_raise_e1(&handle);
	entryExitSelfTransition_runCycle(&handle);
	EXPECT_TRUE(entryExitSelfTransition_isActive(&handle, EntryExitSelfTransition_B));
	EXPECT_TRUE(entryExitSelfTransitionIface_get_entries(&handle) == 1);
	EXPECT_TRUE(entryExitSelfTransitionIface_get_exits(&handle) == 1);
}

		
