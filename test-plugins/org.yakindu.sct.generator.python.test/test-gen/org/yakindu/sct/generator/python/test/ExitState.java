package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/ExitState/tests/test_exitstate.py",
	program = "pytest/ExitState/tests/ExitState",
	model = "testmodels/SCTUnit/exits/ExitState.sct",
	additionalFilesToCopy = {
		"pytest/ExitState/tests/__init__.py",
		"pytest/ExitState/tests/vtimer/__init__.py",
		"pytest/ExitState/tests/vtimer/interface_timer.py",
		"pytest/ExitState/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class ExitState {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
