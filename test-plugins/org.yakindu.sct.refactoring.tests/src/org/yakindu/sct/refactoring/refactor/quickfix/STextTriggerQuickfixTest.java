/** 
 * Copyright (c) 2019 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * itemis AG - initial API and implementation
 */
package org.yakindu.sct.refactoring.refactor.quickfix;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.yakindu.sct.refactoring.test.models.RefactoringTestModels.QUICKFIX;

import org.junit.Test;
import org.yakindu.base.types.Direction;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.ui.quickfix.EventTriggerCreationCommand;

public class STextTriggerQuickfixTest extends AbstractSTextQuickfixTest {

	private Transition retrieveSingleTransition() {
		State stateA = super.getStateByName(initial, "StateA");
		assertNotNull("something wrong, statechart has one 'StateA'", stateA);
		assertEquals(1, stateA.getOutgoingTransitions().size());

		Transition element = stateA.getOutgoingTransitions().get(0);
		return element;
	}

	@Test
	public void testMultipleEventsAsTrigger() {
		this.initial = models.loadStatechartFromResource(QUICKFIX + "before_multipleTransitionTrigger.sct");
		this.expected = models.loadStatechartFromResource(QUICKFIX + "after_multipleTransitionTrigger.sct");

		EventTriggerCreationCommand quickfix = new EventTriggerCreationCommand(retrieveSingleTransition(),
				new TestIssueImpl("newEvent"), Direction.IN);

		execQuickfix(quickfix);
	}

	@Test
	public void testCreateEventForExistingUnnamedInterface() {
		this.initial = models.loadStatechartFromResource(QUICKFIX + "before_eventCreation.sct");
		this.expected = models.loadStatechartFromResource(QUICKFIX + "after_eventCreation.sct");

		EventTriggerCreationCommand quickfix = new EventTriggerCreationCommand(retrieveSingleTransition(),
				new TestIssueImpl("a"), Direction.IN);

		execQuickfix(quickfix);
	}

	@Test
	public void testCreateEventAndUnnamendInterface() {
		this.initial = models.loadStatechartFromResource(QUICKFIX + "before_eventAndUnnamedInterfaceCreation.sct");
		this.expected = models.loadStatechartFromResource(QUICKFIX + "after_eventAndUnnamedInterfaceCreation.sct");

		EventTriggerCreationCommand quickfix = new EventTriggerCreationCommand(retrieveSingleTransition(),
				new TestIssueImpl("a"), Direction.IN);

		execQuickfix(quickfix);
	}

	@Test
	public void testCreateEventForExistingNamedInterface() {
		this.initial = models.loadStatechartFromResource(QUICKFIX + "before_eventCreationForExistingNamedInterface.sct");
		this.expected = models.loadStatechartFromResource(QUICKFIX + "after_eventCreationForExistingNamedInterface.sct");

		EventTriggerCreationCommand quickfix = new EventTriggerCreationCommand(retrieveSingleTransition(),
				new TestIssueImpl("A.e"), Direction.IN);

		execQuickfix(quickfix);
	}
}
