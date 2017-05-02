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
#include "CKeywords.h"
#include "sc_types.h"
CKeywords* statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new CKeywords();
		statechart->init();
	}
	virtual void TearDown() {
		delete statechart;
	}
};


TEST_F(StatemachineTest, CKeywordsTest) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(CKeywords::auto_char));
	
	statechart->raise_auto();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(CKeywords::auto_loop));
	
	EXPECT_TRUE(statechart->isStateActive(CKeywords::auto_loop_switch_case));
	
	EXPECT_TRUE(statechart->isStateActive(CKeywords::auto_loop_switch_case_enum_asm));
	
}
