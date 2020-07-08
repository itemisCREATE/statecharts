/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.java.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.yakindu.scr.ieq.ineventqueue.IInEventQueue.InterfaceOperationCallback;
import org.yakindu.scr.ieq.ineventqueue.InEventQueue;
import org.yakindu.scr.ieq.ineventqueue.InEventQueue.State;

/**
 * 
 * @author BeckmaR
 *
 */
public class CustomInEventQueueTest {
	public static class Callback implements InterfaceOperationCallback {
		protected char mode;

		protected InEventQueue machine;

		public Callback(InEventQueue machine) {
			this.machine = machine;
		}

		@Override
		public void askOracle() {
			System.out.print("Oracle says: ");
			switch (mode) {
				case 'e' : {
					System.out.println("E!");
					machine.raiseE();
					break;
				}
				case 'f' : {
					System.out.println("F!");
					machine.raiseF(42);
					break;
				}
				case 'g' : {
					System.out.println("G!");
					machine.getInterfaceI().raiseG();
					break;
				}
				default : {
					System.out.println("Nothing.");
				}
			}

		}
	}

	protected InEventQueue machine;
	protected Callback callback;

	@Before
	public void setup() {
		machine = new InEventQueue();
		callback = new Callback(machine);
		machine.getInterface().setInterfaceOperationCallback(callback);
		machine.init();
	}

	@Test
	public void testSetup() {
		machine.enter();
		assertTrue(machine.isStateActive(State.INEVENTQUEUE_MAIN_REGION_A));
		assertEquals(0, machine.getCycles());
	}

	@Test
	public void testEventTriggersCycle() {
		machine.enter();
		machine.raiseE();
		assertTrue(machine.isStateActive(State.INEVENTQUEUE_MAIN_REGION_DISPATCH));
		assertEquals(1, machine.getCycles());
	}

	@Test
	public void testOracleE() {
		callback.mode = 'e';
		machine.enter();
		machine.raiseE();
		assertTrue(machine.isStateActive(State.INEVENTQUEUE_MAIN_REGION_A));
		assertEquals(2, machine.getCycles());
	}

	@Test
	public void testOracleF() {
		callback.mode = 'f';
		machine.enter();
		machine.raiseE();
		assertTrue(machine.isStateActive(State.INEVENTQUEUE_MAIN_REGION_B));
		assertEquals(2, machine.getCycles());
	}

	@Test
	public void testOracleFx2() {
		callback.mode = 'f';
		machine.enter();
		machine.raiseE();
		assertTrue(machine.isStateActive(State.INEVENTQUEUE_MAIN_REGION_B));
		assertEquals(2, machine.getCycles());
		callback.mode = '\0';
		machine.raiseF(12);
		assertTrue(machine.isStateActive(State.INEVENTQUEUE_MAIN_REGION_DISPATCH));
		assertEquals(4, machine.getCycles());
	}

	@Test
	public void testOracleFx3() {
		callback.mode = 'f';
		machine.enter();
		machine.raiseE();
		assertTrue(machine.isStateActive(State.INEVENTQUEUE_MAIN_REGION_B));
		assertEquals(2, machine.getCycles());
		machine.raiseF(12);
		assertTrue(machine.isStateActive(State.INEVENTQUEUE_MAIN_REGION_B));
		assertEquals(5, machine.getCycles());
	}

	@Test
	public void testOracleG() {
		callback.mode = 'g';
		machine.enter();
		machine.raiseE();
		assertTrue(machine.isStateActive(State.INEVENTQUEUE_MAIN_REGION_C));
		assertEquals(2, machine.getCycles());
	}

}
