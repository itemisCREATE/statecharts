package org.yakindu.sct.generator.python.test;

import org.junit.Before;
import org.junit.runner.RunWith;

@PythonTest(
	statechartBundle = "org.yakindu.sct.test.models",
	sourceFile = "pytest/EntryReactionAction/tests/test_entryreactionaction.py",
	program = "pytest/EntryReactionAction/tests/EntryReactionAction",
	model = "testmodels/SCTUnit/entries/EntryReactionAction.sct",
	additionalFilesToCopy = {
		"pytest/EntryReactionAction/tests/__init__.py",
		"pytest/EntryReactionAction/tests/vtimer/__init__.py",
		"pytest/EntryReactionAction/tests/vtimer/interface_timer.py",
		"pytest/EntryReactionAction/tests/vtimer/virtual_timer.py"
	}
)
@RunWith(PythonUnittestRunner.class)
public class EntryReactionAction {

	protected final PythonTestHelper helper = new PythonTestHelper(this);

	@Before
	public void setUp() {
		helper.generate();
		helper.compile();
	}
}
