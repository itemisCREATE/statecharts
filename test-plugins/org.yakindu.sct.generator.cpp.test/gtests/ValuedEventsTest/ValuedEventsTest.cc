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
#include "ValuedEvents.h"

TEST(StatemachineTest, valuedEventsTest) {
	ValuedEvents* statechart = new ValuedEvents();
	statechart->init();
	statechart->enter();
	statechart->runCycle();
	EXPECT_TRUE(strcmp(statechart->getDefaultSCI()->get_myString(), "sct") == 0);
	statechart->raise_integerEvent( 23l);
	statechart->raise_booleanEvent( false);
	statechart->raise_realEvent( 20l);
	statechart->raise_stringEvent( "tool");
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(ValuedEvents::integer_region_D));
	EXPECT_TRUE(statechart->isActive(ValuedEvents::string_region_D));
	EXPECT_TRUE(statechart->isActive(ValuedEvents::boolean_region_D));
	EXPECT_TRUE(statechart->isActive(ValuedEvents::real_region_D));
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myInt()== 23l);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myBool()== false);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_myReal()== 20l);
	EXPECT_TRUE(strcmp(statechart->getDefaultSCI()->get_myString(), "tool") == 0);
	delete statechart;
}
