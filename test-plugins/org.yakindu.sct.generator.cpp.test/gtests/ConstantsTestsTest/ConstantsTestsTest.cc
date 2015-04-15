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
#include "Constants.h"

TEST(StatemachineTest, constantDefinition) {
	Constants* statechart = new Constants();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(Constants::main_region_A));
	EXPECT_TRUE(statechart->getDefaultSCI()->get_x()== 10l);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_y()== 20l);
	EXPECT_TRUE(strcmp(statechart->getSCI_Named().get_y(), "Hello World") == 0);
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->getDefaultSCI()->get_result()== 20l);
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(Constants::main_region_C));
	EXPECT_TRUE(statechart->getDefaultSCI()->get_result()== 100l);
	statechart->raise_e2( statechart->getDefaultSCI()->get_x());
	statechart->runCycle();
	EXPECT_TRUE(statechart->getDefaultSCI()->get_result()== 1000l);
	EXPECT_TRUE(statechart->isActive(Constants::main_region_A));
	delete statechart;
}
