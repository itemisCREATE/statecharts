package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/Constants/tests/test_constantstests.py",
	program = "pytest/Constants/tests/Constants",
	model = "testmodels/SCTUnit/Constants.sct",
	additionalFilesToCopy = {
		"pytest/Constants/tests/__init__.py",
		"pytest/Constants/tests/vtimer/__init__.py",
		"pytest/Constants/tests/vtimer/interface_timer.py",
		"pytest/Constants/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class ConstantsTests {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
