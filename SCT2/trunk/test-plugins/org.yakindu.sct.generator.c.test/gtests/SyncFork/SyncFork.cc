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
#include "SyncFork.h"


SyncFork handle;

TEST(StatemachineTest, syncForkTest) {
	syncFork_init(&handle);
	syncFork_enter(&handle);
	EXPECT_TRUE(syncFork_isActive(&handle, SyncFork_A));
	syncForkIface_raise_f(&handle);
	syncFork_runCycle(&handle);
	EXPECT_TRUE(syncFork_isActive(&handle, SyncFork_B));
	EXPECT_TRUE(syncFork_isActive(&handle, SyncFork_C1));
	EXPECT_TRUE(syncFork_isActive(&handle, SyncFork_D1));
	syncForkIface_raise_f(&handle);
	syncFork_runCycle(&handle);
	EXPECT_TRUE(syncFork_isActive(&handle, SyncFork_B));
	EXPECT_TRUE(syncFork_isActive(&handle, SyncFork_C2));
	EXPECT_TRUE(syncFork_isActive(&handle, SyncFork_D2));
	syncForkIface_raise_e(&handle);
	syncFork_runCycle(&handle);
	EXPECT_TRUE(syncFork_isActive(&handle, SyncFork_A));
	syncForkIface_raise_f(&handle);
	syncFork_runCycle(&handle);
	EXPECT_TRUE(syncFork_isActive(&handle, SyncFork_B));
	EXPECT_TRUE(syncFork_isActive(&handle, SyncFork_C1));
	EXPECT_TRUE(syncFork_isActive(&handle, SyncFork_D1));
}

		
