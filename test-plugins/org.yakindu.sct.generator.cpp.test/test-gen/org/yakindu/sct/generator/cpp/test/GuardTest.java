/* Generated by YAKINDU Statechart Tools code generator. */
package org.yakindu.sct.generator.cpp.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.c.gtest.GTest;
import org.yakindu.sct.generator.c.gtest.GTestRunner;
import org.yakindu.sct.generator.c.gtest.GTestHelper;

@GTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "gtests/GuardTest/GuardTest.cc",
	program = "gtests/GuardTest/Guard",
	model = "testmodels/SCTUnit/Guard.sct",
	additionalFilesToCopy = {
		"gtests/GuardTest/sc_runner.h",
		"gtests/GuardTest/sc_runner.cpp"
	},
	additionalFilesToCompile = {
		"Guard.cpp",
		"sc_runner.cpp"
	}
)
@RunWith(GTestRunner.class)
public class GuardTest {
protected final GTestHelper helper = new GTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}

}
