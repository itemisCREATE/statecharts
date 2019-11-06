package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/LogicalAnd/tests/test_logicalandtests.py",
	program = "pytest/LogicalAnd/tests/LogicalAnd",
	model = "testmodels/SCTUnit/LogicalAnd.sct",
	additionalFilesToCopy = {
		"pytest/LogicalAnd/tests/__init__.py",
		"pytest/LogicalAnd/tests/vtimer/__init__.py",
		"pytest/LogicalAnd/tests/vtimer/interface_timer.py",
		"pytest/LogicalAnd/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class LogicalAndTests {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
