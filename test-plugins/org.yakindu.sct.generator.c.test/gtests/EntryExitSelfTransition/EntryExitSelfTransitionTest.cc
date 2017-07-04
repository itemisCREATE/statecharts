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
#include "EntryExitSelfTransition.h"

static EntryExitSelfTransition statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		entryExitSelfTransition_init(&statechart);
	}
};

void init(){
	entryExitSelfTransition_enter(&statechart);
	entryExitSelfTransition_runCycle(&statechart);
	EXPECT_TRUE(entryExitSelfTransitionIface_get_entries(&statechart)== 1l);
	EXPECT_TRUE(entryExitSelfTransition_isStateActive(&statechart, EntryExitSelfTransition_main_region_A__region0_B));
	entryExitSelfTransitionIface_set_entries(&statechart,0l);
}

TEST_F(StatemachineTest, SelfTransitionToChildState) {					
	init();
	entryExitSelfTransitionIface_raise_e(&statechart);
	entryExitSelfTransition_runCycle(&statechart);
	EXPECT_TRUE(entryExitSelfTransitionIface_get_entries(&statechart)== 1l);
	EXPECT_TRUE(entryExitSelfTransitionIface_get_exits(&statechart)== 1l);
	EXPECT_TRUE(entryExitSelfTransition_isStateActive(&statechart, EntryExitSelfTransition_main_region_A__region0_C));
	entryExitSelfTransition_exit(&statechart);
}
TEST_F(StatemachineTest, SelfTransitionFromChildState) {					
	init();
	entryExitSelfTransitionIface_raise_e1(&statechart);
	entryExitSelfTransition_runCycle(&statechart);
	EXPECT_TRUE(entryExitSelfTransitionIface_get_entries(&statechart)== 0l);
	EXPECT_TRUE(entryExitSelfTransitionIface_get_exits(&statechart)== 0l);
	EXPECT_TRUE(entryExitSelfTransition_isStateActive(&statechart, EntryExitSelfTransition_main_region_A__region0_C));
	entryExitSelfTransitionIface_raise_e1(&statechart);
	entryExitSelfTransition_runCycle(&statechart);
	EXPECT_TRUE(entryExitSelfTransition_isStateActive(&statechart, EntryExitSelfTransition_main_region_A__region0_B));
	EXPECT_TRUE(entryExitSelfTransitionIface_get_entries(&statechart)== 1l);
	EXPECT_TRUE(entryExitSelfTransitionIface_get_exits(&statechart)== 1l);
	entryExitSelfTransition_exit(&statechart);
}


