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
#include "TriggerGuardExpressions.h"

static TriggerGuardExpressions statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		triggerGuardExpressions_init(&statechart);
	}
};


TEST_F(StatemachineTest, trueGuard) {					
	triggerGuardExpressions_enter(&statechart);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&statechart, TriggerGuardExpressions_main_region_A));
	triggerGuardExpressionsIface_raise_e1(&statechart);
	triggerGuardExpressionsIface_set_b(&statechart,true);
	triggerGuardExpressions_runCycle(&statechart);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&statechart, TriggerGuardExpressions_main_region_B));
	triggerGuardExpressions_runCycle(&statechart);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&statechart, TriggerGuardExpressions_main_region_A));
	triggerGuardExpressionsIface_raise_e2(&statechart);
	triggerGuardExpressions_runCycle(&statechart);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&statechart, TriggerGuardExpressions_main_region_B));
	triggerGuardExpressions_runCycle(&statechart);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&statechart, TriggerGuardExpressions_main_region_A));
	triggerGuardExpressionsIface_raise_e1(&statechart);
	triggerGuardExpressionsIface_raise_e2(&statechart);
	triggerGuardExpressions_runCycle(&statechart);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&statechart, TriggerGuardExpressions_main_region_B));
}
TEST_F(StatemachineTest, falseGuard) {					
	triggerGuardExpressions_enter(&statechart);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&statechart, TriggerGuardExpressions_main_region_A));
	triggerGuardExpressionsIface_set_b(&statechart,false);
	triggerGuardExpressionsIface_raise_e1(&statechart);
	triggerGuardExpressions_runCycle(&statechart);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&statechart, TriggerGuardExpressions_main_region_A));
	triggerGuardExpressionsIface_raise_e2(&statechart);
	triggerGuardExpressions_runCycle(&statechart);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&statechart, TriggerGuardExpressions_main_region_A));
	triggerGuardExpressionsIface_raise_e1(&statechart);
	triggerGuardExpressionsIface_raise_e2(&statechart);
	triggerGuardExpressions_runCycle(&statechart);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&statechart, TriggerGuardExpressions_main_region_A));
}


