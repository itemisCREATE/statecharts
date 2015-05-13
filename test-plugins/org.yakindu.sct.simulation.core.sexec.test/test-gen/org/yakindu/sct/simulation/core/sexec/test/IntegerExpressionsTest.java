/**
 * Copyright (c) 2015 committers of YAKINDU and others.
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
 *  Unit TestCase for IntegerExpressions
 */
@SuppressWarnings("all")
@RunWith(XtextRunner.class)
@InjectWith(SExecInjectionProvider.class)
public class IntegerExpressionsTest extends AbstractExecutionFlowTest {
	@Before
	public void setup() throws Exception {
		ExecutionFlow flow = models
				.loadExecutionFlowFromResource("IntegerExpressions.sct");
		initInterpreter(flow);
	}
	@Test
	public void integerExpressions() throws Exception {
		interpreter.enter();
		assertTrue(isStateActive("StateA"));
		assertTrue(getInteger("myInt1") == 10l);
		assertTrue(getInteger("myInt2") == 5l);
		raiseEvent("e1");
		interpreter.runCycle();
		assertTrue(getBoolean("less") == false);
		assertTrue(getBoolean("greater") == true);
		assertTrue(getBoolean("equalOrLess") == false);
		assertTrue(getBoolean("equalOrGreater") == true);
		assertTrue(getBoolean("equal") == false);
		assertTrue(getBoolean("notEqual") == true);
		assertTrue(getInteger("plus") == 15l);
		assertTrue(getInteger("minus") == 5l);
		assertTrue(getInteger("multiply") == 50l);
		assertTrue(getInteger("division") == 2l);
		assertTrue(getInteger("modulo") == 0l);
		assertTrue(getInteger("negat") == -10l);
		assertTrue(getInteger("multiAssign") == 20l);
		assertTrue(getInteger("divAssign") == 2l);
		assertTrue(getInteger("plusAssign") == 12l);
		assertTrue(getInteger("minusAssign") == -8l);
		assertTrue(getInteger("moduloAssign") == 0l);
	}
}
