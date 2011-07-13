package org.yakindu.sct.simulation.runtime.sgraph;

import java.util.Set;

/**
 * Representation of a simple state without nested regions. A simple state may
 * specify a do action, which is executed when the statechart resides "in" this
 * state.
 */
public class SimpleState extends State {

	private Action doAction;

	public SimpleState(String id, String name, Region owningRegion,
			Action entryAction, Action doAction, Action exitAction) {
		super(id, name, owningRegion, entryAction, exitAction);
		this.doAction = doAction;
	}

	protected void reactLocallyOn(Set<Event> events) {

		if (doAction != null) {
			doAction.execute();
		}

	}

	public Action getDoAction() {
		return doAction;
	}

}
