/* Generated by YAKINDU Statechart Tools code generator. */
package org.yakindu.sct.generator.cpp.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.c.gtest.GTest;
import org.yakindu.sct.generator.c.gtest.GTestRunner;
import org.yakindu.sct.generator.c.gtest.GTestHelper;

@GTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "gtests/SimpleEventTest/SimpleEventTest.cc",
	program = "gtests/SimpleEventTest/SimpleEvent",
	model = "testmodels/SCTUnit/SimpleEvent.sct",
	additionalFilesToCopy = {
		"gtests/SimpleEventTest/sc_runner.h",
		"gtests/SimpleEventTest/sc_runner.cpp"
	},
	additionalFilesToCompile = {
		"SimpleEvent.cpp",
		"sc_runner.cpp"
	}
)
@RunWith(GTestRunner.class)
public class SimpleEventTest {
protected final GTestHelper helper = new GTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}

}
