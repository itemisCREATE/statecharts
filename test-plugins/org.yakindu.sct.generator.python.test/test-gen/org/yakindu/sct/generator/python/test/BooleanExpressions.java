package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/BooleanExpressions/tests/test_booleanexpressions.py",
	program = "pytest/BooleanExpressions/tests/BooleanExpressions",
	model = "testmodels/SCTUnit/BooleanExpressions.sct",
	additionalFilesToCopy = {
		"pytest/BooleanExpressions/tests/__init__.py",
		"pytest/BooleanExpressions/tests/vtimer/__init__.py",
		"pytest/BooleanExpressions/tests/vtimer/interface_timer.py",
		"pytest/BooleanExpressions/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class BooleanExpressions {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
