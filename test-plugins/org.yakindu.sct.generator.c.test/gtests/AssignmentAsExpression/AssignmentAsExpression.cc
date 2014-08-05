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
#include "AssignmentAsExpression.h"


AssignmentAsExpression handle;

TEST(StatemachineTest, simpleAssignment) {
	assignmentAsExpression_init(&handle);
	assignmentAsExpression_enter(&handle);
	EXPECT_TRUE(assignmentAsExpression_isActive(&handle, AssignmentAsExpression_Add));
	EXPECT_TRUE(assignmentAsExpressionIface_get_b(&handle) == 5);
	EXPECT_TRUE(assignmentAsExpressionIface_get_a(&handle) == 9);
	assignmentAsExpression_runCycle(&handle);
	EXPECT_TRUE(assignmentAsExpression_isActive(&handle, AssignmentAsExpression_Subtract));
	EXPECT_TRUE(assignmentAsExpressionIface_get_d(&handle) == 6);
	assignmentAsExpression_runCycle(&handle);
	EXPECT_TRUE(assignmentAsExpression_isActive(&handle, AssignmentAsExpression_Multiply));
	EXPECT_TRUE(assignmentAsExpressionIface_get_e(&handle) == 15);
	assignmentAsExpression_runCycle(&handle);
	EXPECT_TRUE(assignmentAsExpression_isActive(&handle, AssignmentAsExpression_Divide));
	EXPECT_TRUE(assignmentAsExpressionIface_get_g(&handle) == 1);
	assignmentAsExpression_runCycle(&handle);
	EXPECT_TRUE(assignmentAsExpression_isActive(&handle, AssignmentAsExpression_Modulo));
	EXPECT_TRUE(assignmentAsExpressionIface_get_i(&handle) == 1);
	assignmentAsExpression_runCycle(&handle);
	EXPECT_TRUE(assignmentAsExpression_isActive(&handle, AssignmentAsExpression_Shift));
	EXPECT_TRUE(assignmentAsExpressionIface_get_j(&handle) == 16);
	EXPECT_TRUE(assignmentAsExpressionIface_get_k(&handle) == 4);
	assignmentAsExpression_runCycle(&handle);
	EXPECT_TRUE(assignmentAsExpression_isActive(&handle, AssignmentAsExpression_boolean_And));
	EXPECT_TRUE(assignmentAsExpressionIface_get_l(&handle) == 1);
	assignmentAsExpression_runCycle(&handle);
	EXPECT_TRUE(assignmentAsExpression_isActive(&handle, AssignmentAsExpression_boolean_Or));
	EXPECT_TRUE(assignmentAsExpressionIface_get_p(&handle) == 15);
	assignmentAsExpression_runCycle(&handle);
	EXPECT_TRUE(assignmentAsExpression_isActive(&handle, AssignmentAsExpression_boolean_Xor));
	EXPECT_TRUE(assignmentAsExpressionIface_get_u(&handle) == 12);
	assignmentAsExpression_exit(&handle);
}

		
