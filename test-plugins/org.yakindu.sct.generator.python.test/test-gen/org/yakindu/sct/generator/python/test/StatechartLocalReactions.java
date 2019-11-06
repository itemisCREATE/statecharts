package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/StatechartLocalReactions/tests/test_statechartlocalreactions.py",
	program = "pytest/StatechartLocalReactions/tests/StatechartLocalReactions",
	model = "testmodels/SCTUnit/StatechartLocalReactions.sct",
	additionalFilesToCopy = {
		"pytest/StatechartLocalReactions/tests/__init__.py",
		"pytest/StatechartLocalReactions/tests/vtimer/__init__.py",
		"pytest/StatechartLocalReactions/tests/vtimer/interface_timer.py",
		"pytest/StatechartLocalReactions/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class StatechartLocalReactions {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
