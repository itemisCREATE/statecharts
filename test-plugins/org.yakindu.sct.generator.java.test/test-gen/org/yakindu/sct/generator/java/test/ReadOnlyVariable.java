
package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.readonlyvariable.ReadOnlyVariableStatemachine;
import org.yakindu.scr.readonlyvariable.ReadOnlyVariableStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for ReadOnlyVariable
 */
@SuppressWarnings("all")
public class ReadOnlyVariable {
	
	private ReadOnlyVariableStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void readOnlyVariable_setUp() {
		statemachine = new ReadOnlyVariableStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		
		statemachine.init();
		
	}

	@After
	public void readOnlyVariable_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void readOnlyVariableTest() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_StateA));
		assertTrue(statemachine.getMyInt() == 0l);
		assertTrue(statemachine.getMyString().equals("testString"));
		assertTrue(statemachine.getMyBool() == true);
		assertTrue(statemachine.getMyReal() == 1.1);
		assertTrue(statemachine.getSCIA().getMyInt() == 0l);
		assertTrue(statemachine.getSCIA().getMyString().equals("testString"));
		assertTrue(statemachine.getSCIA().getMyBool() == true);
		assertTrue(statemachine.getSCIA().getMyReal() == 1.1);
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_StateB));
		assertTrue(statemachine.getMyInt() == 100l);
		assertTrue(statemachine.getMyString().equals("fail"));
		assertTrue(statemachine.getMyBool() == false);
		assertTrue(statemachine.getMyReal() == 6.6);
		assertTrue(statemachine.getSCIA().getMyInt() == 200l);
		assertTrue(statemachine.getSCIA().getMyString().equals("A_fail"));
		assertTrue(statemachine.getSCIA().getMyBool() == false);
		assertTrue(statemachine.getSCIA().getMyReal() == 7.7);
	}
}
