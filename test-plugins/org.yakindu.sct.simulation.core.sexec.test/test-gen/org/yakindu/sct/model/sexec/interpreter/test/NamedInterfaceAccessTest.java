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
 *  Unit TestCase for NamedInterfaceAccess
 */
@SuppressWarnings("all")
@RunWith(XtextRunner.class)
@InjectWith(SExecInjectionProvider.class)
public class NamedInterfaceAccessTest extends AbstractExecutionFlowTest {
	@Inject
	private SCTUnitTestModels models;
	@Before
	public void setup() throws Exception {
		ExecutionFlow flow = models
				.loadExecutionFlowFromResource("NamedInterfaceAccess.sct");
		initInterpreter(flow);
	}
	@Test
	public void SafeOpenSuccess() throws Exception {
		interpreter.enter();
		interpreter.runCycle();
		raiseEvent("User.numberPressed", 3);
		interpreter.runCycle();
		raiseEvent("User.numberPressed", 7);
		interpreter.runCycle();
		raiseEvent("User.numberPressed", 5);
		interpreter.runCycle();
		assertTrue(isRaised("Safe.open"));
	}
}
