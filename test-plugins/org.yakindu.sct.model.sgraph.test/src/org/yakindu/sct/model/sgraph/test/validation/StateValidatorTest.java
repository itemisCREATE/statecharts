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

import static org.yakindu.sct.model.sgraph.validation.StateValidator.ISSUE_STATE_NAME_CODE;

import org.eclipse.xtext.junit4.validation.AssertableDiagnostics;
import org.junit.Test;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.test.util.SGraphJavaValidatorTester;
import org.yakindu.sct.model.sgraph.validation.StateValidator;

import com.google.inject.Inject;

/**
 *
 * Tests for {@link StateValidator}
 *
 */
public class StateValidatorTest extends AbstractSGraphValidatorTest {

	@Inject
	protected SGraphJavaValidatorTester<StateValidator> tester;

	/**
	 * A regular state must have a name.
	 */
	@Test
	public void stateWithoutName() {
		State state = createState();
		state.setName(null);
		AssertableDiagnostics result = tester.validate(state);
		result.assertError(ISSUE_STATE_NAME_CODE);
	}

	/**
	 * A states name must not be empty.
	 */
	@Test
	public void nameIsNotEmpty() {
		State state = createState();
		state.setName("");
		AssertableDiagnostics result = tester.validate(state);
		result.assertError(ISSUE_STATE_NAME_CODE);
	}

	/**
	 * A state name with just white spaces is not valid.
	 */
	@Test
	public void stateWithWhitespaceName() {
		State state = createState();
		state.setName(" 	");
		AssertableDiagnostics result = tester.validate(state);
		result.assertError(ISSUE_STATE_NAME_CODE);
	}

}
