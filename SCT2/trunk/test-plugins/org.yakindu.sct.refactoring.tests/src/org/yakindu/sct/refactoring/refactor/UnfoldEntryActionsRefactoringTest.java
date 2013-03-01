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

import static org.yakindu.sct.refactoring.test.models.RefactoringTestModels.EXPECTED_STATECHART;
import static org.yakindu.sct.refactoring.test.models.RefactoringTestModels.INITIAL_STATECHART;
import static org.yakindu.sct.refactoring.test.models.RefactoringTestModels.UNFOLD_ENTRY_ACTIONS;

import org.junit.Test;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.refactoring.refactor.impl.UnfoldEntryActionsRefactoring;

import com.google.common.collect.Lists;
/**
 * Tests for {@link UnfoldEntryActionsRefactoring}.
 * 
 * @author thomas kutz - Initial contribution and API
 * 
 */
public class UnfoldEntryActionsRefactoringTest extends
		StateBasedRefactoringTest {

	@Test
	public void testUnfoldEntryActions() {

		testRefactoringOnState(
				UNFOLD_ENTRY_ACTIONS + INITIAL_STATECHART,
				UNFOLD_ENTRY_ACTIONS + EXPECTED_STATECHART,
				"B");
	}
	
	@Test
	public void testIsExecutable() {
		testRefactoringIsExecutableOnState(
				UNFOLD_ENTRY_ACTIONS + INITIAL_STATECHART,
				UNFOLD_ENTRY_ACTIONS + EXPECTED_STATECHART,
				"B",
				true);
		
		testRefactoringIsExecutableOnState(
				UNFOLD_ENTRY_ACTIONS + INITIAL_STATECHART,
				UNFOLD_ENTRY_ACTIONS + EXPECTED_STATECHART,
				"InnerState",
				false);
		
		testRefactoringIsExecutableOnState(
				UNFOLD_ENTRY_ACTIONS + INITIAL_STATECHART,
				UNFOLD_ENTRY_ACTIONS + EXPECTED_STATECHART,
				"A2",
				false);
		
		testRefactoringIsExecutableOnState(
				UNFOLD_ENTRY_ACTIONS + INITIAL_STATECHART,
				UNFOLD_ENTRY_ACTIONS + EXPECTED_STATECHART,
				"F",
				false);
	}

	@Override
	protected AbstractRefactoring<State> getRefactoring(State state) {
		UnfoldEntryActionsRefactoring unfoldEntryActionsRefactoring = new UnfoldEntryActionsRefactoring();
		unfoldEntryActionsRefactoring.setContextObjects(Lists.newArrayList(state));
		return unfoldEntryActionsRefactoring;
	}

}
