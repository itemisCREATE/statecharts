/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 *
 */
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
		TracingImpl<State> traceObserver1 = new TracingImpl<>();
		TracingImpl<State> traceObserver2 = new TracingImpl<>();
		TracingImpl<State> traceObserver3 = new TracingImpl<>();
		sm.addTraceObserver(traceObserver1);
		sm.addTraceObserver(traceObserver2);
		sm.addTraceObserver(traceObserver3);
		sm.init();
		sm.enter();
		assertTrue(traceObserver1.isEntered());
		assertTrue(traceObserver2.isEntered());
		assertTrue(traceObserver3.isEntered());
		sm.removeTraceObserver(traceObserver2);
		sm.runCycle();
		assertTrue(traceObserver1.isExited());
		assertTrue(traceObserver3.isExited());
		assertTrue(sm.isFinal());
	}
}
