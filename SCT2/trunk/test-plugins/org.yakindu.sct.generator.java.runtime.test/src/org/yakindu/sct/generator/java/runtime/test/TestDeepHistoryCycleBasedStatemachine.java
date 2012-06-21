package org.yakindu.sct.generator.java.runtime.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.generator.java.runtime.cyclebased.test_deephistory.Test_DeepHistoryStatemachine;
import org.yakindu.sct.generator.java.runtime.cyclebased.test_deephistory.Test_DeepHistoryStatemachine.State;

public class TestDeepHistoryCycleBasedStatemachine {

	private Test_DeepHistoryStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new Test_DeepHistoryStatemachine();
		statemachine.init();
		statemachine.enter();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testDeepHistory() {
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

		// Leave State2. State4 and State9 should be saved as history.
		statemachine.raiseEvent2();
		statemachine.runCycle();
		assertTrue(statemachine.isStateActive(State.MainRegion_State1));
		assertFalse(statemachine.isStateActive(State.MainRegion_State2__region0_State4__region0_State7__region0_State9));

		// Reenter State2. State9 should be activated (History of State2).
		statemachine.raiseEvent1();
		statemachine.runCycle();
		assertFalse(statemachine.isStateActive(State.MainRegion_State1));
		assertTrue(statemachine.isStateActive(State.MainRegion_State2__region0_State4__region0_State7__region0_State9));
	}
}
