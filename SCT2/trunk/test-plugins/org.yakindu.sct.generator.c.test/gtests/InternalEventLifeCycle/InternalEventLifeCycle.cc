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
#include "InternalEventLifeCycle.h"


InternalEventLifeCycle handle;

TEST(StatemachineTest, InternalEventLifeCycleTest) {
	internalEventLifeCycle_init(&handle);
	internalEventLifeCycle_enter(&handle);
	EXPECT_TRUE(internalEventLifeCycle_isActive(&handle, InternalEventLifeCycle_A));
	EXPECT_TRUE(internalEventLifeCycle_isActive(&handle, InternalEventLifeCycle_C));
	internalEventLifeCycleIface_raise_e(&handle);
	internalEventLifeCycle_runCycle(&handle);
	EXPECT_TRUE(internalEventLifeCycle_isActive(&handle, InternalEventLifeCycle_A));
	EXPECT_TRUE(internalEventLifeCycle_isActive(&handle, InternalEventLifeCycle_D));
	internalEventLifeCycle_runCycle(&handle);
	EXPECT_TRUE(internalEventLifeCycle_isActive(&handle, InternalEventLifeCycle_A));
	EXPECT_TRUE(internalEventLifeCycle_isActive(&handle, InternalEventLifeCycle_D));
	internalEventLifeCycleIface_raise_f(&handle);
	internalEventLifeCycle_runCycle(&handle);
	EXPECT_TRUE(internalEventLifeCycle_isActive(&handle, InternalEventLifeCycle_A));
	EXPECT_TRUE(internalEventLifeCycle_isActive(&handle, InternalEventLifeCycle_C));
	internalEventLifeCycle_runCycle(&handle);
	EXPECT_TRUE(internalEventLifeCycle_isActive(&handle, InternalEventLifeCycle_A));
	EXPECT_TRUE(internalEventLifeCycle_isActive(&handle, InternalEventLifeCycle_C));
}

		
