package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/ChildFirstTransitionTaking/tests/test_childfirsttransitiontaking.py",
	program = "pytest/ChildFirstTransitionTaking/tests/ChildFirstTransitionTaking",
	model = "testmodels/SCTUnit/executionorder/ChildFirstTransitionTaking.sct",
	additionalFilesToCopy = {
		"pytest/ChildFirstTransitionTaking/tests/__init__.py",
		"pytest/ChildFirstTransitionTaking/tests/vtimer/__init__.py",
		"pytest/ChildFirstTransitionTaking/tests/vtimer/interface_timer.py",
		"pytest/ChildFirstTransitionTaking/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class ChildFirstTransitionTaking {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
