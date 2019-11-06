package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/ParentFirstExecutionHierarchy/tests/test_parentfirstexecutionhierarchy.py",
	program = "pytest/ParentFirstExecutionHierarchy/tests/ParentFirstExecutionHierarchy",
	model = "testmodels/SCTUnit/executionorder/ParentFirstExecutionHierarchy.sct",
	additionalFilesToCopy = {
		"pytest/ParentFirstExecutionHierarchy/tests/__init__.py",
		"pytest/ParentFirstExecutionHierarchy/tests/vtimer/__init__.py",
		"pytest/ParentFirstExecutionHierarchy/tests/vtimer/interface_timer.py",
		"pytest/ParentFirstExecutionHierarchy/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class ParentFirstExecutionHierarchy {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
