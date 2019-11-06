package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/FinalState/tests/test_finalstate.py",
	program = "pytest/FinalState/tests/FinalState",
	model = "testmodels/SCTUnit/FinalState.sct",
	additionalFilesToCopy = {
		"pytest/FinalState/tests/__init__.py",
		"pytest/FinalState/tests/vtimer/__init__.py",
		"pytest/FinalState/tests/vtimer/interface_timer.py",
		"pytest/FinalState/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class FinalState {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
