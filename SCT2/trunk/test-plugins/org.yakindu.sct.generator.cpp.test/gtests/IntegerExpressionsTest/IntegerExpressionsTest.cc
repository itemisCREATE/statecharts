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
#include "IntegerExpressions.h"

TEST(StatemachineTest, integerExpressions) {
	IntegerExpressions* statechart = new IntegerExpressions();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(IntegerExpressions::main_region_StateA));
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myInt1()== 10);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myInt2()== 5);
	statechart->raise_e1();
	statechart->runCycle();
	EXPECT_TRUE(statechart->getDefaultSCI()->get_less()== false);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_greater()== true);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_equalOrLess()== false);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_equalOrGreater()== true);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_equal()== false);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_notEqual()== true);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_plus()== 15);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_minus()== 5);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_multiply()== 50);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_division()== 2);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_modulo()== 0);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_negat()== - 10 );
	EXPECT_TRUE(statechart->getDefaultSCI()->get_multiAssign()== 20);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_divAssign()== 2);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_plusAssign()== 12);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_minusAssign()== - 8 );
	EXPECT_TRUE(statechart->getDefaultSCI()->get_moduloAssign()== 0);
	delete statechart;
}
