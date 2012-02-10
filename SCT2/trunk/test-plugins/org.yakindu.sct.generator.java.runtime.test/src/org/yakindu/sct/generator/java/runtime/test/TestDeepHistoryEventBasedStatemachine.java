package org.yakindu.sct.generator.java.runtime.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.runtime.java.test_deephistory.DefaultInterface;
import org.yakindu.sct.runtime.java.test_deephistory.Test_DeepHistoryCycleBasedStatemachine.State;
import org.yakindu.sct.runtime.java.test_deephistory.Test_DeepHistoryEventBasedStatemachine;

public class TestDeepHistoryEventBasedStatemachine {

	private Test_DeepHistoryEventBasedStatemachine statemachine;

	private DefaultInterface dInterface;

	@Before
	public void setUp() {
		statemachine = new Test_DeepHistoryEventBasedStatemachine();
		statemachine.init();
		statemachine.enter();
		dInterface = statemachine.getDefaultInterface();
		dInterface = statemachine.getDefaultInterface();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testDeepHistory() {
		// Change active states to State9;
		dInterface.raiseEvent1();
		dInterface.raiseEvent3();
		dInterface.raiseEvent5();
		dInterface.raiseEvent7();
		assertFalse(statemachine.isStateActive(State.State1));
		assertTrue(statemachine.isStateActive(State.State9));

		// Leave State2. State4 and State9 should be saved as history.
		dInterface.raiseEvent2();
		assertTrue(statemachine.isStateActive(State.State1));
		assertFalse(statemachine.isStateActive(State.State9));

		// Reenter State2. State9 should be activated (History of State2).
		dInterface.raiseEvent1();
		assertFalse(statemachine.isStateActive(State.State1));
		assertTrue(statemachine.isStateActive(State.State9));
	}
}
