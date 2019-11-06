package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/ShallowHistory/tests/test_shallowhistory.py",
	program = "pytest/ShallowHistory/tests/ShallowHistory",
	model = "testmodels/SCTUnit/ShallowHistory.sct",
	additionalFilesToCopy = {
		"pytest/ShallowHistory/tests/__init__.py",
		"pytest/ShallowHistory/tests/vtimer/__init__.py",
		"pytest/ShallowHistory/tests/vtimer/interface_timer.py",
		"pytest/ShallowHistory/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class ShallowHistory {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
