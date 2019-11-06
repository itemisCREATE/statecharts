package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/NullCheck/tests/test_nullcheck.py",
	program = "pytest/NullCheck/tests/NullCheck",
	model = "testmodels/SCTUnit/NullCheck.sct",
	additionalFilesToCopy = {
		"pytest/NullCheck/tests/__init__.py",
		"pytest/NullCheck/tests/vtimer/__init__.py",
		"pytest/NullCheck/tests/vtimer/interface_timer.py",
		"pytest/NullCheck/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class NullCheck {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
