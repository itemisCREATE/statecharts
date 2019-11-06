package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/HistoryWithExitPoint/tests/test_historywithexitpoint.py",
	program = "pytest/HistoryWithExitPoint/tests/HistoryWithExitPoint",
	model = "testmodels/SCTUnit/HistoryWithExitPoint.sct",
	additionalFilesToCopy = {
		"pytest/HistoryWithExitPoint/tests/__init__.py",
		"pytest/HistoryWithExitPoint/tests/vtimer/__init__.py",
		"pytest/HistoryWithExitPoint/tests/vtimer/interface_timer.py",
		"pytest/HistoryWithExitPoint/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class HistoryWithExitPoint {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
