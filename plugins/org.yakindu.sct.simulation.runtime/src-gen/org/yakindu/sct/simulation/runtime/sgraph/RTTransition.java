package org.yakindu.sct.simulation.runtime.sgraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Representation of a transition. A transition always connects a source node to
 * a target node. It may react on a time trigger and/or multiple signal triggers
 * and may be additionally guarded. In case a transition is taken, its action
 * will be executed.
 */
public class RTTransition {

	private String id;
	private int priority;

	private RTGuard guard;
	private Set<RTSignalEvent> signalTriggers = new HashSet<RTSignalEvent>();
	private RTTimeEvent timeTrigger;
	private RTAction action;

	private RTNode sourceNode;
	private RTNode targetNode;

	private RTRegion commonAncestorRegion;
	private List<RTCompoundState> enclosingStatesToEnter;
	private List<RTCompoundState> enclosingStatesToLeave;

	public RTTransition(String id, int priority, RTTimeEvent timeTrigger,
			Set<RTSignalEvent> signalTriggers, RTGuard guard, RTAction action,
			RTNode sourceNode, RTNode targetNode) {
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

	protected boolean isTriggeredBy(Set<RTEvent> events) {

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

	public RTTimeEvent getTimeTrigger() {
		return timeTrigger;
	}

	protected boolean isTimeTriggered() {
		return timeTrigger != null;
	}

	protected void take() {

		// leave all enclosing states from the souceNode's container up to
		// the common ancestor region
		for (RTCompoundState state : enclosingStatesToLeave) {
			state.shallowLeave();
		}
		sourceNode.leave();

		((RTStatechart) commonAncestorRegion.getStatechart())
				.transitionFired(this);

		if (action != null) {
			action.execute();
		}

		// enter all enclosing states from the common ancestor region to the
		// targetNode's container
		for (RTCompoundState state : enclosingStatesToEnter) {
			state.shallowEnter();
		}
		targetNode.enter();

	}

	private List<RTCompoundState> getEnclosingStatesToEnter(RTNode targetNode,
			RTRegion commonAncestorRegion) {

		// compute all enclosing state that have to be entered
		List<RTCompoundState> enclosingStatesToEnter = new ArrayList<RTCompoundState>();
		RTRegion targetRegion = targetNode.getOwningRegion();
		while (targetRegion != commonAncestorRegion) {
			RTCompoundState state = targetRegion.getOwningState();
			enclosingStatesToEnter.add(state);
			targetRegion = state.getOwningRegion();

		}
		Collections.reverse(enclosingStatesToEnter); // ensure entering is done
														// in reverse order
		return enclosingStatesToEnter;

	}

	private List<RTCompoundState> getEnclosingStatesToLeave(RTNode sourceNode,
			RTRegion commonAncestorRegion) {

		// compute all enclosing compound states up to the ancestor region
		List<RTCompoundState> enclosingStatesToLeave = new ArrayList<RTCompoundState>();
		RTRegion sourceRegion = sourceNode.getOwningRegion();
		while (sourceRegion != commonAncestorRegion) {
			RTCompoundState state = sourceRegion.getOwningState();
			enclosingStatesToLeave.add(state);
			sourceRegion = state.getOwningRegion();
		}
		return enclosingStatesToLeave;

	}

	private RTRegion getCommonAncestorRegion(RTNode sourceNode, RTNode targetNode) {
		RTRegion candidate = sourceNode.getOwningRegion();
		while (candidate != null
				&& !isRegionAncestorOfNode(candidate, targetNode)) {
			candidate = candidate.getOwningState() != null ? candidate
					.getOwningState().getOwningRegion() : null;
		}
		return candidate;
	}

	private boolean isRegionAncestorOfNode(RTRegion region, RTNode node) {
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

	public RTNode getSourceNode() {
		return sourceNode;
	}

	public RTNode getTargetNode() {
		return targetNode;
	}

	public RTGuard getGuard() {
		return guard;
	}

	public RTAction getAction() {
		return action;
	}

	public Set<RTSignalEvent> getSignalTriggers() {
		return signalTriggers;
	}

}
