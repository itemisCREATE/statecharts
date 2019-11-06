package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/BitExpressions/tests/test_bitexpressions.py",
	program = "pytest/BitExpressions/tests/BitExpressions",
	model = "testmodels/SCTUnit/BitExpressions.sct",
	additionalFilesToCopy = {
		"pytest/BitExpressions/tests/__init__.py",
		"pytest/BitExpressions/tests/vtimer/__init__.py",
		"pytest/BitExpressions/tests/vtimer/interface_timer.py",
		"pytest/BitExpressions/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class BitExpressions {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
