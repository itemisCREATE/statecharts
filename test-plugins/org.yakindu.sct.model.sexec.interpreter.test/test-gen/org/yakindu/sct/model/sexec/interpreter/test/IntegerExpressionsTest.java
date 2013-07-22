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
package org.yakindu.sct.model.sexec.interpreter.test;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sexec.interpreter.test.util.AbstractExecutionFlowTest;
import org.yakindu.sct.model.sexec.interpreter.test.util.SExecInjectionProvider;
import com.google.inject.Inject;
import org.junit.Before;
import org.yakindu.sct.model.sexec.interpreter.IExecutionFlowInterpreter;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.test.models.SCTUnitTestModels;
import static junit.framework.Assert.*;
/**
 *  Unit TestCase for IntegerExpressions
 */
@SuppressWarnings("all")
@RunWith(XtextRunner.class)
@InjectWith(SExecInjectionProvider.class)
public class IntegerExpressionsTest extends AbstractExecutionFlowTest {
	@Inject
	private SCTUnitTestModels models;
	@Before
	public void setup() throws Exception {
		ExecutionFlow flow = models
				.loadExecutionFlowFromResource("IntegerExpressions.sct");
		initInterpreter(flow);
	}
	@Test
	public void integerExpressions() throws Exception {
		interpreter.enter();
		assertTrue(isActive("StateA"));
		assertTrue(getInteger("myInt1") == 10);
		assertTrue(getInteger("myInt2") == 5);
		raiseEvent("e1");
		interpreter.runCycle();
		assertTrue(getBoolean("less") == false);
		assertTrue(getBoolean("greater") == true);
		assertTrue(getBoolean("equalOrLess") == false);
		assertTrue(getBoolean("equalOrGreater") == true);
		assertTrue(getBoolean("equal") == false);
		assertTrue(getBoolean("notEqual") == true);
		assertTrue(getInteger("plus") == 15);
		assertTrue(getInteger("minus") == 5);
		assertTrue(getInteger("multiply") == 50);
		assertTrue(getInteger("division") == 2);
		assertTrue(getInteger("modulo") == 0);
		assertTrue(getInteger("negat") == -10);
		assertTrue(getInteger("multiAssign") == 20);
		assertTrue(getInteger("divAssign") == 2);
		assertTrue(getInteger("plusAssign") == 12);
		assertTrue(getInteger("minusAssign") == -8);
		assertTrue(getInteger("moduloAssign") == 0);
	}
}
