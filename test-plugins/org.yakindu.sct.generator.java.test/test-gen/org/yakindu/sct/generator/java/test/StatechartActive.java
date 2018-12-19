
package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.statechartactive.StatechartActiveStatemachine;
import org.yakindu.scr.statechartactive.StatechartActiveStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for StatechartActive
 */
@SuppressWarnings("all")
public class StatechartActive {
	
	private StatechartActiveStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void statechartActive_setUp() {
		statemachine = new StatechartActiveStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		
		statemachine.init();
		
	}

	@After
	public void statechartActive_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void inactiveBeforeEnter() {
		assertTrue(!statemachine.isActive());
	}
	
	@Test
	public void activeAfterEnter() {
		statemachine.enter();
		assertTrue(statemachine.isActive());
	}
	
	@Test
	public void inactiveAfterExit() {
		statemachine.enter();
		statemachine.exit();
		assertTrue(!statemachine.isActive());
	}
	
	@Test
	public void activeAfterReenter() {
		statemachine.enter();
		statemachine.exit();
		statemachine.enter();
		assertTrue(statemachine.isActive());
	}
}
