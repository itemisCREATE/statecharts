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
#include "InternalEventLifeCycle.h"

TEST(StatemachineTest, InternalEventLifeCycleTest) {
	InternalEventLifeCycle* statechart = new InternalEventLifeCycle();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(InternalEventLifeCycle::A));
	EXPECT_TRUE(statechart->isActive(InternalEventLifeCycle::C));
	statechart->raise_e();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(InternalEventLifeCycle::A));
	EXPECT_TRUE(statechart->isActive(InternalEventLifeCycle::D));
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(InternalEventLifeCycle::A));
	EXPECT_TRUE(statechart->isActive(InternalEventLifeCycle::D));
	statechart->raise_f();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(InternalEventLifeCycle::A));
	EXPECT_TRUE(statechart->isActive(InternalEventLifeCycle::C));
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(InternalEventLifeCycle::A));
	EXPECT_TRUE(statechart->isActive(InternalEventLifeCycle::C));
	delete statechart;
}
