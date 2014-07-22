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
#include "CKeywords.h"

TEST(StatemachineTest, CKeywordsTest) {
	CKeywords* statechart = new CKeywords();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(CKeywords::char_ID));
	statechart->raise_auto();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(CKeywords::const_ID));
	EXPECT_TRUE(statechart->isActive(CKeywords::case_ID));
	EXPECT_TRUE(statechart->isActive(CKeywords::asm_ID));
	delete statechart;
}
