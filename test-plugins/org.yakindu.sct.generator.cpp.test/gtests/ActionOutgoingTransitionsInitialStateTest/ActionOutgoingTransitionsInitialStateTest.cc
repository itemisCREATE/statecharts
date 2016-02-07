/**
* Copyright (c) 2016 committers of YAKINDU and others.
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
#include "ActionOutgoingTransitionsInitialState.h"

TEST(StatemachineTest, ActionOutgoingTransitionsInitialStateTest) {
	ActionOutgoingTransitionsInitialState* statechart = new ActionOutgoingTransitionsInitialState();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isStateActive(ActionOutgoingTransitionsInitialState::region_1__1));
	EXPECT_TRUE(statechart->isStateActive(ActionOutgoingTransitionsInitialState::region_2__1));
	EXPECT_TRUE(statechart->isStateActive(ActionOutgoingTransitionsInitialState::region_2__1_r1__2));
	EXPECT_TRUE(statechart->getDefaultSCI()->get_internalB()== 5l);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_c()== 5l);
	EXPECT_TRUE(statechart->getDefaultSCI()->get_d()== 5l);
	delete statechart;
}
