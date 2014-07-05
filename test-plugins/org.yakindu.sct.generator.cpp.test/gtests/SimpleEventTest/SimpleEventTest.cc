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
#include "SimpleEvent.h"

TEST(StatemachineTest, simpleEventTest) {
	SimpleEvent* statechart = new SimpleEvent();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(SimpleEvent::A)) << "Expected A to be active" ;
	EXPECT_TRUE(5== 5);
	statechart->raise_event1();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(SimpleEvent::B)) << "Expected B to be active" ;
	statechart->runCycle();
	EXPECT_TRUE(!statechart->isActive(SimpleEvent::B));
	delete statechart;
}
