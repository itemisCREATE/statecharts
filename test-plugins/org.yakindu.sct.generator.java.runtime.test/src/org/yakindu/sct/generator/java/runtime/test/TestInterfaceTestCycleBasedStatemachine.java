package org.yakindu.sct.generator.java.runtime.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.yakindu.sct.runtime.java.interfacetest.InterfaceTestAbstractBaseStatemachine.State;
import org.yakindu.sct.runtime.java.interfacetest.InterfaceTestCyleBasedStatemachine;

public class TestInterfaceTestCycleBasedStatemachine {

	private InterfaceTestCyleBasedStatemachine statemachine;

	@Before
	public void setUp() {
		statemachine = new InterfaceTestCyleBasedStatemachine();
		statemachine.entry();
	}

	@After
	public void tearDown() {
		statemachine = null;
	}

	@Test
	public void testStatemachineInitialisation() {
		setUp();
		assertEquals("InterfaceDefault.Var2 is not correct initialized:", 2.3,
				statemachine.getInterfaceDefault().getVarVar2(),
				Math.pow(10, -8));
		assertEquals("InterfaceDefault.Var3 is not correct initialized:", 1,
				statemachine.getInterfaceDefault().getVarVar3());
		assertTrue("Statemachine isn't in State: " + State.State1.name() + ".",
				statemachine.getActiveStates().contains(State.State1));
		assertEquals("More than one state is active.", 1, statemachine
				.getActiveStates().size());
		tearDown();
	}

	@Test
	public void testStatemachineRunCycle_1() {
		setUp();
		statemachine.getInterfaceDefault().raiseEvent1();
		statemachine.runCycle();
		// Test if state is changed to State2
		assertTrue("Statemachine isn't in State: " + State.State2.name() + ".",
				statemachine.getActiveStates().contains(State.State2));
		// Test if only one state is active
		assertEquals("More than one state is active.", 1, statemachine
				.getActiveStates().size());
		// Test if event2 is raised (happens in entry of State2
		assertTrue("Event not raised: ", statemachine.getInterfaceDefault()
				.isRaisedEvent2());
		// Test if event2 value is set to 22 (happens in entry of State2
		assertEquals("Event 2 value not set correct: ", 22, statemachine
				.getInterfaceDefault().getEventEvent2().getValue().intValue());

		statemachine.getInterfaceDefault().raiseEvent1();
		statemachine.runCycle();
		// Test if statemachine is back in State 1
		assertTrue("Statemachine isn't in State: " + State.State1.name() + ".",
				statemachine.getActiveStates().contains(State.State1));
		// Test if only one state is active
		assertEquals("More than one state is active.", 1, statemachine
				.getActiveStates().size());
		// Event 2 shouldn't be raised anymore
		assertFalse("Event is still raised: ", statemachine
				.getInterfaceDefault().isRaisedEvent2());
		tearDown();
	}

	@Test
	public void testStatemachineRunCycle_2() {
		setUp();
		statemachine.getInterfaceDefault().setVarVar2(-12.6);
		statemachine.getInterfaceDefault().raiseEvent1();
		statemachine.runCycle();
		// Test if statemachine is still in State 1
		assertTrue("Statemachine isn't in State: " + State.State1.name() + ".",
				statemachine.getActiveStates().contains(State.State1));
		// Test if only one state is active
		assertEquals("More than one state is active.", 1, statemachine
				.getActiveStates().size());
		// Event 2 shouldn't be raised
		assertFalse("Event is still raised: ", statemachine
				.getInterfaceDefault().isRaisedEvent2());
		// Event 2 value should not be set to 22
		assertTrue("Event value is set to 22: ", statemachine
				.getInterfaceDefault().getEventEvent2().getValue() != 22);

		statemachine.getInterfaceDefault().raiseEvent1();
		statemachine.getInterfaceDefault().setVarVar2(213.55);
		statemachine.runCycle();
		// Test if state is changed to State2
		assertTrue("Statemachine isn't in State: " + State.State2.name() + ".",
				statemachine.getActiveStates().contains(State.State2));
		// Test if only one state is active
		assertEquals("More than one state is active.", 1, statemachine
				.getActiveStates().size());
		// Test if event2 is raised (happens in entry of State2
		assertTrue("Event not raised: ", statemachine.getInterfaceDefault()
				.isRaisedEvent2());
		// Test if event2 value is set to 22 (happens in entry of State2
		assertEquals("Event 2 value not set correct: ", 22, statemachine
				.getInterfaceDefault().getEventEvent2().getValue().intValue());

		tearDown();
	}

