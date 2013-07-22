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

package org.yakindu.sct.generator.java.test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.yakindu.scr.performancetest.PerformanceTestStatemachine;
import org.yakindu.scr.performancetest.PerformanceTestStatemachine.State;
import org.yakindu.scr.TimerService;
/**
 *  Unit TestCase for PerformanceTest
 */
@SuppressWarnings("all")
public class PerformanceTestsTest {

	private PerformanceTestStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new PerformanceTestStatemachine();
		statemachine.setTimerService(new TimerService());
		statemachine.init();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testtest_100_000() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.mr_A));
		while (statemachine.getC() < 100000) {
			if (statemachine.isStateActive(State.mr_A)) {
				statemachine.raiseE1();;
			} else {
				if (statemachine.getC() % 2 == 0) {
					statemachine.raiseE2();;
				} else {
					statemachine.raiseE3();;
				};
			}
			statemachine.runCycle();
		}
		assertTrue(statemachine.getA() > 2);
	}
	@Test
	public void testtest_1_000_000() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.mr_A));
		while (statemachine.getC() < 1000000) {
			if (statemachine.isStateActive(State.mr_A)) {
				statemachine.raiseE1();;
			} else {
				if (statemachine.getC() % 2 == 0) {
					statemachine.raiseE2();;
				} else {
					statemachine.raiseE3();;
				};
			}
			statemachine.runCycle();
		}
		assertTrue(statemachine.getA() > 2);
	}
	@Test
	public void testtest_10_000_000() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.mr_A));
		while (statemachine.getC() < 10000000) {
			if (statemachine.isStateActive(State.mr_A)) {
				statemachine.raiseE1();;
			} else {
				if (statemachine.getC() % 2 == 0) {
					statemachine.raiseE2();;
				} else {
					statemachine.raiseE3();;
				};
			}
			statemachine.runCycle();
		}
		assertTrue(statemachine.getA() > 2);
	}
}
