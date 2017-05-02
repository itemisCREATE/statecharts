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

TriggerGuardExpressions handle;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		triggerGuardExpressions_init(&handle);
	}
};


TEST_F(StatemachineTest, trueGuard) {					
	triggerGuardExpressions_enter(&handle);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&handle, TriggerGuardExpressions_main_region_A));
	triggerGuardExpressionsIface_raise_e1(&handle);
	triggerGuardExpressionsIface_set_b(&handle,true);
	triggerGuardExpressions_runCycle(&handle);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&handle, TriggerGuardExpressions_main_region_B));
	triggerGuardExpressions_runCycle(&handle);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&handle, TriggerGuardExpressions_main_region_A));
	triggerGuardExpressionsIface_raise_e2(&handle);
	triggerGuardExpressions_runCycle(&handle);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&handle, TriggerGuardExpressions_main_region_B));
	triggerGuardExpressions_runCycle(&handle);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&handle, TriggerGuardExpressions_main_region_A));
	triggerGuardExpressionsIface_raise_e1(&handle);
	triggerGuardExpressionsIface_raise_e2(&handle);
	triggerGuardExpressions_runCycle(&handle);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&handle, TriggerGuardExpressions_main_region_B));
}
TEST_F(StatemachineTest, falseGuard) {					
	triggerGuardExpressions_enter(&handle);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&handle, TriggerGuardExpressions_main_region_A));
	triggerGuardExpressionsIface_set_b(&handle,false);
	triggerGuardExpressionsIface_raise_e1(&handle);
	triggerGuardExpressions_runCycle(&handle);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&handle, TriggerGuardExpressions_main_region_A));
	triggerGuardExpressionsIface_raise_e2(&handle);
	triggerGuardExpressions_runCycle(&handle);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&handle, TriggerGuardExpressions_main_region_A));
	triggerGuardExpressionsIface_raise_e1(&handle);
	triggerGuardExpressionsIface_raise_e2(&handle);
	triggerGuardExpressions_runCycle(&handle);
	EXPECT_TRUE(triggerGuardExpressions_isStateActive(&handle, TriggerGuardExpressions_main_region_A));
}


