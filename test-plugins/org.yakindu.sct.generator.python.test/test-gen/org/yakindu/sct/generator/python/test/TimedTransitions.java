package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/TimedTransitions/tests/test_timedtransitions.py",
	program = "pytest/TimedTransitions/tests/TimedTransitions",
	model = "testmodels/SCTUnit/TimedTransitions.sct",
	additionalFilesToCopy = {
		"pytest/TimedTransitions/tests/__init__.py",
		"pytest/TimedTransitions/tests/vtimer/__init__.py",
		"pytest/TimedTransitions/tests/vtimer/interface_timer.py",
		"pytest/TimedTransitions/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class TimedTransitions {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
