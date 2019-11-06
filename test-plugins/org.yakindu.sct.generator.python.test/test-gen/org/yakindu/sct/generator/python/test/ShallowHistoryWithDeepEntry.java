package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/ShallowHistoryWithDeepEntry/tests/test_shallowhistorywithdeepentry.py",
	program = "pytest/ShallowHistoryWithDeepEntry/tests/ShallowHistoryWithDeepEntry",
	model = "testmodels/SCTUnit/ShallowHistoryWithDeepEntry.sct",
	additionalFilesToCopy = {
		"pytest/ShallowHistoryWithDeepEntry/tests/__init__.py",
		"pytest/ShallowHistoryWithDeepEntry/tests/vtimer/__init__.py",
		"pytest/ShallowHistoryWithDeepEntry/tests/vtimer/interface_timer.py",
		"pytest/ShallowHistoryWithDeepEntry/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class ShallowHistoryWithDeepEntry {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
