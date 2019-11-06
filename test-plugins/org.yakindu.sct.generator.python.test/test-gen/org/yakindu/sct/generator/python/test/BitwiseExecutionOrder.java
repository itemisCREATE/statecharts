package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/BitwiseExecutionOrder/tests/test_bitwiseexecutionorder.py",
	program = "pytest/BitwiseExecutionOrder/tests/BitwiseExecutionOrder",
	model = "testmodels/SCTUnit/BitwiseExecutionOrder.sct",
	additionalFilesToCopy = {
		"pytest/BitwiseExecutionOrder/tests/__init__.py",
		"pytest/BitwiseExecutionOrder/tests/vtimer/__init__.py",
		"pytest/BitwiseExecutionOrder/tests/vtimer/interface_timer.py",
		"pytest/BitwiseExecutionOrder/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class BitwiseExecutionOrder {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
