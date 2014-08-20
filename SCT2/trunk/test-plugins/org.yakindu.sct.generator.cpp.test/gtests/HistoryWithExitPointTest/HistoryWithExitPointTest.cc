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
#include "HistoryWithExitPoint.h"

TEST(StatemachineTest, historyEntryAfterExit) {
	HistoryWithExitPoint* statechart = new HistoryWithExitPoint();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(HistoryWithExitPoint::mr_A_r_X1));
	statechart->raise_push();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(HistoryWithExitPoint::mr_B));
	statechart->raise_back();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(HistoryWithExitPoint::mr_A_r_X1));
	statechart->raise_next();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(HistoryWithExitPoint::mr_A_r_X2));
	statechart->raise_push();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(HistoryWithExitPoint::mr_B));
	statechart->raise_back();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(HistoryWithExitPoint::mr_A_r_X2));
	delete statechart;
}
