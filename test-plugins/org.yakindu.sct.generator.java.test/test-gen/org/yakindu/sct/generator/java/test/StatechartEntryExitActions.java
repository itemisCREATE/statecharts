
package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.statechartentryandexitactions.StatechartEntryAndExitActionsStatemachine;
import org.yakindu.scr.statechartentryandexitactions.StatechartEntryAndExitActionsStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for StatechartEntryAndExitActions
 */
@SuppressWarnings("all")
public class StatechartEntryExitActions {
	
	private StatechartEntryAndExitActionsStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void statechartEntryExitActions_setUp() {
		statemachine = new StatechartEntryAndExitActionsStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		
		statemachine.init();
		
	}

	@After
	public void statechartEntryExitActions_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void entryActionsAreExecutedOnEnteringStatechart() {
		assertTrue(statemachine.getX() == 0l);
		assertTrue(statemachine.getY() == 0l);
		statemachine.getSCInterface().setB(true);
		statemachine.enter();
		assertTrue(statemachine.getX() == 5l);
		assertTrue(statemachine.getY() == 3l);
	}
	
	public void entryActionsAreExecutedOnEnteringStatechartOnlyIfGuardIsTrue() {
		assertTrue(statemachine.getX() == 0l);
		assertTrue(statemachine.getY() == 0l);
		statemachine.getSCInterface().setB(false);
		statemachine.enter();
		assertTrue(statemachine.getX() == 2l);
		assertTrue(statemachine.getY() == 3l);
	}
	
	@Test
	public void exitActionsAreExecutedOnEnteringStatechart() {
		statemachine.enter();
		statemachine.exit();
		assertTrue(statemachine.getX() == 6l);
		assertTrue(statemachine.getY() == 2l);
	}
	
	public void exitActionsAreExecutedOnEnteringStatechartOnlyIfGuardIsTrue() {
		statemachine.enter();
		statemachine.exit();
		assertTrue(statemachine.getX() == 8l);
		assertTrue(statemachine.getY() == 2l);
	}
}
