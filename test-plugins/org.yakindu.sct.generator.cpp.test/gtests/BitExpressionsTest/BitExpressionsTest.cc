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
#include "BitExpressions.h"

TEST(StatemachineTest, BitExpressions) {
	BitExpressions* statechart = new BitExpressions();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(BitExpressions::main_region_StateA));
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myBit1()== 5);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myBit2()== 7);
	statechart->raise_e1();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(BitExpressions::main_region_StateB));
	EXPECT_TRUE(statechart->getDefaultSCI()->get_leftBitshift()== 10);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_rightBitshift()== 2);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_complementBitshift()== - 6 );
	EXPECT_TRUE(statechart->getDefaultSCI()->get_bitwiseAnd()== 5);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_bitwiseOr()== 7);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_bitwiseXor()== 2);
	delete statechart;
}
