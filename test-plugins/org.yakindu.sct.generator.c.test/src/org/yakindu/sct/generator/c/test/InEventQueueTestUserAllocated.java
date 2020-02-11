package org.yakindu.sct.generator.c.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.c.gtest.GTest;
import org.yakindu.sct.generator.c.gtest.GTestHelper;
import org.yakindu.sct.generator.c.gtest.GTestHelper.Compiler;
import org.yakindu.sct.generator.c.gtest.GTestRunner;

@GTest(
		sourceFile = "gtests/InEventQueueTestUserAllocated/InEventQueueTest.cc", 
		program = "gtests/InEventQueueTestUserAllocated/InEventQueue", 
		model = "testmodels/SCTUnit/ineventqueue/InEventQueue.sct", 
		statechartBundle = "org.yakindu.sct.test.models",
		additionalFilesToCompile = {
				"InEventQueue.c"
		}
		)
@RunWith(GTestRunner.class)
public class InEventQueueTestUserAllocated {
	protected final GTestHelper helper = new GTestHelper(this, Compiler.GCC) {
	};
	
	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
