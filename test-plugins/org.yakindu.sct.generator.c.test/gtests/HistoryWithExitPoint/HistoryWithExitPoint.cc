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
#include "HistoryWithExitPoint.h"


HistoryWithExitPoint handle;

TEST(StatemachineTest, historyEntryAfterExit) {
	historyWithExitPoint_init(&handle);
	historyWithExitPoint_enter(&handle);
	EXPECT_TRUE(historyWithExitPoint_isStateActive(&handle, HistoryWithExitPoint_mr_A_r_X1));
	historyWithExitPointIface_raise_push(&handle);
	historyWithExitPoint_runCycle(&handle);
	EXPECT_TRUE(historyWithExitPoint_isStateActive(&handle, HistoryWithExitPoint_mr_B));
	historyWithExitPointIface_raise_back(&handle);
	historyWithExitPoint_runCycle(&handle);
	EXPECT_TRUE(historyWithExitPoint_isStateActive(&handle, HistoryWithExitPoint_mr_A_r_X1));
	historyWithExitPointIface_raise_next(&handle);
	historyWithExitPoint_runCycle(&handle);
	EXPECT_TRUE(historyWithExitPoint_isStateActive(&handle, HistoryWithExitPoint_mr_A_r_X2));
	historyWithExitPointIface_raise_push(&handle);
	historyWithExitPoint_runCycle(&handle);
	EXPECT_TRUE(historyWithExitPoint_isStateActive(&handle, HistoryWithExitPoint_mr_B));
	historyWithExitPointIface_raise_back(&handle);
	historyWithExitPoint_runCycle(&handle);
	EXPECT_TRUE(historyWithExitPoint_isStateActive(&handle, HistoryWithExitPoint_mr_A_r_X2));
}

		
