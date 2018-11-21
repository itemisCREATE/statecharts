package org.yakindu.sct.generator.cpp.test;

import java.util.Collection;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.c.gtest.GTest;
import org.yakindu.sct.generator.c.gtest.GTestHelper;
import org.yakindu.sct.generator.c.gtest.GTestRunner;

@GTest(sourceFile = "gtests/TracingTest/TracingTest.cc", program = "gtests/TracingTest/Tracing", model = "testmodels/SCTUnit/Tracing.sct", statechartBundle = "org.yakindu.sct.test.models")
@RunWith(GTestRunner.class)
public class TracingTest {
	protected final GTestHelper helper = new GTestHelper(this) {

		@Override
		protected void getTestDataFiles(Collection<String> files) {
			super.getTestDataFiles(files);
			files.add("gtests/TracingTest/TracingInterfaceImpl.h");
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
