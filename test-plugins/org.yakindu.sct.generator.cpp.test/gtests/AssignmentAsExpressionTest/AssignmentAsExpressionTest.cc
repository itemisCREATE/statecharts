/**
* Copyright (c) 2015 committers of YAKINDU and others.
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
#include "AssignmentAsExpression.h"

TEST(StatemachineTest, simpleAssignment) {
	AssignmentAsExpression* statechart = new AssignmentAsExpression();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(AssignmentAsExpression::main_region_Add));
	EXPECT_TRUE(statechart->getDefaultSCI()->get_b()== 5);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_a()== 9);
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(AssignmentAsExpression::main_region_Subtract));
	EXPECT_TRUE(statechart->getDefaultSCI()->get_d()== 6);
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(AssignmentAsExpression::main_region_Multiply));
	EXPECT_TRUE(statechart->getDefaultSCI()->get_e()== 15);
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(AssignmentAsExpression::main_region_Divide));
	EXPECT_TRUE(statechart->getDefaultSCI()->get_g()== 1);
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(AssignmentAsExpression::main_region_Modulo));
	EXPECT_TRUE(statechart->getDefaultSCI()->get_i()== 1);
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(AssignmentAsExpression::main_region_Shift));
	EXPECT_TRUE(statechart->getDefaultSCI()->get_j()== 16);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_k()== 4);
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(AssignmentAsExpression::main_region_boolean_And));
	EXPECT_TRUE(statechart->getDefaultSCI()->get_l()== 1);
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(AssignmentAsExpression::main_region_boolean_Or));
	EXPECT_TRUE(statechart->getDefaultSCI()->get_p()== 15);
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(AssignmentAsExpression::main_region_boolean_Xor));
	EXPECT_TRUE(statechart->getDefaultSCI()->get_u()== 12);
	statechart->exit();
	delete statechart;
}
