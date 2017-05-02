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
#include "GuardedEntry.h"

GuardedEntry handle;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		guardedEntry_init(&handle);
	}
};

void initEntryInTransition(bool guardVar, bool doneVar){
	guardedEntry_enter(&handle);
	EXPECT_TRUE(guardedEntry_isStateActive(&handle, GuardedEntry_main_region_A));
	guardedEntryIface_raise_e(&handle);
	guardedEntry_runCycle(&handle);
	EXPECT_TRUE(guardedEntry_isStateActive(&handle, GuardedEntry_main_region_B));
	guardedEntryIface_set_guard(&handle,guardVar);
	guardedEntryIface_set_done(&handle,doneVar);
	guardedEntryIface_raise_e(&handle);
	guardedEntry_runCycle(&handle);
	EXPECT_TRUE(guardedEntry_isStateActive(&handle, GuardedEntry_main_region_A));
}

TEST_F(StatemachineTest, EntryNotTakenOnStatechartEnter) {					
	EXPECT_TRUE(guardedEntryIface_get_guard(&handle)== false);
	guardedEntry_enter(&handle);
	EXPECT_TRUE(guardedEntry_isStateActive(&handle, GuardedEntry_main_region_A));
	EXPECT_TRUE(guardedEntryIface_get_done(&handle)== false);
}
TEST_F(StatemachineTest, EntryTakenOnStatechartEnter) {					
	guardedEntryIface_set_guard(&handle,true);
	guardedEntry_enter(&handle);
	EXPECT_TRUE(guardedEntry_isStateActive(&handle, GuardedEntry_main_region_A));
	EXPECT_TRUE(guardedEntryIface_get_done(&handle)== true);
}
TEST_F(StatemachineTest, EntryTakenInTransition) {					
	initEntryInTransition(true,false);
	EXPECT_TRUE(guardedEntryIface_get_done(&handle));
}
TEST_F(StatemachineTest, EntryNotTakenInTransition) {					
	initEntryInTransition(false,false);
	EXPECT_TRUE(!guardedEntryIface_get_done(&handle));
}


