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


AssignmentAsExpression handle;

TEST(StatemachineTest, simpleAssignment) {
	assignmentAsExpression_init(&handle);
	assignmentAsExpression_enter(&handle);
	EXPECT_TRUE(assignmentAsExpression_isActive(&handle, AssignmentAsExpression_main_region_Add));
	EXPECT_TRUE(assignmentAsExpressionIface_get_b(&handle) == 5l);
	EXPECT_TRUE(assignmentAsExpressionIface_get_a(&handle) == 9l);
	assignmentAsExpression_runCycle(&handle);
	EXPECT_TRUE(assignmentAsExpression_isActive(&handle, AssignmentAsExpression_main_region_Subtract));
	EXPECT_TRUE(assignmentAsExpressionIface_get_d(&handle) == 6l);
	assignmentAsExpression_runCycle(&handle);
	EXPECT_TRUE(assignmentAsExpression_isActive(&handle, AssignmentAsExpression_main_region_Multiply));
	EXPECT_TRUE(assignmentAsExpressionIface_get_e(&handle) == 15l);
	assignmentAsExpression_runCycle(&handle);
	EXPECT_TRUE(assignmentAsExpression_isActive(&handle, AssignmentAsExpression_main_region_Divide));
	EXPECT_TRUE(assignmentAsExpressionIface_get_g(&handle) == 1l);
	assignmentAsExpression_runCycle(&handle);
	EXPECT_TRUE(assignmentAsExpression_isActive(&handle, AssignmentAsExpression_main_region_Modulo));
	EXPECT_TRUE(assignmentAsExpressionIface_get_i(&handle) == 1l);
	assignmentAsExpression_runCycle(&handle);
	EXPECT_TRUE(assignmentAsExpression_isActive(&handle, AssignmentAsExpression_main_region_Shift));
	EXPECT_TRUE(assignmentAsExpressionIface_get_j(&handle) == 16l);
	EXPECT_TRUE(assignmentAsExpressionIface_get_k(&handle) == 4l);
	assignmentAsExpression_runCycle(&handle);
	EXPECT_TRUE(assignmentAsExpression_isActive(&handle, AssignmentAsExpression_main_region_boolean_And));
	EXPECT_TRUE(assignmentAsExpressionIface_get_l(&handle) == 1l);
	assignmentAsExpression_runCycle(&handle);
	EXPECT_TRUE(assignmentAsExpression_isActive(&handle, AssignmentAsExpression_main_region_boolean_Or));
	EXPECT_TRUE(assignmentAsExpressionIface_get_p(&handle) == 15l);
	assignmentAsExpression_runCycle(&handle);
	EXPECT_TRUE(assignmentAsExpression_isActive(&handle, AssignmentAsExpression_main_region_boolean_Xor));
	EXPECT_TRUE(assignmentAsExpressionIface_get_u(&handle) == 12l);
	assignmentAsExpression_exit(&handle);
}

		
