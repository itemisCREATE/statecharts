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
#include "StatechartActive.h"


StatechartActive handle;

TEST(StatemachineTest, inactiveBeforeEnter) {
	statechartActive_init(&handle);
	EXPECT_TRUE(false);
}
TEST(StatemachineTest, activeAfterEnter) {
	statechartActive_init(&handle);
	statechartActive_enter(&handle);
	EXPECT_TRUE(false);
}
TEST(StatemachineTest, inactiveAfterExit) {
	statechartActive_init(&handle);
	statechartActive_enter(&handle);
	statechartActive_exit(&handle);
	EXPECT_TRUE(false);
}
TEST(StatemachineTest, activeAfterReenter) {
	statechartActive_init(&handle);
	statechartActive_enter(&handle);
	statechartActive_exit(&handle);
	statechartActive_enter(&handle);
	EXPECT_TRUE(false);
}

		
