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
#include "EnterState.h"

EnterState handle;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		enterState_init(&handle);
	}
};


TEST_F(StatemachineTest, defaultEntry) {					
	enterState_enter(&handle);
	EXPECT_TRUE(enterState_isStateActive(&handle, EnterState_r_A));
	enterStateIface_raise_e(&handle);
	enterState_runCycle(&handle);
	EXPECT_TRUE(enterState_isStateActive(&handle, EnterState_r_B_r_E));
}
TEST_F(StatemachineTest, namedEntryThroughNamedTransition) {					
	enterState_enter(&handle);
	EXPECT_TRUE(enterState_isStateActive(&handle, EnterState_r_A));
	enterStateIface_raise_f(&handle);
	enterState_runCycle(&handle);
	EXPECT_TRUE(enterState_isStateActive(&handle, EnterState_r_B_r_F));
}
TEST_F(StatemachineTest, namedEntryThroughDefaultTransition) {					
	enterState_enter(&handle);
	EXPECT_TRUE(enterState_isStateActive(&handle, EnterState_r_A));
	enterStateIface_raise_g(&handle);
	enterState_runCycle(&handle);
	EXPECT_TRUE(enterState_isStateActive(&handle, EnterState_r_B_r_E));
}


