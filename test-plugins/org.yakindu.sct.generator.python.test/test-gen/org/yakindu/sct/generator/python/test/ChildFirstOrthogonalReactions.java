package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/ChildFirstOrthogonalReactions/tests/test_childfirstorthogonalreactions.py",
	program = "pytest/ChildFirstOrthogonalReactions/tests/ChildFirstOrthogonalReactions",
	model = "testmodels/SCTUnit/executionorder/ChildFirstOrthogonalReactions.sct",
	additionalFilesToCopy = {
		"pytest/ChildFirstOrthogonalReactions/tests/__init__.py",
		"pytest/ChildFirstOrthogonalReactions/tests/vtimer/__init__.py",
		"pytest/ChildFirstOrthogonalReactions/tests/vtimer/interface_timer.py",
		"pytest/ChildFirstOrthogonalReactions/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class ChildFirstOrthogonalReactions {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
