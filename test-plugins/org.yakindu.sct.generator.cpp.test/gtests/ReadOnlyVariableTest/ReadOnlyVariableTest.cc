/**
* Copyright (c) 2015 committers of YAKINDU and others.
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

TEST(StatemachineTest, ReadOnlyVariableTest) {
	ReadOnlyVariable* statechart = new ReadOnlyVariable();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isStateActive(ReadOnlyVariable::main_region_StateA));
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myInt()== 0l);
	EXPECT_TRUE(strcmp(statechart->getDefaultSCI()->get_myString(), "testString") == 0);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myBool()== true);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myReal()== 1.1d);
	EXPECT_TRUE(statechart->getSCI_A()->get_myInt()== 0l);
	EXPECT_TRUE(strcmp(statechart->getSCI_A()->get_myString(), "testString") == 0);
	EXPECT_TRUE(statechart->getSCI_A()->get_myBool()== true);
	EXPECT_TRUE(statechart->getSCI_A()->get_myReal()== 1.1d);
	statechart->runCycle();
	EXPECT_TRUE(statechart->isStateActive(ReadOnlyVariable::main_region_StateB));
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myInt()== 100l);
	EXPECT_TRUE(strcmp(statechart->getDefaultSCI()->get_myString(), "fail") == 0);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myBool()== false);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myReal()== 6.6d);
	EXPECT_TRUE(statechart->getSCI_A()->get_myInt()== 200l);
	EXPECT_TRUE(strcmp(statechart->getSCI_A()->get_myString(), "A_fail") == 0);
	EXPECT_TRUE(statechart->getSCI_A()->get_myBool()== false);
	EXPECT_TRUE(statechart->getSCI_A()->get_myReal()== 7.7d);
	delete statechart;
}
