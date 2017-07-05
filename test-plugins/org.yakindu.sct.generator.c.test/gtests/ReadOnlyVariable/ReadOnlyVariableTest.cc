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

static ReadOnlyVariable statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		readOnlyVariable_init(&statechart);
	}
};


TEST_F(StatemachineTest, ReadOnlyVariableTest) {					
	readOnlyVariable_enter(&statechart);
	EXPECT_TRUE(readOnlyVariable_isStateActive(&statechart, ReadOnlyVariable_main_region_StateA));
	EXPECT_TRUE(readOnlyVariableIface_get_myInt(&statechart)== 0l);
	EXPECT_TRUE(strcmp(readOnlyVariableIface_get_myString(&statechart), "testString") == 0);
	EXPECT_TRUE(readOnlyVariableIface_get_myBool(&statechart)== true);
	EXPECT_TRUE(readOnlyVariableIface_get_myReal(&statechart)== 1.1);
	EXPECT_TRUE(readOnlyVariableIfaceA_get_myInt(&statechart) == 0l);
	EXPECT_TRUE(strcmp(readOnlyVariableIfaceA_get_myString(&statechart) , "testString") == 0);
	EXPECT_TRUE(readOnlyVariableIfaceA_get_myBool(&statechart) == true);
	EXPECT_TRUE(readOnlyVariableIfaceA_get_myReal(&statechart) == 1.1);
	readOnlyVariable_runCycle(&statechart);
	EXPECT_TRUE(readOnlyVariable_isStateActive(&statechart, ReadOnlyVariable_main_region_StateB));
	EXPECT_TRUE(readOnlyVariableIface_get_myInt(&statechart)== 100l);
	EXPECT_TRUE(strcmp(readOnlyVariableIface_get_myString(&statechart), "fail") == 0);
	EXPECT_TRUE(readOnlyVariableIface_get_myBool(&statechart)== false);
	EXPECT_TRUE(readOnlyVariableIface_get_myReal(&statechart)== 6.6);
	EXPECT_TRUE(readOnlyVariableIfaceA_get_myInt(&statechart) == 200l);
	EXPECT_TRUE(strcmp(readOnlyVariableIfaceA_get_myString(&statechart) , "A_fail") == 0);
	EXPECT_TRUE(readOnlyVariableIfaceA_get_myBool(&statechart) == false);
	EXPECT_TRUE(readOnlyVariableIfaceA_get_myReal(&statechart) == 7.7);
}


