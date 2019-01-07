package org.yakindu.sct.generator.c.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.c.gtest.GTest;
import org.yakindu.sct.generator.c.gtest.GTestRunner;
import org.yakindu.sct.generator.c.gtest.GTestHelper;

@GTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "gtests/InEventLifeCycle/InEventLifeCycleTest.cc",
	program = "gtests/InEventLifeCycle/InEventLifeCycle",
	model = "testmodels/SCTUnit/InEventLifeCycle.sct",
	additionalFilesToCopy = {
		"libraryTarget/sc_timer_service.c",
		"libraryTarget/sc_timer_service.h"
	},
	additionalFilesToCompile = {
		"InEventLifeCycle.c",
		"sc_timer_service.c"
	}
)
@RunWith(GTestRunner.class)
public class InEventLifeCycleTest {

	protected final GTestHelper helper = new GTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
