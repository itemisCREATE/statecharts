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
#include "PerformanceTest.h"

TEST(StatemachineTest, test_100_000) {
	PerformanceTest handle;
	performanceTest_init(&handle);
	performanceTest_enter(&handle);
	EXPECT_TRUE(performanceTest_isActive(&handle, PerformanceTest_mr_A));
	while (performanceTestIface_get_c(&handle) < 100000) {
		if (performanceTest_isActive(&handle, PerformanceTest_mr_A)) {
					performanceTestIface_raise_e1(&handle);;
				  }
				else {
					if (performanceTestIface_get_c(&handle) %2== 0) {
								performanceTestIface_raise_e2(&handle);;
							  }
							else {
								performanceTestIface_raise_e3(&handle);;
							}
					;
				}
		performanceTest_runCycle(&handle);
	}
	EXPECT_TRUE(performanceTestIface_get_a(&handle) > 2);
}
TEST(StatemachineTest, test_1_000_000) {
	PerformanceTest handle;
	performanceTest_init(&handle);
	performanceTest_enter(&handle);
	EXPECT_TRUE(performanceTest_isActive(&handle, PerformanceTest_mr_A));
	while (performanceTestIface_get_c(&handle) < 1000000) {
		if (performanceTest_isActive(&handle, PerformanceTest_mr_A)) {
					performanceTestIface_raise_e1(&handle);;
				  }
				else {
					if (performanceTestIface_get_c(&handle) %2== 0) {
								performanceTestIface_raise_e2(&handle);;
							  }
							else {
								performanceTestIface_raise_e3(&handle);;
							}
					;
				}
		performanceTest_runCycle(&handle);
	}
	EXPECT_TRUE(performanceTestIface_get_a(&handle) > 2);
}
TEST(StatemachineTest, test_10_000_000) {
	PerformanceTest handle;
	performanceTest_init(&handle);
	performanceTest_enter(&handle);
	EXPECT_TRUE(performanceTest_isActive(&handle, PerformanceTest_mr_A));
	while (performanceTestIface_get_c(&handle) < 10000000) {
		if (performanceTest_isActive(&handle, PerformanceTest_mr_A)) {
					performanceTestIface_raise_e1(&handle);;
				  }
				else {
					if (performanceTestIface_get_c(&handle) %2== 0) {
								performanceTestIface_raise_e2(&handle);;
							  }
							else {
								performanceTestIface_raise_e3(&handle);;
							}
					;
				}
		performanceTest_runCycle(&handle);
	}
	EXPECT_TRUE(performanceTestIface_get_a(&handle) > 2);
}
