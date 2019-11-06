package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/FloatModulo/tests/test_floatmodulo.py",
	program = "pytest/FloatModulo/tests/FloatModulo",
	model = "testmodels/SCTUnit/FloatModulo.sct",
	additionalFilesToCopy = {
		"pytest/FloatModulo/tests/__init__.py",
		"pytest/FloatModulo/tests/vtimer/__init__.py",
		"pytest/FloatModulo/tests/vtimer/interface_timer.py",
		"pytest/FloatModulo/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class FloatModulo {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
