package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/CastExpressions/tests/test_castexpressions.py",
	program = "pytest/CastExpressions/tests/CastExpressions",
	model = "testmodels/SCTUnit/CastExpressions.sct",
	additionalFilesToCopy = {
		"pytest/CastExpressions/tests/__init__.py",
		"pytest/CastExpressions/tests/vtimer/__init__.py",
		"pytest/CastExpressions/tests/vtimer/interface_timer.py",
		"pytest/CastExpressions/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class CastExpressions {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
