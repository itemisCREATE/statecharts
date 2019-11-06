package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/EventDrivenOutEvents/tests/test_eventdrivenoutevents.py",
	program = "pytest/EventDrivenOutEvents/tests/EventDrivenOutEvents",
	model = "testmodels/SCTUnit/EventDrivenOutEvents.sct",
	additionalFilesToCopy = {
		"pytest/EventDrivenOutEvents/tests/__init__.py",
		"pytest/EventDrivenOutEvents/tests/vtimer/__init__.py",
		"pytest/EventDrivenOutEvents/tests/vtimer/interface_timer.py",
		"pytest/EventDrivenOutEvents/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class EventDrivenOutEvents {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
