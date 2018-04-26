/**
 * Copyright (c) 2012-2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sgraph.validation.test;

import org.junit.Test;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.validation.SynchronizationValidator;

import com.google.inject.Inject;

public class SynchronizationValidatorTest extends AbstractSGraphValidatorTest {

	@Inject
	protected SGraphJavaValidatorTester<SynchronizationValidator> tester;

	@Test
	public void synchronizationTransitionCount() {
		Statechart statechart = loadStatechart("SynchronizationTransitionCount.sct");
		tester.validate(statechart);
		// Iterator<EObject> iter = statechart.eAllContents();
		// while (iter.hasNext()) {
		// EObject element = iter.next();
		// if (element instanceof Synchronization) {
		// assertFalse(validator.validate(element, diagnostics, new HashMap<Object,
		// Object>()));
		// }
		// }
		//
		// assertIssueCount(diagnostics, 2);
		// assertError(diagnostics, ISSUE_SYNCHRONIZATION_TRANSITION_COUNT);
	}

	@Test
	public void synchronizationOutgoingTransitionCount() {
		Statechart statechart = loadStatechart("SyncOutgoingTransition.sct");
		tester.validate(statechart);
//		State state = firstNamed(EcoreUtil2.eAllOfType(statechart, State.class), "StateB");
//		Synchronization sync = (Synchronization) state.getOutgoingTransitions().get(0).getTarget();
//
//		assertFalse(validator.validate(sync, diagnostics, new HashMap<Object, Object>()));
//		assertIssueCount(diagnostics, 1);
//		assertError(diagnostics, ISSUE_SYNCHRONIZATION_TRANSITION_OUTGOING);
	}

	@Test
	public void orthogonalTargetStates_StateInParentStateRegion() {
		Statechart statechart = loadStatechart("NotOrthogonalRegion01.sct");

		tester.validate(statechart);
//		State b = firstNamed(EcoreUtil2.eAllOfType(statechart, State.class), "B");
//		Synchronization sync = (Synchronization) b.getOutgoingTransitions().get(0).getTarget();
//
//		assertFalse(validator.validate(sync, diagnostics, new HashMap<Object, Object>()));
//		assertIssueCount(diagnostics, 1);
//		assertError(diagnostics, ISSUE_SYNCHRONIZATION_TARGET_STATES_NOT_ORTHOGONAL);
	}

	@Test
	public void orthogonalTargetStates_StateInTopLevelRegion() {
		Statechart statechart = loadStatechart("NotOrthogonalRegion02.sct");
		tester.validate(statechart);
//		State b = firstNamed(EcoreUtil2.eAllOfType(statechart, State.class), "B");
//		Synchronization sync = (Synchronization) b.getOutgoingTransitions().get(0).getTarget();
//
//		assertFalse(validator.validate(sync, diagnostics, new HashMap<Object, Object>()));
//		assertIssueCount(diagnostics, 1);
//		assertError(diagnostics, ISSUE_SYNCHRONIZATION_TARGET_STATES_NOT_ORTHOGONAL);
	}

	@Test
	public void orthogonalSynchronizedTransition() {
		Statechart statechart = loadStatechart("NotOrthogonalRegion03.sct");
		tester.validate(statechart);

//		State stateB = firstNamed(EcoreUtil2.eAllOfType(statechart, State.class), "B");
//		Synchronization sync = (Synchronization) stateB.getOutgoingTransitions().get(0).getTarget();
//
//		assertFalse(validator.validate(sync, diagnostics, new HashMap<Object, Object>()));
//		assertIssueCount(diagnostics, 2);
//		assertError(diagnostics, ISSUE_SYNCHRONIZATION_SOURCE_TARGET_STATES_PARENT_REGION);
	}

	@Test
	public void orthogonalSourceStates() {
		Statechart statechart = loadStatechart("OrthogonalRegion01.sct");
		tester.validate(statechart);
		
//		State b = firstNamed(EcoreUtil2.eAllOfType(statechart, State.class), "AA");
//		Synchronization sync = (Synchronization) b.getOutgoingTransitions().get(0).getTarget();
//
//		assertTrue(validator.validate(sync, diagnostics, new HashMap<Object, Object>()));
//		assertNoIssues(diagnostics);
	}

	@Test
	public void orthogonalSourceStates_StateInParentStateRegion() {
		Statechart statechart = loadStatechart("NotOrthogonalRegion01.sct");
		tester.validate(statechart);
			
//		State b = firstNamed(EcoreUtil2.eAllOfType(statechart, State.class), "AA");
//		Synchronization sync = (Synchronization) b.getOutgoingTransitions().get(0).getTarget();
//
//		assertFalse(validator.validate(sync, diagnostics, new HashMap<Object, Object>()));
//		assertIssueCount(diagnostics, 1);
//		assertError(diagnostics, ISSUE_SYNCHRONIZATION_SOURCE_STATES_NOT_ORTHOGONAL);
	}

	@Test
	public void orthogonalSourceStates_StateInTopLevelRegion() {
		Statechart statechart = loadStatechart("NotOrthogonalRegion02.sct");
		tester.validate(statechart);
//		State b = firstNamed(EcoreUtil2.eAllOfType(statechart, State.class), "AA");
//		Synchronization sync = (Synchronization) b.getOutgoingTransitions().get(0).getTarget();
//
//		assertFalse(validator.validate(sync, diagnostics, new HashMap<Object, Object>()));
//		assertIssueCount(diagnostics, 1);
//		assertError(diagnostics, ISSUE_SYNCHRONIZATION_SOURCE_STATES_NOT_ORTHOGONAL);
	}

	@Test
	public void orthogonalTargetStates() {
		Statechart statechart = loadStatechart("OrthogonalRegion01.sct");
		tester.validate(statechart);
		
//		State b = firstNamed(EcoreUtil2.eAllOfType(statechart, State.class), "B");
//		Synchronization sync = (Synchronization) b.getOutgoingTransitions().get(0).getTarget();
//
//		assertTrue(validator.validate(sync, diagnostics, new HashMap<Object, Object>()));
//		assertNoIssues(diagnostics);
	}

	@Test
	public void orthogonalSynchronizedTransition_Source() {
		Statechart statechart = loadStatechart("NotOrthogonalRegion03.sct");
		tester.validate(statechart);
		
//		State stateC = firstNamed(EcoreUtil2.eAllOfType(statechart, State.class), "C");
//		Synchronization sync = (Synchronization) stateC.getOutgoingTransitions().get(0).getTarget();
//
//		assertFalse(validator.validate(sync, diagnostics, new HashMap<Object, Object>()));
//		assertIssueCount(diagnostics, 2);
//		assertError(diagnostics, ISSUE_SYNCHRONIZATION_SOURCE_TARGET_STATES_PARENT_REGION);
	}

	@Test
	public void syncLocation_Issue58() {
		Statechart statechart = loadStatechart("SyncLocation_Issue58.sct");
		tester.validate(statechart);
		
//		State state = firstNamed(EcoreUtil2.eAllOfType(statechart, State.class), "AA");
//		Synchronization sync = (Synchronization) state.getOutgoingTransitions().get(0).getTarget();
//
//		assertTrue(validator.validate(sync, diagnostics, new HashMap<Object, Object>()));
//		assertNoIssues(diagnostics);
	}

	protected Statechart loadStatechart(String modelName) {
		return super.loadStatechart("synchronization/" + modelName);
	}

}
