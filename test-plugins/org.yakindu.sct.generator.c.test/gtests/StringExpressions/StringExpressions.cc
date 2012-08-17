/**
* Copyright (c) 2012 committers of YAKINDU and others.
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

TEST(StatemachineTest, StringExpressionsTest) {
	StringExpressions handle;
	stringExpressions_init(&handle);
	stringExpressions_enter(&handle);
	EXPECT_TRUE(stringExpressions_isActive(&handle, StringExpressions_main_region_StateA));
	EXPECT_TRUE(stringExpressionsIface_get_myString(&handle).equals("hello"));
	EXPECT_TRUE(stringExpressionsIface_get_myString2(&handle).equals("world"));
	stringExpressionsIface_raise_e1(&handle);
	stringExpressions_runCycle(&handle);
	EXPECT_TRUE(stringExpressions_isActive(&handle, StringExpressions_main_region_StateB));
	EXPECT_TRUE(stringExpressionsIface_get_equals(&handle) == false);
	EXPECT_TRUE(stringExpressionsIface_get_notEqual(&handle) == true);
}
