/**
* Copyright (c) 2014 committers of YAKINDU and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     committers of YAKINDU - initial API and implementation
*/
#include <string>
#include "gtest/gtest.h"
#include "Guard.h"


Guard handle;

TEST(StatemachineTest, guardTest) {
	guard_init(&handle);
	guard_enter(&handle);
	EXPECT_TRUE(guard_isActive(&handle, Guard_main_region_A));
	guardIface_raise_event1(&handle);
	guard_runCycle(&handle);
	EXPECT_TRUE(guard_isActive(&handle, Guard_main_region_A));
	guardIface_raise_event2(&handle);
	guard_runCycle(&handle);
	EXPECT_TRUE(guard_isActive(&handle, Guard_main_region_B));
	guardIface_raise_return(&handle);
	guard_runCycle(&handle);
	EXPECT_TRUE(guard_isActive(&handle, Guard_main_region_A));
	guardIface_raise_event1(&handle);
	guard_runCycle(&handle);
	EXPECT_TRUE(guard_isActive(&handle, Guard_main_region_B));
	guardIface_raise_return(&handle);
	guard_runCycle(&handle);
	EXPECT_TRUE(guard_isActive(&handle, Guard_main_region_A));
}

		
