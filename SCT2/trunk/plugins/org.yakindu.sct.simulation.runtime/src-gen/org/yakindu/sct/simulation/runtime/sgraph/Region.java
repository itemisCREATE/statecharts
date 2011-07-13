package org.yakindu.sct.simulation.runtime.sgraph;

import java.util.HashSet;
import java.util.Set;

public class Region {

	private String id;
	private int priority;
	private AbstractStatechart owningStatechart;
	private CompoundState owningState;

	private Set<Node> nodes = new HashSet<Node>();

	protected State currentState;

	public Region(String id, int priority, AbstractStatechart owner) {
		this.id = id;
		this.priority = priority;
		this.owningStatechart = owner;
		this.owningStatechart.getRegions().add(this);
	}

	public Region(String id, int priority, CompoundState owner) {
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

	protected CompoundState getOwningState() {
		return owningState;
	}

	protected AbstractStatechart getOwningStatechart() {
		return owningStatechart;
	}

	public Set<Node> getNodes() {
		return nodes;
	}

	private Node getInitialNode() {
		for (Node node : nodes) {
			if (node instanceof Pseudostate
					&& ((Pseudostate) node).getKind() == PseudostateKind.INITIAL) {
				return node;
			}
		}
		throw new IllegalStateException("No initial state present");
	}

	protected void setCurrentState(State state) {
		this.currentState = state;
	}

	public State getCurrentState() {
		return currentState;
	}

	protected void enter() {

		getInitialNode().enter();

	}

	protected void reenter(HistoryMode history) {

		currentState.reenter(history);

	}

	protected void reactOn(Set<Event> events) {

		currentState.reactOn(events);

	}

	protected void leave() {

		currentState.leave();

	}

}
