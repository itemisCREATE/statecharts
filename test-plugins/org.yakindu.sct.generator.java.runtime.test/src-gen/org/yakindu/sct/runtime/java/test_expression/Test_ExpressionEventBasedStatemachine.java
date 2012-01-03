/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.test_expression;

import java.util.LinkedList;

import org.yakindu.sct.runtime.java.Event;

public class Test_ExpressionEventBasedStatemachine
		extends
			Test_ExpressionCycleBasedStatemachine {

	private LinkedList<Event<? extends Enum<?>>> eventQueue;

	public Test_ExpressionEventBasedStatemachine() {
		eventQueue = new LinkedList<Event<? extends Enum<?>>>();
	}

	@Override
	protected LinkedList<Event<? extends Enum<?>>> getOccuredEvents() {
		return eventQueue;
	}

	@Override
	protected boolean eventOccured() {
		return !eventQueue.isEmpty();
	}

	@Override
	public void runCycle() {
		if (eventOccured()) {
			Event<? extends Enum<?>> event = getOccuredEvents().poll();
			super.getOccuredEvents().add(event);
			super.runCycle();
		}
	}
}
