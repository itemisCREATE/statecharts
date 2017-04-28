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
#include "TypeAlias.h"
#include "sc_types.h"
TypeAlias* statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new TypeAlias();
		statechart->init();
	}
	virtual void TearDown() {
		delete statechart;
	}
};


TEST_F(StatemachineTest, TypeAliasTest) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(TypeAlias::main_region_Start));
	
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myVar()== 1l);
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(TypeAlias::main_region_Mid));
	
	EXPECT_TRUE(strcmp(statechart->getDefaultSCI()->get_myString(), "TypeSystem") == 0);
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(TypeAlias::main_region_Mid2));
	
	statechart->raise_myEvent();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(TypeAlias::main_region_End));
	
}
