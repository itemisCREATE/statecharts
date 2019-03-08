package org.yakindu.sct.generator.c.test;

import java.util.Collection;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.c.gtest.GTest;
import org.yakindu.sct.generator.c.gtest.GTestHelper;
import org.yakindu.sct.generator.c.gtest.GTestHelper.Compiler;
import org.yakindu.sct.generator.c.gtest.GTestRunner;

@GTest(sourceFile = "gtests/InEventQueueTest/InEventQueueTest.cc", program = "gtests/InEventQueueTest/InEventQueue", model = "testmodels/SCTUnit/ineventqueue/InEventQueue.sct", statechartBundle = "org.yakindu.sct.test.models")
@RunWith(GTestRunner.class)
public class InEventQueueTest {
	protected final GTestHelper helper = new GTestHelper(this, Compiler.GCC) {
		
		@Override
		protected void getTestDataFiles(Collection<String> files) {
			super.getTestDataFiles(files);
			// files.add("gtests/TracingTest/TraceObserverImpl.h");
		}
		
		@Override
		protected void getSourceFiles(Collection<String> files) {
			super.getSourceFiles(files);
			files.add(getFileName(getTestProgram()) + ".c");
		}
		
	};
	
	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
