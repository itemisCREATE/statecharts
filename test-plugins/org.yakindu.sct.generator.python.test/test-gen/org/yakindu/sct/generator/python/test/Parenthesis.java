package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/Parenthesis/tests/test_parenthesis.py",
	program = "pytest/Parenthesis/tests/Parenthesis",
	model = "testmodels/SCTUnit/Parenthesis.sct",
	additionalFilesToCopy = {
		"pytest/Parenthesis/tests/__init__.py",
		"pytest/Parenthesis/tests/vtimer/__init__.py",
		"pytest/Parenthesis/tests/vtimer/interface_timer.py",
		"pytest/Parenthesis/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class Parenthesis {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
