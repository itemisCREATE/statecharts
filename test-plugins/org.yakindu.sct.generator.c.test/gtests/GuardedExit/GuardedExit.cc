/**
* Copyright (c) 2015 committers of YAKINDU and others.
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


GuardedExit handle;

TEST(StatemachineTest, ExitTaken) {
	guardedExit_init(&handle);
	guardedExit_enter(&handle);
	EXPECT_TRUE(guardedExit_isStateActive(&handle, GuardedExit_main_region_A));
	EXPECT_TRUE(!guardedExitIface_get_guard(&handle) );
	guardedExitIface_raise_e(&handle);
	guardedExit_runCycle(&handle);
	EXPECT_TRUE(guardedExit_isStateActive(&handle, GuardedExit_main_region_B));
	EXPECT_TRUE(!guardedExitIface_get_done(&handle) );
}
TEST(StatemachineTest, ExitNotTaken) {
	guardedExit_init(&handle);
	guardedExit_enter(&handle);
	EXPECT_TRUE(guardedExit_isStateActive(&handle, GuardedExit_main_region_A));
	guardedExitIface_set_guard(&handle, true);
	guardedExitIface_raise_e(&handle);
	guardedExit_runCycle(&handle);
	EXPECT_TRUE(guardedExit_isStateActive(&handle, GuardedExit_main_region_B));
	EXPECT_TRUE(guardedExitIface_get_done(&handle) );
}

		
