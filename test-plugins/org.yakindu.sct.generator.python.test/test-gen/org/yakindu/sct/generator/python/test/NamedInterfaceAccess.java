package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/NamedInterfaceAccess/tests/test_namedinterfaceaccess.py",
	program = "pytest/NamedInterfaceAccess/tests/NamedInterfaceAccess",
	model = "testmodels/SCTUnit/NamedInterfaceAccess.sct",
	additionalFilesToCopy = {
		"pytest/NamedInterfaceAccess/tests/__init__.py",
		"pytest/NamedInterfaceAccess/tests/vtimer/__init__.py",
		"pytest/NamedInterfaceAccess/tests/vtimer/interface_timer.py",
		"pytest/NamedInterfaceAccess/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class NamedInterfaceAccess {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
