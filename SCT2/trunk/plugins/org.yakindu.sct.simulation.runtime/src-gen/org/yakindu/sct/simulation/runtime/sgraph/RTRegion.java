package org.yakindu.sct.simulation.runtime.sgraph;

import java.util.HashSet;
import java.util.Set;

public class RTRegion {

	private String id;
	private int priority;
	private AbstractStatechart owningStatechart;
	private RTCompoundState owningState;

	private Set<RTNode> nodes = new HashSet<RTNode>();

	protected RTState currentState;

	public RTRegion(String id, int priority, AbstractStatechart owner) {
		this.id = id;
		this.priority = priority;
		this.owningStatechart = owner;
		this.owningStatechart.getRegions().add(this);
	}

	public RTRegion(String id, int priority, RTCompoundState owner) {
		this.id = id;
		this.priority = priority;
		this.owningState = owner;
		this.owningState.getRegions().add(this);
	}

	/** Returns the id of the region.
	 */
	public String getId() {
		return id;
	}

	/** Returns the priority of the region. Regions with lower priority value will be evaluated 
	 * before regions with higher priority value.
	 */
	public int getPriority() {
		return priority;
	}

	public AbstractStatechart getStatechart() {
		if (owningStatechart != null) {
			return owningStatechart;
		} else {
			return owningState.getStatechart();
		}
	}

	protected RTCompoundState getOwningState() {
		return owningState;
	}

	protected AbstractStatechart getOwningStatechart() {
		return owningStatechart;
	}

	public Set<RTNode> getNodes() {
		return nodes;
	}

	private RTNode getInitialNode() {
		for (RTNode node : nodes) {
			if (node instanceof RTPseudostate
					&& ((RTPseudostate) node).getKind() == PseudostateKind.INITIAL) {
				return node;
			}
		}
		throw new IllegalStateException("No initial state present");
	}

	protected void setCurrentState(RTState state) {
		this.currentState = state;
	}

	public RTState getCurrentState() {
		return currentState;
	}

	protected void enter() {

		getInitialNode().enter();

	}

	protected void reenter(HistoryMode history) {

		currentState.reenter(history);

	}

	protected void reactOn(Set<RTEvent> events) {

		currentState.reactOn(events);

	}

	protected void leave() {

		currentState.leave();

	}

}
