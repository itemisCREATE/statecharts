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
 *  Unit TestCase for OutEventLifeCycle
 */
@SuppressWarnings("all")
@RunWith(XtextRunner.class)
@InjectWith(SExecInjectionProvider.class)
public class OutEventLifeCycleTest extends AbstractExecutionFlowTest {

	@Inject
	private SCTUnitTestModels models;

	@Before
	public void setup() throws Exception {
		ExecutionFlow flow = models
				.loadExecutionFlowFromResource("OutEventLifeCycle.sct");
		initInterpreter(flow);
	}
	@Test
	public void availableAfterCycle() throws Exception {
		interpreter.enter();
		raiseEvent("e");
		interpreter.runCycle();
		assertTrue(isRaised("f"));
	}
	@Test
	public void availableWithinCycle() throws Exception {
		interpreter.enter();
		raiseEvent("e");
		interpreter.runCycle();
		assertTrue(getBoolean("f_available_in_cycle"));
	}
	@Test
	public void unvailableWithin2ndCycle() throws Exception {
		interpreter.enter();
		raiseEvent("e");
		interpreter.runCycle();
		interpreter.runCycle();
		assertTrue(!getBoolean("f_available_in_next_cycle"));
	}
	@Test
	public void unvailableAfter2ndCycle() throws Exception {
		interpreter.enter();
		raiseEvent("e");
		interpreter.runCycle();
		interpreter.runCycle();
		assertTrue(!isRaised("f"));
	}
}
