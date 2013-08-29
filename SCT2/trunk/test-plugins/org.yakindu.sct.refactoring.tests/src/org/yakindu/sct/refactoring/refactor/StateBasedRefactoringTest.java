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

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;
import org.yakindu.sct.test.models.TestModelInjectorProvider;

/**
 * Base test class for state based refactorings.
 * 
 * @author thomas kutz - Initial contribution and API
 * 
 */
@RunWith(XtextRunner.class)
@InjectWith(TestModelInjectorProvider.class)
public abstract class StateBasedRefactoringTest extends RefactoringTest {

	protected void testRefactoringOnState(String pathToInitialSct, String pathToExpectedSct, String stateName) {
		Statechart initial = models.loadStatechartFromResource(pathToInitialSct);

		State state = getStateByName(initial, stateName);

		AbstractRefactoring<?> refactoring = getRefactoring(state);
		AbstractSCTResource initialRes = (AbstractSCTResource) initial.eResource();
		initialRes.setSerializerEnabled(true);
		refactoring.internalExecute();
		initialRes.setSerializerEnabled(false);
		initialRes.linkSpecificationElements();

		Statechart expected = models.loadStatechartFromResource(pathToExpectedSct);

		compareStatecharts(initial, expected);
	}

	protected void testRefactoringIsExecutableOnState(String pathToInitialSct, String pathToExpectedSct,
			String stateName, boolean expectedResult) {
		Statechart initial = models.loadStatechartFromResource(pathToInitialSct);

		State state = getStateByName(initial, stateName);

		AbstractRefactoring<?> refactoring = getRefactoring(state);
		if (expectedResult) {
			Assert.assertTrue("Refactoring on state '" + stateName + "' was not executable, although it should be.",
					refactoring.isExecutable());
		} else {
			Assert.assertFalse("Refactoring on state '" + stateName + "' was executable, although it should not be.",
					refactoring.isExecutable());
		}
	}

	protected abstract AbstractRefactoring<?> getRefactoring(State state);

	protected State getStateByName(Statechart statechart, String name) {
		List<State> allStates = EcoreUtil2.getAllContentsOfType(statechart, State.class);
		for (State state : allStates) {
			if (state.getName().equals(name)) {
				return state;
			}
		}
		return null;
	}
}
