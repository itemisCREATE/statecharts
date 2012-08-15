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
#include "RealExpressions.h"

TEST(StatemachineTest, realExpressionsTest) {
	RealExpressions handle;
	realExpressions_init(&handle);
	realExpressions_enter(&handle);
	EXPECT_TRUE(realExpressions_isActive(&handle, RealExpressions_main_region_StateA));
	EXPECT_TRUE(realExpressionsIface_get_myReal1(&handle) == 5.3);
	EXPECT_TRUE(realExpressionsIface_get_myReal2(&handle) == 10.6);
	realExpressionsIface_raise_e1(&handle);
	realExpressions_runCycle(&handle);
	EXPECT_TRUE(realExpressions_isActive(&handle, RealExpressions_main_region_StateB));
	EXPECT_TRUE(realExpressionsIface_get_less(&handle) == true);
	EXPECT_TRUE(realExpressionsIface_get_greater(&handle) == false);
	EXPECT_TRUE(realExpressionsIface_get_equalOrLess(&handle) == true);
	EXPECT_TRUE(realExpressionsIface_get_equalOrGreater(&handle) == false);
	EXPECT_TRUE(realExpressionsIface_get_equal(&handle) == false);
	EXPECT_TRUE(realExpressionsIface_get_notEqual(&handle) == true);
	EXPECT_TRUE(realExpressionsIface_get_plus(&handle) == true);
	EXPECT_TRUE(realExpressionsIface_get_minus(&handle) == true);
	EXPECT_TRUE(realExpressionsIface_get_multiply(&handle) == true);
	EXPECT_TRUE(realExpressionsIface_get_division(&handle) == true);
	EXPECT_TRUE(realExpressionsIface_get_modulo(&handle) == true);
	EXPECT_TRUE(realExpressionsIface_get_negat(&handle) == - 5.3 );
	EXPECT_TRUE(realExpressionsIface_get_multiAssign(&handle) == 11.66);
	EXPECT_TRUE(realExpressionsIface_get_divAssign(&handle) == 4.3);
	EXPECT_TRUE(realExpressionsIface_get_plusAssign(&handle) == 7.5);
	EXPECT_TRUE(realExpressionsIface_get_minusAssign(&handle) == 3.3);
	EXPECT_TRUE(realExpressionsIface_get_moduloAssign(&handle) == true);
}
