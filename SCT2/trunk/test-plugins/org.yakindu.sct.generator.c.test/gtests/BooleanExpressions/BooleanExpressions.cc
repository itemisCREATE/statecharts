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
#include "BooleanExpressions.h"


BooleanExpressions handle;

TEST(StatemachineTest, booleanExpressions) {
	booleanExpressions_init(&handle);
	booleanExpressions_enter(&handle);
	EXPECT_TRUE(booleanExpressions_isActive(&handle, BooleanExpressions_StateA));
	EXPECT_TRUE(booleanExpressionsIface_get_myBool1(&handle) == true);
	EXPECT_TRUE(booleanExpressionsIface_get_myBool2(&handle) == false);
	booleanExpressionsIface_raise_e1(&handle);
	booleanExpressions_runCycle(&handle);
	EXPECT_TRUE(booleanExpressions_isActive(&handle, BooleanExpressions_StateB));
	EXPECT_TRUE(booleanExpressionsIface_get_and(&handle) == false);
	EXPECT_TRUE(booleanExpressionsIface_get_or(&handle) == true);
	EXPECT_TRUE(booleanExpressionsIface_get_not(&handle) == false);
	EXPECT_TRUE(booleanExpressionsIface_get_equal(&handle) == false);
	EXPECT_TRUE(booleanExpressionsIface_get_notequal(&handle) == true);
}

		
