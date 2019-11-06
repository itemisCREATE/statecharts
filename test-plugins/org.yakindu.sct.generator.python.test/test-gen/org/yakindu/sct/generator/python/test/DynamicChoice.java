package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/DynamicChoice/tests/test_dynamicchoice.py",
	program = "pytest/DynamicChoice/tests/DynamicChoice",
	model = "testmodels/SCTUnit/DynamicChoice.sct",
	additionalFilesToCopy = {
		"pytest/DynamicChoice/tests/__init__.py",
		"pytest/DynamicChoice/tests/vtimer/__init__.py",
		"pytest/DynamicChoice/tests/vtimer/interface_timer.py",
		"pytest/DynamicChoice/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class DynamicChoice {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
