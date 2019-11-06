package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/EntryChoice/tests/test_entrychoice.py",
	program = "pytest/EntryChoice/tests/EntryChoice",
	model = "testmodels/SCTUnit/EntryChoice.sct",
	additionalFilesToCopy = {
		"pytest/EntryChoice/tests/__init__.py",
		"pytest/EntryChoice/tests/vtimer/__init__.py",
		"pytest/EntryChoice/tests/vtimer/interface_timer.py",
		"pytest/EntryChoice/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class EntryChoice {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
