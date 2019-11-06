package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/DeepHistory/tests/test_deephistory.py",
	program = "pytest/DeepHistory/tests/DeepHistory",
	model = "testmodels/SCTUnit/DeepHistory.sct",
	additionalFilesToCopy = {
		"pytest/DeepHistory/tests/__init__.py",
		"pytest/DeepHistory/tests/vtimer/__init__.py",
		"pytest/DeepHistory/tests/vtimer/interface_timer.py",
		"pytest/DeepHistory/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class DeepHistory {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
