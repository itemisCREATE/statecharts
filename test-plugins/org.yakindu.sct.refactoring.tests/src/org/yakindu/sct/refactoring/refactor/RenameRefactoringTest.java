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

import static org.junit.Assert.fail;
import static org.yakindu.sct.test.models.RefactoringTestModels.INITIAL_STATECHART;
import static org.yakindu.sct.test.models.RefactoringTestModels.RENAMING;



import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sgraph.Event;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Variable;
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.refactoring.refactor.impl.RenameRefactoring;
import org.yakindu.sct.test.models.TestModelInjectorProvider;


/**
 * Tests for {@link RenameRefactoring}.
 * 
 * @author thomas kutz - Initial contribution and API
 * 
 */
@RunWith(XtextRunner.class)
@InjectWith(TestModelInjectorProvider.class)
public class RenameRefactoringTest extends RefactoringTest {

	@Test
	public void testRenameVariable() {
		Statechart initial = models.loadStatechartFromResource(RENAMING
				+ INITIAL_STATECHART);

		// get element to rename
		Variable someVariable = null;
		EList<Scope> scopes = initial.getScopes();
		for (Scope scope : scopes) {
			if (scope instanceof InterfaceScope) {
				InterfaceScope iScope = (InterfaceScope) scope;
				someVariable = iScope.getVariables().get(0);
			}
		}

		AbstractRefactoring<?> refactoring = new RenameRefactoring(
				someVariable, "someNewVariableName");

		((AbstractSCTResource) initial.eResource()).setSerializerEnabled(true);
		refactoring.internalExecute();
		((AbstractSCTResource) initial.eResource()).setSerializerEnabled(false);

		Statechart expected = models.loadStatechartFromResource(RENAMING
				+ "AfterRenamingVariable.sct");

		parseAllSpecifications(initial);
		parseAllSpecifications(expected);
		
		compareStatecharts(initial, expected);
	}

	@Test
	public void testRenameEvent() {
		Statechart initial = models.loadStatechartFromResource(RENAMING
				+ INITIAL_STATECHART);

		// get element to rename
		Event someEvent1 = null;
		EList<Scope> scopes = initial.getScopes();
		for (Scope scope : scopes) {
			if (scope instanceof InterfaceScope) {
				InterfaceScope iScope = (InterfaceScope) scope;
				for (Event event : iScope.getEvents()) {
					if (event.getName().equals("someEvent1")) {
						someEvent1 = event;
					}
				}
			}
		}

		AbstractRefactoring<?> refactoring = new RenameRefactoring(someEvent1,
				"someNewEventName");

		((AbstractSCTResource) initial.eResource()).setSerializerEnabled(true);
		refactoring.internalExecute();
		((AbstractSCTResource) initial.eResource()).setSerializerEnabled(false);

		Statechart expected = models.loadStatechartFromResource(RENAMING
				+ "AfterRenamingEvent.sct");

		parseAllSpecifications(initial);
		parseAllSpecifications(expected);
		
		compareStatecharts(initial, expected);
	}

	@Test
	public void testRenameInterface() {
		Statechart initial = models.loadStatechartFromResource(RENAMING
				+ INITIAL_STATECHART);

		// get element to rename
		InterfaceScope someInterface = null;
		EList<Scope> scopes = initial.getScopes();
		for (Scope scope : scopes) {
			if (scope instanceof InterfaceScope) {
				someInterface = (InterfaceScope) scope;
			}
		}

		AbstractRefactoring<?> refactoring = new RenameRefactoring(
				someInterface, "someNewInterfaceName");

		((AbstractSCTResource) initial.eResource()).setSerializerEnabled(true);
		refactoring.internalExecute();
		((AbstractSCTResource) initial.eResource()).setSerializerEnabled(false);

		Statechart expected = models.loadStatechartFromResource(RENAMING
				+ "AfterRenamingInterface.sct");

		parseAllSpecifications(initial);
		parseAllSpecifications(expected);
		
		compareStatecharts(initial, expected);
	}

	@Ignore
	@Test
	public void testNoRenamingIntoExistingName() {
		fail("Not yet implemented.");
	}

}
