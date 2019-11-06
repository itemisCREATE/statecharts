package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/StatechartKeywords/tests/test_statemachinekeywords.py",
	program = "pytest/StatechartKeywords/tests/StatechartKeywords",
	model = "testmodels/SCTUnit/StatechartKeywords.sct",
	additionalFilesToCopy = {
		"pytest/StatechartKeywords/tests/__init__.py",
		"pytest/StatechartKeywords/tests/vtimer/__init__.py",
		"pytest/StatechartKeywords/tests/vtimer/interface_timer.py",
		"pytest/StatechartKeywords/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class StatemachineKeywords {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
