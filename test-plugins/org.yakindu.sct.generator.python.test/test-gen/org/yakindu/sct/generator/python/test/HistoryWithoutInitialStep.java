package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/HistoryWithoutInitialStep/tests/test_historywithoutinitialstep.py",
	program = "pytest/HistoryWithoutInitialStep/tests/HistoryWithoutInitialStep",
	model = "testmodels/SCTUnit/HistoryWithoutInitialStep.sct",
	additionalFilesToCopy = {
		"pytest/HistoryWithoutInitialStep/tests/__init__.py",
		"pytest/HistoryWithoutInitialStep/tests/vtimer/__init__.py",
		"pytest/HistoryWithoutInitialStep/tests/vtimer/interface_timer.py",
		"pytest/HistoryWithoutInitialStep/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class HistoryWithoutInitialStep {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
