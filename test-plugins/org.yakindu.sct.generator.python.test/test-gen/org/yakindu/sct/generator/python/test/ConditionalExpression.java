package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/ConditionalExpressions/tests/test_conditionalexpression.py",
	program = "pytest/ConditionalExpressions/tests/ConditionalExpressions",
	model = "testmodels/SCTUnit/ConditionalExpressions.sct",
	additionalFilesToCopy = {
		"pytest/ConditionalExpressions/tests/__init__.py",
		"pytest/ConditionalExpressions/tests/vtimer/__init__.py",
		"pytest/ConditionalExpressions/tests/vtimer/interface_timer.py",
		"pytest/ConditionalExpressions/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class ConditionalExpression {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
