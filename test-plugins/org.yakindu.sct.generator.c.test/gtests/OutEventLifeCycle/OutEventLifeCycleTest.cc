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
#include "OutEventLifeCycle.h"

static OutEventLifeCycle statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		outEventLifeCycle_init(&statechart);
	}
};

void init(bool sndCycle){
	outEventLifeCycle_enter(&statechart);
	outEventLifeCycleIface_raise_e(&statechart);
	outEventLifeCycle_runCycle(&statechart);
	if (sndCycle) {
		outEventLifeCycle_runCycle(&statechart);
	}
}

TEST_F(StatemachineTest, availableAfterCycle) {					
	outEventLifeCycle_enter(&statechart);
	outEventLifeCycleIface_raise_e(&statechart);
	outEventLifeCycle_runCycle(&statechart);
	EXPECT_TRUE(outEventLifeCycleIface_israised_f(&statechart));
}
TEST_F(StatemachineTest, availableWithinCycle) {					
	init(false);
	EXPECT_TRUE(outEventLifeCycleIface_get_f_available_in_cycle(&statechart));
}
TEST_F(StatemachineTest, unvailableWithin2ndCycle) {					
	init(true);
	EXPECT_TRUE(!outEventLifeCycleIface_get_f_available_in_next_cycle(&statechart));
}
TEST_F(StatemachineTest, unvailableAfter2ndCycle) {					
	init(true);
	EXPECT_TRUE(!outEventLifeCycleIface_israised_f(&statechart));
}


