/* Generated by YAKINDU Statechart Tools code generator. */
package org.yakindu.sct.generator.cpp.test;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.c.gtest.GTest;
import org.yakindu.sct.generator.c.gtest.GTestRunner;
import org.yakindu.sct.generator.c.gtest.GTestHelper;

@GTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "gtests/NamedInterfaceAccessTest/NamedInterfaceAccessTest.cc",
	program = "gtests/NamedInterfaceAccessTest/NamedInterfaceAccess",
	model = "testmodels/SCTUnit/NamedInterfaceAccess.sct",
	additionalFilesToCopy = {
		"gtests/NamedInterfaceAccessTest/sc_runner.h",
		"gtests/NamedInterfaceAccessTest/sc_runner.cpp"
	},
	additionalFilesToCompile = {
		"NamedInterfaceAccess.cpp",
		"sc_runner.cpp"
	}
)
@RunWith(GTestRunner.class)
public class NamedInterfaceAccessTest {
protected final GTestHelper helper = new GTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}

}
