package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/SimpleEvent/tests/test_simpleevent.py",
	program = "pytest/SimpleEvent/tests/SimpleEvent",
	model = "testmodels/SCTUnit/SimpleEvent.sct",
	additionalFilesToCopy = {
		"pytest/SimpleEvent/tests/__init__.py",
		"pytest/SimpleEvent/tests/vtimer/__init__.py",
		"pytest/SimpleEvent/tests/vtimer/interface_timer.py",
		"pytest/SimpleEvent/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class SimpleEvent {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
