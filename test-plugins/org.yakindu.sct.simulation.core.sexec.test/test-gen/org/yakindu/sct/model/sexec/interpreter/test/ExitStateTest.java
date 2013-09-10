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
import static junit.framework.Assert.assertTrue;

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
/**
 *  Unit TestCase for ExitState
 */
@SuppressWarnings("all")
@RunWith(XtextRunner.class)
@InjectWith(SExecInjectionProvider.class)
public class ExitStateTest extends AbstractExecutionFlowTest {
	@Inject
	private SCTUnitTestModels models;
	@Before
	public void setup() throws Exception {
		ExecutionFlow flow = models
				.loadExecutionFlowFromResource("ExitState.sct");
		initInterpreter(flow);
	}
	@Test
	public void defaultExit() throws Exception {
		interpreter.enter();
		assertTrue(isActive("A"));
		raiseEvent("e");
		interpreter.runCycle();
		assertTrue(isActive("E"));
	}
	@Test
	public void namedExitThroughNamedTransition() throws Exception {
		interpreter.enter();
		assertTrue(isActive("A"));
		raiseEvent("f");
		interpreter.runCycle();
		assertTrue(isActive("F"));
	}
	@Test
	public void namedExitThroughDefaultTransition() throws Exception {
		interpreter.enter();
		assertTrue(isActive("A"));
		raiseEvent("g");
		interpreter.runCycle();
		assertTrue(isActive("E"));
	}
	@Test
	public void remainInA() throws Exception {
		interpreter.enter();
		assertTrue(isActive("A"));
		interpreter.runCycle();
		assertTrue(isActive("A"));
	}
}
