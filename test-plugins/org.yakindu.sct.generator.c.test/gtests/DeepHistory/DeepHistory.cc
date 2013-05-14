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
#include "DeepHistory.h"

TEST(StatemachineTest, deepHistoryTest) {
	DeepHistory handle;
	deepHistory_init(&handle);
	deepHistory_enter(&handle);
	deepHistoryIface_raise_event1(&handle);
	deepHistory_runCycle(&handle);
	deepHistoryIface_raise_event3(&handle);
	deepHistory_runCycle(&handle);
	deepHistoryIface_raise_event5(&handle);
	deepHistory_runCycle(&handle);
	deepHistoryIface_raise_event7(&handle);
	deepHistory_runCycle(&handle);
	EXPECT_TRUE(!deepHistory_isActive(&handle, DeepHistory_mainRegion_State1));
	EXPECT_TRUE(deepHistory_isActive(&handle, DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9));
	deepHistoryIface_raise_event2(&handle);
	deepHistory_runCycle(&handle);
	EXPECT_TRUE(deepHistory_isActive(&handle, DeepHistory_mainRegion_State1));
	EXPECT_TRUE(!deepHistory_isActive(&handle, DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9));
	deepHistoryIface_raise_event1(&handle);
	deepHistory_runCycle(&handle);
	EXPECT_TRUE(!deepHistory_isActive(&handle, DeepHistory_mainRegion_State1));
	EXPECT_TRUE(deepHistory_isActive(&handle, DeepHistory_mainRegion_State2__region0_State4__region0_State7__region0_State9));
}
