/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sexec.interpreter.test;

import java.io.IOException;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Test;
import org.junit.runner.RunWith;

import util.AbstractExecutionFlowTest;
import util.SExecInjectionProvider;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@RunWith(XtextRunner.class)
@InjectWith(SExecInjectionProvider.class)
public class ExecutionFlowInterpreterTest extends AbstractExecutionFlowTest {

	@Test
	public void testSimpleGuard() throws Exception {
		loadAndconfigureInterpreter(models.createGuardModel());
		assertIsActive("A");
		assertVarValue("MyVar", 0);
		context().raiseEvent("Event1", null);
		interpreter.runCycle();
		assertIsActive("A");
		context().raiseEvent("Event2", null);
		interpreter.runCycle();
		assertVarValue("MyVar", 10);
		assertIsActive("B");
		context().raiseEvent("Return", null);
		interpreter.runCycle();
		assertIsActive("A");
		context().raiseEvent("Event1", null);
		interpreter.runCycle();
		assertIsActive("B");
	}

	@Test
	public void testsimpleHierachy() throws IOException {
		loadAndconfigureInterpreter(models.createSimpleHierachyModel());
		assertIsActive("A");
		context().raiseEvent("Event1", null);
		interpreter.runCycle();
		assertIsActive("B");
		assertIsActive("B1");
	}

	@Test
	public void testDeepHistory() throws IOException {
		loadAndconfigureInterpreter(models.createDeepHistoryModel());
		assertIsActive("State1");
		context().raiseEvent("event1", null);
		interpreter.runCycle();
		interpreter.runCycle();
		interpreter.runCycle();
		assertIsActive("State2");
		assertIsActive("State4");
		assertIsActive("State6");
		context().raiseEvent("event2", null);
		interpreter.runCycle();
		assertIsActive("State1");
		context().raiseEvent("event1", null);
		interpreter.runCycle();
		interpreter.runCycle();
		interpreter.runCycle();
		// Now, the deep history states should be active
		assertIsActive("State2");
		assertIsActive("State4");
		assertIsActive("State6");
	}

	@Test
	public void testStateIsActive() throws IOException {
		loadAndconfigureInterpreter(models.createStateIsActiveModel());
		assertIsActive("R1A");
		assertIsActive("R2A");
		context().raiseEvent("Event1", null);
		interpreter.runCycle();
		interpreter.runCycle();
		assertIsActive("R1B");
		assertIsActive("R2B");
	}

	@Test
	public void testValuedEvents() throws IOException {
		loadAndconfigureInterpreter(models.createValuedEventsModel());
		assertIsActive("A");
		assertIsActive("B");
		interpreter.runCycle();
		assertIsActive("C");
		assertVarValue("myVar", 42);
	}

	@Test
	public void testFeatureCall() throws Exception {
		loadAndconfigureInterpreter(models.createFeatureCallModel());
		assertIsActive("A");
		interpreter.runCycle();
		context().raiseEvent("MyInterface.Event1", null);
		interpreter.runCycle();
		interpreter.runCycle();
		assertIsActive("B");
		assertVarValue("MyInterface.myInt", 42);
	}
	@Test
	public void testStatechartLocalReactionsCall() throws Exception {
		loadAndconfigureInterpreter(models.createStatechartLocalReactionsModel());
		assertIsActive("S1");
		assertVarValue("myInt", 0);
		interpreter.runCycle();
		assertVarValue("myInt", 1);
		interpreter.runCycle();
		assertVarValue("myInt", 2);
		interpreter.runCycle();
		assertVarValue("myInt", 3);
	}

}
