/**
 * Copyright (c) 2020 Committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	Robin Herrmann    - Initial contribution and API
 */
package org.yakindu.sct.generator.c.test.sgen;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.junit4.validation.AssertableDiagnostics;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.c.features.CDefaultFeatureValueProvider;
import org.yakindu.sct.generator.genmodel.test.SGenJavaValidatorTest.MsgPredicate;
import org.yakindu.sct.generator.genmodel.test.util.AbstractSGenTest;
import org.yakindu.sct.generator.genmodel.test.util.SGenInjectorProvider;
import org.yakindu.sct.model.sgen.GeneratorModel;

/**
 * 
 * @author rherrmann
 *
 */
@RunWith(XtextRunner.class)
@InjectWith(SGenInjectorProvider.class)
public class CSGenJavaValidatorTest extends AbstractSGenTest {

	@Test
	public void checkFeatureConfiguration() {
		EObject model = null;
		AssertableDiagnostics result = null;

		String start = "GeneratorModel for yakindu::c { statechart Example {";

		model = parseExpression(start + "feature OutEventAPI {observables = false}}}",
				GeneratorModel.class.getSimpleName());
		result = tester.validate(model);
		result.assertAny(
				new MsgPredicate(String.format(CDefaultFeatureValueProvider.REQUIRED_TRUE_PARAMETER, "OutEventAPI")));

		model = parseExpression(start + "feature OutEventAPI {observables = false getters = false}}}",
				GeneratorModel.class.getSimpleName());
		result = tester.validate(model);
		result.assertAny(
				new MsgPredicate(String.format(CDefaultFeatureValueProvider.REQUIRED_TRUE_PARAMETER, "OutEventAPI")));

		model = parseExpression(start + " feature OutEventAPI {observables = true}}}",
				GeneratorModel.class.getSimpleName());
		result = tester.validate(model);
		result.assertDiagnosticsCount(1);

		model = parseExpression(start + "feature OutEventAPI {observables = true getters = true}}}",
				GeneratorModel.class.getSimpleName());
		result = tester.validate(model);
		result.assertDiagnosticsCount(1);

		model = parseExpression(start + "feature OutEventAPI {observables = true getters = false}}}",
				GeneratorModel.class.getSimpleName());
		result = tester.validate(model);
		result.assertDiagnosticsCount(1);

		model = parseExpression(start + "feature OutEventAPI {observables = false getters = true}}}",
				GeneratorModel.class.getSimpleName());
		result = tester.validate(model);
		result.assertDiagnosticsCount(1);

		model = parseExpression(start + "feature OutEventAPI {getters = true}}}", GeneratorModel.class.getSimpleName());
		result = tester.validate(model);
		result.assertDiagnosticsCount(1);

		model = parseExpression(start + "feature OutEventAPI {getters = false}}}",
				GeneratorModel.class.getSimpleName());
		result = tester.validate(model);
		result.assertDiagnosticsCount(1);
	}
}
