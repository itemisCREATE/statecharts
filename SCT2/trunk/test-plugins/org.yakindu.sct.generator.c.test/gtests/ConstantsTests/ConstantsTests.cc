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
#include "Constants.h"


Constants handle;

TEST(StatemachineTest, constantDefinition) {
	constants_init(&handle);
	constants_enter(&handle);
	EXPECT_TRUE(constants_isActive(&handle, Constants_main_region_A));
	EXPECT_TRUE(constantsIface_get_x(&handle) == 10);
	EXPECT_TRUE(constantsIface_get_y(&handle) == 20);
	EXPECT_TRUE(strcmp(constantsIfaceNamed_get_y(&handle) , "Hello World") == 0);
	constantsIface_raise_e(&handle);
	constants_runCycle(&handle);
	EXPECT_TRUE(constantsIface_get_result(&handle) == 20);
}

		
