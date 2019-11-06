package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/ValuedEvents/tests/test_valuedevents.py",
	program = "pytest/ValuedEvents/tests/ValuedEvents",
	model = "testmodels/SCTUnit/ValuedEvents.sct",
	additionalFilesToCopy = {
		"pytest/ValuedEvents/tests/__init__.py",
		"pytest/ValuedEvents/tests/vtimer/__init__.py",
		"pytest/ValuedEvents/tests/vtimer/interface_timer.py",
		"pytest/ValuedEvents/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class ValuedEvents {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
