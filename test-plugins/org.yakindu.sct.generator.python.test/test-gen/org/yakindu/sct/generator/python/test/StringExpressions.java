package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/StringExpressions/tests/test_stringexpressions.py",
	program = "pytest/StringExpressions/tests/StringExpressions",
	model = "testmodels/SCTUnit/StringExpressions.sct",
	additionalFilesToCopy = {
		"pytest/StringExpressions/tests/__init__.py",
		"pytest/StringExpressions/tests/vtimer/__init__.py",
		"pytest/StringExpressions/tests/vtimer/interface_timer.py",
		"pytest/StringExpressions/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class StringExpressions {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
