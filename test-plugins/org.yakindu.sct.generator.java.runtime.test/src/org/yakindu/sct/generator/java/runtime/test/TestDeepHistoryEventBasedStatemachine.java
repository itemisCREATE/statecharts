package org.yakindu.sct.generator.java.runtime.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.runtime.java.test_deephistory.Test_DeepHistoryCycleBasedStatemachine.State;
import org.yakindu.sct.runtime.java.test_deephistory.Test_DeepHistoryEventBasedStatemachine;

public class TestDeepHistoryEventBasedStatemachine {

	private Test_DeepHistoryEventBasedStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new Test_DeepHistoryEventBasedStatemachine();
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
		statemachine.raiseEvent3();
		statemachine.raiseEvent5();
		statemachine.raiseEvent7();
		assertFalse(statemachine.isStateActive(State.State1));
		assertTrue(statemachine.isStateActive(State.State9));

		// Leave State2. State4 and State9 should be saved as history.
		statemachine.raiseEvent2();
		assertTrue(statemachine.isStateActive(State.State1));
		assertFalse(statemachine.isStateActive(State.State9));

		// Reenter State2. State9 should be activated (History of State2).
		statemachine.raiseEvent1();
		assertFalse(statemachine.isStateActive(State.State1));
		assertTrue(statemachine.isStateActive(State.State9));
	}
}
