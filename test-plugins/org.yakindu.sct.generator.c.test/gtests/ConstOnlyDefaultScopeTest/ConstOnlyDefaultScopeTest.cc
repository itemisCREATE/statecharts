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
#include "ConstOnlyDefaultScope.h"

ConstOnlyDefaultScope handle;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		constOnlyDefaultScope_init(&handle);
	}
};


TEST_F(StatemachineTest, statechartEntry) {					
	constOnlyDefaultScope_enter(&handle);
	EXPECT_TRUE(constOnlyDefaultScope_isStateActive(&handle, ConstOnlyDefaultScope_ConstOnlyDefaultScope_main_region_A));
}
TEST_F(StatemachineTest, stateTransition) {					
	constOnlyDefaultScope_enter(&handle);
	constOnlyDefaultScopeIfaceA_raise_e(&handle, 1l);
	constOnlyDefaultScope_runCycle(&handle);
	EXPECT_TRUE(constOnlyDefaultScope_isStateActive(&handle, ConstOnlyDefaultScope_ConstOnlyDefaultScope_main_region_B));
}


