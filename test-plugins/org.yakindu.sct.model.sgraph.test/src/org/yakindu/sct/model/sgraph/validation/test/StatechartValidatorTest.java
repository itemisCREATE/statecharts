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

import static org.yakindu.sct.model.sgraph.validation.StatechartValidator.STATECHART_NAME_VALID_IDENTIFIER_CODE;

import org.junit.Test;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.validation.StatechartValidator;

import com.google.inject.Inject;

public class StatechartValidatorTest extends AbstractSGraphValidatorTest {

	@Inject
	protected SGraphJavaValidatorTester<StatechartValidator> tester;

	@Test
	public void checkStatechartNameIsIdentifier() {
		Statechart statechart = SGraphFactory.eINSTANCE.createStatechart();
		statechart.setName("Not a valid identifier");
		tester.validate(statechart).assertError(STATECHART_NAME_VALID_IDENTIFIER_CODE);

		statechart.setName("0Notavalididentifier");
		tester.validate(statechart).assertError(STATECHART_NAME_VALID_IDENTIFIER_CODE);

		statechart.setName("ValidIdentifier");
		tester.validate(statechart).assertOK();
	}

}
