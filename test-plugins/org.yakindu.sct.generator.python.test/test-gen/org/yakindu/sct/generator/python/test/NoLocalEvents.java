package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/NoLocalEvents/tests/test_nolocalevents.py",
	program = "pytest/NoLocalEvents/tests/NoLocalEvents",
	model = "testmodels/SCTUnit/eventdriven/NoLocalEvents.sct",
	additionalFilesToCopy = {
		"pytest/NoLocalEvents/tests/__init__.py",
		"pytest/NoLocalEvents/tests/vtimer/__init__.py",
		"pytest/NoLocalEvents/tests/vtimer/interface_timer.py",
		"pytest/NoLocalEvents/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class NoLocalEvents {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
