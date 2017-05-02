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
#include "Guard.h"

Guard handle;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		guard_init(&handle);
	}
};


TEST_F(StatemachineTest, guardTest) {					
	guard_enter(&handle);
	EXPECT_TRUE(guard_isStateActive(&handle, Guard_main_region_A));
	guardIface_raise_event1(&handle);
	guard_runCycle(&handle);
	EXPECT_TRUE(guard_isStateActive(&handle, Guard_main_region_A));
	guardIface_raise_event2(&handle);
	guard_runCycle(&handle);
	EXPECT_TRUE(guard_isStateActive(&handle, Guard_main_region_B));
	guardIface_raise_return(&handle);
	guard_runCycle(&handle);
	EXPECT_TRUE(guard_isStateActive(&handle, Guard_main_region_A));
	guardIface_raise_event1(&handle);
	guard_runCycle(&handle);
	EXPECT_TRUE(guard_isStateActive(&handle, Guard_main_region_B));
	guardIface_raise_return(&handle);
	guard_runCycle(&handle);
	EXPECT_TRUE(guard_isStateActive(&handle, Guard_main_region_A));
}


