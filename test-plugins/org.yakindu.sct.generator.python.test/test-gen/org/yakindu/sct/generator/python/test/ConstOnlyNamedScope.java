package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/ConstOnlyNamedScope/tests/test_constonlynamedscope.py",
	program = "pytest/ConstOnlyNamedScope/tests/ConstOnlyNamedScope",
	model = "testmodels/SCTUnit/declarations/ConstOnlyNamedScope.sct",
	additionalFilesToCopy = {
		"pytest/ConstOnlyNamedScope/tests/__init__.py",
		"pytest/ConstOnlyNamedScope/tests/vtimer/__init__.py",
		"pytest/ConstOnlyNamedScope/tests/vtimer/interface_timer.py",
		"pytest/ConstOnlyNamedScope/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class ConstOnlyNamedScope {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
