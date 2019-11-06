package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/LocalEvents/tests/test_localevents.py",
	program = "pytest/LocalEvents/tests/LocalEvents",
	model = "testmodels/SCTUnit/eventdriven/LocalEvents.sct",
	additionalFilesToCopy = {
		"pytest/LocalEvents/tests/__init__.py",
		"pytest/LocalEvents/tests/vtimer/__init__.py",
		"pytest/LocalEvents/tests/vtimer/interface_timer.py",
		"pytest/LocalEvents/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class LocalEvents {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
