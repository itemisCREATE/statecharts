package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/InEventLifeCycle/tests/test_ineventlifecycle.py",
	program = "pytest/InEventLifeCycle/tests/InEventLifeCycle",
	model = "testmodels/SCTUnit/InEventLifeCycle.sct",
	additionalFilesToCopy = {
		"pytest/InEventLifeCycle/tests/__init__.py",
		"pytest/InEventLifeCycle/tests/vtimer/__init__.py",
		"pytest/InEventLifeCycle/tests/vtimer/interface_timer.py",
		"pytest/InEventLifeCycle/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class InEventLifeCycle {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
