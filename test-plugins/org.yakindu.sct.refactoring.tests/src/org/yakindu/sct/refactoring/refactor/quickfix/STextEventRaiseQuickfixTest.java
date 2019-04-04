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

public class STextEventRaiseQuickfixTest extends AbstractSTextQuickfixTest {
	@Test
	public void testExistingUnnamnedInterface_InsideTransition() {

		this.initial = models.loadStatechartFromResource(QUICKFIX + "before_eventRaiseInsideTransition.sct");
		this.expected = models.loadStatechartFromResource(QUICKFIX + "after_eventRaiseInsideTransition.sct");

		State stateA = super.getStateByName(initial, "StateA");
		assertNotNull("something wrong, statechart has one 'StateA'", stateA);
		assertEquals(1, stateA.getOutgoingTransitions().size());

		Transition element = stateA.getOutgoingTransitions().get(0);
		EventTriggerCreationCommand quickfix = new EventTriggerCreationCommand(element, new TestIssueImpl("newEvent"),
				Direction.OUT);

		execQuickfix(quickfix);
	}

	@Test
	public void testExistingUnnamnedInterface() {
		super.initial = models.loadStatechartFromResource(
				QUICKFIX + "before_eventRaiseInsideLocalReaction_ExistingUnnamendInterface.sct");
		super.expected = models.loadStatechartFromResource(
				QUICKFIX + "after_eventRaiseInsideLocalReaction_ExistingUnnamendInterface.sct");

		State stateA = super.getStateByName(initial, "StateA");

		EventTriggerCreationCommand quickfix = new EventTriggerCreationCommand(stateA, new TestIssueImpl("newEvent"),
				Direction.OUT);

		execQuickfix(quickfix);
	}

	@Test
	public void testMissingUnnamnedInterface() {
		super.initial = models.loadStatechartFromResource(
				QUICKFIX + "before_eventRaiseInsideLocalReaction_MissingUnnamnedInterface.sct");
		super.expected = models.loadStatechartFromResource(
				QUICKFIX + "after_eventRaiseInsideLocalReaction_MissingUnnamnedInterface.sct");

		State stateA = super.getStateByName(initial, "StateA");

		EventTriggerCreationCommand quickfix = new EventTriggerCreationCommand(stateA, new TestIssueImpl("newEvent"),
				Direction.OUT);

		execQuickfix(quickfix);
	}

	@Test
	public void testFeatureCall_ExistingInterface() {
		super.initial = models.loadStatechartFromResource(
				QUICKFIX + "before_eventRaiseInsideLocalReaction_FeatureCall_ExistingInterface.sct");
		super.expected = models.loadStatechartFromResource(
				QUICKFIX + "after_eventRaiseInsideLocalReaction_FeatureCall_ExistingInterface.sct");

		State stateA = super.getStateByName(initial, "StateA");

		EventTriggerCreationCommand quickfix = new EventTriggerCreationCommand(stateA, new TestIssueImpl("A.newEvent"),
				Direction.OUT);

		execQuickfix(quickfix);
	}

	@Test
	public void testFeatureCall_MissingInterface() {
		super.initial = models.loadStatechartFromResource(
				QUICKFIX + "before_eventRaiseInsideLocalReaction_FeatureCall_MissingInterface.sct");
		super.expected = models.loadStatechartFromResource(
				QUICKFIX + "after_eventRaiseInsideLocalReaction_FeatureCall_MissingInterface.sct");

		State stateA = super.getStateByName(initial, "StateA");

		EventTriggerCreationCommand quickfix = new EventTriggerCreationCommand(stateA, new TestIssueImpl("A.newEvent"),
				Direction.OUT);

		execQuickfix(quickfix);
	}
}
