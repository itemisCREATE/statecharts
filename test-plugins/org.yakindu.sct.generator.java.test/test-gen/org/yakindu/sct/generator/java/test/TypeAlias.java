
package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.typealias.TypeAliasStatemachine;
import org.yakindu.scr.typealias.TypeAliasStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for TypeAlias
 */
@SuppressWarnings("all")
public class TypeAlias {
	
	private TypeAliasStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void typeAlias_setUp() {
		statemachine = new TypeAliasStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		
		statemachine.init();
		
	}

	@After
	public void typeAlias_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void typeAliasTest() {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.main_region_Start));
		assertTrue(statemachine.getMyVar() == 1l);
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_Mid));
		assertTrue(statemachine.getMyString().equals("TypeSystem"));
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_Mid2));
		statemachine.getSCInterface().raiseMyEvent();
		timer.cycleLeap(1);
		assertTrue(statemachine.isStateActive(State.main_region_End));
	}
}
