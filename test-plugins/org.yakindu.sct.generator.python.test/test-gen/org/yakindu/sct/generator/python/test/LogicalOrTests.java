package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/LogicalOr/tests/test_logicalortests.py",
	program = "pytest/LogicalOr/tests/LogicalOr",
	model = "testmodels/SCTUnit/LogicalOr.sct",
	additionalFilesToCopy = {
		"pytest/LogicalOr/tests/__init__.py",
		"pytest/LogicalOr/tests/vtimer/__init__.py",
		"pytest/LogicalOr/tests/vtimer/interface_timer.py",
		"pytest/LogicalOr/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class LogicalOrTests {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
