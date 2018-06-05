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

import static org.yakindu.sct.model.sgraph.validation.FinalStateValidator.FINAL_STATE_TRANSITIONS_NO_OUT_CODE;

import org.junit.Test;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.test.util.SGraphJavaValidatorTester;
import org.yakindu.sct.model.sgraph.validation.FinalStateValidator;

import com.google.inject.Inject;

/**
 *
 * Tests for {@link FinalStateValidator#checkNoOutTransitions}
 * 
 */
public class FinalStateNoOutTransitionsValidatorTest extends AbstractSGraphValidatorTest {

	@Inject
	private SGraphJavaValidatorTester<FinalStateValidator> tester;

	/**
	 * If a final state does not have any outgoing transitions, the model does not
	 * contain any diagnostics.
	 */
	@Test
	public void testNoOutTransitionsOK() {
		Statechart statechart = factory.createStatechart();
		Region region = factory.createRegion();
		statechart.getRegions().add(region);
		FinalState finalState = factory.createFinalState();
		region.getVertices().add(finalState);
		State state = factory.createState();
		region.getVertices().add(state);
		createTransition(state, finalState);

		tester.validate(finalState).assertOK();
	}

	/**
	 * If a final state does have one outgoing transition, one warning is expected.
	 */
	@Test
	public void testSingleOutTransitionWarning() {
		Statechart statechart = factory.createStatechart();
		Region region = factory.createRegion();
		statechart.getRegions().add(region);
		FinalState finalState = factory.createFinalState();
		region.getVertices().add(finalState);
		State state = factory.createState();
		region.getVertices().add(state);

		createTransition(state, finalState);
		createTransition(finalState, state);

		tester.validate(finalState).assertWarning(FINAL_STATE_TRANSITIONS_NO_OUT_CODE);
	}

	/**
	 * If a final state does have multiple outgoing transitions, one warning is
	 * expected.
	 */
	@Test
	public void testMultipleOutTransitionsWarning() {
		Statechart statechart = factory.createStatechart();
		Region region = factory.createRegion();
		statechart.getRegions().add(region);
		FinalState finalState = factory.createFinalState();
		region.getVertices().add(finalState);
		State state = factory.createState();
		region.getVertices().add(state);

		createTransition(state, finalState);
		createTransition(finalState, state);
		createTransition(finalState, state);

		tester.validate(finalState).assertWarning(FINAL_STATE_TRANSITIONS_NO_OUT_CODE);
	}
}
