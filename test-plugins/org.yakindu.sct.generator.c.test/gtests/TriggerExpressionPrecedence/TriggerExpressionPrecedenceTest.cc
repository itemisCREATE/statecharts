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

static TriggerExpressionPrecedence statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		triggerExpressionPrecedence_init(&statechart);
	}
};


TEST_F(StatemachineTest, unsatisfiedTriggerAndFGuardFalseOrFalse) {					
	triggerExpressionPrecedence_enter(&statechart);
	triggerExpressionPrecedenceIface_set_c1(&statechart,false);
	triggerExpressionPrecedenceIface_set_c2(&statechart,false);
	triggerExpressionPrecedence_runCycle(&statechart);
	EXPECT_TRUE(!triggerExpressionPrecedenceIface_get_e1_transition(&statechart));
}
TEST_F(StatemachineTest, unsatisfiedTriggerAndFGuardTrueOrFalse) {					
	triggerExpressionPrecedence_enter(&statechart);
	triggerExpressionPrecedenceIface_set_c1(&statechart,true);
	triggerExpressionPrecedenceIface_set_c2(&statechart,false);
	triggerExpressionPrecedence_runCycle(&statechart);
	EXPECT_TRUE(!triggerExpressionPrecedenceIface_get_e1_transition(&statechart));
}
TEST_F(StatemachineTest, unsatisfiedTriggerAndFGuardFalseOrTrue) {					
	triggerExpressionPrecedence_enter(&statechart);
	triggerExpressionPrecedenceIface_set_c1(&statechart,false);
	triggerExpressionPrecedenceIface_set_c2(&statechart,true);
	triggerExpressionPrecedence_runCycle(&statechart);
	EXPECT_TRUE(!triggerExpressionPrecedenceIface_get_e1_transition(&statechart));
}
TEST_F(StatemachineTest, unsatisfiedTriggerAndFGuardTrueOrTrue) {					
	triggerExpressionPrecedence_enter(&statechart);
	triggerExpressionPrecedenceIface_set_c1(&statechart,true);
	triggerExpressionPrecedenceIface_set_c2(&statechart,true);
	triggerExpressionPrecedence_runCycle(&statechart);
	EXPECT_TRUE(!triggerExpressionPrecedenceIface_get_e1_transition(&statechart));
}


