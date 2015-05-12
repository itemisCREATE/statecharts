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
#include "SameNameDifferentRegion.h"


SameNameDifferentRegion handle;

TEST(StatemachineTest, sameNameDifferenRegionTest) {
	sameNameDifferentRegion_init(&handle);
	sameNameDifferentRegion_enter(&handle);
	EXPECT_TRUE(sameNameDifferentRegion_isStateActive(&handle, SameNameDifferentRegion_main_region_StateA));
	sameNameDifferentRegionIface_raise_e1(&handle);
	sameNameDifferentRegion_runCycle(&handle);
	EXPECT_TRUE(sameNameDifferentRegion_isStateActive(&handle, SameNameDifferentRegion_main_region_StateB));
	EXPECT_TRUE(sameNameDifferentRegion_isStateActive(&handle, SameNameDifferentRegion_main_region_StateB_r1_StateA));
	sameNameDifferentRegionIface_raise_e1(&handle);
	sameNameDifferentRegion_runCycle(&handle);
	EXPECT_TRUE(sameNameDifferentRegion_isStateActive(&handle, SameNameDifferentRegion_main_region_StateB));
	EXPECT_TRUE(sameNameDifferentRegion_isStateActive(&handle, SameNameDifferentRegion_main_region_StateB_r1_StateB));
}

		
