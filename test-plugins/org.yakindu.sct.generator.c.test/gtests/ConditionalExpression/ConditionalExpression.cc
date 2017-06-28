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
#include "ConditionalExpressions.h"

static ConditionalExpressions statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		conditionalExpressions_init(&statechart);
	}
};


TEST_F(StatemachineTest, ConditionalExpressionTest) {					
	conditionalExpressions_enter(&statechart);
	EXPECT_TRUE(conditionalExpressions_isStateActive(&statechart, ConditionalExpressions_main_region_A));
	EXPECT_TRUE(conditionalExpressionsIface_get_condition(&statechart)== 1l);
	conditionalExpressionsIface_raise_e(&statechart);
	conditionalExpressions_runCycle(&statechart);
	EXPECT_TRUE(conditionalExpressions_isStateActive(&statechart, ConditionalExpressions_main_region_B));
	EXPECT_TRUE(conditionalExpressionsIface_get_condition(&statechart)== 2l);
}


