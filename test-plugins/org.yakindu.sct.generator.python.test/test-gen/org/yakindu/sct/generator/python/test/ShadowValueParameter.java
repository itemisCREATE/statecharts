package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/ShadowValueParameter/tests/test_shadowvalueparameter.py",
	program = "pytest/ShadowValueParameter/tests/ShadowValueParameter",
	model = "testmodels/SCTUnit/ShadowValueParameter.sct",
	additionalFilesToCopy = {
		"pytest/ShadowValueParameter/tests/__init__.py",
		"pytest/ShadowValueParameter/tests/vtimer/__init__.py",
		"pytest/ShadowValueParameter/tests/vtimer/interface_timer.py",
		"pytest/ShadowValueParameter/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class ShadowValueParameter {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
