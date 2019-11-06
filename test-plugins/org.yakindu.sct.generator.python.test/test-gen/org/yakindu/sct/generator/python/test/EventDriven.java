package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/EventDriven/tests/test_eventdriven.py",
	program = "pytest/EventDriven/tests/EventDriven",
	model = "testmodels/SCTUnit/EventDriven.sct",
	additionalFilesToCopy = {
		"pytest/EventDriven/tests/__init__.py",
		"pytest/EventDriven/tests/vtimer/__init__.py",
		"pytest/EventDriven/tests/vtimer/interface_timer.py",
		"pytest/EventDriven/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class EventDriven {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
