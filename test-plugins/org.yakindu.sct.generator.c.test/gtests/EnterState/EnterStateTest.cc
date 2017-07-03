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

static EnterState statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		enterState_init(&statechart);
	}
};


TEST_F(StatemachineTest, defaultEntry) {					
	enterState_enter(&statechart);
	EXPECT_TRUE(enterState_isStateActive(&statechart, EnterState_r_A));
	enterStateIface_raise_e(&statechart);
	enterState_runCycle(&statechart);
	EXPECT_TRUE(enterState_isStateActive(&statechart, EnterState_r_B_r_E));
}
TEST_F(StatemachineTest, namedEntryThroughNamedTransition) {					
	enterState_enter(&statechart);
	EXPECT_TRUE(enterState_isStateActive(&statechart, EnterState_r_A));
	enterStateIface_raise_f(&statechart);
	enterState_runCycle(&statechart);
	EXPECT_TRUE(enterState_isStateActive(&statechart, EnterState_r_B_r_F));
}
TEST_F(StatemachineTest, namedEntryThroughDefaultTransition) {					
	enterState_enter(&statechart);
	EXPECT_TRUE(enterState_isStateActive(&statechart, EnterState_r_A));
	enterStateIface_raise_g(&statechart);
	enterState_runCycle(&statechart);
	EXPECT_TRUE(enterState_isStateActive(&statechart, EnterState_r_B_r_E));
}


