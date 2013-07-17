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
#include "PerformanceTest.hpp"

TEST(StatemachineTest, test_100_000) {
	PerformanceTest* statechart = new PerformanceTest();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(PerformanceTest_mr_A));
	while (statechart->getSCInterface().get_c()< 100000) {
		if (isActive(PerformanceTest_mr_A)) {
					statechart->raise_e1();
				  }
				else {
					if (getSCInterface().get_c()%2== 0) {
								statechart->raise_e2();
							  }
							else {
								statechart->raise_e3();;
							}
					;
				}
		statechart->runCycle();
	}
	EXPECT_TRUE(statechart->getSCInterface().get_a()> 2);
	delete statechart;
}
TEST(StatemachineTest, test_1_000_000) {
	PerformanceTest* statechart = new PerformanceTest();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(PerformanceTest_mr_A));
	while (statechart->getSCInterface().get_c()< 1000000) {
		if (isActive(PerformanceTest_mr_A)) {
					statechart->raise_e1();
				  }
				else {
					if (getSCInterface().get_c()%2== 0) {
								statechart->raise_e2();
							  }
							else {
								statechart->raise_e3();;
							}
					;
				}
		statechart->runCycle();
	}
	EXPECT_TRUE(statechart->getSCInterface().get_a()> 2);
	delete statechart;
}
TEST(StatemachineTest, test_10_000_000) {
	PerformanceTest* statechart = new PerformanceTest();
	statechart->init();
	statechart->enter();
	EXPECT_TRUE(statechart->isActive(PerformanceTest_mr_A));
	while (statechart->getSCInterface().get_c()< 10000000) {
		if (isActive(PerformanceTest_mr_A)) {
					statechart->raise_e1();
				  }
				else {
					if (getSCInterface().get_c()%2== 0) {
								statechart->raise_e2();
							  }
							else {
								statechart->raise_e3();;
							}
					;
				}
		statechart->runCycle();
	}
	EXPECT_TRUE(statechart->getSCInterface().get_a()> 2);
	delete statechart;
}
