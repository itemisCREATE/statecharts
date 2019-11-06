package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/ConstOnlyDefaultScope/tests/test_constonlydefaultscope.py",
	program = "pytest/ConstOnlyDefaultScope/tests/ConstOnlyDefaultScope",
	model = "testmodels/SCTUnit/declarations/ConstOnlyDefaultScope.sct",
	additionalFilesToCopy = {
		"pytest/ConstOnlyDefaultScope/tests/__init__.py",
		"pytest/ConstOnlyDefaultScope/tests/vtimer/__init__.py",
		"pytest/ConstOnlyDefaultScope/tests/vtimer/interface_timer.py",
		"pytest/ConstOnlyDefaultScope/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class ConstOnlyDefaultScope {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
