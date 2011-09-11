package org.yakindu.sct.simulation.runtime.sgraph;

/**
 * Representation of a Pseudostate.
 */
public class RTPseudostate extends RTNode {

	PseudostateKind kind;

	public RTPseudostate(String id, RTRegion owningRegion, PseudostateKind kind) {
		super(id, owningRegion);
		this.kind = kind;
	}

	public PseudostateKind getKind() {
		return kind;
	}

	protected void enter() {
		if (kind == PseudostateKind.INITIAL) {
			// go directly into the next state (special transition needs no
			// event
			outgoingTransitions.get(0).take();
		} else if (kind == PseudostateKind.SHALLOWHISTORY
				|| kind == PseudostateKind.DEEPHISTORY) {
			// if this is the first time we enter this state, prolong the
			// default transition, else reenter the region
			if (owningRegion.getCurrentState() == null) {
				outgoingTransitions.get(0).take();
			} else {
				owningRegion.reenter(kind == PseudostateKind.SHALLOWHISTORY
						? HistoryMode.SHALLOW
						: HistoryMode.DEEP);
			}
		} else if (kind == PseudostateKind.CHOICE) {
			// choose the first outgoing transition that can be taken and take it
			getEnabledOutgoingTransitionOfHighestPriority().take();
		} else if (kind == PseudostateKind.JUNCTION) {
			// just take the single outgoing transition to the next state
			outgoingTransitions.get(0).take();
		} else {
			throw new IllegalArgumentException("UNSUPPORTED Pseudostate Kind");
		}

	}

	protected void leave() {

		// do nothing by default

	}

}
