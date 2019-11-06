package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/ConstantsVariation/tests/test_constantsvariationtests.py",
	program = "pytest/ConstantsVariation/tests/ConstantsVariation",
	model = "testmodels/SCTUnit/ConstantsVariation.sct",
	additionalFilesToCopy = {
		"pytest/ConstantsVariation/tests/__init__.py",
		"pytest/ConstantsVariation/tests/vtimer/__init__.py",
		"pytest/ConstantsVariation/tests/vtimer/interface_timer.py",
		"pytest/ConstantsVariation/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class ConstantsVariationTests {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
