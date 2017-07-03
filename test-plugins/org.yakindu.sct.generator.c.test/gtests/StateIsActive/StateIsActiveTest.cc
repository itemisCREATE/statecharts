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
#include "StateIsActive.h"

static StateIsActive statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		stateIsActive_init(&statechart);
	}
};


TEST_F(StatemachineTest, stateIsActive) {					
	stateIsActive_enter(&statechart);
	EXPECT_TRUE(stateIsActive_isStateActive(&statechart, StateIsActive_R1_R1A));
	EXPECT_TRUE(stateIsActive_isStateActive(&statechart, StateIsActive_R2_R2A));
	stateIsActiveIface_raise_event1(&statechart);
	stateIsActive_runCycle(&statechart);
	stateIsActive_runCycle(&statechart);
	EXPECT_TRUE(stateIsActive_isStateActive(&statechart, StateIsActive_R1_R1B));
	EXPECT_TRUE(stateIsActive_isStateActive(&statechart, StateIsActive_R2_R2B));
}


