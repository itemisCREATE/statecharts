/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.stext.test;

import static org.junit.Assert.assertTrue;

import org.eclipse.xtext.junit4.validation.AssertableDiagnostics;
import org.eclipse.xtext.junit4.validation.ValidatorTester;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.stext.ui.internal.STextActivator;
import org.yakindu.sct.model.stext.validation.STextJavaValidator;
import org.yakindu.sct.test.models.SCTUnitTestModels;

import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * @author andreas muelder - Initial contribution and API
 * 
 */
@RunWith(Parameterized.class)
public class TestModelsContainErrorsTest {

	@Inject
	private STextJavaValidator validator;
	@Inject
	private Injector injector;

	private Statechart statechart;

	private ValidatorTester<STextJavaValidator> tester;

	public TestModelsContainErrorsTest(Statechart statechart) {
		STextActivator.getInstance().getInjector(STextActivator.ORG_YAKINDU_SCT_MODEL_STEXT_STEXT).injectMembers(this);
		this.statechart = statechart;
	}

	@Before
	public void setup() {
		tester = new ValidatorTester<STextJavaValidator>(validator, injector);
	}

	@After
	public void teardown() {
		tester = null;
	}

	@Parameters
	public static Iterable<Object[]> testData() throws Exception {
		return SCTUnitTestModels.parameterizedTestData();
	}

	@Test
	public void testTestModelContainsErrors() throws Exception {
		AssertableDiagnostics validate = tester.validate(statechart);
		assertTrue("Testmodel " + statechart.getName() + " contains validation diagnostics",
				Iterables.size(validate.getAllDiagnostics()) == 0);
	}
}
