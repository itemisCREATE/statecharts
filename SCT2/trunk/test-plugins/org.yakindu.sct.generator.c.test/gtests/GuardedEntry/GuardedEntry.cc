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
#include "GuardedEntry.h"


GuardedEntry handle;

TEST(StatemachineTest, EntryNotTakenOnStatechartEnter) {
	guardedEntry_init(&handle);
	EXPECT_TRUE(guardedEntryIface_get_guard(&handle) == false);
	guardedEntry_enter(&handle);
	EXPECT_TRUE(guardedEntry_isActive(&handle, GuardedEntry_main_region_A));
	EXPECT_TRUE(guardedEntryIface_get_done(&handle) == false);
}
TEST(StatemachineTest, EntryTakenOnStatechartEnter) {
	guardedEntry_init(&handle);
	guardedEntryIface_set_guard(&handle, true);
	guardedEntry_enter(&handle);
	EXPECT_TRUE(guardedEntry_isActive(&handle, GuardedEntry_main_region_A));
	EXPECT_TRUE(guardedEntryIface_get_done(&handle) == true);
}
TEST(StatemachineTest, EntryTakenInTransition) {
	guardedEntry_init(&handle);
	guardedEntry_enter(&handle);
	EXPECT_TRUE(guardedEntry_isActive(&handle, GuardedEntry_main_region_A));
	guardedEntryIface_raise_e(&handle);
	guardedEntry_runCycle(&handle);
	EXPECT_TRUE(guardedEntry_isActive(&handle, GuardedEntry_main_region_B));
	guardedEntryIface_set_guard(&handle, true);
	guardedEntryIface_set_done(&handle, false);
	guardedEntryIface_raise_e(&handle);
	guardedEntry_runCycle(&handle);
	EXPECT_TRUE(guardedEntry_isActive(&handle, GuardedEntry_main_region_A));
	EXPECT_TRUE(guardedEntryIface_get_done(&handle) );
}
TEST(StatemachineTest, EntryNotTakenInTransition) {
	guardedEntry_init(&handle);
	guardedEntry_enter(&handle);
	EXPECT_TRUE(guardedEntry_isActive(&handle, GuardedEntry_main_region_A));
	guardedEntryIface_raise_e(&handle);
	guardedEntry_runCycle(&handle);
	EXPECT_TRUE(guardedEntry_isActive(&handle, GuardedEntry_main_region_B));
	guardedEntryIface_set_guard(&handle, false);
	guardedEntryIface_set_done(&handle, false);
	guardedEntryIface_raise_e(&handle);
	guardedEntry_runCycle(&handle);
	EXPECT_TRUE(guardedEntry_isActive(&handle, GuardedEntry_main_region_A));
	EXPECT_TRUE(!guardedEntryIface_get_done(&handle) );
}

		
