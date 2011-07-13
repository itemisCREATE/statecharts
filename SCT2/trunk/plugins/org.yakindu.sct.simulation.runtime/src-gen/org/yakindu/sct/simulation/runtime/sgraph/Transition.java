package org.yakindu.sct.simulation.runtime.sgraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.yakindu.sct.simulation.runtime.sgraph.Statechart;

/**
 * Representation of a transition. A transition always connects a source node to
 * a target node. It may react on a time trigger and/or multiple signal triggers
 * and may be additionally guarded. In case a transition is taken, its action
 * will be executed.
 */
public class Transition {

	private String id;
	private int priority;

	private Guard guard;
	private Set<SignalEvent> signalTriggers = new HashSet<SignalEvent>();
	private TimeEvent timeTrigger;
	private Action action;

	private Node sourceNode;
	private Node targetNode;

	private Region commonAncestorRegion;
	private List<CompoundState> enclosingStatesToEnter;
	private List<CompoundState> enclosingStatesToLeave;

	public Transition(String id, int priority, TimeEvent timeTrigger,
			Set<SignalEvent> signalTriggers, Guard guard, Action action,
			Node sourceNode, Node targetNode) {
		this.id = id;
		this.priority = priority;

		this.timeTrigger = timeTrigger;
		if (signalTriggers != null) {
			this.signalTriggers.addAll(signalTriggers);
		}
		this.guard = guard;
		this.action = action;

		this.sourceNode = sourceNode;
		sourceNode.outgoingTransitions.add(this);
		this.targetNode = targetNode;
		targetNode.incomingTransitions.add(this);

		// compute common ancestor region
		commonAncestorRegion = getCommonAncestorRegion(sourceNode, targetNode);
		commonAncestorRegion.getStatechart().getTransitions().add(this);
		// compute which enclosing compound states have to be entered or left, when taking the transition
		enclosingStatesToEnter = getEnclosingStatesToEnter(targetNode,
				commonAncestorRegion);
		enclosingStatesToLeave = getEnclosingStatesToLeave(sourceNode,
				commonAncestorRegion);
	}

	protected boolean isTriggeredBy(Set<Event> events) {

		return !Collections.disjoint(this.signalTriggers, events)
				|| (timeTrigger != null && events.contains(timeTrigger));

	}

	public String getId() {
		return id;
	}

	public int getPriority() {
		return priority;
	}

	protected boolean isEnabled() {
		if (guard == null) {
			return true;
		} else {
			return guard.evaluate();
		}
	}

	public TimeEvent getTimeTrigger() {
		return timeTrigger;
	}

	protected boolean isTimeTriggered() {
		return timeTrigger != null;
	}

	protected void take() {

		// leave all enclosing states from the souceNode's container up to
		// the common ancestor region
		for (CompoundState state : enclosingStatesToLeave) {
			state.shallowLeave();
		}
		sourceNode.leave();

		((Statechart) commonAncestorRegion.getStatechart())
				.transitionFired(this);

		if (action != null) {
			action.execute();
		}

		// enter all enclosing states from the common ancestor region to the
		// targetNode's container
		for (CompoundState state : enclosingStatesToEnter) {
			state.shallowEnter();
		}
		targetNode.enter();

	}

	private List<CompoundState> getEnclosingStatesToEnter(Node targetNode,
			Region commonAncestorRegion) {

		// compute all enclosing state that have to be entered
		List<CompoundState> enclosingStatesToEnter = new ArrayList<CompoundState>();
		Region targetRegion = targetNode.getOwningRegion();
		while (targetRegion != commonAncestorRegion) {
			CompoundState state = targetRegion.getOwningState();
			enclosingStatesToEnter.add(state);
			targetRegion = state.getOwningRegion();

		}
		Collections.reverse(enclosingStatesToEnter); // ensure entering is done
														// in reverse order
		return enclosingStatesToEnter;

	}

	private List<CompoundState> getEnclosingStatesToLeave(Node sourceNode,
			Region commonAncestorRegion) {

		// compute all enclosing compound states up to the ancestor region
		List<CompoundState> enclosingStatesToLeave = new ArrayList<CompoundState>();
		Region sourceRegion = sourceNode.getOwningRegion();
		while (sourceRegion != commonAncestorRegion) {
			CompoundState state = sourceRegion.getOwningState();
			enclosingStatesToLeave.add(state);
			sourceRegion = state.getOwningRegion();
		}
		return enclosingStatesToLeave;

	}

	private Region getCommonAncestorRegion(Node sourceNode, Node targetNode) {
		Region candidate = sourceNode.getOwningRegion();
		while (candidate != null
				&& !isRegionAncestorOfNode(candidate, targetNode)) {
			candidate = candidate.getOwningState() != null ? candidate
					.getOwningState().getOwningRegion() : null;
		}
		return candidate;
	}

	private boolean isRegionAncestorOfNode(Region region, Node node) {
		if (node.getOwningRegion() == region) {
			return true;
		} else {
			if (node.getOwningRegion().getOwningState() == null) {
				return false;
			} else {
				return isRegionAncestorOfNode(region, node.getOwningRegion()
						.getOwningState());
			}
		}
	}

	public Node getSourceNode() {
		return sourceNode;
	}

	public Node getTargetNode() {
		return targetNode;
	}

	public Guard getGuard() {
		return guard;
	}

	public Action getAction() {
		return action;
	}

	public Set<SignalEvent> getSignalTriggers() {
		return signalTriggers;
	}

}
