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

Constants handle;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		constants_init(&handle);
	}
};


TEST_F(StatemachineTest, constantDefinition) {					
	constants_enter(&handle);
	EXPECT_TRUE(constants_isStateActive(&handle, Constants_main_region_A));
	EXPECT_TRUE(constantsIface_get_x(&handle)== 10l);
	EXPECT_TRUE(constantsIface_get_y(&handle)== 20l);
	EXPECT_TRUE(strcmp(constantsIfaceNamed_get_y(&handle) , "Hello World") == 0);
	constantsIface_raise_e(&handle);
	constants_runCycle(&handle);
	EXPECT_TRUE(constantsIface_get_result(&handle)== 20l);
	constantsIface_raise_e(&handle);
	constants_runCycle(&handle);
	EXPECT_TRUE(constants_isStateActive(&handle, Constants_main_region_C));
	EXPECT_TRUE(constantsIface_get_result(&handle)== 100l);
	constantsIface_raise_e2(&handle, constantsIface_get_x(&handle));
	constants_runCycle(&handle);
	EXPECT_TRUE(constantsIface_get_result(&handle)== 1000l);
	EXPECT_TRUE(constants_isStateActive(&handle, Constants_main_region_A));
}


