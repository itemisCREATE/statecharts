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
#include "SimpleHierachy.h"

TEST(StatemachineTest, simpleHierachyTest) {
	SimpleHierachy handle;
	simpleHierachy_init(&handle);
	simpleHierachy_enter(&handle);
	EXPECT_TRUE(simpleHierachy_isActive(&handle, SimpleHierachy_main_region_A));
	simpleHierachyIface_raise_event1(&handle);
	simpleHierachyIface_raise_event1(&handle);
	simpleHierachyIface_raise_event1(&handle);
	simpleHierachy_runCycle(&handle);
	EXPECT_TRUE(simpleHierachy_isActive(&handle, SimpleHierachy_main_region_B));
	EXPECT_TRUE(simpleHierachy_isActive(&handle, SimpleHierachy_main_region_B_subregion1_B1));
}
