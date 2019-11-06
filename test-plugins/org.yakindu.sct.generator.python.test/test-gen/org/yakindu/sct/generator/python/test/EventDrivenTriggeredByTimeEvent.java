package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/EventDrivenTriggeredByTimeEvent/tests/test_eventdriventriggeredbytimeevent.py",
	program = "pytest/EventDrivenTriggeredByTimeEvent/tests/EventDrivenTriggeredByTimeEvent",
	model = "testmodels/SCTUnit/eventdriven/EventDrivenTriggeredByTimeEvent.sct",
	additionalFilesToCopy = {
		"pytest/EventDrivenTriggeredByTimeEvent/tests/__init__.py",
		"pytest/EventDrivenTriggeredByTimeEvent/tests/vtimer/__init__.py",
		"pytest/EventDrivenTriggeredByTimeEvent/tests/vtimer/interface_timer.py",
		"pytest/EventDrivenTriggeredByTimeEvent/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class EventDrivenTriggeredByTimeEvent {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
