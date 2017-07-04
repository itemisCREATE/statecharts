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

static StatechartActive statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		statechartActive_init(&statechart);
	}
};


TEST_F(StatemachineTest, inactiveBeforeEnter) {					
	EXPECT_TRUE(!statechartActive_isActive(&statechart));
}
TEST_F(StatemachineTest, activeAfterEnter) {					
	statechartActive_enter(&statechart);
	EXPECT_TRUE(statechartActive_isActive(&statechart));
}
TEST_F(StatemachineTest, inactiveAfterExit) {					
	statechartActive_enter(&statechart);
	statechartActive_exit(&statechart);
	EXPECT_TRUE(!statechartActive_isActive(&statechart));
}
TEST_F(StatemachineTest, activeAfterReenter) {					
	statechartActive_enter(&statechart);
	statechartActive_exit(&statechart);
	statechartActive_enter(&statechart);
	EXPECT_TRUE(statechartActive_isActive(&statechart));
}


