
package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.namedinterfaceaccess.NamedInterfaceAccessStatemachine;
import org.yakindu.scr.namedinterfaceaccess.NamedInterfaceAccessStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for NamedInterfaceAccess
 */
@SuppressWarnings("all")
public class NamedInterfaceAccess {
	
	private NamedInterfaceAccessStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void namedInterfaceAccess_setUp() {
		statemachine = new NamedInterfaceAccessStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		
		statemachine.init();
		
	}

	@After
	public void namedInterfaceAccess_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void safeOpenSuccess() {
		statemachine.enter();
		timer.cycleLeap(1);
		statemachine.getSCIUser().raiseNumberPressed(3l);
		timer.cycleLeap(1);
		statemachine.getSCIUser().raiseNumberPressed(7l);
		timer.cycleLeap(1);
		statemachine.getSCIUser().raiseNumberPressed(5l);
		timer.cycleLeap(1);
		assertTrue(statemachine.getSCISafe().isRaisedOpen());
	}
}
