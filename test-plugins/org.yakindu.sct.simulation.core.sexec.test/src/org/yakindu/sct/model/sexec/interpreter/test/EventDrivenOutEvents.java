/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 *
 */
package org.yakindu.sct.model.sexec.interpreter.test;

import static org.junit.Assert.assertTrue;

import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sexec.interpreter.test.util.AbstractExecutionFlowTest;
import org.yakindu.sct.model.sexec.interpreter.test.util.SExecInjectionProvider;
import org.yakindu.sct.test.models.SCTUnitTestModels;

/**
 * @author rbeckmann
 *
 */
@SuppressWarnings("all")
@RunWith(XtextRunner.class)
@InjectWith(SExecInjectionProvider.class)
public class EventDrivenOutEvents extends AbstractExecutionFlowTest {
	@Before
	public void setup() throws Exception {
		ExecutionFlow flow = models.loadExecutionFlowFromResource(SCTUnitTestModels.EVENT_DRIVEN_OUT_EVENTS);
		initInterpreter(flow);
	}

	@Override
	protected void initInterpreter(ExecutionFlow flow) {
		initializer.initialize(context, flow);
		interpreter.initialize(flow, context, true);
		this.flow = flow;
	}

	@Test
	public void testOutEventAvailable() {
		interpreter.enter();
		assertTrue(isStateActive("StateA"));
		assertTrue(isStateActive("StateC"));
		interpreter.runCycle(); // needed to trigger "always"
		assertTrue(isStateActive("StateB"));
		assertTrue(isStateActive("StateD"));
	}
}
