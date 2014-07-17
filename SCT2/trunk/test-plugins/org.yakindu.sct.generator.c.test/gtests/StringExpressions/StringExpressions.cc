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
#include "StringExpressions.h"


StringExpressions handle;

TEST(StatemachineTest, StringExpressionsTest) {
	stringExpressions_init(&handle);
	EXPECT_TRUE(strcmp(stringExpressionsIface_get_quotedStringX(&handle) , "\"X\"") == 0);
	EXPECT_TRUE(strcmp(stringExpressionsIface_get_quotedStringY(&handle) , "\"Y\"") == 0);
	stringExpressions_enter(&handle);
	EXPECT_TRUE(stringExpressions_isActive(&handle, StringExpressions_AssgnmntChckd));
	stringExpressionsIface_raise_e(&handle);
	stringExpressions_runCycle(&handle);
	EXPECT_TRUE(stringExpressions_isActive(&handle, StringExpressions_2));
	EXPECT_TRUE(stringExpressionsIface_get_guardStringEqual(&handle) );
	EXPECT_TRUE(stringExpressionsIface_get_guardStringNotEqual(&handle) );
	EXPECT_TRUE(stringExpressionsIface_get_stringVarEqual(&handle) );
	EXPECT_TRUE(stringExpressionsIface_get_stringVarNotEqual(&handle) );
	stringExpressionsIface_raise_e(&handle);
	stringExpressions_runCycle(&handle);
	EXPECT_TRUE(stringExpressions_isActive(&handle, StringExpressions_3));
	EXPECT_TRUE(stringExpressionsIface_get_guardStringEqual(&handle) );
	EXPECT_TRUE(stringExpressionsIface_get_guardStringNotEqual(&handle) );
	EXPECT_TRUE(stringExpressionsIface_get_stringVarEqual(&handle) );
	EXPECT_TRUE(stringExpressionsIface_get_stringVarNotEqual(&handle) );
	stringExpressionsIface_raise_e(&handle);
	stringExpressions_runCycle(&handle);
	EXPECT_TRUE(stringExpressions_isActive(&handle, StringExpressions_4));
	EXPECT_TRUE(stringExpressionsIface_get_guardStringEqual(&handle) );
	EXPECT_TRUE(stringExpressionsIface_get_guardStringNotEqual(&handle) );
	EXPECT_TRUE(stringExpressionsIface_get_stringVarEqual(&handle) );
	EXPECT_TRUE(stringExpressionsIface_get_stringVarNotEqual(&handle) );
	stringExpressionsIface_raise_e(&handle);
	stringExpressions_runCycle(&handle);
	EXPECT_TRUE(stringExpressions_isActive(&handle, StringExpressions_5));
	EXPECT_TRUE(stringExpressionsIface_get_guardStringEqual(&handle) );
	EXPECT_TRUE(stringExpressionsIface_get_guardStringNotEqual(&handle) );
	EXPECT_TRUE(stringExpressionsIface_get_stringVarEqual(&handle) );
	EXPECT_TRUE(stringExpressionsIface_get_stringVarNotEqual(&handle) );
}

		
