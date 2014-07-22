/**
* Copyright (c) 2014 committers of YAKINDU and others.
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
#include "NullCheck.h"

TEST(StatemachineTest, SimpleNullCheckTest) {
	NullCheck* statechart = new NullCheck();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(NullCheck::A));
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(NullCheck::B));
	delete statechart;
}
