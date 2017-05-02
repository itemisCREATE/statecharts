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
#include "InternalEventLifeCycle.h"

InternalEventLifeCycle handle;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		internalEventLifeCycle_init(&handle);
	}
};


TEST_F(StatemachineTest, InternalEventLifeCycleTest) {					
	internalEventLifeCycle_enter(&handle);
	EXPECT_TRUE(internalEventLifeCycle_isStateActive(&handle, InternalEventLifeCycle_r1_A));
	EXPECT_TRUE(internalEventLifeCycle_isStateActive(&handle, InternalEventLifeCycle_r2_C));
	internalEventLifeCycleIface_raise_e(&handle);
	internalEventLifeCycle_runCycle(&handle);
	EXPECT_TRUE(internalEventLifeCycle_isStateActive(&handle, InternalEventLifeCycle_r1_A));
	EXPECT_TRUE(internalEventLifeCycle_isStateActive(&handle, InternalEventLifeCycle_r2_D));
	internalEventLifeCycle_runCycle(&handle);
	EXPECT_TRUE(internalEventLifeCycle_isStateActive(&handle, InternalEventLifeCycle_r1_A));
	EXPECT_TRUE(internalEventLifeCycle_isStateActive(&handle, InternalEventLifeCycle_r2_D));
	internalEventLifeCycleIface_raise_f(&handle);
	internalEventLifeCycle_runCycle(&handle);
	EXPECT_TRUE(internalEventLifeCycle_isStateActive(&handle, InternalEventLifeCycle_r1_A));
	EXPECT_TRUE(internalEventLifeCycle_isStateActive(&handle, InternalEventLifeCycle_r2_C));
	internalEventLifeCycle_runCycle(&handle);
	EXPECT_TRUE(internalEventLifeCycle_isStateActive(&handle, InternalEventLifeCycle_r1_A));
	EXPECT_TRUE(internalEventLifeCycle_isStateActive(&handle, InternalEventLifeCycle_r2_C));
}


