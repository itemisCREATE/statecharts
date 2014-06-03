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
import org.eclipse.xtext.parser.IParser;
import org.junit.Assert;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.refactoring.refactor.util.StatechartEqualityHelper;
import org.yakindu.sct.refactoring.test.models.RefactoringTestModels;

import com.google.inject.Inject;

/**
 * 
 * @author thomas kutz - Initial contribution and API
 * 
 */
public class RefactoringTest {

	@Inject
	protected IParser parser;

	@Inject
	protected RefactoringTestModels models;

	protected void compareStatecharts(Statechart initial, Statechart expected) {
		StatechartEqualityHelper equalityHelper = new StatechartEqualityHelper();
		if (!equalityHelper.equals(initial, expected)) {
			Assert.fail("Equality check on statecharts failed!");
		}
	}
	
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