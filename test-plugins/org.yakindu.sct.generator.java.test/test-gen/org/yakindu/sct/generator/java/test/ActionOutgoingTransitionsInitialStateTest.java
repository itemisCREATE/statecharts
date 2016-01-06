/**
* Copyright (c) 2016 committers of YAKINDU and others.
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
import org.yakindu.scr.actionoutgoingtransitionsinitialstate.ActionOutgoingTransitionsInitialStateStatemachine;
import org.yakindu.scr.actionoutgoingtransitionsinitialstate.ActionOutgoingTransitionsInitialStateStatemachine.State;
/**
 *  Unit TestCase for ActionOutgoingTransitionsInitialState
 */
@SuppressWarnings("all")
public class ActionOutgoingTransitionsInitialStateTest {

	private ActionOutgoingTransitionsInitialStateStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new ActionOutgoingTransitionsInitialStateStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testActionOutgoingTransitionsInitialStateTest() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.region_1__1));
		assertTrue(statemachine.isStateActive(State.region_2__1));
		assertTrue(statemachine.isStateActive(State.region_2__1_r1__2));
		assertTrue(statemachine.getInternalB() == 5l);
		assertTrue(statemachine.getC() == 5l);
		assertTrue(statemachine.getD() == 5l);
	}
}
