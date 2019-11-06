package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/STextKeywordsInStatesAndRegions/tests/test_stextkeywordsinstatesandregions.py",
	program = "pytest/STextKeywordsInStatesAndRegions/tests/STextKeywordsInStatesAndRegions",
	model = "testmodels/SCTUnit/STextKeywordsInStatesAndRegions.sct",
	additionalFilesToCopy = {
		"pytest/STextKeywordsInStatesAndRegions/tests/__init__.py",
		"pytest/STextKeywordsInStatesAndRegions/tests/vtimer/__init__.py",
		"pytest/STextKeywordsInStatesAndRegions/tests/vtimer/interface_timer.py",
		"pytest/STextKeywordsInStatesAndRegions/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class STextKeywordsInStatesAndRegions {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
