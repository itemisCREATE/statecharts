/**
* Copyright (c) 2015 committers of YAKINDU and others.
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
#include "EnterState.h"


EnterState handle;

TEST(StatemachineTest, defaultEntry) {
	enterState_init(&handle);
	enterState_enter(&handle);
	EXPECT_TRUE(enterState_isStateActive(&handle, EnterState_r_A));
	enterStateIface_raise_e(&handle);
	enterState_runCycle(&handle);
	EXPECT_TRUE(enterState_isStateActive(&handle, EnterState_r_B_r_E));
}
TEST(StatemachineTest, namedEntryThroughNamedTransition) {
	enterState_init(&handle);
	enterState_enter(&handle);
	EXPECT_TRUE(enterState_isStateActive(&handle, EnterState_r_A));
	enterStateIface_raise_f(&handle);
	enterState_runCycle(&handle);
	EXPECT_TRUE(enterState_isStateActive(&handle, EnterState_r_B_r_F));
}
TEST(StatemachineTest, namedEntryThroughDefaultTransition) {
	enterState_init(&handle);
	enterState_enter(&handle);
	EXPECT_TRUE(enterState_isStateActive(&handle, EnterState_r_A));
	enterStateIface_raise_g(&handle);
	enterState_runCycle(&handle);
	EXPECT_TRUE(enterState_isStateActive(&handle, EnterState_r_B_r_E));
}

		
