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
#include "SyncFork.h"

TEST(StatemachineTest, syncForkTest) {
	SyncFork* statechart = new SyncFork();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(SyncFork::A));
	statechart->raise_f();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(SyncFork::B));
	EXPECT_TRUE(statechart->isActive(SyncFork::C1));
	EXPECT_TRUE(statechart->isActive(SyncFork::D1));
	statechart->raise_f();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(SyncFork::B));
	EXPECT_TRUE(statechart->isActive(SyncFork::C2));
	EXPECT_TRUE(statechart->isActive(SyncFork::D2));
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(SyncFork::A));
	statechart->raise_f();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(SyncFork::B));
	EXPECT_TRUE(statechart->isActive(SyncFork::C1));
	EXPECT_TRUE(statechart->isActive(SyncFork::D1));
	delete statechart;
}
