package org.yakindu.sct.refactoring.refactor;

import junit.framework.Assert;

import org.eclipse.xtext.parser.IParser;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.refactoring.refactor.util.SctEqualityHelper;
import org.yakindu.sct.refactoring.test.models.RefactoringTestModels;

import com.google.inject.Inject;

public class RefactoringTest {

	@Inject
	protected IParser parser;
	
	@Inject
	protected RefactoringTestModels models;

	protected void compareStatecharts(Statechart initial, Statechart expected) {
		SctEqualityHelper equalityHelper = new SctEqualityHelper();
		if (!equalityHelper.equals(initial, expected)) {
			Assert.fail("Equality check on statecharts failed!");
		}
	}
}