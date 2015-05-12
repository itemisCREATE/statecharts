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
#include "CKeywords.h"


CKeywords handle;

TEST(StatemachineTest, CKeywordsTest) {
	cKeywords_init(&handle);
	cKeywords_enter(&handle);
	EXPECT_TRUE(cKeywords_isStateActive(&handle, CKeywords_auto_char));
	cKeywordsIface_raise_auto(&handle);
	cKeywords_runCycle(&handle);
	EXPECT_TRUE(cKeywords_isStateActive(&handle, CKeywords_auto_loop));
	EXPECT_TRUE(cKeywords_isStateActive(&handle, CKeywords_auto_loop_switch_case));
	EXPECT_TRUE(cKeywords_isStateActive(&handle, CKeywords_auto_loop_switch_case_enum_asm));
}

		
