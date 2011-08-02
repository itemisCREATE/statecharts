package org.yakindu.sct.simulation.runtime.sgraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Representation of a node (which is the abstract super concept of State and
 * Pseudostate). A node may have incoming and outgoing transitions. As the
 * statechart may only reside "in" states, pseudostates will normally directly
 * trigger an outgoing transition when being entered.
 */
public abstract class RTNode {

	private String id;
	protected RTRegion owningRegion;

	protected List<RTTransition> incomingTransitions = new ArrayList<RTTransition>();
	protected List<RTTransition> outgoingTransitions = new ArrayList<RTTransition>();

	public RTNode(String id, RTRegion owner) {
		this.id = id;
		this.owningRegion = owner;
		this.owningRegion.getNodes().add(this);
	}

	public String getId() {
		return id;
	}

	protected RTRegion getOwningRegion() {
		return owningRegion;
	}

	public List<RTTransition> getIncomingTransitions() {
		return incomingTransitions;
	}

	public List<RTTransition> getOutgoingTransitions() {
		return outgoingTransitions;
	}

	protected RTTransition getEnabledOutgoingTransitionOfHighestPriority() {

		Set<RTEvent> s = Collections.emptySet();
		for (RTTransition transition : outgoingTransitions) {
			
			if (transition.isTriggeredBy(s)) {
				return transition;
			}
		}
		return null;

	}

	protected abstract void enter();

	protected abstract void leave();

}
