/* Generated by YAKINDU Statechart Tools code generator. */
package org.yakindu.sct.generator.cpp.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.c.gtest.GTest;
import org.yakindu.sct.generator.c.gtest.GTestRunner;
import org.yakindu.sct.generator.c.gtest.GTestHelper;

@GTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "gtests/StatechartLocalReactionsTest/StatechartLocalReactionsTest.cc",
	program = "gtests/StatechartLocalReactionsTest/StatechartLocalReactions",
	model = "testmodels/SCTUnit/StatechartLocalReactions.sct",
	additionalFilesToCopy = {
		"gtests/StatechartLocalReactionsTest/sc_runner.h",
		"gtests/StatechartLocalReactionsTest/sc_runner.cpp"
	},
	additionalFilesToCompile = {
		"StatechartLocalReactions.cpp",
		"sc_runner.cpp"
	}
)
@RunWith(GTestRunner.class)
public class StatechartLocalReactionsTest {
protected final GTestHelper helper = new GTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}

}
