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
#include "DeepEntry.h"

TEST(StatemachineTest, enterToSubstate) {
	DeepEntry handle;
	deepEntry_init(&handle);
	EXPECT_TRUE(deepEntryIface_get_x(&handle) == 0);
	EXPECT_TRUE(deepEntryIface_get_y(&handle) == 0);
	EXPECT_TRUE(deepEntryIface_get_z(&handle) == 0);
	deepEntry_enter(&handle);
	EXPECT_TRUE(deepEntryIface_get_x(&handle) == 1);
	EXPECT_TRUE(deepEntryIface_get_y(&handle) == 1);
	EXPECT_TRUE(deepEntryIface_get_z(&handle) == 2);
	deepEntryIface_raise_e(&handle);
	deepEntry_runCycle(&handle);
	EXPECT_TRUE(deepEntry_isActive(&handle, DeepEntry_r2_B_r_BB));
	deepEntryIface_raise_f(&handle);
	deepEntry_runCycle(&handle);
	EXPECT_TRUE(deepEntry_isActive(&handle, DeepEntry_r2_C));
	deepEntryIface_raise_f(&handle);
	deepEntry_runCycle(&handle);
	EXPECT_TRUE(deepEntry_isActive(&handle, DeepEntry_r2_B_r_BB));
	EXPECT_TRUE(deepEntryIface_get_y(&handle) == 1);
}
