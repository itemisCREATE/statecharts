
package org.yakindu.sct.generator.java.test;

import static org.mockito.Mockito.*;
import static org.mockito.Matchers.*;
import static org.hamcrest.CoreMatchers.*;
import org.yakindu.scr.syncjoin.ISyncJoinStatemachine.*;	
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.syncjoin.SyncJoinStatemachine;
import org.yakindu.scr.syncjoin.SyncJoinStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for SyncJoin
 */
@SuppressWarnings("all")
public class SyncJoin {
	
	private SyncJoinStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void syncJoin_setUp() {
		statemachine = new SyncJoinStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		
		statemachine.init();
		
	}

	@After
	public void syncJoin_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void syncJoin_C2_Waits() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_B));
		assertTrue(statemachine.isStateActive(State.main_region_B_r1_C1));
		assertTrue(statemachine.isStateActive(State.main_region_B_r2_D1));
		statemachine.getSCInterface().raiseE();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_B_r1_C2));
		assertTrue(statemachine.isStateActive(State.main_region_B_r2_D1));
		statemachine.getSCInterface().raiseJc();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_B_r1_C2));
		assertTrue(statemachine.isStateActive(State.main_region_B_r2_D1));
		statemachine.getSCInterface().raiseJd();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_B_r1_C2));
		assertTrue(statemachine.isStateActive(State.main_region_B_r2_D1));
		statemachine.getSCInterface().raiseJc();
		statemachine.getSCInterface().raiseJd();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_B_r1_C2));
		assertTrue(statemachine.isStateActive(State.main_region_B_r2_D1));
		statemachine.getSCInterface().raiseF();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_B_r1_C2));
		assertTrue(statemachine.isStateActive(State.main_region_B_r2_D2));
		statemachine.getSCInterface().raiseJc();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_B_r1_C2));
		assertTrue(statemachine.isStateActive(State.main_region_B_r2_D2));
		statemachine.getSCInterface().raiseJd();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_B_r1_C2));
		assertTrue(statemachine.isStateActive(State.main_region_B_r2_D2));
		statemachine.getSCInterface().raiseJc();
		statemachine.getSCInterface().raiseJd();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_A));
	}
	
	@Test
	public void syncJoin_D2_Waits() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_B));
		assertTrue(statemachine.isStateActive(State.main_region_B_r1_C1));
		assertTrue(statemachine.isStateActive(State.main_region_B_r2_D1));
		statemachine.getSCInterface().raiseF();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_B_r1_C1));
		assertTrue(statemachine.isStateActive(State.main_region_B_r2_D2));
		statemachine.getSCInterface().raiseJc();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_B_r1_C1));
		assertTrue(statemachine.isStateActive(State.main_region_B_r2_D2));
		statemachine.getSCInterface().raiseJd();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_B_r1_C1));
		assertTrue(statemachine.isStateActive(State.main_region_B_r2_D2));
		statemachine.getSCInterface().raiseJc();
		statemachine.getSCInterface().raiseJd();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_B_r1_C1));
		assertTrue(statemachine.isStateActive(State.main_region_B_r2_D2));
		statemachine.getSCInterface().raiseE();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_B_r1_C2));
		assertTrue(statemachine.isStateActive(State.main_region_B_r2_D2));
	}
	
	@Test
	public void doubleEntryActionBug() {
		statemachine.enter();
		statemachine.getSCInterface().raiseE();
		statemachine.getSCInterface().raiseF();
		timer.cycleLeap(1);
		statemachine.getSCInterface().raiseJc();
		statemachine.getSCInterface().raiseJd();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_A));
		assertTrue(statemachine.getX() == 1l);
	}
}
