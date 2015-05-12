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
#include "Parenthesis.h"

TEST(StatemachineTest, simple) {
	Parenthesis* statechart = new Parenthesis();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isStateActive(Parenthesis::mainRegion_A));
	EXPECT_TRUE(statechart->getDefaultSCI()->get_erg()== 8l);
	delete statechart;
}
