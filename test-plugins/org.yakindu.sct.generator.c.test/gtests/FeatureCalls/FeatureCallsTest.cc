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
#include "FeatureCalls.h"

static FeatureCalls statechart;

class StatemachineTest : public ::testing::Test{
	protected:
	virtual void SetUp() {
		featureCalls_init(&statechart);
	}
};


TEST_F(StatemachineTest, FeatureCalls) {					
	featureCalls_enter(&statechart);
	EXPECT_TRUE(featureCalls_isStateActive(&statechart, FeatureCalls_main_region_A));
	featureCalls_runCycle(&statechart);
	EXPECT_TRUE(featureCalls_isStateActive(&statechart, FeatureCalls_main_region_A));
}


