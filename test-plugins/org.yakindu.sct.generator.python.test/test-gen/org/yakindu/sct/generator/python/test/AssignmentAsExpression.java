package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/AssignmentAsExpression/tests/test_assignmentasexpression.py",
	program = "pytest/AssignmentAsExpression/tests/AssignmentAsExpression",
	model = "testmodels/SCTUnit/AssignmentAsExpression.sct",
	additionalFilesToCopy = {
		"pytest/AssignmentAsExpression/tests/__init__.py",
		"pytest/AssignmentAsExpression/tests/vtimer/__init__.py",
		"pytest/AssignmentAsExpression/tests/vtimer/interface_timer.py",
		"pytest/AssignmentAsExpression/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class AssignmentAsExpression {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
