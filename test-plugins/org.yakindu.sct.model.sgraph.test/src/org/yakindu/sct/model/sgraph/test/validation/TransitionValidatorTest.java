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

import static org.yakindu.sct.model.sgraph.validation.TransitionValidator.REGION_ENTRY_TARGET_MUST_BE_CHILD_CODE;
import static org.yakindu.sct.model.sgraph.validation.TransitionValidator.TRANSITION_SOURCE_NOT_ORTHOGONAL_TO_TARGET_CODE;

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
		tester.validate(statechart).assertError(REGION_ENTRY_TARGET_MUST_BE_CHILD_CODE);
	}

	@Test
	public void orthogonalTransition_BetweenTopLevelRegions() {
		Statechart statechart = loadStatechart("OrthogonalTransition01.sct");
		tester.validate(statechart).assertError(TRANSITION_SOURCE_NOT_ORTHOGONAL_TO_TARGET_CODE);
	}

	@Test
	public void orthogonalTransition_BetweenCompositeStateRegions() {
		Statechart statechart = loadStatechart("OrthogonalTransition02.sct");
		tester.validate(statechart).assertError(TRANSITION_SOURCE_NOT_ORTHOGONAL_TO_TARGET_CODE);
	}

	@Override
	protected Statechart loadStatechart(String path) {
		return super.loadStatechart("transition/" + path);
	}

}
