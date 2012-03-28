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

}
