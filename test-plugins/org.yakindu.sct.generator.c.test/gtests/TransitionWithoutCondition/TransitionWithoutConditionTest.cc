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
#include "TransitionWithoutCondition.h"

static TransitionWithoutCondition statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		transitionWithoutCondition_init(&statechart);
	}
};


TEST_F(StatemachineTest, TransitionWithoutConditionTest) {					
	transitionWithoutCondition_enter(&statechart);
	EXPECT_TRUE(transitionWithoutCondition_isStateActive(&statechart, TransitionWithoutCondition_main_region_A));
	transitionWithoutCondition_runCycle(&statechart);
	EXPECT_TRUE(transitionWithoutCondition_isStateActive(&statechart, TransitionWithoutCondition_main_region_B));
}


