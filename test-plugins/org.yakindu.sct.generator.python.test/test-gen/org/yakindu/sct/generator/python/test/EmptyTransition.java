package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/EmptyTransition/tests/test_emptytransition.py",
	program = "pytest/EmptyTransition/tests/EmptyTransition",
	model = "testmodels/SCTUnit/EmptyTransition.sct",
	additionalFilesToCopy = {
		"pytest/EmptyTransition/tests/__init__.py",
		"pytest/EmptyTransition/tests/vtimer/__init__.py",
		"pytest/EmptyTransition/tests/vtimer/interface_timer.py",
		"pytest/EmptyTransition/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class EmptyTransition {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
