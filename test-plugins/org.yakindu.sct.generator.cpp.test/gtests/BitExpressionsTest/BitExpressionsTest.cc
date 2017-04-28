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
#include <string>
#include "gtest/gtest.h"
#include "BitExpressions.h"
#include "sc_types.h"
BitExpressions* statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new BitExpressions();
		statechart->init();
	}
	virtual void TearDown() {
		delete statechart;
	}
};


TEST_F(StatemachineTest, BitExpressions) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(BitExpressions::main_region_StateA));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myBit1()== 5l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myBit2()== 7l);
	
	statechart->raise_e1();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(BitExpressions::main_region_StateB));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_leftBitshift()== 10l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_rightBitshift()== 2l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_complementBitshift()== - 6l );
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_bitwiseAnd()== 5l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_bitwiseOr()== 7l);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_bitwiseXor()== 2l);
	
}
