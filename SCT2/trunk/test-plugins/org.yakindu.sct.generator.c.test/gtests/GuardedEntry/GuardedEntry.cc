/**
* Copyright (c) 2012 committers of YAKINDU and others.
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

TEST(StatemachineTest, EntryNotTakenOnStatechartEnter) {
	GuardedEntry handle;
	guardedEntry_init(&handle);
	guardedEntry_enter(&handle);
	EXPECT_TRUE(guardedEntry_isActive(&handle, GuardedEntry_main_region_A));
	EXPECT_TRUE(guardedEntryIface_get_done(&handle) == false);
}
TEST(StatemachineTest, EntryTakenOnStatechartEnter) {
	GuardedEntry handle;
	guardedEntry_init(&handle);
	guardedEntry_enter(&handle);
	guardedEntryIface_set_guard(true);
	EXPECT_TRUE(false);
	EXPECT_TRUE(guardedEntry_isActive(&handle, GuardedEntry_main_region_A));
	EXPECT_TRUE(guardedEntryIface_get_done(&handle) == true);
}
TEST(StatemachineTest, EntryTakenInTransition) {
	GuardedEntry handle;
	guardedEntry_init(&handle);
	guardedEntry_enter(&handle);
	EXPECT_TRUE(guardedEntry_isActive(&handle, GuardedEntry_main_region_A));
	guardedEntryIface_raise_e(&handle);
	guardedEntry_runCycle(&handle);
	EXPECT_TRUE(guardedEntry_isActive(&handle, GuardedEntry_main_region_B));
	guardedEntryIface_set_guard(true);
	guardedEntryIface_set_done(false);
	guardedEntryIface_raise_e(&handle);
	guardedEntry_runCycle(&handle);
	EXPECT_TRUE(guardedEntry_isActive(&handle, GuardedEntry_main_region_A));
	EXPECT_TRUE(guardedEntryIface_get_done(&handle));
}
TEST(StatemachineTest, EntryNotTakenInTransition) {
	GuardedEntry handle;
	guardedEntry_init(&handle);
	guardedEntry_enter(&handle);
	EXPECT_TRUE(guardedEntry_isActive(&handle, GuardedEntry_main_region_A));
	guardedEntryIface_raise_e(&handle);
	guardedEntry_runCycle(&handle);
	EXPECT_TRUE(guardedEntry_isActive(&handle, GuardedEntry_main_region_B));
	guardedEntryIface_set_guard(false);
	guardedEntryIface_set_done(false);
	guardedEntryIface_raise_e(&handle);
	guardedEntry_runCycle(&handle);
	EXPECT_TRUE(guardedEntry_isActive(&handle, GuardedEntry_main_region_A));
	EXPECT_TRUE(!guardedEntryIface_get_done(&handle));
}
