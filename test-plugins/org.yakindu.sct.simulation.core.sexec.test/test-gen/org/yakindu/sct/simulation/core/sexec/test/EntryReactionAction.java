/**
* Copyright (c) 2017 committers of YAKINDU and others.
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
 * Unit TestCase for EntryReactionAction
 */
@SuppressWarnings("all")
@RunWith(XtextRunner.class)
@InjectWith(SExecInjectionProvider.class)
public class EntryReactionAction extends AbstractExecutionFlowTest {
	@Before
	public void setup() throws Exception{
		ExecutionFlow flow = models.loadExecutionFlowFromResource("entries/EntryReactionAction.sct");
		initInterpreter(flow);
	}
	@Test
	public void entryTransitionActionOnStatechartEnter() throws Exception {
		interpreter.enter();
		assertTrue(getBoolean("enteredR1"));
		assertTrue(getBoolean("enteredR2"));
		assertTrue(getBoolean("enteredBdefault"));
		assertTrue(!getBoolean("enteredBother"));
	}
	@Test
	public void entryOnRTS() throws Exception {
		init();
		raiseEvent("b");
		interpreter.runCycle();
		assertTrue(!getBoolean("enteredR1"));
		assertTrue(!getBoolean("enteredR2"));
		assertTrue(!getBoolean("enteredBdefault"));
		assertTrue(getBoolean("enteredBother"));
	}
	@Test
	public void noEntryTransitionActionOnHistory() throws Exception {
		init();
		raiseEvent("d");
		interpreter.runCycle();
		assertTrue(!getBoolean("enteredR1"));
		assertTrue(!getBoolean("enteredR2"));
		assertTrue(!getBoolean("enteredBdefault"));
		assertTrue(!getBoolean("enteredBother"));
	}
	public void init() throws Exception {
		interpreter.enter();
		raiseEvent("b");
		interpreter.runCycle();
		raiseEvent("d");
		interpreter.runCycle();
		setBoolean("enteredR1", false);
		setBoolean("enteredR2", false);
		setBoolean("enteredBdefault", false);
		setBoolean("enteredBother", false);
	}
}
