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
#include "DeepEntry.h"

TEST(StatemachineTest, enterToSubstate) {
	DeepEntry* statechart = new DeepEntry();
	statechart->init();
	EXPECT_TRUE(statechart->getDefaultSCI()->get_x()== 0);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_y()== 0);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_z()== 0);
	statechart->enter();
	EXPECT_TRUE(statechart->getDefaultSCI()->get_x()== 1);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_y()== 1);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_z()== 2);
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(DeepEntry::r2_B_r_BB));
	statechart->raise_f();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(DeepEntry::r2_C));
	statechart->raise_f();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(DeepEntry::r2_B_r_BB));
	EXPECT_TRUE(statechart->getDefaultSCI()->get_y()== 1);
	delete statechart;
}
