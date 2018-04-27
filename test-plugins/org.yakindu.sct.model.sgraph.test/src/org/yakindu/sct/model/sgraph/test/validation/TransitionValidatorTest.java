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

import static org.yakindu.sct.model.sgraph.validation.TransitionValidator.INITIAL_ENTRY_WITH_TRANSITION_TO_CONTAINER_CODE;
import static org.yakindu.sct.model.sgraph.validation.TransitionValidator.TRANSITION_SOURCE_TARGET_NOT_ORTHOGONAL_CODE;

import org.junit.Test;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.test.util.SGraphJavaValidatorTester;
import org.yakindu.sct.model.sgraph.validation.TransitionValidator;

import com.google.inject.Inject;

/**
 *
 * Tests for {@link TransitionValidator}
 *
 */
public class TransitionValidatorTest extends AbstractSGraphValidatorTest {

	@Inject
	protected SGraphJavaValidatorTester<TransitionValidator> tester;

	@Test
	public void initialEntryWithTransitionToContainer() {
		Statechart statechart = loadStatechart("EntryTransitionToParentState.sct");
		tester.validate(statechart).assertError(INITIAL_ENTRY_WITH_TRANSITION_TO_CONTAINER_CODE);
	}

	@Test
	public void orthogonalTransition_BetweenTopLevelRegions() {
		Statechart statechart = loadStatechart("OrthogonalTransition01.sct");
		tester.validate(statechart).assertError(TRANSITION_SOURCE_TARGET_NOT_ORTHOGONAL_CODE);
	}

	@Test
	public void orthogonalTransition_BetweenCompositeStateRegions() {
		Statechart statechart = loadStatechart("OrthogonalTransition02.sct");
		tester.validate(statechart).assertError(TRANSITION_SOURCE_TARGET_NOT_ORTHOGONAL_CODE);
	}

	@Override
	protected Statechart loadStatechart(String path) {
		return super.loadStatechart("transition/" + path);
	}

}
