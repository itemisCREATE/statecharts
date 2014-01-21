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
#include "InEventLifeCycle.h"


InEventLifeCycle handle;

TEST(StatemachineTest, eventLifeCycle) {
	inEventLifeCycle_init(&handle);
	inEventLifeCycle_enter(&handle);
	inEventLifeCycleIface_raise_e(&handle);
	EXPECT_TRUE(inEventLifeCycleIface_get_i(&handle) == 0);
	inEventLifeCycle_runCycle(&handle);
	EXPECT_TRUE(inEventLifeCycleIface_get_i(&handle) == 1);
}

		
