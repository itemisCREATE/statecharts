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
#include "InEventLifeCycle.h"

InEventLifeCycle handle;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		inEventLifeCycle_init(&handle);
	}
};


TEST_F(StatemachineTest, eventLifeCycle) {					
	inEventLifeCycle_enter(&handle);
	inEventLifeCycleIface_raise_e(&handle);
	EXPECT_TRUE(inEventLifeCycleIface_get_i(&handle)== 0l);
	inEventLifeCycle_runCycle(&handle);
	EXPECT_TRUE(inEventLifeCycleIface_get_i(&handle)== 1l);
}


