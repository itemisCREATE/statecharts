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
#include "ExitState.h"

TEST(StatemachineTest, defaultExit) {
	ExitState handle;
	exitState_init(&handle);
	exitState_enter(&handle);
	EXPECT_TRUE(exitState_isActive(&handle, ExitState_r_A));
	exitStateIface_raise_e(&handle);
	exitState_runCycle(&handle);
	EXPECT_TRUE(exitState_isActive(&handle, ExitState_r_E));
}
TEST(StatemachineTest, namedExitThroughNamedTransition) {
	ExitState handle;
	exitState_init(&handle);
	exitState_enter(&handle);
	EXPECT_TRUE(exitState_isActive(&handle, ExitState_r_A));
	exitStateIface_raise_f(&handle);
	exitState_runCycle(&handle);
	EXPECT_TRUE(exitState_isActive(&handle, ExitState_r_F));
}
TEST(StatemachineTest, namedExitThroughDefaultTransition) {
	ExitState handle;
	exitState_init(&handle);
	exitState_enter(&handle);
	EXPECT_TRUE(exitState_isActive(&handle, ExitState_r_A));
	exitStateIface_raise_g(&handle);
	exitState_runCycle(&handle);
	EXPECT_TRUE(exitState_isActive(&handle, ExitState_r_E));
}
TEST(StatemachineTest, remainInA) {
	ExitState handle;
	exitState_init(&handle);
	exitState_enter(&handle);
	EXPECT_TRUE(exitState_isActive(&handle, ExitState_r_A));
	exitState_runCycle(&handle);
	EXPECT_TRUE(exitState_isActive(&handle, ExitState_r_A));
}
