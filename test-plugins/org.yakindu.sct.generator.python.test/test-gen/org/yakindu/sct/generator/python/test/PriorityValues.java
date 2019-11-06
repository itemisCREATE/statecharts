package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/PriorityValues/tests/test_priorityvalues.py",
	program = "pytest/PriorityValues/tests/PriorityValues",
	model = "testmodels/SCTUnit/PriorityValues.sct",
	additionalFilesToCopy = {
		"pytest/PriorityValues/tests/__init__.py",
		"pytest/PriorityValues/tests/vtimer/__init__.py",
		"pytest/PriorityValues/tests/vtimer/interface_timer.py",
		"pytest/PriorityValues/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class PriorityValues {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
