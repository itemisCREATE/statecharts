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

import static org.junit.Assert.fail;
import static org.yakindu.sct.refactoring.test.models.RefactoringTestModels.INITIAL_STATECHART;
import static org.yakindu.sct.refactoring.test.models.RefactoringTestModels.RENAMING;

import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.base.base.NamedElement;
import org.yakindu.base.types.Event;
import org.yakindu.base.types.Property;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;
import org.yakindu.sct.model.stext.stext.InterfaceScope;
import org.yakindu.sct.refactoring.refactor.RefactoringTest;
import org.yakindu.sct.test.models.TestModelInjectorProvider;

import com.google.common.collect.Lists;

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

		Statechart initial = models.loadStatechartFromResource(RENAMING + INITIAL_STATECHART);
		// get element to rename
		Property someVariable = null;
		EList<Scope> scopes = initial.getScopes();
		for (Scope scope : scopes) {
			if (scope instanceof InterfaceScope) {
				InterfaceScope iScope = (InterfaceScope) scope;
				someVariable = iScope.getVariables().get(0);
			}
		}
		Statechart expected = models.loadStatechartFromResource(RENAMING + "AfterRenamingVariable.sct");

		testRenaming(initial, expected, someVariable, "someNewVariableName");
	}

	@Test
	public void testRenameEvent() {
		Statechart initial = models.loadStatechartFromResource(RENAMING + INITIAL_STATECHART);

		Statechart expected = models.loadStatechartFromResource(RENAMING + "AfterRenamingEvent.sct");

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

		testRenaming(initial, expected, someEvent1, "someNewEventName");
	}

	@Test
	public void testRenameInterface() {
		Statechart initial = models.loadStatechartFromResource(RENAMING + INITIAL_STATECHART);

		Statechart expected = models.loadStatechartFromResource(RENAMING + "AfterRenamingInterface.sct");

		// get element to rename
		InterfaceScope someInterface = null;
		EList<Scope> scopes = initial.getScopes();
		for (Scope scope : scopes) {
			if (scope instanceof InterfaceScope) {
				someInterface = (InterfaceScope) scope;
			}
		}

		testRenaming(initial, expected, someInterface, "someNewInterfaceName");
	}

	@Ignore
	@Test
	public void testNoRenamingIntoExistingName() {
		fail("Not yet implemented.");
	}
	@Test
	public void testRenameMultiStatement() {
		Statechart initial = models.loadStatechartFromResource(RENAMING + "beforeMultiStatement.sct");
		Statechart expected = models.loadStatechartFromResource(RENAMING + "AfterMultiStatement.sct");

		// get element to rename
		InterfaceScope someInterface = null;
		EList<Scope> scopes = initial.getScopes();
		for (Scope scope : scopes) {
			if (scope instanceof InterfaceScope) {
				someInterface = (InterfaceScope) scope;
			}
		}

		testRenaming(initial, expected, someInterface.getVariables().get(0), "y");

	}

	private void testRenaming(Statechart initial, Statechart expected, NamedElement elementToRename, String newName) {
		RenameRefactoring refactoring = new RenameRefactoring();

		refactoring.setContextObjects(Lists.newArrayList(elementToRename));
		refactoring.setNewName(newName);

		AbstractSCTResource initialRes = (AbstractSCTResource) initial.eResource();
		initialRes.setSerializerEnabled(true);
		refactoring.internalExecute();
		initialRes.setSerializerEnabled(false);

		initialRes.linkSpecificationElements();

		compareStatecharts(initial, expected);
	}

}
