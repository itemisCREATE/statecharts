
package org.yakindu.sct.generator.java.test;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.hamcrest.CoreMatchers.*;
import org.yakindu.scr.transitionwithoutcondition.ITransitionWithoutConditionStatemachine.*;	
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.transitionwithoutcondition.TransitionWithoutConditionStatemachine;
import org.yakindu.scr.transitionwithoutcondition.TransitionWithoutConditionStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for TransitionWithoutCondition
 */
@SuppressWarnings("all")
public class TransitionWithoutCondition {
	
	private TransitionWithoutConditionStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void transitionWithoutCondition_setUp() {
		statemachine = new TransitionWithoutConditionStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		
		statemachine.init();
		
	}

	@After
	public void transitionWithoutCondition_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void transitionWithoutConditionTest() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_B));
	}
}
