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


ValuedEvents handle;

TEST(StatemachineTest, valuedEventsTest) {
	valuedEvents_init(&handle);
	valuedEvents_enter(&handle);
	valuedEvents_runCycle(&handle);
	EXPECT_TRUE(strcmp(valuedEventsIface_get_myString(&handle) , ""sct"") == 0);
	valuedEventsIface_raise_integerEvent(&handle, 23l);
	valuedEventsIface_raise_booleanEvent(&handle, false);
	valuedEventsIface_raise_realEvent(&handle, 20l);
	valuedEventsIface_raise_stringEvent(&handle, "tool");
	valuedEvents_runCycle(&handle);
	EXPECT_TRUE(valuedEvents_isActive(&handle, ValuedEvents_integer_region_D));
	EXPECT_TRUE(valuedEvents_isActive(&handle, ValuedEvents_string_region_D));
	EXPECT_TRUE(valuedEvents_isActive(&handle, ValuedEvents_boolean_region_D));
	EXPECT_TRUE(valuedEvents_isActive(&handle, ValuedEvents_real_region_D));
	EXPECT_TRUE(valuedEventsIface_get_myInt(&handle) == 23l);
	EXPECT_TRUE(valuedEventsIface_get_myBool(&handle) == false);
	EXPECT_TRUE(valuedEventsIface_get_myReal(&handle) == 20l);
	EXPECT_TRUE(strcmp(valuedEventsIface_get_myString(&handle) , ""tool"") == 0);
}

		
