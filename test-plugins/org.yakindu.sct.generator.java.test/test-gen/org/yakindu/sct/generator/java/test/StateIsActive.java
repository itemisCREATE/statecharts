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
import org.yakindu.scr.stateisactive.StateIsActiveStatemachine;
import org.yakindu.scr.stateisactive.StateIsActiveStatemachine.State;	

/**
 * Unit TestCase for StateIsActive
 */
@SuppressWarnings("all")
public class StateIsActive {
	
	private StateIsActiveStatemachine statemachine;	
	
	
	
	@Before
	public void stateIsActive_setUp() {
		statemachine = new StateIsActiveStatemachine();
		statemachine.init();
	}

	@After
	public void stateIsActive_tearDown() {
		statemachine = null;
	}
	
	@Test
	public void stateIsActive() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.r1_R1A));
		assertTrue(statemachine.isStateActive(State.r2_R2A));
		statemachine.raiseEvent1();
		statemachine.runCycle();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.r1_R1B));
		assertTrue(statemachine.isStateActive(State.r2_R2B));
	}
}
