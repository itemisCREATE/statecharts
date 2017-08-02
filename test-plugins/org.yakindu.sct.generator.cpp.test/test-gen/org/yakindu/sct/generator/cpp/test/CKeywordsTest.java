/* Generated by YAKINDU Statechart Tools code generator. */
package org.yakindu.sct.generator.cpp.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.c.gtest.GTest;
import org.yakindu.sct.generator.c.gtest.GTestRunner;
import org.yakindu.sct.generator.c.gtest.GTestHelper;

@GTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "gtests/CKeywordsTest/CKeywordsTest.cc",
	program = "gtests/CKeywordsTest/CKeywords",
	model = "testmodels/SCTUnit/CKeywords.sct",
	additionalFilesToCopy = {
		"gtests/CKeywordsTest/sc_runner.h",
		"gtests/CKeywordsTest/sc_runner.cpp"
	},
	additionalFilesToCompile = {
		"CKeywords.cpp",
		"sc_runner.cpp"
	}
)
@RunWith(GTestRunner.class)
public class CKeywordsTest {
protected final GTestHelper helper = new GTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}

}
