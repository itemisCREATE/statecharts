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
 *  Unit TestCase for SyncJoin
 */
@SuppressWarnings("all")
@RunWith(XtextRunner.class)
@InjectWith(SExecInjectionProvider.class)
public class SyncJoinTest extends AbstractExecutionFlowTest {
	@Before
	public void setup() throws Exception {
		ExecutionFlow flow = models
				.loadExecutionFlowFromResource("SyncJoin.sct");
		initInterpreter(flow);
	}
	@Test
	public void syncJoin_C2_Waits() throws Exception {
		interpreter.enter();
		assertTrue(isStateActive("B"));
		assertTrue(isStateActive("C1"));
		assertTrue(isStateActive("D1"));
		raiseEvent("e");
		interpreter.runCycle();
		assertTrue(isStateActive("C2"));
		assertTrue(isStateActive("D1"));
		raiseEvent("jc");
		interpreter.runCycle();
		assertTrue(isStateActive("C2"));
		assertTrue(isStateActive("D1"));
		raiseEvent("jd");
		interpreter.runCycle();
		assertTrue(isStateActive("C2"));
		assertTrue(isStateActive("D1"));
		raiseEvent("jc");
		raiseEvent("jd");
		interpreter.runCycle();
		assertTrue(isStateActive("C2"));
		assertTrue(isStateActive("D1"));
		raiseEvent("f");
		interpreter.runCycle();
		assertTrue(isStateActive("C2"));
		assertTrue(isStateActive("D2"));
		raiseEvent("jc");
		interpreter.runCycle();
		assertTrue(isStateActive("C2"));
		assertTrue(isStateActive("D2"));
		raiseEvent("jd");
		interpreter.runCycle();
		assertTrue(isStateActive("C2"));
		assertTrue(isStateActive("D2"));
		raiseEvent("jc");
		raiseEvent("jd");
		interpreter.runCycle();
		assertTrue(isStateActive("A"));
	}
	@Test
	public void syncJoin_D2_Waits() throws Exception {
		interpreter.enter();
		assertTrue(isStateActive("B"));
		assertTrue(isStateActive("C1"));
		assertTrue(isStateActive("D1"));
		raiseEvent("f");
		interpreter.runCycle();
		assertTrue(isStateActive("C1"));
		assertTrue(isStateActive("D2"));
		raiseEvent("jc");
		interpreter.runCycle();
		assertTrue(isStateActive("C1"));
		assertTrue(isStateActive("D2"));
		raiseEvent("jd");
		interpreter.runCycle();
		assertTrue(isStateActive("C1"));
		assertTrue(isStateActive("D2"));
		raiseEvent("jc");
		raiseEvent("jd");
		interpreter.runCycle();
		assertTrue(isStateActive("C1"));
		assertTrue(isStateActive("D2"));
		raiseEvent("e");
		interpreter.runCycle();
		assertTrue(isStateActive("C2"));
		assertTrue(isStateActive("D2"));
	}
	@Test
	public void doubleEntryActionBug() throws Exception {
		interpreter.enter();
		raiseEvent("e");
		raiseEvent("f");
		interpreter.runCycle();
		raiseEvent("jc");
		raiseEvent("jd");
		interpreter.runCycle();
		assertTrue(isStateActive("A"));
		assertTrue(getInteger("x") == 1l);
	}
}
