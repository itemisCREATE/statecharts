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

ValuedEvents handle;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		valuedEvents_init(&handle);
	}
};


TEST_F(StatemachineTest, valuedEventsTest) {					
	valuedEvents_enter(&handle);
	valuedEvents_runCycle(&handle);
	EXPECT_TRUE(strcmp(valuedEventsIface_get_myString(&handle), "sct") == 0);
	valuedEventsIface_raise_integerEvent(&handle, 23l);
	valuedEventsIface_raise_booleanEvent(&handle, false);
	valuedEventsIface_raise_realEvent(&handle, 20l);
	valuedEventsIface_raise_stringEvent(&handle, "tool");
	valuedEvents_runCycle(&handle);
	EXPECT_TRUE(valuedEvents_isStateActive(&handle, ValuedEvents_integer_region_D));
	EXPECT_TRUE(valuedEvents_isStateActive(&handle, ValuedEvents_string_region_D));
	EXPECT_TRUE(valuedEvents_isStateActive(&handle, ValuedEvents_boolean_region_D));
	EXPECT_TRUE(valuedEvents_isStateActive(&handle, ValuedEvents_real_region_D));
	EXPECT_TRUE(valuedEventsIface_get_myInt(&handle)== 23l);
	EXPECT_TRUE(valuedEventsIface_get_myBool(&handle)== false);
	EXPECT_TRUE(valuedEventsIface_get_myReal(&handle)== 20l);
	EXPECT_TRUE(strcmp(valuedEventsIface_get_myString(&handle), "tool") == 0);
}


