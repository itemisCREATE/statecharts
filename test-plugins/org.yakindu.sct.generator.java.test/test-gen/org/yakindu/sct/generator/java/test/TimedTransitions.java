/** Generated by YAKINDU Statechart Tools code generator. */

package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.timedtransitions.TimedTransitionsStatemachine;
import org.yakindu.scr.timedtransitions.TimedTransitionsStatemachine.State;
import org.yakindu.sct.VirtualTimer;
import org.yakindu.sct.VirtualTimer.VirtualTimeTask;
import org.yakindu.sct.VirtualTimer.CycleTimeEventTask;

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
		assertTrue(statemachine.isStateActive(TimedTransitionsStatemachine.State.MAIN_REGION_START));
		timer.timeLeap(2030l);
		timer.cycleLeap(1l);
		assertTrue(statemachine.isStateActive(TimedTransitionsStatemachine.State.MAIN_REGION_END));
	}
	
	@Test
	public void timer02() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(TimedTransitionsStatemachine.State.MAIN_REGION_START));
		timer.timeLeap(2l*1000l);
		assertTrue(statemachine.isStateActive(TimedTransitionsStatemachine.State.MAIN_REGION_END));
	}
	
	@Test
	public void noAdditionalCycle() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(TimedTransitionsStatemachine.State.MAIN_REGION_START));
		timer.timeLeap(1950l);
		assertTrue(statemachine.isStateActive(TimedTransitionsStatemachine.State.MAIN_REGION_START));
		timer.timeLeap(100l);
		assertTrue(statemachine.isStateActive(TimedTransitionsStatemachine.State.MAIN_REGION_END));
	}
	
	@Test
	public void countCycles() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(TimedTransitionsStatemachine.State.MAIN_REGION_START));
		assertTrue((statemachine.getCycles() == 0l));
		assertTrue((statemachine.getSeconds() == 0l));
		timer.timeLeap(100l);
		assertTrue((statemachine.getCycles() == 0l));
		assertTrue((statemachine.getSeconds() == 0l));
		timer.timeLeap(100l);
		assertTrue((statemachine.getCycles() == 1l));
		assertTrue((statemachine.getSeconds() == 0l));
		timer.timeLeap(800l);
		assertTrue((statemachine.getCycles() == 5l));
		assertTrue((statemachine.getSeconds() == 1l));
	}
}
