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
#include "HistoryWithExitPoint.h"
#include "sc_types.h"
HistoryWithExitPoint* statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechart = new HistoryWithExitPoint();
		statechart->init();
	}
	virtual void TearDown() {
		delete statechart;
	}
};


TEST_F(StatemachineTest, historyEntryAfterExit) {
	
	
	statechart->enter();
	
	EXPECT_TRUE(statechart->isStateActive(HistoryWithExitPoint::mr_A_r_X1));
	
	statechart->raise_push();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(HistoryWithExitPoint::mr_B));
	
	statechart->raise_back();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(HistoryWithExitPoint::mr_A_r_X1));
	
	statechart->raise_next();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(HistoryWithExitPoint::mr_A_r_X2));
	
	statechart->raise_push();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(HistoryWithExitPoint::mr_B));
	
	statechart->raise_back();
	
	statechart->runCycle();
	
	EXPECT_TRUE(statechart->isStateActive(HistoryWithExitPoint::mr_A_r_X2));
	
}
