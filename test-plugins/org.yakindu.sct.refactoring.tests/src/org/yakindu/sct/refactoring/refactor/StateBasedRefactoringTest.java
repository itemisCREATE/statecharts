/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.refactoring.refactor;

import java.util.List;

import junit.framework.Assert;

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.parser.IParser;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sgraph.SpecificationElement;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;
import org.yakindu.sct.model.stext.resource.impl.StextResource;
import org.yakindu.sct.refactoring.refactor.util.SctEqualityHelper;
import org.yakindu.sct.refactoring.refactor.util.TestHelper;
import org.yakindu.sct.refactoring.refactor.util.TestInjectorProvider;
import org.yakindu.sct.test.models.RefactoringTestModels;

import com.google.inject.Inject;

/**
 * Base test class for state based refactorings.
 * 
 * @author thomas kutz - Initial contribution and API
 * 
 */
@RunWith(XtextRunner.class)
@InjectWith(TestInjectorProvider.class)
public abstract class StateBasedRefactoringTest {

	@Inject
	protected IParser parser;

	@Inject
	protected RefactoringTestModels models;

	protected TestHelper helper = new TestHelper();

	protected void compareStatecharts(Statechart initial, Statechart expected) {
		SctEqualityHelper equalityHelper = new SctEqualityHelper();
		if (!equalityHelper.equals(initial, expected)) {
			Assert.fail("Equality check on statecharts failed!");
		}
	}

	protected void testRefactoringOnState(String pathToInitialSct,
			String pathToExpectedSct, String stateName) {
		Statechart initial = models
				.loadStatechartFromResource(pathToInitialSct);

		State state = helper.getStateByName(initial, stateName);

		AbstractRefactoring<?> refactoring = getRefactoring(state);
		((AbstractSCTResource) initial.eResource()).setSerializerEnabled(true);
		refactoring.internalExecute();
		((AbstractSCTResource) initial.eResource()).setSerializerEnabled(false);

		Statechart expected = models
				.loadStatechartFromResource(pathToExpectedSct);
		
		parseAllSpecifications(initial);
		parseAllSpecifications(expected);
		
		compareStatecharts(initial, expected);
	}
	
	protected void testRefactoringIsExecutableOnState(String pathToInitialSct,
			String pathToExpectedSct, String stateName, boolean expectedResult) {
		Statechart initial = models
				.loadStatechartFromResource(pathToInitialSct);

		State state = helper.getStateByName(initial, stateName);

		AbstractRefactoring<?> refactoring = getRefactoring(state);
		if (expectedResult) {
			Assert.assertTrue("Refactoring on state '"+stateName+"' was not executable, although it should be.", refactoring.isExecutable());
		}
		else {			
			Assert.assertFalse("Refactoring on state '"+stateName+"' was executable, although it should not be.", refactoring.isExecutable());
		}
	}

	private void parseAllSpecifications(Statechart sct) {
		List<SpecificationElement> allSpecElements = EcoreUtil2.getAllContentsOfType(sct, SpecificationElement.class);
		for (SpecificationElement specificationElement : allSpecElements) {
			((StextResource)sct.eResource()).parseSpecificationElement(specificationElement);
		}
	}

	protected abstract AbstractRefactoring<?> getRefactoring(State state);
}
