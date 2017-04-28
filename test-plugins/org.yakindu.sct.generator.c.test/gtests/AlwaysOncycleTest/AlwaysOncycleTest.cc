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
#include "AlwaysOncycle.h"

AlwaysOncycle handle;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		alwaysOncycle_init(&handle);
	}
};


TEST_F(StatemachineTest, alwaysOncycleTest) {					
	alwaysOncycle_enter(&handle);
	EXPECT_TRUE(alwaysOncycle_isStateActive(&handle, AlwaysOncycle_main_region_StateA));
	while (alwaysOncycleIface_get_value(&handle)< 5l) {
		alwaysOncycle_runCycle(&handle);
		EXPECT_TRUE(alwaysOncycle_isStateActive(&handle, AlwaysOncycle_main_region_StateA));
	}
	alwaysOncycle_runCycle(&handle);
	EXPECT_TRUE(alwaysOncycle_isStateActive(&handle, AlwaysOncycle_main_region_StateB));
	while (alwaysOncycleIface_get_value(&handle)< 5l) {
		alwaysOncycle_runCycle(&handle);
		EXPECT_TRUE(alwaysOncycle_isStateActive(&handle, AlwaysOncycle_main_region_StateB));
	}
	alwaysOncycle_runCycle(&handle);
	EXPECT_TRUE(alwaysOncycle_isStateActive(&handle, AlwaysOncycle_main_region_StateA));
}


