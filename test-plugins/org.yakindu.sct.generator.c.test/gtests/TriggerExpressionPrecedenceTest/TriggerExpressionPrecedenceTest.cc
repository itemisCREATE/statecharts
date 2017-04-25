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
#include <string>
#include "gtest/gtest.h"
#include "TriggerExpressionPrecedence.h"

TriggerExpressionPrecedence handle;

TEST(StatemachineTest, unsatisfiedTriggerAndFGuardFalseOrFalse) {
	triggerExpressionPrecedence_init(&handle);
	
	triggerExpressionPrecedence_enter(&handle);
	triggerExpressionPrecedenceIface_set_c1(false);
	triggerExpressionPrecedenceIface_set_c2(false);
	triggerExpressionPrecedence_runCycle(&handle);
	EXPECT_TRUE(!triggerExpressionPrecedenceIface_get_e1_transition(&handle));
}
TEST(StatemachineTest, unsatisfiedTriggerAndFGuardTrueOrFalse) {
	triggerExpressionPrecedence_init(&handle);
	
	triggerExpressionPrecedence_enter(&handle);
	triggerExpressionPrecedenceIface_set_c1(true);
	triggerExpressionPrecedenceIface_set_c2(false);
	triggerExpressionPrecedence_runCycle(&handle);
	EXPECT_TRUE(!triggerExpressionPrecedenceIface_get_e1_transition(&handle));
}
TEST(StatemachineTest, unsatisfiedTriggerAndFGuardFalseOrTrue) {
	triggerExpressionPrecedence_init(&handle);
	
	triggerExpressionPrecedence_enter(&handle);
	triggerExpressionPrecedenceIface_set_c1(false);
	triggerExpressionPrecedenceIface_set_c2(true);
	triggerExpressionPrecedence_runCycle(&handle);
	EXPECT_TRUE(!triggerExpressionPrecedenceIface_get_e1_transition(&handle));
}
TEST(StatemachineTest, unsatisfiedTriggerAndFGuardTrueOrTrue) {
	triggerExpressionPrecedence_init(&handle);
	
	triggerExpressionPrecedence_enter(&handle);
	triggerExpressionPrecedenceIface_set_c1(true);
	triggerExpressionPrecedenceIface_set_c2(true);
	triggerExpressionPrecedence_runCycle(&handle);
	EXPECT_TRUE(!triggerExpressionPrecedenceIface_get_e1_transition(&handle));
}


