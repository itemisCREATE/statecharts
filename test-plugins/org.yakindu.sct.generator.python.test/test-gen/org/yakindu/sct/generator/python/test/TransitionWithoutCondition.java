package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/TransitionWithoutCondition/tests/test_transitionwithoutcondition.py",
	program = "pytest/TransitionWithoutCondition/tests/TransitionWithoutCondition",
	model = "testmodels/SCTUnit/TransitionWithoutCondition.sct",
	additionalFilesToCopy = {
		"pytest/TransitionWithoutCondition/tests/__init__.py",
		"pytest/TransitionWithoutCondition/tests/vtimer/__init__.py",
		"pytest/TransitionWithoutCondition/tests/vtimer/interface_timer.py",
		"pytest/TransitionWithoutCondition/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class TransitionWithoutCondition {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
