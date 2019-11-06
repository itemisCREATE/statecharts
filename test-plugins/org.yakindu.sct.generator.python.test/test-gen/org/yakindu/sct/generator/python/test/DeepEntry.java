package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/DeepEntry/tests/test_deepentry.py",
	program = "pytest/DeepEntry/tests/DeepEntry",
	model = "testmodels/SCTUnit/DeepEntry.sct",
	additionalFilesToCopy = {
		"pytest/DeepEntry/tests/__init__.py",
		"pytest/DeepEntry/tests/vtimer/__init__.py",
		"pytest/DeepEntry/tests/vtimer/interface_timer.py",
		"pytest/DeepEntry/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class DeepEntry {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
