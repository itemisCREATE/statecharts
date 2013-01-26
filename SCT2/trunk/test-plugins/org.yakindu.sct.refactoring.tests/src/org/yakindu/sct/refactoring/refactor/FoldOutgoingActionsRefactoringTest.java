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

import static org.yakindu.sct.test.models.RefactoringTestModels.EXPECTED_STATECHART;
import static org.yakindu.sct.test.models.RefactoringTestModels.FOLD_OUTGOING_ACTIONS;
import static org.yakindu.sct.test.models.RefactoringTestModels.INITIAL_STATECHART;

import org.junit.Test;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.refactoring.refactor.impl.FoldOutgoingActionsRefactoring;

import com.google.common.collect.Lists;

/**
 * 
 * @author thomas kutz - Initial contribution and API
 * 
 */
public class FoldOutgoingActionsRefactoringTest extends
		StateBasedRefactoringTest {

	@Test
	public void testFoldOutgoingActions() {
		testRefactoringOnState(FOLD_OUTGOING_ACTIONS + INITIAL_STATECHART,
				FOLD_OUTGOING_ACTIONS + EXPECTED_STATECHART, "A");
	}

	@Override
	protected AbstractRefactoring<?> getRefactoring(State state) {
		FoldOutgoingActionsRefactoring foldOutgoingActionsRefactoring = new FoldOutgoingActionsRefactoring();
		foldOutgoingActionsRefactoring.setContextObjects(Lists
				.newArrayList(state));
		return foldOutgoingActionsRefactoring;

	}

}
