package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/ParentFirstLocalReactions/tests/test_parentfirstlocalreactions.py",
	program = "pytest/ParentFirstLocalReactions/tests/ParentFirstLocalReactions",
	model = "testmodels/SCTUnit/executionorder/ParentFirstLocalReactions.sct",
	additionalFilesToCopy = {
		"pytest/ParentFirstLocalReactions/tests/__init__.py",
		"pytest/ParentFirstLocalReactions/tests/vtimer/__init__.py",
		"pytest/ParentFirstLocalReactions/tests/vtimer/interface_timer.py",
		"pytest/ParentFirstLocalReactions/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class ParentFirstLocalReactions {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
