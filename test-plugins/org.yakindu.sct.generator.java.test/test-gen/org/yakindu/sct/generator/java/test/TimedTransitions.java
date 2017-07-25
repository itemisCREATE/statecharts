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
import org.yakindu.scr.timedtransitions.TimedTransitionsStatemachine;
import org.yakindu.scr.timedtransitions.TimedTransitionsStatemachine.State;	
import org.yakindu.scr.VirtualTimer;

/**
 * Unit TestCase for TimedTransitions
 */
@SuppressWarnings("all")
public class TimedTransitions {
	
	private TimedTransitionsStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	
	@Before
	public void timedTransitions_setUp() {
		statemachine = new TimedTransitionsStatemachine();
		timer = new VirtualTimer();
		statemachine.setTimer(timer);
		statemachine.init();
	}

	@After
	public void timedTransitions_tearDown() {
		statemachine = null;
		timer = null;
	}
	
	@Test
	public void timer01() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_Start));
		for(int i = 1; i <= 10; i++) {
			timer.timeLeap(200);
			statemachine.runCycle();
		}
		timer.timeLeap(30);
		statemachine.runCycle();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.main_region_End));
	}
}
