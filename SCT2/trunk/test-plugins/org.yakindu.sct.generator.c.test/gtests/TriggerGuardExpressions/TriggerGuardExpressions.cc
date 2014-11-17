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
#include "TriggerGuardExpressions.h"


TriggerGuardExpressions handle;

TEST(StatemachineTest, trueGuard) {
	triggerGuardExpressions_init(&handle);
	triggerGuardExpressions_enter(&handle);
	EXPECT_TRUE(triggerGuardExpressions_isActive(&handle, TriggerGuardExpressions_main_region_A));
	triggerGuardExpressionsIface_raise_e1(&handle);
	triggerGuardExpressionsIface_set_b(&handle, true);
	triggerGuardExpressions_runCycle(&handle);
	EXPECT_TRUE(triggerGuardExpressions_isActive(&handle, TriggerGuardExpressions_main_region_B));
	triggerGuardExpressions_runCycle(&handle);
	EXPECT_TRUE(triggerGuardExpressions_isActive(&handle, TriggerGuardExpressions_main_region_A));
	triggerGuardExpressionsIface_raise_e2(&handle);
	triggerGuardExpressions_runCycle(&handle);
	EXPECT_TRUE(triggerGuardExpressions_isActive(&handle, TriggerGuardExpressions_main_region_B));
	triggerGuardExpressions_runCycle(&handle);
	EXPECT_TRUE(triggerGuardExpressions_isActive(&handle, TriggerGuardExpressions_main_region_A));
	triggerGuardExpressionsIface_raise_e1(&handle);
	triggerGuardExpressionsIface_raise_e2(&handle);
	triggerGuardExpressions_runCycle(&handle);
	EXPECT_TRUE(triggerGuardExpressions_isActive(&handle, TriggerGuardExpressions_main_region_B));
}
TEST(StatemachineTest, falseGuard) {
	triggerGuardExpressions_init(&handle);
	triggerGuardExpressions_enter(&handle);
	EXPECT_TRUE(triggerGuardExpressions_isActive(&handle, TriggerGuardExpressions_main_region_A));
	triggerGuardExpressionsIface_set_b(&handle, false);
	triggerGuardExpressionsIface_raise_e1(&handle);
	triggerGuardExpressions_runCycle(&handle);
	EXPECT_TRUE(triggerGuardExpressions_isActive(&handle, TriggerGuardExpressions_main_region_A));
	triggerGuardExpressionsIface_raise_e2(&handle);
	triggerGuardExpressions_runCycle(&handle);
	EXPECT_TRUE(triggerGuardExpressions_isActive(&handle, TriggerGuardExpressions_main_region_A));
	triggerGuardExpressionsIface_raise_e1(&handle);
	triggerGuardExpressionsIface_raise_e2(&handle);
	triggerGuardExpressions_runCycle(&handle);
	EXPECT_TRUE(triggerGuardExpressions_isActive(&handle, TriggerGuardExpressions_main_region_A));
}

		
