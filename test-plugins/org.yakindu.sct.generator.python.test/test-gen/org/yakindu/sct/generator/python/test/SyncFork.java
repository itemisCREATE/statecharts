package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/SyncFork/tests/test_syncfork.py",
	program = "pytest/SyncFork/tests/SyncFork",
	model = "testmodels/SCTUnit/SyncFork.sct",
	additionalFilesToCopy = {
		"pytest/SyncFork/tests/__init__.py",
		"pytest/SyncFork/tests/vtimer/__init__.py",
		"pytest/SyncFork/tests/vtimer/interface_timer.py",
		"pytest/SyncFork/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class SyncFork {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
