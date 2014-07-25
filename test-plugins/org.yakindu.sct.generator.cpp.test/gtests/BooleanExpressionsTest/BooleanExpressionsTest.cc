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
#include "BooleanExpressions.h"

TEST(StatemachineTest, booleanExpressions) {
	BooleanExpressions* statechart = new BooleanExpressions();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(BooleanExpressions::StateA));
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myBool1()== true);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myBool2()== false);
	statechart->raise_e1();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(BooleanExpressions::StateB));
	EXPECT_TRUE(statechart->getDefaultSCI()->get_and()== false);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_or()== true);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_not()== false);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_equal()== false);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_notequal()== true);
	delete statechart;
}
