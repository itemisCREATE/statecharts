package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/ReadOnlyVariable/tests/test_readonlyvariable.py",
	program = "pytest/ReadOnlyVariable/tests/ReadOnlyVariable",
	model = "testmodels/SCTUnit/ReadOnlyVariable.sct",
	additionalFilesToCopy = {
		"pytest/ReadOnlyVariable/tests/__init__.py",
		"pytest/ReadOnlyVariable/tests/vtimer/__init__.py",
		"pytest/ReadOnlyVariable/tests/vtimer/interface_timer.py",
		"pytest/ReadOnlyVariable/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class ReadOnlyVariable {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
