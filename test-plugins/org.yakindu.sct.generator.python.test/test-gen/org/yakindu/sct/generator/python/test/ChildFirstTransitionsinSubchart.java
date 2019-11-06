package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/ChildFirstTransitionsInSubchart/tests/test_childfirsttransitionsinsubchart.py",
	program = "pytest/ChildFirstTransitionsInSubchart/tests/ChildFirstTransitionsInSubchart",
	model = "testmodels/SCTUnit/executionorder/ChildFirstTransitionsInSubchart.sct",
	additionalFilesToCopy = {
		"pytest/ChildFirstTransitionsInSubchart/tests/__init__.py",
		"pytest/ChildFirstTransitionsInSubchart/tests/vtimer/__init__.py",
		"pytest/ChildFirstTransitionsInSubchart/tests/vtimer/interface_timer.py",
		"pytest/ChildFirstTransitionsInSubchart/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class ChildFirstTransitionsinSubchart {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
