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
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myInt1()== 10l);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myInt2()== 5l);
	statechart->raise_e1();
	statechart->runCycle();
	EXPECT_TRUE(statechart->getDefaultSCI()->get_less()== false);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_greater()== true);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_equalOrLess()== false);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_equalOrGreater()== true);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_equal()== false);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_notEqual()== true);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_plus()== 15l);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_minus()== 5l);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_multiply()== 50l);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_division()== 2l);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_modulo()== 0l);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_negat()== - 10l );
	EXPECT_TRUE(statechart->getDefaultSCI()->get_multiAssign()== 20l);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_divAssign()== 2l);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_plusAssign()== 12l);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_minusAssign()== - 8l );
	EXPECT_TRUE(statechart->getDefaultSCI()->get_moduloAssign()== 0l);
	delete statechart;
}
