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

import org.junit.Test;

import util.AbstractExecutionFlowTest;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExecutionFlowInterpreterTest extends AbstractExecutionFlowTest {


	@Test
	public void testSimpleTransition() throws Exception {
		loadAndconfigureInterpreter(models.createSimpleModel());
		assertIsActive("A");
		assertVarValue("MyVar", 0);
		context().raiseEvent("Event1", null);
		interpreter.runCycle();
		assertIsActive("B");
		assertVarValue("MyVar", 10);
	}
	@Test
	public void testsimpleHierachy() throws IOException{
		loadAndconfigureInterpreter(models.createSimpleHierachyModel());
		assertIsActive("A");
		context().raiseEvent("Event1", null);
		interpreter.runCycle();
		assertIsActive("B");
		assertIsActive("B1");
	}

}
