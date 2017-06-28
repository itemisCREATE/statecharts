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
#include "gtest/gtest.h"
#include "CKeywords.h"

static CKeywords statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		cKeywords_init(&statechart);
	}
};


TEST_F(StatemachineTest, CKeywordsTest) {					
	cKeywords_enter(&statechart);
	EXPECT_TRUE(cKeywords_isStateActive(&statechart, CKeywords_auto_char));
	cKeywordsIface_raise_auto(&statechart);
	cKeywords_runCycle(&statechart);
	EXPECT_TRUE(cKeywords_isStateActive(&statechart, CKeywords_auto_loop));
	EXPECT_TRUE(cKeywords_isStateActive(&statechart, CKeywords_auto_loop_switch_case));
	EXPECT_TRUE(cKeywords_isStateActive(&statechart, CKeywords_auto_loop_switch_case_enum_asm));
}


