package org.yakindu.sct.generator.cpp.test;

import java.util.Collection;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.c.gtest.GTest;
import org.yakindu.sct.generator.c.gtest.GTestHelper;
import org.yakindu.sct.generator.c.gtest.GTestRunner;
import org.yakindu.sct.generator.c.gtest.RunIfEnv;
import org.yakindu.sct.generator.c.gtest.GTestHelper.Compiler;

@GTest(sourceFile = "gtests/InEventQueueTest/InEventQueueTest.cc", program = "gtests/InEventQueueTest/InEventQueue", model = "testmodels/SCTUnit/ineventqueue/InEventQueue.sct", statechartBundle = "org.yakindu.sct.test.models")
@RunWith(GTestRunner.class)
@RunIfEnv("FAILING_GENERATOR_TESTS")
public class InEventQueueTest {
	protected final GTestHelper helper = new GTestHelper(this, Compiler.GPLUSPLUS) {

		@Override
		protected void getTestDataFiles(Collection<String> files) {
			super.getTestDataFiles(files);
			// files.add("gtests/TracingTest/TraceObserverImpl.h");
		}

		@Override
		protected void getSourceFiles(Collection<String> files) {
			super.getSourceFiles(files);
			files.add(getFileName(getTestProgram()) + ".cpp");
		}

	};

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
