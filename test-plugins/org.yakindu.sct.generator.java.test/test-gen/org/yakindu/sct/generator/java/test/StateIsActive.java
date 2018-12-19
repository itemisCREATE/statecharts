
package org.yakindu.sct.generator.java.test;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.hamcrest.CoreMatchers.*;
import org.yakindu.scr.stateisactive.IStateIsActiveStatemachine.*;	
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.stateisactive.StateIsActiveStatemachine;
import org.yakindu.scr.stateisactive.StateIsActiveStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for StateIsActive
 */
@SuppressWarnings("all")
public class StateIsActive {
	
	private StateIsActiveStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void stateIsActive_setUp() {
		statemachine = new StateIsActiveStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		
		statemachine.init();
		
	}

	@After
	public void stateIsActive_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void stateIsActive() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.r1_R1A));
		assertTrue(statemachine.isStateActive(State.r2_R2A));
		statemachine.getSCInterface().raiseEvent1();
		timer.cycleLeap(1);
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.r1_R1B));
		assertTrue(statemachine.isStateActive(State.r2_R2B));
	}
}
