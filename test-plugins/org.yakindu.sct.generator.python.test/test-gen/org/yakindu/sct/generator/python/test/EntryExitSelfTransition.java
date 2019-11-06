package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/EntryExitSelfTransition/tests/test_entryexitselftransition.py",
	program = "pytest/EntryExitSelfTransition/tests/EntryExitSelfTransition",
	model = "testmodels/SCTUnit/EntryExitSelfTransition.sct",
	additionalFilesToCopy = {
		"pytest/EntryExitSelfTransition/tests/__init__.py",
		"pytest/EntryExitSelfTransition/tests/vtimer/__init__.py",
		"pytest/EntryExitSelfTransition/tests/vtimer/interface_timer.py",
		"pytest/EntryExitSelfTransition/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class EntryExitSelfTransition {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
