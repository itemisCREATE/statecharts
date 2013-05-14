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
#include "BooleanExpressions.h"

TEST(StatemachineTest, booleanExpressions) {
	BooleanExpressions handle;
	booleanExpressions_init(&handle);
	booleanExpressions_enter(&handle);
	EXPECT_TRUE(booleanExpressions_isActive(&handle, BooleanExpressions_main_region_StateA));
	EXPECT_TRUE(booleanExpressionsIface_get_myBool1(&handle) == true);
	EXPECT_TRUE(booleanExpressionsIface_get_myBool2(&handle) == false);
	booleanExpressionsIface_raise_e1(&handle);
	booleanExpressions_runCycle(&handle);
	EXPECT_TRUE(booleanExpressions_isActive(&handle, BooleanExpressions_main_region_StateB));
	EXPECT_TRUE(booleanExpressionsIface_get_and(&handle) == false);
	EXPECT_TRUE(booleanExpressionsIface_get_or(&handle) == true);
	EXPECT_TRUE(booleanExpressionsIface_get_not(&handle) == false);
	EXPECT_TRUE(booleanExpressionsIface_get_equal(&handle) == false);
	EXPECT_TRUE(booleanExpressionsIface_get_notequal(&handle) == true);
}
