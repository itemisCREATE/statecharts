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
#include "HistoryWithExitPoint.h"

static HistoryWithExitPoint statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		historyWithExitPoint_init(&statechart);
	}
};


TEST_F(StatemachineTest, historyEntryAfterExit) {					
	historyWithExitPoint_enter(&statechart);
	EXPECT_TRUE(historyWithExitPoint_isStateActive(&statechart, HistoryWithExitPoint_mr_A_r_X1));
	historyWithExitPointIface_raise_push(&statechart);
	historyWithExitPoint_runCycle(&statechart);
	EXPECT_TRUE(historyWithExitPoint_isStateActive(&statechart, HistoryWithExitPoint_mr_B));
	historyWithExitPointIface_raise_back(&statechart);
	historyWithExitPoint_runCycle(&statechart);
	EXPECT_TRUE(historyWithExitPoint_isStateActive(&statechart, HistoryWithExitPoint_mr_A_r_X1));
	historyWithExitPointIface_raise_next(&statechart);
	historyWithExitPoint_runCycle(&statechart);
	EXPECT_TRUE(historyWithExitPoint_isStateActive(&statechart, HistoryWithExitPoint_mr_A_r_X2));
	historyWithExitPointIface_raise_push(&statechart);
	historyWithExitPoint_runCycle(&statechart);
	EXPECT_TRUE(historyWithExitPoint_isStateActive(&statechart, HistoryWithExitPoint_mr_B));
	historyWithExitPointIface_raise_back(&statechart);
	historyWithExitPoint_runCycle(&statechart);
	EXPECT_TRUE(historyWithExitPoint_isStateActive(&statechart, HistoryWithExitPoint_mr_A_r_X2));
}


