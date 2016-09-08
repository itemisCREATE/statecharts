/**
* Copyright (c) 2016 committers of YAKINDU and others.
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

TEST(StatemachineTest, TypeAliasTest) {
	TypeAlias* statechart = new TypeAlias();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isStateActive(TypeAlias::main_region_Start));
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myVar()== 1l);
	statechart->runCycle();
	EXPECT_TRUE(statechart->isStateActive(TypeAlias::main_region_Mid));
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myString()== "TypeSystem");
	statechart->runCycle();
	EXPECT_TRUE(statechart->isStateActive(TypeAlias::main_region_Mid2));
	statechart->raise_myEvent();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isStateActive(TypeAlias::main_region_End));
	delete statechart;
}
