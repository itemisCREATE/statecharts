package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/EventDrivenTriggeredByEvent/tests/test_eventdriventriggeredbyevent.py",
	program = "pytest/EventDrivenTriggeredByEvent/tests/EventDrivenTriggeredByEvent",
	model = "testmodels/SCTUnit/eventdriven/EventDrivenTriggeredByEvent.sct",
	additionalFilesToCopy = {
		"pytest/EventDrivenTriggeredByEvent/tests/__init__.py",
		"pytest/EventDrivenTriggeredByEvent/tests/vtimer/__init__.py",
		"pytest/EventDrivenTriggeredByEvent/tests/vtimer/interface_timer.py",
		"pytest/EventDrivenTriggeredByEvent/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class EventDrivenTriggeredByEvent {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
