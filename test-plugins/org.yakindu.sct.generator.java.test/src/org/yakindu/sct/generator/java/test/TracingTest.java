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
		TracingImpl<State> ifaceTraceObserver1 = new TracingImpl<State>();
		TracingImpl<State> ifaceTraceObserver2 = new TracingImpl<State>();
		TracingImpl<State> ifaceTraceObserver3 = new TracingImpl<State>();
		sm.addIfaceTraceObserver(ifaceTraceObserver1);
		sm.addIfaceTraceObserver(ifaceTraceObserver2);
		sm.addIfaceTraceObserver(ifaceTraceObserver3);
		sm.init();
		sm.enter();
		assertTrue(ifaceTraceObserver1.isEntered());
		assertTrue(ifaceTraceObserver2.isEntered());
		assertTrue(ifaceTraceObserver3.isEntered());
		sm.removeIfaceTraceObserver(ifaceTraceObserver2);
		sm.runCycle();
		assertTrue(ifaceTraceObserver1.isExited());
		assertTrue(ifaceTraceObserver3.isExited());
		assertTrue(sm.isFinal());
	}
}
