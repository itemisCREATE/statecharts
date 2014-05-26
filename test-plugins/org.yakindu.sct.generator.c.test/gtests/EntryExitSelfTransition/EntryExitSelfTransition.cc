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

TEST(StatemachineTest, EntryExitSelfTransitionTest) {
	entryExitSelfTransition_init(&handle);
	entryExitSelfTransition_enter(&handle);
	entryExitSelfTransition_runCycle(&handle);
	EXPECT_TRUE(entryExitSelfTransitionIface_get_x(&handle) == 1);
	entryExitSelfTransitionIface_raise_e(&handle);
	entryExitSelfTransition_runCycle(&handle);
	EXPECT_TRUE(entryExitSelfTransitionIface_get_x(&handle) == 3);
}

		
