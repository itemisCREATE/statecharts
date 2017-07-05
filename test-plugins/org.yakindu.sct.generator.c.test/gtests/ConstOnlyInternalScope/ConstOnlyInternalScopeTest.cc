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
#include "ConstOnlyInternalScope.h"

static ConstOnlyInternalScope statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		constOnlyInternalScope_init(&statechart);
	}
};


TEST_F(StatemachineTest, statechartEntry) {					
	constOnlyInternalScope_enter(&statechart);
	EXPECT_TRUE(constOnlyInternalScope_isStateActive(&statechart, ConstOnlyInternalScope_ConstOnlyInternalScope_main_region_A));
}
TEST_F(StatemachineTest, stateTransition) {					
	constOnlyInternalScope_enter(&statechart);
	constOnlyInternalScopeIface_raise_e(&statechart, 1l);
	constOnlyInternalScope_runCycle(&statechart);
	EXPECT_TRUE(constOnlyInternalScope_isStateActive(&statechart, ConstOnlyInternalScope_ConstOnlyInternalScope_main_region_B));
}


