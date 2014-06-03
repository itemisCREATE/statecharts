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
package org.yakindu.sct.refactoring.refactor.impl;

import static org.yakindu.sct.refactoring.test.models.RefactoringTestModels.EXPECTED_STATECHART;
import static org.yakindu.sct.refactoring.test.models.RefactoringTestModels.GROUPING_STATES;
import static org.yakindu.sct.refactoring.test.models.RefactoringTestModels.INITIAL_STATECHART;

import java.util.List;

import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;
import org.yakindu.sct.refactoring.refactor.RefactoringTest;
import org.yakindu.sct.test.models.TestModelInjectorProvider;

import com.google.common.collect.Lists;

@RunWith(XtextRunner.class)
@InjectWith(TestModelInjectorProvider.class)
public class GroupStatesIntoCompositeRefactoringTest extends RefactoringTest {

	@Test
	public void testSemanticalRefactoring() {
		Statechart initial = models
				.loadStatechartFromResource(GROUPING_STATES + INITIAL_STATECHART);

		List<State> states = getStatesByName(initial, Lists.newArrayList("B", "C", "D"));

		GroupStatesIntoCompositeRefactoring refactoring = new GroupStatesIntoCompositeRefactoring();
		refactoring.contextStates = Lists.newArrayList(states);
		
		AbstractSCTResource initialRes = (AbstractSCTResource) initial.eResource();
		initialRes.setSerializerEnabled(true);
		refactoring.doSemanticalRefactoring();
		initialRes.setSerializerEnabled(false);
		initialRes.linkSpecificationElements();

		Statechart expected = models
				.loadStatechartFromResource(GROUPING_STATES + EXPECTED_STATECHART);
		
		compareStatecharts(initial, expected);
	}
	
	
	protected List<State> getStatesByName(Statechart statechart, List<String> names) {
		List<State> allStates = EcoreUtil2.getAllContentsOfType(statechart, State.class);
		List<State> result = Lists.newArrayList();
		for (State state : allStates) {
			if (names.contains(state.getName())) {
				result.add(state);
			}
		}
		return result;
	}
	
}
