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
#include "FeatureCalls.h"


FeatureCalls handle;

TEST(StatemachineTest, FeatureCalls) {
	featureCalls_init(&handle);
	featureCalls_enter(&handle);
	EXPECT_TRUE(featureCalls_isStateActive(&handle, FeatureCalls_main_region_A));
	featureCalls_runCycle(&handle);
	EXPECT_TRUE(featureCalls_isStateActive(&handle, FeatureCalls_main_region_A));
}

		
