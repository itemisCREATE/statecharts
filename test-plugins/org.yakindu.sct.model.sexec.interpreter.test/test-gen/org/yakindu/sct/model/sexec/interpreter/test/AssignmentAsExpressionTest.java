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
 *  Unit TestCase for AssignmentAsExpression
 */
@SuppressWarnings("all")
@RunWith(XtextRunner.class)
@InjectWith(SExecInjectionProvider.class)
public class AssignmentAsExpressionTest extends AbstractExecutionFlowTest {

	@Inject
	private SCTUnitTestModels models;

	@Before
	public void setup() throws Exception {
		ExecutionFlow flow = models
				.loadExecutionFlowFromResource("AssignmentAsExpression.sct");
		initInterpreter(flow);
	}
	@Test
	public void simpleAssignment() throws Exception {
		interpreter.enter();
		assertTrue(isActive("Add"));
		assertTrue(getInteger("b") == 5);
		assertTrue(getInteger("a") == 9);
		interpreter.runCycle();
		assertTrue(isActive("Subtract"));
		assertTrue(getInteger("d") == 6);
		interpreter.runCycle();
		assertTrue(isActive("Multiply"));
		assertTrue(getInteger("e") == 15);
		interpreter.runCycle();
		assertTrue(isActive("Divide"));
		assertTrue(getInteger("g") == 1);
		interpreter.runCycle();
		assertTrue(isActive("Modulo"));
		assertTrue(getInteger("i") == 1);
		interpreter.runCycle();
		assertTrue(isActive("Shift"));
		assertTrue(getInteger("j") == 16);
		assertTrue(getInteger("k") == 4);
		interpreter.runCycle();
		assertTrue(isActive("boolean And"));
		assertTrue(getInteger("l") == 1);
		interpreter.runCycle();
		assertTrue(isActive("boolean Or"));
		assertTrue(getInteger("p") == 15);
		interpreter.runCycle();
		assertTrue(isActive("boolean Xor"));
		assertTrue(getInteger("u") == 12);
		interpreter.exit();
	}
}
