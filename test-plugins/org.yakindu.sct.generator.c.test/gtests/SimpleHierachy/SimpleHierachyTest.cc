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
#include "SimpleHierachy.h"

static SimpleHierachy statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		simpleHierachy_init(&statechart);
	}
};


TEST_F(StatemachineTest, simpleHierachyTest) {					
	simpleHierachy_enter(&statechart);
	EXPECT_TRUE(simpleHierachy_isStateActive(&statechart, SimpleHierachy_main_region_A));
	simpleHierachyIface_raise_event1(&statechart);
	simpleHierachyIface_raise_event1(&statechart);
	simpleHierachyIface_raise_event1(&statechart);
	simpleHierachy_runCycle(&statechart);
	EXPECT_TRUE(simpleHierachy_isStateActive(&statechart, SimpleHierachy_main_region_B));
	EXPECT_TRUE(simpleHierachy_isStateActive(&statechart, SimpleHierachy_main_region_B_subregion1_B1));
}


