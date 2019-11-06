package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/CKeywords/tests/test_ckeywords.py",
	program = "pytest/CKeywords/tests/CKeywords",
	model = "testmodels/SCTUnit/CKeywords.sct",
	additionalFilesToCopy = {
		"pytest/CKeywords/tests/__init__.py",
		"pytest/CKeywords/tests/vtimer/__init__.py",
		"pytest/CKeywords/tests/vtimer/interface_timer.py",
		"pytest/CKeywords/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class CKeywords {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
