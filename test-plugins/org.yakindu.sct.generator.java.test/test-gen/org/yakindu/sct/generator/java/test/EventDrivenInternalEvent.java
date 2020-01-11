/** Generated by YAKINDU Statechart Tools code generator. */

package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.eventdriveninternalevent.EventDrivenInternalEventStatemachine;
import org.yakindu.scr.eventdriveninternalevent.EventDrivenInternalEventStatemachine.State;	

/**
 * Unit TestCase for EventDrivenInternalEvent
 */
@SuppressWarnings("all")
public class EventDrivenInternalEvent {
	
	private EventDrivenInternalEventStatemachine statemachine;	
	
	
	@Before
	public void eventDrivenInternalEvent_setUp() {
		statemachine = new EventDrivenInternalEventStatemachine();
		
		statemachine.init();
		
	}

	@After
	public void eventDrivenInternalEvent_tearDown() {
		statemachine = null;
		
	}
	
	@Test
	public void checkInternlEventQueueing() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.eventDrivenInternalEvent_r1_A));
		assertTrue(statemachine.isStateActive(State.eventDrivenInternalEvent_r2_C));
		assertTrue(statemachine.isStateActive(State.eventDrivenInternalEvent_check_VALID));
		statemachine.getSCInterface().raiseStart();
		assertTrue(statemachine.isStateActive(State.eventDrivenInternalEvent_r1_B));
		assertTrue(statemachine.isStateActive(State.eventDrivenInternalEvent_r2_D));
		assertTrue(statemachine.isStateActive(State.eventDrivenInternalEvent_check_VALID));
		assertTrue(statemachine.getI1_sequence() == 2l);
		assertTrue(statemachine.getI2_sequence() == 3l);
		statemachine.exit();
	}
}
