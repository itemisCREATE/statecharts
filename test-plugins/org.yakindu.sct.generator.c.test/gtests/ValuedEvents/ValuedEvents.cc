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
#include "ValuedEvents.h"


ValuedEvents handle;

TEST(StatemachineTest, valuedEventsTest) {
	valuedEvents_init(&handle);
	valuedEvents_enter(&handle);
	valuedEvents_runCycle(&handle);
	EXPECT_TRUE(valuedEvents_isActive(&handle, ValuedEvents_A));
	EXPECT_TRUE(valuedEvents_isActive(&handle, ValuedEvents_C));
	EXPECT_TRUE(valuedEventsIface_get_myVar(&handle) == 42);
}

		
