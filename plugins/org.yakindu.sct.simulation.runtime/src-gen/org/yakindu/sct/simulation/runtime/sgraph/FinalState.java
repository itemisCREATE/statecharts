package org.yakindu.sct.simulation.runtime.sgraph;

import java.util.Set;

/**
 * Representation of a final state. A final state is some sort of event sink, i.e.
 * it does not react on any events, and it further has to entry, do, or exit action.
 */
public class FinalState extends State {

	public FinalState(String id, Region owningRegion) {
		super(id, "FINAL", owningRegion, null, null);
	}

	protected void enter() {
		// only notify the containing region that we are the current state
		owningRegion.setCurrentState(this);
	}

	protected void reactOn(Set<Event> events) {
		// do nothing, just ignore all events 
	}

	protected void reactLocallyOn(Set<Event> events) {
		// never called, as reactOn is overwritten as well
	}

	protected void leave() {
		// do nothing, just ignore
	}
}
