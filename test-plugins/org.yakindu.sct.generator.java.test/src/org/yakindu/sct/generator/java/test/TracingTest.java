package org.yakindu.sct.generator.java.test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.yakindu.scr.tracing.TracingImpl;
import org.yakindu.scr.tracing.TracingStatemachine;
import org.yakindu.scr.tracing.TracingStatemachine.State;

public class TracingTest {
	@Test
	public void testTracing() {
		TracingStatemachine sm = new TracingStatemachine();
		TracingImpl<State> ifaceTraceObserver = new TracingImpl<State>();
		sm.addIfaceTraceObserver(ifaceTraceObserver);
		sm.init();
		sm.enter();
		assertTrue(ifaceTraceObserver.isEntered());
		sm.runCycle();
		assertTrue(ifaceTraceObserver.isExited());
		assertTrue(sm.isFinal());
	}
}
