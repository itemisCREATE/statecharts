package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/RaiseEvent/tests/test_raiseevent.py",
	program = "pytest/RaiseEvent/tests/RaiseEvent",
	model = "testmodels/SCTUnit/RaiseEvent.sct",
	additionalFilesToCopy = {
		"pytest/RaiseEvent/tests/__init__.py",
		"pytest/RaiseEvent/tests/vtimer/__init__.py",
		"pytest/RaiseEvent/tests/vtimer/interface_timer.py",
		"pytest/RaiseEvent/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class RaiseEvent {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
