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
#include "Constants.h"

static Constants statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		constants_init(&statechart);
	}
};


TEST_F(StatemachineTest, constantDefinition) {					
	constants_enter(&statechart);
	EXPECT_TRUE(constants_isStateActive(&statechart, Constants_main_region_A));
	EXPECT_TRUE(constantsIface_get_x(&statechart)== 10l);
	EXPECT_TRUE(constantsIface_get_y(&statechart)== 20l);
	EXPECT_TRUE(strcmp(constantsIfaceNamed_get_y(&statechart) , "Hello World") == 0);
	constantsIface_raise_e(&statechart);
	constants_runCycle(&statechart);
	EXPECT_TRUE(constantsIface_get_result(&statechart)== 20l);
	constantsIface_raise_e(&statechart);
	constants_runCycle(&statechart);
	EXPECT_TRUE(constants_isStateActive(&statechart, Constants_main_region_C));
	EXPECT_TRUE(constantsIface_get_result(&statechart)== 100l);
	constantsIface_raise_e2(&statechart, constantsIface_get_x(&statechart));
	constants_runCycle(&statechart);
	EXPECT_TRUE(constantsIface_get_result(&statechart)== 1000l);
	EXPECT_TRUE(constants_isStateActive(&statechart, Constants_main_region_A));
}


