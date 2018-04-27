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
package org.yakindu.sct.model.sgraph.test.validation;

import static org.yakindu.sct.model.sgraph.validation.VertexValidator.VERTEX_REACHABLE_CODE;

import org.junit.Test;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.test.util.SGraphJavaValidatorTester;
import org.yakindu.sct.model.sgraph.validation.VertexValidator;

import com.google.inject.Inject;

/**
 *
 * Tests for {@link VertexValidator}
 *
 */
public class VertexValidatorTest extends AbstractSGraphValidatorTest {

	@Inject
	protected SGraphJavaValidatorTester<VertexValidator> tester;

	/**
	 * A state must be reachable.
	 */
	@Test
	public void vertexNotReachable() {
		State state = createState();
		tester.validate(state).assertError(VERTEX_REACHABLE_CODE);
	}

	/**
	 * A transition to a sub entry is considered implies reachability.
	 */
	@Test
	public void vertexNotReachable_AcceptThroughSubstate() {
		State state = createState();
		State stateA = factory.createState();
		Region subRegion = factory.createRegion();
		state.getRegions().add(subRegion);
		State stateC = factory.createState();
		subRegion.getVertices().add(stateC);
		Transition t1 = factory.createTransition();
		t1.setSource(stateA);
		t1.setTarget(stateC);
		tester.validate(state).assertOK();
	}

	/**
	 * A transition to a sub entry is considered implies reachability.
	 */
	@Test
	public void vertexNotReachable_AcceptThroughSubentry() {
		State state = createState();
		State stateA = factory.createState();
		Region subRegion = factory.createRegion();
		state.getRegions().add(subRegion);
		State stateC = factory.createState();
		subRegion.getVertices().add(stateC);
		Entry entry = factory.createEntry();
		subRegion.getVertices().add(entry);
		Transition t1 = factory.createTransition();
		t1.setSource(stateA);
		t1.setTarget(entry);
		Transition t2 = factory.createTransition();
		t2.setSource(entry);
		t2.setTarget(stateC);

		tester.validate(state).assertOK();
	}

	/**
	 * A transition to a sub choice is considered implies reachability.
	 */
	@Test
	public void vertexNotReachable_AcceptThroughSubchoice() {
		State state = createState();
		State stateA = factory.createState();
		Region subRegion = factory.createRegion();
		state.getRegions().add(subRegion);
		State stateC = factory.createState();
		subRegion.getVertices().add(stateC);
		Choice choice = factory.createChoice();
		subRegion.getVertices().add(choice);
		Transition t1 = factory.createTransition();
		t1.setSource(stateA);
		t1.setTarget(choice);
		Transition t2 = factory.createTransition();
		t2.setSource(choice);
		t2.setTarget(stateC);

		tester.validate(state).assertOK();
	}

	/**
	 * If an incoming transitions is part of an external transition path that only
	 * consists of pseudo states and only has state predecessors within the state
	 * then the state is not reachable and the validation must fail with an error.
	 */
	@Test
	public void vertexNotReachable_FailOnExternalPseudoPath() {
		State state = createState();
		Choice choice = factory.createChoice();
		((Region) state.eContainer()).getVertices().add(choice);
		createTransition(state, choice);
		createTransition(choice, state);
		tester.validate(state).assertError(VERTEX_REACHABLE_CODE);
	}

	/**
	 * If an incoming transitions is part of an external transition path to an
	 * internal state that only consists of pseudo states and only has state
	 * predecessors within the state then the state is not reachable and the
	 * validation must fail with an error.
	 */
	@Test
	public void vertexNotReachable_FailOnExternalPseudoPathToSubstate() {
		Entry entry = factory.createEntry();
		State state = createState();
		((Region) state.eContainer()).getVertices().add(entry);
		createTransition(entry, state);
		Region subRegion = factory.createRegion();
		state.getRegions().add(subRegion);
		State stateA = factory.createState();
		subRegion.getVertices().add(stateA);
		Choice choice = factory.createChoice();
		((Region) state.eContainer()).getVertices().add(choice);
		createTransition(stateA, choice);
		createTransition(choice, stateA);

		tester.validate(state).assertError(VERTEX_REACHABLE_CODE);
	}

	/**
	 * A final state should have at least one incoming transition.
	 */
	@Test
	public void finalStateIsolated() {
		Statechart statechart = factory.createStatechart();
		Region region = factory.createRegion();
		statechart.getRegions().add(region);
		FinalState finalState = factory.createFinalState();
		region.getVertices().add(finalState);

		tester.validate(finalState).assertError(VERTEX_REACHABLE_CODE);
	}

}
