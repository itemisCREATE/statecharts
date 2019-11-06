package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/OutEventWithPayload/tests/test_outeventwithpayload.py",
	program = "pytest/OutEventWithPayload/tests/OutEventWithPayload",
	model = "testmodels/SCTUnit/events/OutEventWithPayload.sct",
	additionalFilesToCopy = {
		"pytest/OutEventWithPayload/tests/__init__.py",
		"pytest/OutEventWithPayload/tests/vtimer/__init__.py",
		"pytest/OutEventWithPayload/tests/vtimer/interface_timer.py",
		"pytest/OutEventWithPayload/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class OutEventWithPayload {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
