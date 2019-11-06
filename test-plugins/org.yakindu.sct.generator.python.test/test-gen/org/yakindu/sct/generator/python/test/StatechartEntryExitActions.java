package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/StatechartEntryAndExitActions/tests/test_statechartentryexitactions.py",
	program = "pytest/StatechartEntryAndExitActions/tests/StatechartEntryAndExitActions",
	model = "testmodels/SCTUnit/statechartactions/StatechartEntryAndExitActions.sct",
	additionalFilesToCopy = {
		"pytest/StatechartEntryAndExitActions/tests/__init__.py",
		"pytest/StatechartEntryAndExitActions/tests/vtimer/__init__.py",
		"pytest/StatechartEntryAndExitActions/tests/vtimer/interface_timer.py",
		"pytest/StatechartEntryAndExitActions/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class StatechartEntryExitActions {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
