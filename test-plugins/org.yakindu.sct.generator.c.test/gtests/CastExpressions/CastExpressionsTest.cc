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
#include "CastExpressions.h"

static CastExpressions statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		castExpressions_init(&statechart);
	}
};


TEST_F(StatemachineTest, CastExpressionTest) {					
	castExpressions_enter(&statechart);
	EXPECT_TRUE(castExpressionsIface_get_realValue(&statechart)== 5l);
	EXPECT_TRUE(castExpressionsIface_get_intValue(&statechart)== 5l);
	castExpressions_runCycle(&statechart);
	EXPECT_TRUE(castExpressionsIface_get_realValue(&statechart)== 15l);
	castExpressions_runCycle(&statechart);
	EXPECT_TRUE(castExpressions_isStateActive(&statechart, CastExpressions_main_region_C));
	EXPECT_TRUE(castExpressionsIface_get_realValue(&statechart)== 757l);
}


