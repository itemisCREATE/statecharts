package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/ConstOnlyInternalScope/tests/test_constonlyinternalscope.py",
	program = "pytest/ConstOnlyInternalScope/tests/ConstOnlyInternalScope",
	model = "testmodels/SCTUnit/declarations/ConstOnlyInternalScope.sct",
	additionalFilesToCopy = {
		"pytest/ConstOnlyInternalScope/tests/__init__.py",
		"pytest/ConstOnlyInternalScope/tests/vtimer/__init__.py",
		"pytest/ConstOnlyInternalScope/tests/vtimer/interface_timer.py",
		"pytest/ConstOnlyInternalScope/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class ConstOnlyInternalScope {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
