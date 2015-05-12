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
#include "GuardedEntry.h"

TEST(StatemachineTest, EntryNotTakenOnStatechartEnter) {
	GuardedEntry* statechart = new GuardedEntry();
	statechart->init();
	EXPECT_TRUE(statechart->getDefaultSCI()->get_guard()== false);
	statechart->enter();
	EXPECT_TRUE(statechart->isStateActive(GuardedEntry::main_region_A));
	EXPECT_TRUE(statechart->getDefaultSCI()->get_done()== false);
	delete statechart;
}
TEST(StatemachineTest, EntryTakenOnStatechartEnter) {
	GuardedEntry* statechart = new GuardedEntry();
	statechart->init();
	statechart->getDefaultSCI()->set_guard(true);
	statechart->enter();
	EXPECT_TRUE(statechart->isStateActive(GuardedEntry::main_region_A));
	EXPECT_TRUE(statechart->getDefaultSCI()->get_done()== true);
	delete statechart;
}
TEST(StatemachineTest, EntryTakenInTransition) {
	GuardedEntry* statechart = new GuardedEntry();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isStateActive(GuardedEntry::main_region_A));
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isStateActive(GuardedEntry::main_region_B));
	statechart->getDefaultSCI()->set_guard(true);
	statechart->getDefaultSCI()->set_done(false);
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isStateActive(GuardedEntry::main_region_A));
	EXPECT_TRUE(statechart->getDefaultSCI()->get_done());
	delete statechart;
}
TEST(StatemachineTest, EntryNotTakenInTransition) {
	GuardedEntry* statechart = new GuardedEntry();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isStateActive(GuardedEntry::main_region_A));
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isStateActive(GuardedEntry::main_region_B));
	statechart->getDefaultSCI()->set_guard(false);
	statechart->getDefaultSCI()->set_done(false);
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isStateActive(GuardedEntry::main_region_A));
	EXPECT_TRUE(!statechart->getDefaultSCI()->get_done());
	delete statechart;
}
