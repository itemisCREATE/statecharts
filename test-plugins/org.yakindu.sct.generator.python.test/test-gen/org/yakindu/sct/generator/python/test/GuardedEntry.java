package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/GuardedEntry/tests/test_guardedentry.py",
	program = "pytest/GuardedEntry/tests/GuardedEntry",
	model = "testmodels/SCTUnit/GuardedEntry.sct",
	additionalFilesToCopy = {
		"pytest/GuardedEntry/tests/__init__.py",
		"pytest/GuardedEntry/tests/vtimer/__init__.py",
		"pytest/GuardedEntry/tests/vtimer/interface_timer.py",
		"pytest/GuardedEntry/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class GuardedEntry {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
