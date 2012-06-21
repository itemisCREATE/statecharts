package org.yakindu.sct.generator.java.runtime.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.generator.java.runtime.cyclebased.test_shallowhistory.Test_ShallowHistoryStatemachine;
import org.yakindu.sct.generator.java.runtime.cyclebased.test_shallowhistory.Test_ShallowHistoryStatemachine.State;

public class TestShallowHistoryCycleBasedStatemachine {

	private Test_ShallowHistoryStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new Test_ShallowHistoryStatemachine();
		statemachine.init();
		statemachine.enter();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testShallowHistory() {
		// Change active states to State9;
		statemachine.raiseEvent1();
		statemachine.runCycle();
		statemachine.raiseEvent3();
		statemachine.runCycle();
		statemachine.raiseEvent5();
		statemachine.runCycle();
		statemachine.raiseEvent7();
		statemachine.runCycle();
		assertFalse(statemachine.isStateActive(State.MainRegion_State1));
		assertTrue(statemachine.isStateActive(State.MainRegion_State2__region0_State4__region0_State7__region0_State9));

		// Leave State7. State9 should be saved as history.
		statemachine.raiseEvent6();
		statemachine.runCycle();
		assertFalse(statemachine.isStateActive(State.MainRegion_State2__region0_State4__region0_State7__region0_State9));
		assertTrue(statemachine.isStateActive(State.MainRegion_State2__region0_State4__region0_State6));

		// Reenter State7. State9 should be activated because of saved history.
		statemachine.raiseEvent5();
		statemachine.runCycle();
		assertFalse(statemachine.isStateActive(State.MainRegion_State2__region0_State4__region0_State6));
		assertTrue(statemachine.isStateActive(State.MainRegion_State2__region0_State4__region0_State7__region0_State9));

		// Leave State2. State4 and State9 should be saved as history.
		statemachine.raiseEvent2();
		statemachine.runCycle();
		assertFalse(statemachine.isStateActive(State.MainRegion_State2__region0_State4__region0_State7__region0_State9));
		assertTrue(statemachine.isStateActive(State.MainRegion_State1));

		// Reenter State2. State6 should be activated (History of State2).
		statemachine.raiseEvent1();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.MainRegion_State2__region0_State4__region0_State6));
		assertFalse(statemachine.isStateActive(State.MainRegion_State1));

		// Reenter State7. State9 should be activated (History of State7).
		statemachine.raiseEvent5();
		statemachine.runCycle();
		assertFalse(statemachine.isStateActive(State.MainRegion_State2__region0_State4__region0_State6));
		assertTrue(statemachine.isStateActive(State.MainRegion_State2__region0_State4__region0_State7__region0_State9));
	}
}
