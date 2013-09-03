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
 *  Unit TestCase for Choice
 */
@SuppressWarnings("all")
@RunWith(XtextRunner.class)
@InjectWith(SExecInjectionProvider.class)
public class ChoiceTest extends AbstractExecutionFlowTest {
	@Inject
	private SCTUnitTestModels models;
	@Before
	public void setup() throws Exception {
		ExecutionFlow flow = models.loadExecutionFlowFromResource("Choice.sct");
		initInterpreter(flow);
	}
	@Test
	public void elseChoiceUsingNonDefaultTransition() throws Exception {
		interpreter.enter();
		assertTrue(isActive("A"));
		setBoolean("c", true);
		raiseEvent("e");
		interpreter.runCycle();
		assertTrue(isActive("C"));
	}
	@Test
	public void elseChoiceUsingDefaultTransition() throws Exception {
		interpreter.enter();
		assertTrue(isActive("A"));
		setBoolean("c", false);
		raiseEvent("e");
		interpreter.runCycle();
		assertTrue(isActive("B"));
	}
	@Test
	public void defaultChoiceUsingNonDefaultTransition() throws Exception {
		interpreter.enter();
		assertTrue(isActive("A"));
		setBoolean("c", true);
		raiseEvent("g");
		interpreter.runCycle();
		assertTrue(isActive("C"));
	}
	@Test
	public void defaultChoiceUsingDefaultTransition() throws Exception {
		interpreter.enter();
		assertTrue(isActive("A"));
		setBoolean("c", false);
		raiseEvent("g");
		interpreter.runCycle();
		assertTrue(isActive("B"));
	}
	@Test
	public void uncheckedChoiceUsingNonDefaultTransition() throws Exception {
		interpreter.enter();
		assertTrue(isActive("A"));
		setBoolean("c", true);
		raiseEvent("f");
		interpreter.runCycle();
		assertTrue(isActive("C"));
	}
	@Test
	public void uncheckedChoiceUsingDefaultTransition() throws Exception {
		interpreter.enter();
		assertTrue(isActive("A"));
		setBoolean("c", false);
		raiseEvent("f");
		interpreter.runCycle();
		assertTrue(isActive("B"));
	}
	@Test
	public void alwaysTrueTransitionInChoice() throws Exception {
		interpreter.enter();
		assertTrue(isActive("A"));
		setBoolean("c", true);
		raiseEvent("h");
		interpreter.runCycle();
		assertTrue(isActive("C"));
	}
}
