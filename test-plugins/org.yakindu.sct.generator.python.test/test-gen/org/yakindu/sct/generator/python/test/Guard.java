package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/Guard/tests/test_guard.py",
	program = "pytest/Guard/tests/Guard",
	model = "testmodels/SCTUnit/Guard.sct",
	additionalFilesToCopy = {
		"pytest/Guard/tests/__init__.py",
		"pytest/Guard/tests/vtimer/__init__.py",
		"pytest/Guard/tests/vtimer/interface_timer.py",
		"pytest/Guard/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class Guard {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
