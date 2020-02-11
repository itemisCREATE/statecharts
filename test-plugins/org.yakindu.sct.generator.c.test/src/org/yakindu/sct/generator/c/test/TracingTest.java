package org.yakindu.sct.generator.c.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.c.gtest.GTest;
import org.yakindu.sct.generator.c.gtest.GTestHelper;
import org.yakindu.sct.generator.c.gtest.GTestRunner;

@GTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "gtests/TracingTest/TracingTest.cc",
	program = "gtests/TracingTest/Tracing",
	model = "testmodels/SCTUnit/Tracing.sct",
	additionalFilesToCompile = {
			"Tracing.c"
	}
	)
@RunWith(GTestRunner.class)
public class TracingTest {

	protected final GTestHelper helper = new GTestHelper(this) {		
	};

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
