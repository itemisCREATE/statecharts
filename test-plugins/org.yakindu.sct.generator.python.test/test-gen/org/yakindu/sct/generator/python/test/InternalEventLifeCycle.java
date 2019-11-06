package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/InternalEventLifeCycle/tests/test_internaleventlifecycle.py",
	program = "pytest/InternalEventLifeCycle/tests/InternalEventLifeCycle",
	model = "testmodels/SCTUnit/InternalEventLifeCycle.sct",
	additionalFilesToCopy = {
		"pytest/InternalEventLifeCycle/tests/__init__.py",
		"pytest/InternalEventLifeCycle/tests/vtimer/__init__.py",
		"pytest/InternalEventLifeCycle/tests/vtimer/interface_timer.py",
		"pytest/InternalEventLifeCycle/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class InternalEventLifeCycle {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
