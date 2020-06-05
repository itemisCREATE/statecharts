package org.yakindu.sct.generator.c.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.c.gtest.GTest;
import org.yakindu.sct.generator.c.gtest.GTestHelper;
import org.yakindu.sct.generator.c.gtest.GTestRunner;
import org.yakindu.sct.generator.c.gtest.GTestHelper.Compiler;

@GTest(
		sourceFile = "gtests/ObservablesTest/ObservablesTest.cc",
		program = "gtests/ObservablesTest/Observables",
		model = "testmodels/SCTUnit/observables/Observables.sct",
		statechartBundle = "org.yakindu.sct.test.models",
		additionalFilesToCompile = {
				"sc_rxc.c"
		}
		)
@RunWith(GTestRunner.class)
public class ObservablesTest {
	protected final GTestHelper helper = new GTestHelper(this, Compiler.GCC) {
	};

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
