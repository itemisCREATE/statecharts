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
#include "IntegerExpressions.h"

TEST(StatemachineTest, integerExpressions) {
	IntegerExpressions* statechart = new IntegerExpressions();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(IntegerExpressions::StateA));
	EXPECT_TRUE(statechart->getSCInterface()->get_myInt1()== 10);
	EXPECT_TRUE(statechart->getSCInterface()->get_myInt2()== 5);
	statechart->raise_e1();
	statechart->runCycle();
	EXPECT_TRUE(statechart->getSCInterface()->get_less()== false);
	EXPECT_TRUE(statechart->getSCInterface()->get_greater()== true);
	EXPECT_TRUE(statechart->getSCInterface()->get_equalOrLess()== false);
	EXPECT_TRUE(statechart->getSCInterface()->get_equalOrGreater()== true);
	EXPECT_TRUE(statechart->getSCInterface()->get_equal()== false);
	EXPECT_TRUE(statechart->getSCInterface()->get_notEqual()== true);
	EXPECT_TRUE(statechart->getSCInterface()->get_plus()== 15);
	EXPECT_TRUE(statechart->getSCInterface()->get_minus()== 5);
	EXPECT_TRUE(statechart->getSCInterface()->get_multiply()== 50);
	EXPECT_TRUE(statechart->getSCInterface()->get_division()== 2);
	EXPECT_TRUE(statechart->getSCInterface()->get_modulo()== 0);
	EXPECT_TRUE(statechart->getSCInterface()->get_negat()== - 10 );
	EXPECT_TRUE(statechart->getSCInterface()->get_multiAssign()== 20);
	EXPECT_TRUE(statechart->getSCInterface()->get_divAssign()== 2);
	EXPECT_TRUE(statechart->getSCInterface()->get_plusAssign()== 12);
	EXPECT_TRUE(statechart->getSCInterface()->get_minusAssign()== - 8 );
	EXPECT_TRUE(statechart->getSCInterface()->get_moduloAssign()== 0);
	delete statechart;
}
