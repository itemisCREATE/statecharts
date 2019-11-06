package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/TransitionHandlesMultipleExits/tests/test_transitionhandlesmultipleexists.py",
	program = "pytest/TransitionHandlesMultipleExits/tests/TransitionHandlesMultipleExits",
	model = "testmodels/SCTUnit/exits/TransitionHandlesMultipleExits.sct",
	additionalFilesToCopy = {
		"pytest/TransitionHandlesMultipleExits/tests/__init__.py",
		"pytest/TransitionHandlesMultipleExits/tests/vtimer/__init__.py",
		"pytest/TransitionHandlesMultipleExits/tests/vtimer/interface_timer.py",
		"pytest/TransitionHandlesMultipleExits/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class TransitionHandlesMultipleExists {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
