package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/OutEventVisibilityEventDriven/tests/test_outeventvisibilityeventdriven.py",
	program = "pytest/OutEventVisibilityEventDriven/tests/OutEventVisibilityEventDriven",
	model = "testmodels/SCTUnit/events/OutEventVisibilityEventDriven.sct",
	additionalFilesToCopy = {
		"pytest/OutEventVisibilityEventDriven/tests/__init__.py",
		"pytest/OutEventVisibilityEventDriven/tests/vtimer/__init__.py",
		"pytest/OutEventVisibilityEventDriven/tests/vtimer/interface_timer.py",
		"pytest/OutEventVisibilityEventDriven/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class OutEventVisibilityEventDriven {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
