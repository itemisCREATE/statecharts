package org.yakindu.sct.generator.java.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.yakindu.scr.ieq.ineventqueue.IInEventQueueStatemachine.SCInterfaceOperationCallback;
import org.yakindu.scr.ieq.ineventqueue.InEventQueueStatemachine;
import org.yakindu.scr.ieq.ineventqueue.InEventQueueStatemachine.State;

public class CustomInEventQueueTest {
	public static class Callback implements SCInterfaceOperationCallback {
		protected char mode;

		protected InEventQueueStatemachine machine;

		public Callback(InEventQueueStatemachine machine) {
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
					machine.getSCII().raiseG();
					break;
				}
				default : {
					System.out.println("Nothing.");
				}
			}

		}
	}

	protected InEventQueueStatemachine machine;
	protected Callback callback;

	@Before
	public void setup() {
		machine = new InEventQueueStatemachine();
		callback = new Callback(machine);
		machine.getSCInterface().setSCInterfaceOperationCallback(callback);
		machine.init();
	}

	@Test
	public void testSetup() {
		machine.enter();
		assertTrue(machine.isStateActive(State.inEventQueue_main_region_A));
		assertEquals(0, machine.getCycles());
	}

	@Test
	public void testEventTriggersCycle() {
		machine.enter();
		machine.raiseE();
		assertTrue(machine.isStateActive(State.inEventQueue_main_region_dispatch));
		assertEquals(1, machine.getCycles());
	}

	@Test
	public void testOracleE() {
		callback.mode = 'e';
		machine.enter();
		machine.raiseE();
		assertTrue(machine.isStateActive(State.inEventQueue_main_region_A));
		assertEquals(2, machine.getCycles());
	}

	@Test
	public void testOracleF() {
		callback.mode = 'f';
		machine.enter();
		machine.raiseE();
		assertTrue(machine.isStateActive(State.inEventQueue_main_region_B));
		assertEquals(2, machine.getCycles());
	}

	@Test
	public void testOracleFx2() {
		callback.mode = 'f';
		machine.enter();
		machine.raiseE();
		assertTrue(machine.isStateActive(State.inEventQueue_main_region_B));
		assertEquals(2, machine.getCycles());
		callback.mode = '\0';
		machine.raiseF(12);
		assertTrue(machine.isStateActive(State.inEventQueue_main_region_dispatch));
		assertEquals(4, machine.getCycles());
	}

	@Test
	public void testOracleFx3() {
		callback.mode = 'f';
		machine.enter();
		machine.raiseE();
		assertTrue(machine.isStateActive(State.inEventQueue_main_region_B));
		assertEquals(2, machine.getCycles());
		machine.raiseF(12);
		assertTrue(machine.isStateActive(State.inEventQueue_main_region_B));
		assertEquals(5, machine.getCycles());
	}

	@Test
	public void testOracleG() {
		callback.mode = 'g';
		machine.enter();
		machine.raiseE();
		assertTrue(machine.isStateActive(State.inEventQueue_main_region_C));
		assertEquals(2, machine.getCycles());
	}

}
