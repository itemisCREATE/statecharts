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
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testelseChoiceUsingNonDefaultTransition() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.setC(true);
		statemachine.raiseE();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_C));
	}
	@Test
	public void testelseChoiceUsingDefaultTransition() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.setC(false);
		statemachine.raiseE();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_B));
	}
	@Test
	public void testdefaultChoiceUsingNonDefaultTransition() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.setC(true);
		statemachine.raiseG();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_C));
	}
	@Test
	public void testdefaultChoiceUsingDefaultTransition() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.setC(false);
		statemachine.raiseG();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_B));
	}
	@Test
	public void testuncheckedChoiceUsingNonDefaultTransition() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.setC(true);
		statemachine.raiseF();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_C));
	}
	@Test
	public void testuncheckedChoiceUsingDefaultTransition() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.setC(false);
		statemachine.raiseF();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_B));
	}
	@Test
	public void testalwaysTrueTransitionInChoice() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.setC(true);
		statemachine.raiseH();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_C));
	}
}
