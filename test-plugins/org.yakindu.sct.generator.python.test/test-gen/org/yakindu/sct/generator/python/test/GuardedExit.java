package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/GuardedExit/tests/test_guardedexit.py",
	program = "pytest/GuardedExit/tests/GuardedExit",
	model = "testmodels/SCTUnit/GuardedExit.sct",
	additionalFilesToCopy = {
		"pytest/GuardedExit/tests/__init__.py",
		"pytest/GuardedExit/tests/vtimer/__init__.py",
		"pytest/GuardedExit/tests/vtimer/interface_timer.py",
		"pytest/GuardedExit/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class GuardedExit {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
