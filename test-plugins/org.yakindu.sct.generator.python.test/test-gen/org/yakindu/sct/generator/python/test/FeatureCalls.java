package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/FeatureCalls/tests/test_featurecalls.py",
	program = "pytest/FeatureCalls/tests/FeatureCalls",
	model = "testmodels/SCTUnit/FeatureCalls.sct",
	additionalFilesToCopy = {
		"pytest/FeatureCalls/tests/__init__.py",
		"pytest/FeatureCalls/tests/vtimer/__init__.py",
		"pytest/FeatureCalls/tests/vtimer/interface_timer.py",
		"pytest/FeatureCalls/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class FeatureCalls {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
