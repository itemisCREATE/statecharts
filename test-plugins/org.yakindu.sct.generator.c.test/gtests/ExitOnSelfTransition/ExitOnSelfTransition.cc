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
#include "ExitOnSelfTransition.h"

TEST(StatemachineTest, ExitOnSelfTransitionTest) {
	ExitOnSelfTransition handle;
	exitOnSelfTransition_init(&handle);
	exitOnSelfTransition_enter(&handle);
	EXPECT_TRUE(exitOnSelfTransition_isActive(&handle, ExitOnSelfTransition_main_region_A));
	EXPECT_TRUE(exitOnSelfTransitionIface_get_entryCount(&handle) == 1);
	EXPECT_TRUE(exitOnSelfTransitionIface_get_exitCount(&handle) == 0);
	exitOnSelfTransitionIface_raise_e(&handle);
	exitOnSelfTransition_runCycle(&handle);
	EXPECT_TRUE(exitOnSelfTransitionIface_get_entryCount(&handle) == 2);
	EXPECT_TRUE(exitOnSelfTransitionIface_get_exitCount(&handle) == 1);
	exitOnSelfTransitionIface_raise_f(&handle);
	exitOnSelfTransition_runCycle(&handle);
	EXPECT_TRUE(exitOnSelfTransitionIface_get_entryCount(&handle) == 2);
	EXPECT_TRUE(exitOnSelfTransitionIface_get_exitCount(&handle) == 2);
}
