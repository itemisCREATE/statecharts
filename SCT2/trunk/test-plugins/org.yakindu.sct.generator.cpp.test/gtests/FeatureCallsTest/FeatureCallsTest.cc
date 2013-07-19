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
#include "FeatureCalls.h"

TEST(StatemachineTest, FeatureCalls) {
	FeatureCalls* statechart = new FeatureCalls();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(FeatureCalls::FeatureCalls_main_region_A));
	statechart->runCycle();
	EXPECT_TRUE(statechart->isActive(FeatureCalls::FeatureCalls_main_region_A));
	delete statechart;
}
