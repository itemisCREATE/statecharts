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

import junit.framework.Assert;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.parser.IParser;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;
import org.yakindu.sct.refactoring.refactor.AbstractRefactoring;
import org.yakindu.sct.refactoring.refactor.util.TestHelper;
import org.yakindu.sct.refactoring.refactor.util.TestInjectorProvider;
import org.yakindu.sct.refactoring.refactor.util.TestModels;

import com.google.inject.Inject;

/**
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
	protected TestModels models;
	
	protected TestHelper helper = new TestHelper();
	
	protected void compareStatecharts(Statechart initial, Statechart expected) {
		if (!EcoreUtil.equals(initial, expected)) {
			Assert.fail("Equality check on statecharts failed!");
		}
	}
	
	protected void testRefactoringOnState(String pathToInitialSct, String pathToExpectedSct, String stateName) {
		Statechart initial = models.loadStatechartFromResource(pathToInitialSct);
		State stateB = helper.getStateByName(initial, stateName);
		
		AbstractRefactoring<?> refactoring = getRefactoring(stateB);
		((AbstractSCTResource)initial.eResource()).setSerializerEnabled(true);
		refactoring.internalExecute();
		((AbstractSCTResource)initial.eResource()).setSerializerEnabled(false);
		
		Statechart expected = models.loadStatechartFromResource(pathToExpectedSct);
		
		compareStatecharts(initial, expected);
	}
	
	
	protected abstract AbstractRefactoring<?> getRefactoring(State state);
}
