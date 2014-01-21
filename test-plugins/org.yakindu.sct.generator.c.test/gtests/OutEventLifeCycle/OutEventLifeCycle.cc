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
#include "OutEventLifeCycle.h"


OutEventLifeCycle handle;

TEST(StatemachineTest, availableAfterCycle) {
	outEventLifeCycle_init(&handle);
	outEventLifeCycle_enter(&handle);
	outEventLifeCycleIface_raise_e(&handle);
	outEventLifeCycle_runCycle(&handle);
	EXPECT_TRUE(outEventLifeCycleIface_israised_f(&handle) );
}
TEST(StatemachineTest, availableWithinCycle) {
	outEventLifeCycle_init(&handle);
	outEventLifeCycle_enter(&handle);
	outEventLifeCycleIface_raise_e(&handle);
	outEventLifeCycle_runCycle(&handle);
	EXPECT_TRUE(outEventLifeCycleIface_get_f_available_in_cycle(&handle) );
}
TEST(StatemachineTest, unvailableWithin2ndCycle) {
	outEventLifeCycle_init(&handle);
	outEventLifeCycle_enter(&handle);
	outEventLifeCycleIface_raise_e(&handle);
	outEventLifeCycle_runCycle(&handle);
	outEventLifeCycle_runCycle(&handle);
	EXPECT_TRUE(!outEventLifeCycleIface_get_f_available_in_next_cycle(&handle) );
}
TEST(StatemachineTest, unvailableAfter2ndCycle) {
	outEventLifeCycle_init(&handle);
	outEventLifeCycle_enter(&handle);
	outEventLifeCycleIface_raise_e(&handle);
	outEventLifeCycle_runCycle(&handle);
	outEventLifeCycle_runCycle(&handle);
	EXPECT_TRUE(!outEventLifeCycleIface_israised_f(&handle) );
}

		
