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
import org.yakindu.scr.outeventlifecycle.OutEventLifeCycleStatemachine;
import org.yakindu.scr.outeventlifecycle.OutEventLifeCycleStatemachine.State;

/**
 * Unit TestCase for OutEventLifeCycle
 */
@SuppressWarnings("all")
public class OutEventLifeCycleTest {
	private OutEventLifeCycleStatemachine statemachine;	
	
	@Before
	public void setUp() {
		statemachine = new OutEventLifeCycleStatemachine();
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}
	
	@Test
	public void testAvailableAfterCycle() {
		statemachine.enter();
		statemachine.raiseE();
		statemachine.runCycle();
		assertTrue(statemachine.isRaisedF());
	}
	@Test
	public void testAvailableWithinCycle() {
		init(false);
		assertTrue(statemachine.getF_available_in_cycle());
	}
	@Test
	public void testUnvailableWithin2ndCycle() {
		init(true);
		assertTrue(!statemachine.getF_available_in_next_cycle());
	}
	@Test
	public void testUnvailableAfter2ndCycle() {
		init(true);
		assertTrue(!statemachine.isRaisedF());
	}
	public void init(boolean sndCycle) {
		statemachine.enter();
		statemachine.raiseE();
		statemachine.runCycle();
		if (sndCycle) {
			statemachine.runCycle();
		}
	}
}
