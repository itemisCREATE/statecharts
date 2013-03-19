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
#include "Safe.h"

TEST(StatemachineTest, SafeOpenSuccess) {
	Safe handle;
	safe_init(&handle);
	safe_enter(&handle);
	safe_runCycle(&handle);
	safeIfaceUser_raise_numberPressed(&handle, 3);
	safe_runCycle(&handle);
	safeIfaceUser_raise_numberPressed(&handle, 7);
	safe_runCycle(&handle);
	safeIfaceUser_raise_numberPressed(&handle, 5);
	safe_runCycle(&handle);
	EXPECT_TRUE(safeIfaceSafe_israised_open(&handle));
}
