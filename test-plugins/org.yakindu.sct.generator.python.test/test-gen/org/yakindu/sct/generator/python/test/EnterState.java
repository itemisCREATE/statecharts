package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/EnterState/tests/test_enterstate.py",
	program = "pytest/EnterState/tests/EnterState",
	model = "testmodels/SCTUnit/EnterState.sct",
	additionalFilesToCopy = {
		"pytest/EnterState/tests/__init__.py",
		"pytest/EnterState/tests/vtimer/__init__.py",
		"pytest/EnterState/tests/vtimer/interface_timer.py",
		"pytest/EnterState/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class EnterState {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
