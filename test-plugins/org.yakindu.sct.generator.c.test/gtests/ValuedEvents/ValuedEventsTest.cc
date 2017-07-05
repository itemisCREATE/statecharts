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
#include "ValuedEvents.h"

static ValuedEvents statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		valuedEvents_init(&statechart);
	}
};


TEST_F(StatemachineTest, valuedEventsTest) {					
	valuedEvents_enter(&statechart);
	valuedEvents_runCycle(&statechart);
	EXPECT_TRUE(strcmp(valuedEventsIface_get_myString(&statechart), "sct") == 0);
	valuedEventsIface_raise_integerEvent(&statechart, 23l);
	valuedEventsIface_raise_booleanEvent(&statechart, false);
	valuedEventsIface_raise_realEvent(&statechart, 20l);
	valuedEventsIface_raise_stringEvent(&statechart, "tool");
	valuedEvents_runCycle(&statechart);
	EXPECT_TRUE(valuedEvents_isStateActive(&statechart, ValuedEvents_integer_region_D));
	EXPECT_TRUE(valuedEvents_isStateActive(&statechart, ValuedEvents_string_region_D));
	EXPECT_TRUE(valuedEvents_isStateActive(&statechart, ValuedEvents_boolean_region_D));
	EXPECT_TRUE(valuedEvents_isStateActive(&statechart, ValuedEvents_real_region_D));
	EXPECT_TRUE(valuedEventsIface_get_myInt(&statechart)== 23l);
	EXPECT_TRUE(valuedEventsIface_get_myBool(&statechart)== false);
	EXPECT_TRUE(valuedEventsIface_get_myReal(&statechart)== 20l);
	EXPECT_TRUE(strcmp(valuedEventsIface_get_myString(&statechart), "tool") == 0);
}


