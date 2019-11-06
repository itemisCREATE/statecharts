package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/EventDrivenInternalEvent/tests/test_eventdriveninternalevent.py",
	program = "pytest/EventDrivenInternalEvent/tests/EventDrivenInternalEvent",
	model = "testmodels/SCTUnit/eventdriven/EventDrivenInternalEvent.sct",
	additionalFilesToCopy = {
		"pytest/EventDrivenInternalEvent/tests/__init__.py",
		"pytest/EventDrivenInternalEvent/tests/vtimer/__init__.py",
		"pytest/EventDrivenInternalEvent/tests/vtimer/interface_timer.py",
		"pytest/EventDrivenInternalEvent/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class EventDrivenInternalEvent {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
