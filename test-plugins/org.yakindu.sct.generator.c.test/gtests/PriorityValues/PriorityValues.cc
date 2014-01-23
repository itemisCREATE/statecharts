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
#include "PriorityValues.h"


PriorityValues handle;

TEST(StatemachineTest, transitionPriority) {
	priorityValues_init(&handle);
	priorityValues_enter(&handle);
	EXPECT_TRUE(priorityValues_isActive(&handle, PriorityValues_main_region_A));
	priorityValuesIface_raise_event1(&handle);
	priorityValues_runCycle(&handle);
	EXPECT_TRUE(priorityValues_isActive(&handle, PriorityValues_C));
}
TEST(StatemachineTest, regionPriority) {
	priorityValues_init(&handle);
	priorityValues_enter(&handle);
	EXPECT_TRUE(priorityValues_isActive(&handle, PriorityValues_A));
	priorityValuesIface_raise_event2(&handle);
	priorityValues_runCycle(&handle);
	EXPECT_TRUE(priorityValues_isActive(&handle, PriorityValues_B));
	EXPECT_TRUE(!priorityValues_isActive(&handle, PriorityValues_E));
}

		
