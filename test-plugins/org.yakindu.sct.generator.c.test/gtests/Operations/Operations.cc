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
#include "Operations.h"


Operations handle;

TEST(StatemachineTest, OperationsTest) {
	operations_init(&handle);
	operations_enter(&handle);
	operations_runCycle(&handle);
	EXPECT_TRUE(operations_isActive(&handle, Operations_main_region_B));
	operationsIface_raise_ev(&handle);
	operations_runCycle(&handle);
	EXPECT_TRUE(operations_isActive(&handle, Operations_main_region_C));
	operationsIface_raise_ev(&handle);
	operations_runCycle(&handle);
	EXPECT_TRUE(operations_isActive(&handle, Operations_main_region_D));
}

		
