
package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.triggerguardexpressions.TriggerGuardExpressionsStatemachine;
import org.yakindu.scr.triggerguardexpressions.TriggerGuardExpressionsStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for TriggerGuardExpressions
 */
@SuppressWarnings("all")
public class TriggerGuardExpressions {
	
	private TriggerGuardExpressionsStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void triggerGuardExpressions_setUp() {
		statemachine = new TriggerGuardExpressionsStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		
		statemachine.init();
		
	}

	@After
	public void triggerGuardExpressions_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void trueGuard() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.getSCInterface().raiseE1();
		statemachine.getSCInterface().setB(true);
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_B));
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.getSCInterface().raiseE2();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_B));
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.getSCInterface().raiseE1();
		statemachine.getSCInterface().raiseE2();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_B));
	}
	
	@Test
	public void falseGuard() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.getSCInterface().setB(false);
		statemachine.getSCInterface().raiseE1();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.getSCInterface().raiseE2();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_A));
		statemachine.getSCInterface().raiseE1();
		statemachine.getSCInterface().raiseE2();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_A));
	}
}
