package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/ExitOnSelfTransition/tests/test_exitonselftransition.py",
	program = "pytest/ExitOnSelfTransition/tests/ExitOnSelfTransition",
	model = "testmodels/SCTUnit/ExitOnSelfTransition.sct",
	additionalFilesToCopy = {
		"pytest/ExitOnSelfTransition/tests/__init__.py",
		"pytest/ExitOnSelfTransition/tests/vtimer/__init__.py",
		"pytest/ExitOnSelfTransition/tests/vtimer/interface_timer.py",
		"pytest/ExitOnSelfTransition/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class ExitOnSelfTransition {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
