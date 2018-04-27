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

import static org.yakindu.sct.model.sgraph.validation.ChoiceValidator.OUTGOING_TRANSITION_COUNT_CODE;

import org.junit.Test;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.test.util.SGraphJavaValidatorTester;
import org.yakindu.sct.model.sgraph.validation.ChoiceValidator;

import com.google.inject.Inject;

/**
 * 
 * Tests for {@link ChoiceValidator}
 *
 */
public class ChoiceValidatorTest extends AbstractSGraphValidatorTest {

	@Inject
	protected SGraphJavaValidatorTester<ChoiceValidator> tester;

	/**
	 * A choice must have at least one outgoing transition
	 */
	@Test
	public void choiceWithoutOutgoingTransition() {
		Statechart statechart = factory.createStatechart();
		Region region = factory.createRegion();
		statechart.getRegions().add(region);
		Choice choice = factory.createChoice();
		region.getVertices().add(choice);
		State state = factory.createState();
		region.getVertices().add(state);
		createTransition(state, choice);

		tester.validate(choice).assertError(OUTGOING_TRANSITION_COUNT_CODE);
	}

}
