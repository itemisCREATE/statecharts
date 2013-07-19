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
import static org.junit.Assert.*;
/**
 *  Unit TestCase for BitExpressions
 */
@SuppressWarnings("all")
@RunWith(XtextRunner.class)
@InjectWith(SExecInjectionProvider.class)
public class BitExpressionsTest extends AbstractExecutionFlowTest {

	@Inject
	private SCTUnitTestModels models;

	@Before
	public void setup() throws Exception {
		ExecutionFlow flow = models
				.loadExecutionFlowFromResource("BitExpressions.sct");
		initInterpreter(flow);
	}
	@Test
	public void BitExpressions() throws Exception {
		interpreter.enter();
		assertTrue(isActive("StateA"));
		assertTrue(getInteger("myBit1") == 5);
		assertTrue(getInteger("myBit2") == 7);
		raiseEvent("e1");
		interpreter.runCycle();
		assertTrue(isActive("StateB"));
		assertTrue(getInteger("leftBitshift") == 10);
		assertTrue(getInteger("rightBitshift") == 2);
		assertTrue(getInteger("complementBitshift") == -6);
		assertTrue(getInteger("bitwiseAnd") == 5);
		assertTrue(getInteger("bitwiseOr") == 7);
		assertTrue(getInteger("bitwiseXor") == 2);
	}
}
