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

OutEventLifeCycle handle;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		outEventLifeCycle_init(&handle);
	}
};

void init(bool sndCycle){
	outEventLifeCycle_enter(&handle);
	outEventLifeCycleIface_raise_e(&handle);
	outEventLifeCycle_runCycle(&handle);
	if (sndCycle) {
		outEventLifeCycle_runCycle(&handle);
	}
}

TEST_F(StatemachineTest, availableAfterCycle) {					
	outEventLifeCycle_enter(&handle);
	outEventLifeCycleIface_raise_e(&handle);
	outEventLifeCycle_runCycle(&handle);
	EXPECT_TRUE(outEventLifeCycleIface_israised_f(&handle));
}
TEST_F(StatemachineTest, availableWithinCycle) {					
	init(false);
	EXPECT_TRUE(outEventLifeCycleIface_get_f_available_in_cycle(&handle));
}
TEST_F(StatemachineTest, unvailableWithin2ndCycle) {					
	init(true);
	EXPECT_TRUE(!outEventLifeCycleIface_get_f_available_in_next_cycle(&handle));
}
TEST_F(StatemachineTest, unvailableAfter2ndCycle) {					
	init(true);
	EXPECT_TRUE(!outEventLifeCycleIface_israised_f(&handle));
}


