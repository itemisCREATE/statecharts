
package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.timedtransitions.TimedTransitionsStatemachine;
import org.yakindu.scr.timedtransitions.TimedTransitionsStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for TimedTransitions
 */
@SuppressWarnings("all")
public class TimedTransitions {
	
	private TimedTransitionsStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void timedTransitions_setUp() {
		statemachine = new TimedTransitionsStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		statemachine.setTimer(timer);
		
		statemachine.init();
		
	}

	@After
	public void timedTransitions_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void timer01() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_Start));
		timer.timeLeap(2030);
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_End));
	}
}
