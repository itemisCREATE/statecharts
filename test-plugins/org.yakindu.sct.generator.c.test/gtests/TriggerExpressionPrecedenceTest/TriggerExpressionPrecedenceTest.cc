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
#include "TriggerExpressionPrecedence.h"

TriggerExpressionPrecedence handle;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		triggerExpressionPrecedence_init(&handle);
	}
};


TEST_F(StatemachineTest, unsatisfiedTriggerAndFGuardFalseOrFalse) {					
	triggerExpressionPrecedence_enter(&handle);
	triggerExpressionPrecedenceIface_set_c1(&handle,false);
	triggerExpressionPrecedenceIface_set_c2(&handle,false);
	triggerExpressionPrecedence_runCycle(&handle);
	EXPECT_TRUE(!triggerExpressionPrecedenceIface_get_e1_transition(&handle));
}
TEST_F(StatemachineTest, unsatisfiedTriggerAndFGuardTrueOrFalse) {					
	triggerExpressionPrecedence_enter(&handle);
	triggerExpressionPrecedenceIface_set_c1(&handle,true);
	triggerExpressionPrecedenceIface_set_c2(&handle,false);
	triggerExpressionPrecedence_runCycle(&handle);
	EXPECT_TRUE(!triggerExpressionPrecedenceIface_get_e1_transition(&handle));
}
TEST_F(StatemachineTest, unsatisfiedTriggerAndFGuardFalseOrTrue) {					
	triggerExpressionPrecedence_enter(&handle);
	triggerExpressionPrecedenceIface_set_c1(&handle,false);
	triggerExpressionPrecedenceIface_set_c2(&handle,true);
	triggerExpressionPrecedence_runCycle(&handle);
	EXPECT_TRUE(!triggerExpressionPrecedenceIface_get_e1_transition(&handle));
}
TEST_F(StatemachineTest, unsatisfiedTriggerAndFGuardTrueOrTrue) {					
	triggerExpressionPrecedence_enter(&handle);
	triggerExpressionPrecedenceIface_set_c1(&handle,true);
	triggerExpressionPrecedenceIface_set_c2(&handle,true);
	triggerExpressionPrecedence_runCycle(&handle);
	EXPECT_TRUE(!triggerExpressionPrecedenceIface_get_e1_transition(&handle));
}


