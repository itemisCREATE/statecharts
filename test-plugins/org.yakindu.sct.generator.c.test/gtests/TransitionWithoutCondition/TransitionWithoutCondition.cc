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
#include "TransitionWithoutCondition.h"


TransitionWithoutCondition handle;

TEST(StatemachineTest, TransitionWithoutConditionTest) {
	transitionWithoutCondition_init(&handle);
	transitionWithoutCondition_enter(&handle);
	EXPECT_TRUE(transitionWithoutCondition_isStateActive(&handle, TransitionWithoutCondition_main_region_A));
	transitionWithoutCondition_runCycle(&handle);
	EXPECT_TRUE(transitionWithoutCondition_isStateActive(&handle, TransitionWithoutCondition_main_region_B));
}

		
