package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/SyncJoin/tests/test_syncjoin.py",
	program = "pytest/SyncJoin/tests/SyncJoin",
	model = "testmodels/SCTUnit/SyncJoin.sct",
	additionalFilesToCopy = {
		"pytest/SyncJoin/tests/__init__.py",
		"pytest/SyncJoin/tests/vtimer/__init__.py",
		"pytest/SyncJoin/tests/vtimer/interface_timer.py",
		"pytest/SyncJoin/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class SyncJoin {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
