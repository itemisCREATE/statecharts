package org.yakindu.sct.generator.cpp.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.c.gtest.GTest;
import org.yakindu.sct.generator.c.gtest.GTestHelper;
import org.yakindu.sct.generator.c.gtest.GTestHelper.Compiler;
import org.yakindu.sct.generator.c.gtest.GTestRunner;

@GTest(
		sourceFile = "gtests/TracingTest/TracingTest.cc", 
		program = "gtests/TracingTest/Tracing", 
		model = "testmodels/SCTUnit/Tracing.sct", 
		statechartBundle = "org.yakindu.sct.test.models",
		additionalFilesToCopy = {
			"gtests/TracingTest/TraceObserverImpl.h"
		},
		additionalFilesToCompile = {
			"Tracing.cpp"
		}
		)
@RunWith(GTestRunner.class)
public class TracingTest {
	protected final GTestHelper helper = new GTestHelper(this, Compiler.GPLUSPLUS) {
	};

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
