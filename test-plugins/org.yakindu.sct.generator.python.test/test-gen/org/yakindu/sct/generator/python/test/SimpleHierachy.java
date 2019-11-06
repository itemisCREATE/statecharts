package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/SimpleHierachy/tests/test_simplehierachy.py",
	program = "pytest/SimpleHierachy/tests/SimpleHierachy",
	model = "testmodels/SCTUnit/SimpleHierachy.sct",
	additionalFilesToCopy = {
		"pytest/SimpleHierachy/tests/__init__.py",
		"pytest/SimpleHierachy/tests/vtimer/__init__.py",
		"pytest/SimpleHierachy/tests/vtimer/interface_timer.py",
		"pytest/SimpleHierachy/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class SimpleHierachy {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
