package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/ExitSequence/tests/test_exitsequence.py",
	program = "pytest/ExitSequence/tests/ExitSequence",
	model = "testmodels/SCTUnit/ExitSequence.sct",
	additionalFilesToCopy = {
		"pytest/ExitSequence/tests/__init__.py",
		"pytest/ExitSequence/tests/vtimer/__init__.py",
		"pytest/ExitSequence/tests/vtimer/interface_timer.py",
		"pytest/ExitSequence/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class ExitSequence {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
