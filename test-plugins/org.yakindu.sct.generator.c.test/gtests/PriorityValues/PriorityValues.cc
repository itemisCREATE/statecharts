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
#include "PriorityValues.h"

TEST(StatemachineTest, transitionPriority) {
	PriorityValues handle;
	priorityValues_init(&handle);
	priorityValues_enter(&handle);
	EXPECT_TRUE(priorityValues_isActive(&handle, PriorityValues_main_region_A));
	priorityValuesIface_raise_event1(&handle);
	priorityValues_runCycle(&handle);
	EXPECT_TRUE(priorityValues_isActive(&handle, PriorityValues_main_region_C));
}
TEST(StatemachineTest, regionPriority) {
	PriorityValues handle;
	priorityValues_init(&handle);
	priorityValues_enter(&handle);
	EXPECT_TRUE(priorityValues_isActive(&handle, PriorityValues_someRegion_A));
	priorityValuesIface_raise_event2(&handle);
	priorityValues_runCycle(&handle);
	EXPECT_TRUE(priorityValues_isActive(&handle, PriorityValues_someRegion_B));
	EXPECT_TRUE(!priorityValues_isActive(&handle, PriorityValues_main_region_E));
}
