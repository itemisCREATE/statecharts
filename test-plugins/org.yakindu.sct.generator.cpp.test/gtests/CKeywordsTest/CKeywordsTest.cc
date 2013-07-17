/**
* Copyright (c) 2013 committers of YAKINDU and others.
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
#include "CKeywords.hpp"

TEST(StatemachineTest, CKeywordsTest) {
	CKeywords* statechart = new CKeywords();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(CKeywords_auto_char));
	statechart->raise_auto();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(CKeywords_auto_const));
	EXPECT_TRUE(statechart->isActive(CKeywords_auto_const_switch_case));
	EXPECT_TRUE(statechart->isActive(CKeywords_auto_const_switch_case_enum_asm));
	delete statechart;
}
