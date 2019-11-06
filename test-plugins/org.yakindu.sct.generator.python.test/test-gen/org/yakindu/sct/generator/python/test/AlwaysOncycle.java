package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/AlwaysOncycle/tests/test_alwaysoncycle.py",
	program = "pytest/AlwaysOncycle/tests/AlwaysOncycle",
	model = "testmodels/SCTUnit/AlwaysOncycle.sct",
	additionalFilesToCopy = {
		"pytest/AlwaysOncycle/tests/__init__.py",
		"pytest/AlwaysOncycle/tests/vtimer/__init__.py",
		"pytest/AlwaysOncycle/tests/vtimer/interface_timer.py",
		"pytest/AlwaysOncycle/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class AlwaysOncycle {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
