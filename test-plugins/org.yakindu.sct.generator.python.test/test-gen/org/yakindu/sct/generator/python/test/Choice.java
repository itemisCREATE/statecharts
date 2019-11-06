package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/Choice/tests/test_choice.py",
	program = "pytest/Choice/tests/Choice",
	model = "testmodels/SCTUnit/Choice.sct",
	additionalFilesToCopy = {
		"pytest/Choice/tests/__init__.py",
		"pytest/Choice/tests/vtimer/__init__.py",
		"pytest/Choice/tests/vtimer/interface_timer.py",
		"pytest/Choice/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class Choice {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
