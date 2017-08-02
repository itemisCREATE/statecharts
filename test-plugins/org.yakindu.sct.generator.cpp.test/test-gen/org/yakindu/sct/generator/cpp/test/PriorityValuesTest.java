/* Generated by YAKINDU Statechart Tools code generator. */
package org.yakindu.sct.generator.cpp.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.c.gtest.GTest;
import org.yakindu.sct.generator.c.gtest.GTestRunner;
import org.yakindu.sct.generator.c.gtest.GTestHelper;

@GTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "gtests/PriorityValuesTest/PriorityValuesTest.cc",
	program = "gtests/PriorityValuesTest/PriorityValues",
	model = "testmodels/SCTUnit/PriorityValues.sct",
	additionalFilesToCopy = {
		"gtests/PriorityValuesTest/sc_runner.h",
		"gtests/PriorityValuesTest/sc_runner.cpp"
	},
	additionalFilesToCompile = {
		"PriorityValues.cpp",
		"sc_runner.cpp"
	}
)
@RunWith(GTestRunner.class)
public class PriorityValuesTest {
protected final GTestHelper helper = new GTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}

}
