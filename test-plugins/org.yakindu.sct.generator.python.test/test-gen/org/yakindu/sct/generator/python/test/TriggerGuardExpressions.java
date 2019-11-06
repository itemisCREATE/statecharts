package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/TriggerGuardExpressions/tests/test_triggerguardexpressions.py",
	program = "pytest/TriggerGuardExpressions/tests/TriggerGuardExpressions",
	model = "testmodels/SCTUnit/TriggerGuardExpressions.sct",
	additionalFilesToCopy = {
		"pytest/TriggerGuardExpressions/tests/__init__.py",
		"pytest/TriggerGuardExpressions/tests/vtimer/__init__.py",
		"pytest/TriggerGuardExpressions/tests/vtimer/interface_timer.py",
		"pytest/TriggerGuardExpressions/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class TriggerGuardExpressions {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
