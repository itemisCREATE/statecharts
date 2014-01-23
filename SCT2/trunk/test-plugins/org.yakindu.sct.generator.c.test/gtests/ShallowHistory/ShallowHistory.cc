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
#include "ShallowHistory.h"


ShallowHistory handle;

TEST(StatemachineTest, shallowHistoryTest) {
	shallowHistory_init(&handle);
	shallowHistory_enter(&handle);
	shallowHistoryIface_raise_event1(&handle);
	shallowHistory_runCycle(&handle);
	shallowHistoryIface_raise_event3(&handle);
	shallowHistory_runCycle(&handle);
	shallowHistoryIface_raise_event5(&handle);
	shallowHistory_runCycle(&handle);
	shallowHistoryIface_raise_event7(&handle);
	shallowHistory_runCycle(&handle);
	EXPECT_TRUE(!shallowHistory_isActive(&handle, ShallowHistory_State1));
	EXPECT_TRUE(shallowHistory_isActive(&handle, ShallowHistory_State9));
	shallowHistoryIface_raise_event6(&handle);
	shallowHistory_runCycle(&handle);
	EXPECT_TRUE(!shallowHistory_isActive(&handle, ShallowHistory_State9));
	EXPECT_TRUE(shallowHistory_isActive(&handle, ShallowHistory_State6));
	shallowHistoryIface_raise_event5(&handle);
	shallowHistory_runCycle(&handle);
	EXPECT_TRUE(!shallowHistory_isActive(&handle, ShallowHistory_State8));
	EXPECT_TRUE(shallowHistory_isActive(&handle, ShallowHistory_State9));
	shallowHistoryIface_raise_event2(&handle);
	shallowHistory_runCycle(&handle);
	EXPECT_TRUE(!shallowHistory_isActive(&handle, ShallowHistory_State9));
	EXPECT_TRUE(shallowHistory_isActive(&handle, ShallowHistory_State1));
	shallowHistoryIface_raise_event1(&handle);
	shallowHistory_runCycle(&handle);
	EXPECT_TRUE(shallowHistory_isActive(&handle, ShallowHistory_State6));
	EXPECT_TRUE(!shallowHistory_isActive(&handle, ShallowHistory_State1));
	shallowHistoryIface_raise_event5(&handle);
	shallowHistory_runCycle(&handle);
	EXPECT_TRUE(!shallowHistory_isActive(&handle, ShallowHistory_State6));
	EXPECT_TRUE(shallowHistory_isActive(&handle, ShallowHistory_State9));
}

		
