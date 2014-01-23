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
#include "GuardedEntry.h"

TEST(StatemachineTest, EntryNotTakenOnStatechartEnter) {
	GuardedEntry* statechart = new GuardedEntry();
	statechart->init();
	EXPECT_TRUE(statechart->getSCInterface()->get_guard()== false);
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(GuardedEntry::A));
	EXPECT_TRUE(statechart->getSCInterface()->get_done()== false);
	delete statechart;
}
TEST(StatemachineTest, EntryTakenOnStatechartEnter) {
	GuardedEntry* statechart = new GuardedEntry();
	statechart->init();
	statechart->getSCInterface()->set_guard(true);
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(GuardedEntry::A));
	EXPECT_TRUE(statechart->getSCInterface()->get_done()== true);
	delete statechart;
}
TEST(StatemachineTest, EntryTakenInTransition) {
	GuardedEntry* statechart = new GuardedEntry();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(GuardedEntry::A));
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(GuardedEntry::B));
	statechart->getSCInterface()->set_guard(true);
	statechart->getSCInterface()->set_done(false);
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(GuardedEntry::A));
	EXPECT_TRUE(statechart->getSCInterface()->get_done());
	delete statechart;
}
TEST(StatemachineTest, EntryNotTakenInTransition) {
	GuardedEntry* statechart = new GuardedEntry();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(GuardedEntry::A));
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(GuardedEntry::B));
	statechart->getSCInterface()->set_guard(false);
	statechart->getSCInterface()->set_done(false);
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(GuardedEntry::A));
	EXPECT_TRUE(!statechart->getSCInterface()->get_done());
	delete statechart;
}
