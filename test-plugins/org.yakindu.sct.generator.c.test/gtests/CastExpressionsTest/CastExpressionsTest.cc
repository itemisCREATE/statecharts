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

CastExpressions handle;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		castExpressions_init(&handle);
	}
};


TEST_F(StatemachineTest, CastExpressionTest) {					
	castExpressions_enter(&handle);
	EXPECT_TRUE(castExpressionsIface_get_realValue(&handle)== 5l);
	EXPECT_TRUE(castExpressionsIface_get_intValue(&handle)== 5l);
	castExpressions_runCycle(&handle);
	EXPECT_TRUE(castExpressionsIface_get_realValue(&handle)== 15l);
	castExpressions_runCycle(&handle);
	EXPECT_TRUE(castExpressions_isStateActive(&handle, CastExpressions_main_region_C));
	EXPECT_TRUE(castExpressionsIface_get_realValue(&handle)== 757l);
}


