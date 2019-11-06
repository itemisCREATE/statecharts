package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/ChildFirstExecutionHierarchy/tests/test_childfirstexecutionhierarchy.py",
	program = "pytest/ChildFirstExecutionHierarchy/tests/ChildFirstExecutionHierarchy",
	model = "testmodels/SCTUnit/executionorder/ChildFirstExecutionHierarchy.sct",
	additionalFilesToCopy = {
		"pytest/ChildFirstExecutionHierarchy/tests/__init__.py",
		"pytest/ChildFirstExecutionHierarchy/tests/vtimer/__init__.py",
		"pytest/ChildFirstExecutionHierarchy/tests/vtimer/interface_timer.py",
		"pytest/ChildFirstExecutionHierarchy/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class ChildFirstExecutionHierarchy {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
