package org.yakindu.sct.generator.cpp.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.c.gtest.GTest;
import org.yakindu.sct.generator.c.gtest.GTestRunner;
import org.yakindu.sct.generator.c.gtest.GTestHelper;
import org.yakindu.sct.generator.c.gtest.GTestHelper.Compiler;

@GTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "gtests/EntryExitSelfTransitionTest/EntryExitSelfTransitionTest.cc",
	program = "gtests/EntryExitSelfTransitionTest/EntryExitSelfTransition",
	model = "testmodels/SCTUnit/EntryExitSelfTransition.sct",
	additionalFilesToCopy = {
		"libraryTarget/sc_runner.h",
		"libraryTarget/sc_runner.cpp"
	},
	additionalFilesToCompile = {
		"EntryExitSelfTransition.cpp",
		"sc_runner.cpp"
	}
)
@RunWith(GTestRunner.class)
public class EntryExitSelfTransitionTest {
protected final GTestHelper helper = new GTestHelper(this, Compiler.GPLUSPLUS);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}

}
