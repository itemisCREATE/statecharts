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
#include "ExitState.h"

static ExitState statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		exitState_init(&statechart);
	}
};


TEST_F(StatemachineTest, defaultExit) {					
	exitState_enter(&statechart);
	EXPECT_TRUE(exitState_isStateActive(&statechart, ExitState_r_A));
	exitStateIface_raise_e(&statechart);
	exitState_runCycle(&statechart);
	EXPECT_TRUE(exitState_isStateActive(&statechart, ExitState_r_E));
}
TEST_F(StatemachineTest, namedExitThroughNamedTransition) {					
	exitState_enter(&statechart);
	EXPECT_TRUE(exitState_isStateActive(&statechart, ExitState_r_A));
	exitStateIface_raise_f(&statechart);
	exitState_runCycle(&statechart);
	EXPECT_TRUE(exitState_isStateActive(&statechart, ExitState_r_F));
}
TEST_F(StatemachineTest, namedExitThroughDefaultTransition) {					
	exitState_enter(&statechart);
	EXPECT_TRUE(exitState_isStateActive(&statechart, ExitState_r_A));
	exitStateIface_raise_g(&statechart);
	exitState_runCycle(&statechart);
	EXPECT_TRUE(exitState_isStateActive(&statechart, ExitState_r_E));
}
TEST_F(StatemachineTest, remainInA) {					
	exitState_enter(&statechart);
	EXPECT_TRUE(exitState_isStateActive(&statechart, ExitState_r_A));
	exitState_runCycle(&statechart);
	EXPECT_TRUE(exitState_isStateActive(&statechart, ExitState_r_A));
}


