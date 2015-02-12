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
	EXPECT_TRUE(statechart->getDefaultSCI()->get_x()== 10);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_y()== 20);
	EXPECT_TRUE(strcmp(getSCI_Named().get_y(), "Hello World") == 0);
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->getDefaultSCI()->get_result()== 20);
	delete statechart;
}
