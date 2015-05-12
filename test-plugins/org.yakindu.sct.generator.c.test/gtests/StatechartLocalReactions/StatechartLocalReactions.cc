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
#include "StatechartLocalReactions.h"


StatechartLocalReactions handle;

TEST(StatemachineTest, statechartLocalReactionsTest) {
	statechartLocalReactions_init(&handle);
	statechartLocalReactions_enter(&handle);
	EXPECT_TRUE(statechartLocalReactions_isStateActive(&handle, StatechartLocalReactions_main_region_S1));
	EXPECT_TRUE(statechartLocalReactions_isStateActive(&handle, StatechartLocalReactions_region2_a));
	while (statechartLocalReactionsIface_get_myInt(&handle) < 10l) {
		EXPECT_TRUE(statechartLocalReactions_isStateActive(&handle, StatechartLocalReactions_region2_a));
		if (statechartLocalReactionsIface_get_myInt(&handle) %2l== 0l) {
					EXPECT_TRUE(statechartLocalReactions_isStateActive(&handle, StatechartLocalReactions_main_region_S1));;
				  }
				else {
					EXPECT_TRUE(statechartLocalReactions_isStateActive(&handle, StatechartLocalReactions_main_region_S2));;
				}
		statechartLocalReactions_runCycle(&handle);
	}
}

		
