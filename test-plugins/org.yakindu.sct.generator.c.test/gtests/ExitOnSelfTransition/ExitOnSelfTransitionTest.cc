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
#include "ExitOnSelfTransition.h"

static ExitOnSelfTransition statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		exitOnSelfTransition_init(&statechart);
	}
};


TEST_F(StatemachineTest, ExitOnSelfTransitionTest) {					
	exitOnSelfTransition_enter(&statechart);
	EXPECT_TRUE(exitOnSelfTransition_isStateActive(&statechart, ExitOnSelfTransition_main_region_A));
	EXPECT_TRUE(exitOnSelfTransitionIface_get_entryCount(&statechart)== 1l);
	EXPECT_TRUE(exitOnSelfTransitionIface_get_exitCount(&statechart)== 0l);
	exitOnSelfTransitionIface_raise_e(&statechart);
	exitOnSelfTransition_runCycle(&statechart);
	EXPECT_TRUE(exitOnSelfTransitionIface_get_entryCount(&statechart)== 2l);
	EXPECT_TRUE(exitOnSelfTransitionIface_get_exitCount(&statechart)== 1l);
	exitOnSelfTransitionIface_raise_f(&statechart);
	exitOnSelfTransition_runCycle(&statechart);
	EXPECT_TRUE(exitOnSelfTransitionIface_get_entryCount(&statechart)== 2l);
	EXPECT_TRUE(exitOnSelfTransitionIface_get_exitCount(&statechart)== 2l);
}


