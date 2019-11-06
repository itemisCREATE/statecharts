package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/LocalReactions/tests/test_localreactions.py",
	program = "pytest/LocalReactions/tests/LocalReactions",
	model = "testmodels/SCTUnit/LocalReactions.sct",
	additionalFilesToCopy = {
		"pytest/LocalReactions/tests/__init__.py",
		"pytest/LocalReactions/tests/vtimer/__init__.py",
		"pytest/LocalReactions/tests/vtimer/interface_timer.py",
		"pytest/LocalReactions/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class LocalReactions {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
