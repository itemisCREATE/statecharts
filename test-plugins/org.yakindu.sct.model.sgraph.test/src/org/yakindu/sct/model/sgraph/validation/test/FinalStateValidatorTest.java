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

import static org.yakindu.sct.model.sgraph.validation.FinalStateValidator.FINAL_STATE_NO_OUT_TRANSITION_CODE;

import org.junit.Test;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.validation.FinalStateValidator;

import com.google.inject.Inject;

public class FinalStateValidatorTest extends AbstractSGraphValidatorTest {

	@Inject
	private SGraphJavaValidatorTester<FinalStateValidator> tester;

	/**
	 * A final state should have no outgoing transitions
	 */
	@Test
	public void finalStateWithOutgoingTransition() {
		Statechart statechart = factory.createStatechart();
		Region region = factory.createRegion();
		statechart.getRegions().add(region);
		FinalState finalState = factory.createFinalState();
		region.getVertices().add(finalState);
		State state = factory.createState();
		region.getVertices().add(state);

		createTransition(state, finalState);
		createTransition(finalState, state);

		tester.validate(finalState).assertWarning(FINAL_STATE_NO_OUT_TRANSITION_CODE);
	}

	/**
	 * A positive case for a valid final state.
	 */
	@Test
	public void finalStateValid() {
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

}