	@Test
	public void testStatemachineRunCycle_3() {
		setUp();
		statemachine.getInterfaceOther().raiseEvent3();
		statemachine.runCycle();
		// Test if state is changed to State3
		assertTrue("Statemachine isn't in State: " + State.State3.name() + ".",
				statemachine.getActiveStates().contains(State.State3));
		// Test if only one state is active
		assertEquals("More than one state is active.", 1, statemachine
				.getActiveStates().size());
		// Test if event4 is raised (happens in entry of State3
		assertTrue("Event not raised: ", statemachine.getInterfaceOther()
				.isRaisedEvent4());

		statemachine.getInterfaceOther().raiseEvent3();
		statemachine.runCycle();
		// Test if statemachine is back in State 1
		assertTrue("Statemachine isn't in State: " + State.State1.name() + ".",
				statemachine.getActiveStates().contains(State.State1));
		// Test if only one state is active
		assertEquals("More than one state is active.", 1, statemachine
				.getActiveStates().size());
		// Event 4 shouldn't be raised anymore
		assertFalse("Event is still raised: ", statemachine.getInterfaceOther()
				.isRaisedEvent4());
		tearDown();
	}

	@Test
	public void testStatemachineRunCycle_4() {
		setUp();
		statemachine.getInterfaceDefault().setVarVar3(2);
		statemachine.getInterfaceOther().raiseEvent3();
		statemachine.runCycle();
		// Test if state is changed to State1
		assertTrue("Statemachine isn't in State: " + State.State1.name() + ".",
				statemachine.getActiveStates().contains(State.State1));
		// Test if only one state is active
		assertEquals("More than one state is active.", 1, statemachine
				.getActiveStates().size());
		// Test if event4 is not raised
		assertFalse("Event not raised: ", statemachine.getInterfaceOther()
				.isRaisedEvent4());

		statemachine.getInterfaceOther().raiseEvent3();
		statemachine.getInterfaceDefault().setVarVar3(1);
		statemachine.runCycle();
		// Test if state is changed to State3
		assertTrue("Statemachine isn't in State: " + State.State3.name() + ".",
				statemachine.getActiveStates().contains(State.State3));
		// Test if only one state is active
		assertEquals("More than one state is active.", 1, statemachine
				.getActiveStates().size());
		// Test if event4 is raised (happens in entry of State3
		assertTrue("Event not raised: ", statemachine.getInterfaceOther()
				.isRaisedEvent4());
		tearDown();
	}

	@Test
	public void testStatemachineRunCycle_5() {
		setUp();
		statemachine.getInterfaceDefault().setVarVar1(true);
		statemachine.getInterfaceThird().raiseEvent5();
		statemachine.runCycle();
		// Test if state is changed to State4
		assertTrue("Statemachine isn't in State: " + State.State4.name() + ".",
				statemachine.getActiveStates().contains(State.State4));
		// Test if only one state is active
		assertEquals("More than one state is active.", 1, statemachine
				.getActiveStates().size());
		// Test if event6 is raised
		assertTrue("Event not raised: ", statemachine.getInterfaceThird()
				.isRaisedEvent6());
		// Test if event6 is set to true;
		assertTrue("Event 6 not set: ",statemachine.getInterfaceThird()
				.getEventEvent6().getValue());

		statemachine.getInterfaceThird().raiseEvent5();
		statemachine.runCycle();
		// Test if state is changed to State1
		assertTrue("Statemachine isn't in State: " + State.State1.name() + ".",
				statemachine.getActiveStates().contains(State.State1));
		// Test if only one state is active
		assertEquals("More than one state is active.", 1, statemachine
				.getActiveStates().size());
		// Test if event6 is not raised
		assertFalse("Event raised: ", statemachine.getInterfaceThird()
				.isRaisedEvent6());
		tearDown();
	}
}
