package org.yakindu.sct.generator.cpp.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.c.gtest.GTest;
import org.yakindu.sct.generator.c.gtest.GTestRunner;
import org.yakindu.sct.generator.c.gtest.GTestHelper;
import org.yakindu.sct.generator.c.gtest.GTestHelper.Compiler;

@GTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "gtests/StatemachineKeywordsTest/StatemachineKeywords.cc",
	program = "gtests/StatemachineKeywordsTest/StatechartKeywords",
	model = "testmodels/SCTUnit/StatechartKeywords.sct",
	additionalFilesToCopy = {
		"libraryTarget/sc_runner_timed.h",
		"libraryTarget/sc_runner_timed.cpp"
	},
	additionalFilesToCompile = {
		"StatechartKeywords.cpp",
		"sc_runner_timed.cpp"
	}
)
@RunWith(GTestRunner.class)
public class StatemachineKeywords {
protected final GTestHelper helper = new GTestHelper(this, Compiler.GPLUSPLUS);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}

}
