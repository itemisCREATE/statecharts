package org.yakindu.sct.generator.cpp.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.c.gtest.GTest;
import org.yakindu.sct.generator.c.gtest.GTestHelper;
import org.yakindu.sct.generator.c.gtest.GTestHelper.Compiler;
import org.yakindu.sct.generator.c.gtest.GTestRunner;

@GTest(
		sourceFile = "gtests/InEventQueueTest/InEventQueueTest.cc",
		program = "gtests/InEventQueueTest/InEventQueue",
		model = "testmodels/SCTUnit/ineventqueue/InEventQueue.sct",
		statechartBundle = "org.yakindu.sct.test.models",
		additionalFilesToCompile = {
				"InEventQueue.cpp"
		}
		)
@RunWith(GTestRunner.class)
public class InEventQueueTest {
	protected final GTestHelper helper = new GTestHelper(this, Compiler.GPLUSPLUS) {
	};

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
