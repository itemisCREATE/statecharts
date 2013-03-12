/**
* Copyright (c) 2013 committers of YAKINDU and others.
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
#include "AlwaysOncycle.h"

TEST(StatemachineTest, alwaysOncycleTest) {
	AlwaysOncycle handle;
	alwaysOncycle_init(&handle);
	alwaysOncycle_enter(&handle);
	EXPECT_TRUE(alwaysOncycle_isActive(&handle, AlwaysOncycle_main_region_StateA));
	while (alwaysOncycleIface_get_value(&handle) < 5) {
		alwaysOncycle_runCycle(&handle);
		EXPECT_TRUE(alwaysOncycle_isActive(&handle, AlwaysOncycle_main_region_StateA));
	}
	alwaysOncycle_runCycle(&handle);
	EXPECT_TRUE(alwaysOncycle_isActive(&handle, AlwaysOncycle_main_region_StateB));
	while (alwaysOncycleIface_get_value(&handle) < 5) {
		alwaysOncycle_runCycle(&handle);
		EXPECT_TRUE(alwaysOncycle_isActive(&handle, AlwaysOncycle_main_region_StateB));
	}
	alwaysOncycle_runCycle(&handle);
	EXPECT_TRUE(alwaysOncycle_isActive(&handle, AlwaysOncycle_main_region_StateA));
}
