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
#include "LocalReactions.h"


LocalReactions handle;

TEST(StatemachineTest, LocalReactionsTest) {
	localReactions_init(&handle);
	localReactions_enter(&handle);
	EXPECT_TRUE(localReactions_isActive(&handle, LocalReactions_main_region_A));
	localReactions_runCycle(&handle);
	EXPECT_TRUE(localReactionsIface_get_x(&handle) == 1);
}

		
