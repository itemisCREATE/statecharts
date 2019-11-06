package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/TypeAlias/tests/test_typealias.py",
	program = "pytest/TypeAlias/tests/TypeAlias",
	model = "testmodels/SCTUnit/TypeAlias.sct",
	additionalFilesToCopy = {
		"pytest/TypeAlias/tests/__init__.py",
		"pytest/TypeAlias/tests/vtimer/__init__.py",
		"pytest/TypeAlias/tests/vtimer/interface_timer.py",
		"pytest/TypeAlias/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class TypeAlias {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
