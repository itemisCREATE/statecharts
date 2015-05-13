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
 *  Unit TestCase for AssignmentAsExpression
 */
@SuppressWarnings("all")
@RunWith(XtextRunner.class)
@InjectWith(SExecInjectionProvider.class)
public class AssignmentAsExpressionTest extends AbstractExecutionFlowTest {
	@Before
	public void setup() throws Exception {
		ExecutionFlow flow = models
				.loadExecutionFlowFromResource("AssignmentAsExpression.sct");
		initInterpreter(flow);
	}
	@Test
	public void simpleAssignment() throws Exception {
		interpreter.enter();
		assertTrue(isStateActive("Add"));
		assertTrue(getInteger("b") == 5l);
		assertTrue(getInteger("a") == 9l);
		interpreter.runCycle();
		assertTrue(isStateActive("Subtract"));
		assertTrue(getInteger("d") == 6l);
		interpreter.runCycle();
		assertTrue(isStateActive("Multiply"));
		assertTrue(getInteger("e") == 15l);
		interpreter.runCycle();
		assertTrue(isStateActive("Divide"));
		assertTrue(getInteger("g") == 1l);
		interpreter.runCycle();
		assertTrue(isStateActive("Modulo"));
		assertTrue(getInteger("i") == 1l);
		interpreter.runCycle();
		assertTrue(isStateActive("Shift"));
		assertTrue(getInteger("j") == 16l);
		assertTrue(getInteger("k") == 4l);
		interpreter.runCycle();
		assertTrue(isStateActive("boolean And"));
		assertTrue(getInteger("l") == 1l);
		interpreter.runCycle();
		assertTrue(isStateActive("boolean Or"));
		assertTrue(getInteger("p") == 15l);
		interpreter.runCycle();
		assertTrue(isStateActive("boolean Xor"));
		assertTrue(getInteger("u") == 12l);
		interpreter.exit();
	}
}
