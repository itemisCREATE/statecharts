/**
* Copyright (c) 2013 committers of YAKINDU and others.
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
	EXPECT_TRUE(statechart->isActive(AssignmentAsExpression::AssignmentAsExpression_main_region_Add));
	EXPECT_TRUE(statechart->getSCInterface()->get_b()== 5);
	EXPECT_TRUE(statechart->getSCInterface()->get_a()== 9);
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(AssignmentAsExpression::AssignmentAsExpression_main_region_Subtract));
	EXPECT_TRUE(statechart->getSCInterface()->get_d()== 6);
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(AssignmentAsExpression::AssignmentAsExpression_main_region_Multiply));
	EXPECT_TRUE(statechart->getSCInterface()->get_e()== 15);
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(AssignmentAsExpression::AssignmentAsExpression_main_region_Divide));
	EXPECT_TRUE(statechart->getSCInterface()->get_g()== 1);
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(AssignmentAsExpression::AssignmentAsExpression_main_region_Modulo));
	EXPECT_TRUE(statechart->getSCInterface()->get_i()== 1);
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(AssignmentAsExpression::AssignmentAsExpression_main_region_Shift));
	EXPECT_TRUE(statechart->getSCInterface()->get_j()== 16);
	EXPECT_TRUE(statechart->getSCInterface()->get_k()== 4);
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(AssignmentAsExpression::AssignmentAsExpression_main_region_boolean_And));
	EXPECT_TRUE(statechart->getSCInterface()->get_l()== 1);
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(AssignmentAsExpression::AssignmentAsExpression_main_region_boolean_Or));
	EXPECT_TRUE(statechart->getSCInterface()->get_p()== 15);
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(AssignmentAsExpression::AssignmentAsExpression_main_region_boolean_Xor));
	EXPECT_TRUE(statechart->getSCInterface()->get_u()== 12);
	statechart->exit();
	delete statechart;
}
