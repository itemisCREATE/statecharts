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

package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.choice.ChoiceStatemachine;
import org.yakindu.scr.choice.ChoiceStatemachine.State;	

/**
 * Unit TestCase for Choice
 */
@SuppressWarnings("all")
public class Choice {
	
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
	public void elseChoiceUsingNonDefaultTransition() {
		initForEventE(true);
		assertTrue(statemachine.isStateActive(State.main_region_C));
	}
	@Test
	public void elseChoiceUsingDefaultTransition() {
		initForEventE(false);
		assertTrue(statemachine.isStateActive(State.main_region_B));
	}
	@Test
	public void defaultChoiceUsingNonDefaultTransition() {
		initForEventG(true);
		assertTrue(statemachine.isStateActive(State.main_region_C));
	}
	@Test
	public void defaultChoiceUsingDefaultTransition() {
		initForEventG(false);
		assertTrue(statemachine.isStateActive(State.main_region_B));
	}
	@Test
	public void uncheckedChoiceUsingNonDefaultTransition() {
		initForEventF(true);
		assertTrue(statemachine.isStateActive(State.main_region_C));
	}
	@Test
	public void uncheckedChoiceUsingDefaultTransition() {
		initForEventF(false);
		assertTrue(statemachine.isStateActive(State.main_region_B));
	}
	@Test
	public void alwaysTrueTransitionInChoice() {
		initForEventH(true);
		assertTrue(statemachine.isStateActive(State.main_region_C));
	}
	public void initForEventE(boolean valueForC) {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.setC(valueForC);
		statemachine.raiseE();
		statemachine.runCycle();
	}
	public void initForEventF(boolean valueForC) {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.setC(valueForC);
		statemachine.raiseF();
		statemachine.runCycle();
	}
	public void initForEventG(boolean valueForC) {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.setC(valueForC);
		statemachine.raiseG();
		statemachine.runCycle();
	}
	public void initForEventH(boolean valueForC) {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.setC(valueForC);
		statemachine.raiseH();
		statemachine.runCycle();
	}
}
