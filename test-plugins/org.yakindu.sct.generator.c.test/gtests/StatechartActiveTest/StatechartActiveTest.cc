/**
* Copyright (c) 2017 committers of YAKINDU and others.
* All rights reserved. This program and the accompanying materials
* are made available under the terms of the Eclipse Public License v1.0
* which accompanies this distribution, and is available at
* http://www.eclipse.org/legal/epl-v10.html
*
* Contributors:
*     committers of YAKINDU - initial API and implementation
*/
#include "gtest/gtest.h"
#include "StatechartActive.h"

StatechartActive handle;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechartActive_init(&handle);
	}
};


TEST_F(StatemachineTest, inactiveBeforeEnter) {					
	EXPECT_TRUE(!statechartActive_isActive(&handle));
}
TEST_F(StatemachineTest, activeAfterEnter) {					
	statechartActive_enter(&handle);
	EXPECT_TRUE(statechartActive_isActive(&handle));
}
TEST_F(StatemachineTest, inactiveAfterExit) {					
	statechartActive_enter(&handle);
	statechartActive_exit(&handle);
	EXPECT_TRUE(!statechartActive_isActive(&handle));
}
TEST_F(StatemachineTest, activeAfterReenter) {					
	statechartActive_enter(&handle);
	statechartActive_exit(&handle);
	statechartActive_enter(&handle);
	EXPECT_TRUE(statechartActive_isActive(&handle));
}


