package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/OutEventLifeCycle/tests/test_outeventlifecycle.py",
	program = "pytest/OutEventLifeCycle/tests/OutEventLifeCycle",
	model = "testmodels/SCTUnit/OutEventLifeCycle.sct",
	additionalFilesToCopy = {
		"pytest/OutEventLifeCycle/tests/__init__.py",
		"pytest/OutEventLifeCycle/tests/vtimer/__init__.py",
		"pytest/OutEventLifeCycle/tests/vtimer/interface_timer.py",
		"pytest/OutEventLifeCycle/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class OutEventLifeCycle {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
