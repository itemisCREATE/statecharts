/**
 * Copyright (c) 2014 committers of YAKINDU and others.
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
 *  Unit TestCase for SyncFork
 */
@SuppressWarnings("all")
@RunWith(XtextRunner.class)
@InjectWith(SExecInjectionProvider.class)
public class SyncForkTest extends AbstractExecutionFlowTest {
	@Before
	public void setup() throws Exception {
		ExecutionFlow flow = models
				.loadExecutionFlowFromResource("SyncFork.sct");
		initInterpreter(flow);
	}
	@Test
	public void syncForkTest() throws Exception {
		interpreter.enter();
		assertTrue(isActive("A"));
		raiseEvent("f");
		interpreter.runCycle();
		assertTrue(isActive("B"));
		assertTrue(isActive("C1"));
		assertTrue(isActive("D1"));
		raiseEvent("f");
		interpreter.runCycle();
		assertTrue(isActive("B"));
		assertTrue(isActive("C2"));
		assertTrue(isActive("D2"));
		raiseEvent("e");
		interpreter.runCycle();
		assertTrue(isActive("A"));
		raiseEvent("f");
		interpreter.runCycle();
		assertTrue(isActive("B"));
		assertTrue(isActive("C1"));
		assertTrue(isActive("D1"));
	}
}
