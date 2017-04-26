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
#include "sc_types.h"
TriggerExpressionPrecedence* statechart = new TriggerExpressionPrecedence();

TEST(StatemachineTest, unsatisfiedTriggerAndFGuardFalseOrFalse) {
	
	
	statechart->init();
	statechart->enter();
	
	statechart->getDefaultSCI()->set_c1(false);
	
	statechart->getDefaultSCI()->set_c2(false);
	
	statechart->runCycle();
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_e1_transition());
	
	delete statechart;
}
TEST(StatemachineTest, unsatisfiedTriggerAndFGuardTrueOrFalse) {
	
	
	statechart->init();
	statechart->enter();
	
	statechart->getDefaultSCI()->set_c1(true);
	
	statechart->getDefaultSCI()->set_c2(false);
	
	statechart->runCycle();
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_e1_transition());
	
	delete statechart;
}
TEST(StatemachineTest, unsatisfiedTriggerAndFGuardFalseOrTrue) {
	
	
	statechart->init();
	statechart->enter();
	
	statechart->getDefaultSCI()->set_c1(false);
	
	statechart->getDefaultSCI()->set_c2(true);
	
	statechart->runCycle();
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_e1_transition());
	
	delete statechart;
}
TEST(StatemachineTest, unsatisfiedTriggerAndFGuardTrueOrTrue) {
	
	
	statechart->init();
	statechart->enter();
	
	statechart->getDefaultSCI()->set_c1(true);
	
	statechart->getDefaultSCI()->set_c2(true);
	
	statechart->runCycle();
	
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_e1_transition());
	
	delete statechart;
}
