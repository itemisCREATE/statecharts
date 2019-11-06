package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/ParentFirstOrthogonalReactions/tests/test_parentfirstorthogonalreactions.py",
	program = "pytest/ParentFirstOrthogonalReactions/tests/ParentFirstOrthogonalReactions",
	model = "testmodels/SCTUnit/executionorder/ParentFirstOrthogonalReactions.sct",
	additionalFilesToCopy = {
		"pytest/ParentFirstOrthogonalReactions/tests/__init__.py",
		"pytest/ParentFirstOrthogonalReactions/tests/vtimer/__init__.py",
		"pytest/ParentFirstOrthogonalReactions/tests/vtimer/interface_timer.py",
		"pytest/ParentFirstOrthogonalReactions/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class ParentFirstOrthogonalReactions {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
