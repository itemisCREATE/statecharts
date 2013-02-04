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
 *  Unit TestCase for GuardedEntry
 */
@SuppressWarnings("all")
@RunWith(XtextRunner.class)
@InjectWith(SExecInjectionProvider.class)
public class GuardedEntryTest extends AbstractExecutionFlowTest {

	@Inject
	private SCTUnitTestModels models;

	@Before
	public void setup() throws Exception {
		ExecutionFlow flow = models
				.loadExecutionFlowFromResource("GuardedEntry.sct");
		initInterpreter(flow);
	}
	@Test
	public void EntryNotTakenOnStatechartEnter() throws Exception {
		assertTrue(getBoolean("guard") == false);
		interpreter.enter();
		assertTrue(isActive("A"));
		assertTrue(getBoolean("done") == false);
	}
	@Test
	public void EntryTakenOnStatechartEnter() throws Exception {
		setBoolean("guard", true);
		interpreter.enter();
		assertTrue(isActive("A"));
		assertTrue(getBoolean("done") == true);
	}
	@Test
	public void EntryTakenInTransition() throws Exception {
		interpreter.enter();
		assertTrue(isActive("A"));
		raiseEvent("e");
		interpreter.runCycle();
		assertTrue(isActive("B"));
		setBoolean("guard", true);
		setBoolean("done", false);
		raiseEvent("e");
		interpreter.runCycle();
		assertTrue(isActive("A"));
		assertTrue(getBoolean("done"));
	}
	@Test
	public void EntryNotTakenInTransition() throws Exception {
		interpreter.enter();
		assertTrue(isActive("A"));
		raiseEvent("e");
		interpreter.runCycle();
		assertTrue(isActive("B"));
		setBoolean("guard", false);
		setBoolean("done", false);
		raiseEvent("e");
		interpreter.runCycle();
		assertTrue(isActive("A"));
		assertTrue(!getBoolean("done"));
	}
}
