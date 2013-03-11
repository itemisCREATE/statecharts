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
#include "GuardedExit.h"

TEST(StatemachineTest, ExitTaken) {
	GuardedExit handle;
	guardedExit_init(&handle);
	guardedExit_enter(&handle);
	EXPECT_TRUE(guardedExit_isActive(&handle, GuardedExit_main_region_A));
	EXPECT_TRUE(!guardedExitIface_get_guard(&handle) );
	guardedExitIface_raise_e(&handle);
	guardedExit_runCycle(&handle);
	EXPECT_TRUE(guardedExit_isActive(&handle, GuardedExit_main_region_B));
	EXPECT_TRUE(!guardedExitIface_get_done(&handle) );
}
TEST(StatemachineTest, ExitNotTaken) {
	GuardedExit handle;
	guardedExit_init(&handle);
	guardedExit_enter(&handle);
	EXPECT_TRUE(guardedExit_isActive(&handle, GuardedExit_main_region_A));
	guardedExitIface_set_guard(&handle, true);
	guardedExitIface_raise_e(&handle);
	guardedExit_runCycle(&handle);
	EXPECT_TRUE(guardedExit_isActive(&handle, GuardedExit_main_region_B));
	EXPECT_TRUE(guardedExitIface_get_done(&handle) );
}
