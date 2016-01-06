/**
* Copyright (c) 2016 committers of YAKINDU and others.
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
#include "ActionOutgoingTransitionsInitialState.h"


ActionOutgoingTransitionsInitialState handle;

TEST(StatemachineTest, ActionOutgoingTransitionsInitialStateTest) {
	actionOutgoingTransitionsInitialState_init(&handle);
	actionOutgoingTransitionsInitialState_enter(&handle);
	EXPECT_TRUE(actionOutgoingTransitionsInitialState_isStateActive(&handle, ActionOutgoingTransitionsInitialState_region_1__1));
	EXPECT_TRUE(actionOutgoingTransitionsInitialState_isStateActive(&handle, ActionOutgoingTransitionsInitialState_region_2__1));
	EXPECT_TRUE(actionOutgoingTransitionsInitialState_isStateActive(&handle, ActionOutgoingTransitionsInitialState_region_2__1_r1__2));
	EXPECT_TRUE(actionOutgoingTransitionsInitialStateIface_get_internalB(&handle) == 5l);
	EXPECT_TRUE(actionOutgoingTransitionsInitialStateIface_get_c(&handle) == 5l);
	EXPECT_TRUE(actionOutgoingTransitionsInitialStateIface_get_d(&handle) == 5l);
}

		
