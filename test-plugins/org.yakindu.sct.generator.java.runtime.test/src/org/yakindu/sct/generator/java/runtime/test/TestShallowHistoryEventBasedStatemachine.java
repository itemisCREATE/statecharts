package org.yakindu.sct.generator.java.runtime.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.runtime.java.RuntimeService;
import org.yakindu.sct.runtime.java.test_shallowhistory.DefaultInterface;
import org.yakindu.sct.runtime.java.test_shallowhistory.Test_ShallowHistoryCycleBasedStatemachine.State;
import org.yakindu.sct.runtime.java.test_shallowhistory.Test_ShallowHistoryEventBasedStatemachine;

public class TestShallowHistoryEventBasedStatemachine {

	private Test_ShallowHistoryEventBasedStatemachine statemachine;

	private DefaultInterface dInterface;
	
	private RuntimeService runtimeService;

	// Minimal cycletime
	private final long cyclePeriod = 1;

	@Before
	public void setUp() {
		statemachine = new Test_ShallowHistoryEventBasedStatemachine();
		statemachine.init();
		statemachine.enter();
		dInterface = statemachine.getDefaultInterface();
		runtimeService = new RuntimeService(cyclePeriod);
		runtimeService.addStatemachine(statemachine);
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testShallowHistory() throws InterruptedException {
		// Change active states to State9;
		dInterface.raiseEvent1();
		dInterface.raiseEvent3();
		dInterface.raiseEvent5();
		dInterface.raiseEvent7();
		Thread.sleep(5);
		assertFalse(statemachine.isStateActive(State.State1));
		assertTrue(statemachine.isStateActive(State.State9));

		// Leave State7. State9 should be saved as history.
		dInterface.raiseEvent6();
		Thread.sleep(5);
		assertFalse(statemachine.isStateActive(State.State9));
		assertTrue(statemachine.isStateActive(State.State6));

		// Reenter State7. State9 should be activated because of saved history.
		dInterface.raiseEvent5();
		Thread.sleep(5);
		assertFalse(statemachine.isStateActive(State.State6));
		assertTrue(statemachine.isStateActive(State.State9));

		// Leave State2. State4 and State9 should be saved as history.
		dInterface.raiseEvent2();
		Thread.sleep(5);
		assertFalse(statemachine.isStateActive(State.State9));
		assertTrue(statemachine.isStateActive(State.State1));

		// Reenter State2. State6 should be activated (History of State2).
		dInterface.raiseEvent1();
		Thread.sleep(5);
		assertTrue(statemachine.isStateActive(State.State6));
		assertFalse(statemachine.isStateActive(State.State1));

		// Reenter State7. State9 should be activated (History of State7).
		dInterface.raiseEvent5();
		Thread.sleep(5);
		assertFalse(statemachine.isStateActive(State.State6));
		assertTrue(statemachine.isStateActive(State.State9));
	}
}
