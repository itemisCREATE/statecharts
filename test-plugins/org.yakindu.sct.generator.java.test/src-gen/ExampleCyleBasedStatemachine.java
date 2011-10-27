
package org.yakindu.sct.runtime.java.custom;

import java.util.Collection;
import java.util.EnumSet;
import java.util.Set;

public class ExampleCyleBasedStatemachine extends ExampleAbstractBaseStatemachine {

	private Set<Event> occuredEvents = EnumSet.noneOf(Event.class);

	@Override
	protected Collection<Event> getOccuredEvents() {
		return occuredEvents;
	}

	public void runCycle() {
		if (eventOccured()) {
			runCycle(occuredEvents);
			// remove all events
			occuredEvents.clear();
		}
	}
}

