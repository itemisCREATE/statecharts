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
#include "gtest/gtest.h"
#include "BitExpressions.h"

static BitExpressions statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		bitExpressions_init(&statechart);
	}
};


TEST_F(StatemachineTest, BitExpressions) {					
	bitExpressions_enter(&statechart);
	EXPECT_TRUE(bitExpressions_isStateActive(&statechart, BitExpressions_main_region_StateA));
	EXPECT_TRUE(bitExpressionsIface_get_myBit1(&statechart)== 5l);
	EXPECT_TRUE(bitExpressionsIface_get_myBit2(&statechart)== 7l);
	bitExpressionsIface_raise_e1(&statechart);
	bitExpressions_runCycle(&statechart);
	EXPECT_TRUE(bitExpressions_isStateActive(&statechart, BitExpressions_main_region_StateB));
	EXPECT_TRUE(bitExpressionsIface_get_leftBitshift(&statechart)== 10l);
	EXPECT_TRUE(bitExpressionsIface_get_rightBitshift(&statechart)== 2l);
	EXPECT_TRUE(bitExpressionsIface_get_complementBitshift(&statechart)== - 6l );
	EXPECT_TRUE(bitExpressionsIface_get_bitwiseAnd(&statechart)== 5l);
	EXPECT_TRUE(bitExpressionsIface_get_bitwiseOr(&statechart)== 7l);
	EXPECT_TRUE(bitExpressionsIface_get_bitwiseXor(&statechart)== 2l);
}


