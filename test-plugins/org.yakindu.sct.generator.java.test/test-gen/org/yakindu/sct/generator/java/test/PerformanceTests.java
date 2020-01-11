/** Generated by YAKINDU Statechart Tools code generator. */

package org.yakindu.sct.generator.java.test;

import org.junit.*;
import static org.junit.Assert.*;
import org.yakindu.scr.performancetest.PerformanceTestStatemachine;
import org.yakindu.scr.performancetest.PerformanceTestStatemachine.State;	
import org.yakindu.scr.VirtualTimer;
import org.yakindu.scr.VirtualTimer.VirtualTimeTask;
import org.yakindu.scr.VirtualTimer.CycleTimeEventTask;

/**
 * Unit TestCase for PerformanceTest
 */
@SuppressWarnings("all")
public class PerformanceTests {
	
	private PerformanceTestStatemachine statemachine;	
	private VirtualTimer timer;
	
	
	@Before
	public void performanceTests_setUp() {
		statemachine = new PerformanceTestStatemachine();
		timer = new VirtualTimer(200);
		timer.schedulePeriodicalTask(new CycleTimeEventTask(statemachine), 200, 200);
		statemachine.setTimer(timer);
		
		statemachine.init();
		
	}

	@After
	public void performanceTests_tearDown() {
		statemachine = null;
		
		timer = null;
	}
	
	@Test
	public void test_100_000() {
		performance(100000l);
	}
	
	@Test
	public void test_1_000_000() {
		performance(1000000l);
	}
	
	@Test
	public void test_10_000_000() {
		performance(10000000l);
	}
	
	public void performance(long perf) {
		statemachine.enter();
		assertTrue(statemachine.isStateActive(State.mr_A));
		while (statemachine.getC() < perf) {
			if (statemachine.isStateActive(State.mr_A)) {
				statemachine.raiseE1();
			}
			else {
				if (statemachine.getC()%2l == 0l) {
					statemachine.raiseE2();
				}
				else {
					statemachine.raiseE3();
				}
			}
			timer.cycleLeap(1l);
		}
		assertTrue(statemachine.getA() > 2l);
	}
}
