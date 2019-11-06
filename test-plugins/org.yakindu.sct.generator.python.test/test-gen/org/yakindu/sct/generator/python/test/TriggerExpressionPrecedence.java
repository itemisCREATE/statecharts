package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/TriggerExpressionPrecedence/tests/test_triggerexpressionprecedence.py",
	program = "pytest/TriggerExpressionPrecedence/tests/TriggerExpressionPrecedence",
	model = "testmodels/SCTUnit/expressions/TriggerExpressionPrecedence.sct",
	additionalFilesToCopy = {
		"pytest/TriggerExpressionPrecedence/tests/__init__.py",
		"pytest/TriggerExpressionPrecedence/tests/vtimer/__init__.py",
		"pytest/TriggerExpressionPrecedence/tests/vtimer/interface_timer.py",
		"pytest/TriggerExpressionPrecedence/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class TriggerExpressionPrecedence {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
