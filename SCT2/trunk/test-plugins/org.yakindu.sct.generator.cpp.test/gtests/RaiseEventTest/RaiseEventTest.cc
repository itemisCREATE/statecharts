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
#include "RaiseEvent.h"

TEST(StatemachineTest, raiseEvent) {
	RaiseEvent* statechart = new RaiseEvent();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(RaiseEvent::RaiseEvent_second_region_SateA));
	EXPECT_TRUE(statechart->isActive(RaiseEvent::RaiseEvent_main_region_StateA));
	statechart->raise_e2();
	statechart->runCycle();
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(RaiseEvent::RaiseEvent_second_region_StateB));
	EXPECT_TRUE(statechart->isActive(RaiseEvent::RaiseEvent_main_region_StateB));
	delete statechart;
}
