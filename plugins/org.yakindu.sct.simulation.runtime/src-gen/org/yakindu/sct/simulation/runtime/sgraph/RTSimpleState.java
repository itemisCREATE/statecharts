package org.yakindu.sct.simulation.runtime.sgraph;

import java.util.Set;

/**
 * Representation of a simple state without nested regions. A simple state may
 * specify a do action, which is executed when the statechart resides "in" this
 * state.
 */
public class RTSimpleState extends RTState {

	private RTAction doAction;

	public RTSimpleState(String id, String name, RTRegion owningRegion,
			RTAction entryAction, RTAction doAction, RTAction exitAction) {
		super(id, name, owningRegion, entryAction, exitAction);
		this.doAction = doAction;
	}

	protected void reactLocallyOn(Set<RTEvent> events) {
		performLocalReactions(events);
	}

	public RTAction getDoAction() {
		return doAction;
	}
 
}
