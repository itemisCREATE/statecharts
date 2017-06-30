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
#include "BooleanExpressions.h"

static BooleanExpressions statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		booleanExpressions_init(&statechart);
	}
};


TEST_F(StatemachineTest, booleanExpressions) {					
	booleanExpressions_enter(&statechart);
	EXPECT_TRUE(booleanExpressions_isStateActive(&statechart, BooleanExpressions_main_region_StateA));
	EXPECT_TRUE(booleanExpressionsIface_get_myBool1(&statechart)== true);
	EXPECT_TRUE(booleanExpressionsIface_get_myBool2(&statechart)== false);
	booleanExpressionsIface_raise_e1(&statechart);
	booleanExpressions_runCycle(&statechart);
	EXPECT_TRUE(booleanExpressions_isStateActive(&statechart, BooleanExpressions_main_region_StateB));
	EXPECT_TRUE(booleanExpressionsIface_get_and(&statechart)== false);
	EXPECT_TRUE(booleanExpressionsIface_get_or(&statechart)== true);
	EXPECT_TRUE(booleanExpressionsIface_get_not(&statechart)== false);
	EXPECT_TRUE(booleanExpressionsIface_get_equal(&statechart)== false);
	EXPECT_TRUE(booleanExpressionsIface_get_notequal(&statechart)== true);
}


