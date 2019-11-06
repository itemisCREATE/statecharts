package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/StaticChoice/tests/test_staticchoice.py",
	program = "pytest/StaticChoice/tests/StaticChoice",
	model = "testmodels/SCTUnit/StaticChoice.sct",
	additionalFilesToCopy = {
		"pytest/StaticChoice/tests/__init__.py",
		"pytest/StaticChoice/tests/vtimer/__init__.py",
		"pytest/StaticChoice/tests/vtimer/interface_timer.py",
		"pytest/StaticChoice/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class StaticChoice {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
