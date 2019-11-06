package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/StatechartActive/tests/test_statechartactive.py",
	program = "pytest/StatechartActive/tests/StatechartActive",
	model = "testmodels/SCTUnit/StatechartActive.sct",
	additionalFilesToCopy = {
		"pytest/StatechartActive/tests/__init__.py",
		"pytest/StatechartActive/tests/vtimer/__init__.py",
		"pytest/StatechartActive/tests/vtimer/interface_timer.py",
		"pytest/StatechartActive/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class StatechartActive {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
