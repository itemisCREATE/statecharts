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
package org.yakindu.sct.generator.java.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.yakindu.scr.choice.ChoiceStatemachine;
import org.yakindu.scr.choice.ChoiceStatemachine.State;
/**
 *  Unit TestCase for Choice
 */
@SuppressWarnings("all")
public class ChoiceTest {

	private ChoiceStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new ChoiceStatemachine();
		statemachine.init();
		statemachine.enter();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testchoiceTest() {
		assertTrue(statemachine.isStateActive(State.Main_region_A));
		assertTrue(statemachine.getValue() == 4);
		statemachine.raisePressKey();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.Main_region_B));
		assertTrue(statemachine.getValue() == 3);
		statemachine.raisePressKey();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.Main_region_A));
		statemachine.raisePressKey();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.Main_region_C));
		assertTrue(statemachine.getValue() == 2);
		statemachine.raisePressKey();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.Main_region_B));
		assertTrue(statemachine.getValue() == 1);
		statemachine.raisePressKey();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.Main_region_A));
		assertTrue(statemachine.getValue() == 1);
		statemachine.raisePressKey();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.Main_region_C));
		assertTrue(statemachine.getValue() == 0);
		statemachine.raisePressKey();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.Main_region_A));
	}
}
