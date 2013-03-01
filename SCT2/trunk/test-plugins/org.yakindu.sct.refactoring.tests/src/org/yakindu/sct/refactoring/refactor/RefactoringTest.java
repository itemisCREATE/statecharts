package org.yakindu.sct.refactoring.refactor;

import java.util.List;

import junit.framework.Assert;

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.parser.IParser;
import org.yakindu.sct.model.sgraph.SpecificationElement;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.resource.impl.StextResource;
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

	protected void parseAllSpecifications(Statechart sct) {
		List<SpecificationElement> allSpecElements = EcoreUtil2.getAllContentsOfType(sct, SpecificationElement.class);
		for (SpecificationElement specificationElement : allSpecElements) {
			((StextResource)sct.eResource()).parseSpecificationElement(specificationElement);
		}
	}

}