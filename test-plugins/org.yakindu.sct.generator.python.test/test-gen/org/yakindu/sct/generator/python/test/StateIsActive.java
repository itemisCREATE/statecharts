package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/StateIsActive/tests/test_stateisactive.py",
	program = "pytest/StateIsActive/tests/StateIsActive",
	model = "testmodels/SCTUnit/StateIsActive.sct",
	additionalFilesToCopy = {
		"pytest/StateIsActive/tests/__init__.py",
		"pytest/StateIsActive/tests/vtimer/__init__.py",
		"pytest/StateIsActive/tests/vtimer/interface_timer.py",
		"pytest/StateIsActive/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class StateIsActive {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
