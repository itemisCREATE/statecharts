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
#include "ReadOnlyVariable.h"

ReadOnlyVariable handle;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		readOnlyVariable_init(&handle);
	}
};


TEST_F(StatemachineTest, ReadOnlyVariableTest) {					
	readOnlyVariable_enter(&handle);
	EXPECT_TRUE(readOnlyVariable_isStateActive(&handle, ReadOnlyVariable_main_region_StateA));
	EXPECT_TRUE(readOnlyVariableIface_get_myInt(&handle)== 0l);
	EXPECT_TRUE(strcmp(readOnlyVariableIface_get_myString(&handle), "testString") == 0);
	EXPECT_TRUE(readOnlyVariableIface_get_myBool(&handle)== true);
	EXPECT_TRUE(readOnlyVariableIface_get_myReal(&handle)== 1.1);
	EXPECT_TRUE(readOnlyVariableIfaceA_get_myInt(&handle) == 0l);
	EXPECT_TRUE(strcmp(readOnlyVariableIfaceA_get_myString(&handle) , "testString") == 0);
	EXPECT_TRUE(readOnlyVariableIfaceA_get_myBool(&handle) == true);
	EXPECT_TRUE(readOnlyVariableIfaceA_get_myReal(&handle) == 1.1);
	readOnlyVariable_runCycle(&handle);
	EXPECT_TRUE(readOnlyVariable_isStateActive(&handle, ReadOnlyVariable_main_region_StateB));
	EXPECT_TRUE(readOnlyVariableIface_get_myInt(&handle)== 100l);
	EXPECT_TRUE(strcmp(readOnlyVariableIface_get_myString(&handle), "fail") == 0);
	EXPECT_TRUE(readOnlyVariableIface_get_myBool(&handle)== false);
	EXPECT_TRUE(readOnlyVariableIface_get_myReal(&handle)== 6.6);
	EXPECT_TRUE(readOnlyVariableIfaceA_get_myInt(&handle) == 200l);
	EXPECT_TRUE(strcmp(readOnlyVariableIfaceA_get_myString(&handle) , "A_fail") == 0);
	EXPECT_TRUE(readOnlyVariableIfaceA_get_myBool(&handle) == false);
	EXPECT_TRUE(readOnlyVariableIfaceA_get_myReal(&handle) == 7.7);
}


