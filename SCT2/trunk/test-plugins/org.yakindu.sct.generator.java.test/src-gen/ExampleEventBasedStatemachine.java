
package org.yakindu.sct.runtime.java.custom;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

public class ExampleEventBasedStatemachine extends ExampleAbstractBaseStatemachine {

	private Queue<Event> eventQueue = new LinkedList<Event>();
	
	@Override
	protected Collection<Event> getOccuredEvents() {
		return eventQueue;
	}
	
	@Override
	public void runCycle() {
		if (eventOccured()) {
			Event event = eventQueue.poll();
			runCycle(Collections.singletonList(event));
		}
	}
}

