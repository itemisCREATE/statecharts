package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/Operations/tests/test_operationstest.py",
	program = "pytest/Operations/tests/Operations",
	model = "testmodels/SCTUnit/Operations.sct",
	additionalFilesToCopy = {
		"pytest/Operations/tests/__init__.py",
		"pytest/Operations/tests/vtimer/__init__.py",
		"pytest/Operations/tests/vtimer/interface_timer.py",
		"pytest/Operations/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class OperationsTest {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
