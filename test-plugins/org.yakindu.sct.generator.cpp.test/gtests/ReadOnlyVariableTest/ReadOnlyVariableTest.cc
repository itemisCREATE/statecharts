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
#include "ReadOnlyVariable.h"
#include "sc_types.h"
ReadOnlyVariable* statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new ReadOnlyVariable();
		statechart->init();
	}
	virtual void TearDown() {
		delete statechart;
	}
};


TEST_F(StatemachineTest, ReadOnlyVariableTest) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(ReadOnlyVariable::main_region_StateA));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myInt()== 0l);
	
	EXPECT_TRUE(strcmp(statechart->getDefaultSCI()->get_myString(), "testString") == 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myBool()== true);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myReal()== 1.1);
	
	EXPECT_TRUE(statechart->getSCI_A()->get_myInt()== 0l);
	
	EXPECT_TRUE(strcmp(statechart->getSCI_A()->get_myString(), "testString") == 0);
	
	EXPECT_TRUE(statechart->getSCI_A()->get_myBool()== true);
	
	EXPECT_TRUE(statechart->getSCI_A()->get_myReal()== 1.1);
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(ReadOnlyVariable::main_region_StateB));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myInt()== 100l);
	
	EXPECT_TRUE(strcmp(statechart->getDefaultSCI()->get_myString(), "fail") == 0);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myBool()== false);
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myReal()== 6.6);
	
	EXPECT_TRUE(statechart->getSCI_A()->get_myInt()== 200l);
	
	EXPECT_TRUE(strcmp(statechart->getSCI_A()->get_myString(), "A_fail") == 0);
	
	EXPECT_TRUE(statechart->getSCI_A()->get_myBool()== false);
	
	EXPECT_TRUE(statechart->getSCI_A()->get_myReal()== 7.7);
	
}
