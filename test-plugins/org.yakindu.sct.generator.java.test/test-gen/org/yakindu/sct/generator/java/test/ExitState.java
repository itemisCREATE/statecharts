
package org.yakindu.sct.generator.java.test;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.hamcrest.CoreMatchers.*;
import org.yakindu.scr.exitstate.IExitStateStatemachine.*;	
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.exitstate.ExitStateStatemachine;
import org.yakindu.scr.exitstate.ExitStateStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for ExitState
 */
@SuppressWarnings("all")
public class ExitState {
	
	private ExitStateStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void exitState_setUp() {
		statemachine = new ExitStateStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		
		statemachine.init();
		
	}

	@After
	public void exitState_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void defaultExit() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.r_A));
		statemachine.getSCInterface().raiseE();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.r_E));
	}
	
	@Test
	public void namedExitThroughNamedTransition() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.r_A));
		statemachine.getSCInterface().raiseF();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.r_F));
	}
	
	@Test
	public void namedExitThroughDefaultTransition() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.r_A));
		statemachine.getSCInterface().raiseG();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.r_E));
	}
	
	@Test
	public void remainInA() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.r_A));
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.r_A));
	}
}
