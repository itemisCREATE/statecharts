
package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.ineventlifecycle.InEventLifeCycleStatemachine;
import org.yakindu.scr.ineventlifecycle.InEventLifeCycleStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for InEventLifeCycle
 */
@SuppressWarnings("all")
public class InEventLifeCycle {
	
	private InEventLifeCycleStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void inEventLifeCycle_setUp() {
		statemachine = new InEventLifeCycleStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		
		statemachine.init();
		
	}

	@After
	public void inEventLifeCycle_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void eventLifeCycle() {
		statemachine.enter();
		statemachine.getSCInterface().raiseE();
		assertTrue(statemachine.getI() == 0l);
		timer.cycleLeap(1);
		assertTrue(statemachine.getI() == 1l);
	}
}
