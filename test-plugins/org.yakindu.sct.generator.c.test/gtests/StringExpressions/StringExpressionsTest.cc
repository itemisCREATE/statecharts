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
#include "StringExpressions.h"

static StringExpressions statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		stringExpressions_init(&statechart);
	}
};


TEST_F(StatemachineTest, StringExpressionsTest) {					
	EXPECT_TRUE(strcmp(stringExpressionsIface_get_quotedStringX(&statechart), "\"X\"") == 0);
	EXPECT_TRUE(strcmp(stringExpressionsIface_get_quotedStringY(&statechart), "\"Y\"") == 0);
	stringExpressions_enter(&statechart);
	EXPECT_TRUE(stringExpressions_isStateActive(&statechart, StringExpressions_AssignmentChecked));
	stringExpressionsIface_raise_e(&statechart);
	stringExpressions_runCycle(&statechart);
	EXPECT_TRUE(stringExpressions_isStateActive(&statechart, StringExpressions_VarToVarCompareSucceeded));
	EXPECT_TRUE(stringExpressionsIface_get_guardStringEqual(&statechart));
	EXPECT_TRUE(stringExpressionsIface_get_guardStringNotEqual(&statechart));
	EXPECT_TRUE(stringExpressionsIface_get_stringVarEqual(&statechart));
	EXPECT_TRUE(stringExpressionsIface_get_stringVarNotEqual(&statechart));
	stringExpressionsIface_raise_e(&statechart);
	stringExpressions_runCycle(&statechart);
	EXPECT_TRUE(stringExpressions_isStateActive(&statechart, StringExpressions_VarToConstCompareSucceeded));
	EXPECT_TRUE(stringExpressionsIface_get_guardStringEqual(&statechart));
	EXPECT_TRUE(stringExpressionsIface_get_guardStringNotEqual(&statechart));
	EXPECT_TRUE(stringExpressionsIface_get_stringVarEqual(&statechart));
	EXPECT_TRUE(stringExpressionsIface_get_stringVarNotEqual(&statechart));
	stringExpressionsIface_raise_e(&statechart);
	stringExpressions_runCycle(&statechart);
	EXPECT_TRUE(stringExpressions_isStateActive(&statechart, StringExpressions_ConstToVarCompareSucceeded));
	EXPECT_TRUE(stringExpressionsIface_get_guardStringEqual(&statechart));
	EXPECT_TRUE(stringExpressionsIface_get_guardStringNotEqual(&statechart));
	EXPECT_TRUE(stringExpressionsIface_get_stringVarEqual(&statechart));
	EXPECT_TRUE(stringExpressionsIface_get_stringVarNotEqual(&statechart));
	stringExpressionsIface_raise_e(&statechart);
	stringExpressions_runCycle(&statechart);
	EXPECT_TRUE(stringExpressions_isStateActive(&statechart, StringExpressions_ConstToConstCompareSucceeded));
	EXPECT_TRUE(stringExpressionsIface_get_guardStringEqual(&statechart));
	EXPECT_TRUE(stringExpressionsIface_get_guardStringNotEqual(&statechart));
	EXPECT_TRUE(stringExpressionsIface_get_stringVarEqual(&statechart));
	EXPECT_TRUE(stringExpressionsIface_get_stringVarNotEqual(&statechart));
}


