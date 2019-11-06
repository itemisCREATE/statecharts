package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/IntegerExpressions/tests/test_integerexpressions.py",
	program = "pytest/IntegerExpressions/tests/IntegerExpressions",
	model = "testmodels/SCTUnit/IntegerExpressions.sct",
	additionalFilesToCopy = {
		"pytest/IntegerExpressions/tests/__init__.py",
		"pytest/IntegerExpressions/tests/vtimer/__init__.py",
		"pytest/IntegerExpressions/tests/vtimer/interface_timer.py",
		"pytest/IntegerExpressions/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class IntegerExpressions {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
