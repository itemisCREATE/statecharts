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
 *  Unit TestCase for OperationsWithoutBraces
 */
@SuppressWarnings("all")
@RunWith(XtextRunner.class)
@InjectWith(SExecInjectionProvider.class)
public class OperationsWithoutBracesTest extends AbstractExecutionFlowTest {
	@Before
	public void setup() throws Exception {
		ExecutionFlow flow = models
				.loadExecutionFlowFromResource("OperationsWithoutBraces.sct");
		initInterpreter(flow);
	}
	@Test
	public void OperationsWithoutBracesTest() throws Exception {
		interpreter.enter();
		assertTrue(isStateActive("A"));
		assertTrue(isStateActive("A"));
		interpreter.runCycle();
		assertTrue(isStateActive("B"));
		assertTrue(isStateActive("B"));
		interpreter.runCycle();
		assertTrue(isStateActive("C"));
		assertTrue(isStateActive("C"));
		interpreter.runCycle();
		assertTrue(isStateActive("D"));
		assertTrue(isStateActive("D"));
	}
}
