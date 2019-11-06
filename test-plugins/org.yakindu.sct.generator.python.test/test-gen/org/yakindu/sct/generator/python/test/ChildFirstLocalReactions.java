package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/ChildFirstLocalReactions/tests/test_childfirstlocalreactions.py",
	program = "pytest/ChildFirstLocalReactions/tests/ChildFirstLocalReactions",
	model = "testmodels/SCTUnit/executionorder/ChildFirstLocalReactions.sct",
	additionalFilesToCopy = {
		"pytest/ChildFirstLocalReactions/tests/__init__.py",
		"pytest/ChildFirstLocalReactions/tests/vtimer/__init__.py",
		"pytest/ChildFirstLocalReactions/tests/vtimer/interface_timer.py",
		"pytest/ChildFirstLocalReactions/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class ChildFirstLocalReactions {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
