package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/SameNameDifferentRegion/tests/test_samenamedifferentregion.py",
	program = "pytest/SameNameDifferentRegion/tests/SameNameDifferentRegion",
	model = "testmodels/SCTUnit/SameNameDifferentRegion.sct",
	additionalFilesToCopy = {
		"pytest/SameNameDifferentRegion/tests/__init__.py",
		"pytest/SameNameDifferentRegion/tests/vtimer/__init__.py",
		"pytest/SameNameDifferentRegion/tests/vtimer/interface_timer.py",
		"pytest/SameNameDifferentRegion/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class SameNameDifferentRegion {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
