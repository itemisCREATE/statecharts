package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/Declarations/tests/test_declarations.py",
	program = "pytest/Declarations/tests/Declarations",
	model = "testmodels/SCTUnit/Declarations.sct",
	additionalFilesToCopy = {
		"pytest/Declarations/tests/__init__.py",
		"pytest/Declarations/tests/vtimer/__init__.py",
		"pytest/Declarations/tests/vtimer/interface_timer.py",
		"pytest/Declarations/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class Declarations {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
