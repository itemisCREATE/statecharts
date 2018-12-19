
package org.yakindu.sct.generator.java.test;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.hamcrest.CoreMatchers.*;
import org.yakindu.scr.raiseevent.IRaiseEventStatemachine.*;	
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.raiseevent.RaiseEventStatemachine;
import org.yakindu.scr.raiseevent.RaiseEventStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for RaiseEvent
 */
@SuppressWarnings("all")
public class RaiseEvent {
	
	private RaiseEventStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void raiseEvent_setUp() {
		statemachine = new RaiseEventStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		
		statemachine.init();
		
	}

	@After
	public void raiseEvent_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void raiseEvent() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.second_region_SateA));
		assertTrue(statemachine.isStateActive(State.main_region_StateA));
		statemachine.getSCInterface().raiseE2();
		timer.cycleLeap(1);
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.second_region_StateB));
		assertTrue(statemachine.isStateActive(State.main_region_StateB));
	}
}
