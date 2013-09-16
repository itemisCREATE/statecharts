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
package org.yakindu.sct.simulation.core.sexec.test;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.interpreter.test.util.AbstractExecutionFlowTest;
import org.yakindu.sct.model.sexec.interpreter.test.util.SExecInjectionProvider;
import org.yakindu.sct.test.models.SCTUnitTestModels;
import com.google.inject.Inject;
import static org.junit.Assert.assertTrue;
/**
 *  Unit TestCase for StringExpressions
 */
@SuppressWarnings("all")
@RunWith(XtextRunner.class)
@InjectWith(SExecInjectionProvider.class)
public class StringExpressionsTest extends AbstractExecutionFlowTest {
	@Inject
	private SCTUnitTestModels models;
	@Before
	public void setup() throws Exception {
		ExecutionFlow flow = models
				.loadExecutionFlowFromResource("StringExpressions.sct");
		initInterpreter(flow);
	}
	@Test
	public void StringExpressionsTest() throws Exception {
		assertTrue(getString("quotedString").equals("\"x\""));
		interpreter.enter();
		assertTrue(isActive("StateA"));
		assertTrue(getString("myString").equals("hello"));
		assertTrue(getString("myString2").equals("world"));
		assertTrue(getString("quotedString").equals("'y'"));
		raiseEvent("e1");
		interpreter.runCycle();
		assertTrue(isActive("StateB"));
		assertTrue(getBoolean("equals") == false);
		assertTrue(getBoolean("notEqual") == true);
		assertTrue(getString("quotedString").equals("\"z\""));
	}
}
