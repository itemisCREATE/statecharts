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
 *  Unit TestCase for ReadOnlyVariable
 */
@SuppressWarnings("all")
@RunWith(XtextRunner.class)
@InjectWith(SExecInjectionProvider.class)
public class ReadOnlyVariableTest extends AbstractExecutionFlowTest {
	@Before
	public void setup() throws Exception {
		ExecutionFlow flow = models
				.loadExecutionFlowFromResource("ReadOnlyVariable.sct");
		initInterpreter(flow);
	}
	@Test
	public void ReadOnlyVariableTest() throws Exception {
		interpreter.enter();
		assertTrue(isStateActive("StateA"));
		assertTrue(getInteger("myInt") == 0l);
		assertTrue(getString("myString").equals("testString"));
		assertTrue(getBoolean("myBool") == true);
		assertTrue(getReal("myReal") == 1.1d);
		assertTrue(getInteger("A.myInt") == 0l);
		assertTrue(getString("A.myString").equals("testString"));
		assertTrue(getBoolean("A.myBool") == true);
		assertTrue(getReal("A.myReal") == 1.1d);
		interpreter.runCycle();
		assertTrue(isStateActive("StateB"));
		assertTrue(getInteger("myInt") == 100l);
		assertTrue(getString("myString").equals("fail"));
		assertTrue(getBoolean("myBool") == false);
		assertTrue(getReal("myReal") == 6.6d);
		assertTrue(getInteger("A.myInt") == 200l);
		assertTrue(getString("A.myString").equals("A_fail"));
		assertTrue(getBoolean("A.myBool") == false);
		assertTrue(getReal("A.myReal") == 7.7d);
	}
}
