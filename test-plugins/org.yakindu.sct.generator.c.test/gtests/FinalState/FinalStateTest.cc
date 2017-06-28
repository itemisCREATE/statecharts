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
#include "FinalState.h"

static FinalState statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		finalState_init(&statechart);
	}
};


TEST_F(StatemachineTest, StatechartNameTest) {					
	finalState_enter(&statechart);
	finalState_runCycle(&statechart);
	EXPECT_TRUE(finalState_isFinal(&statechart));
}


