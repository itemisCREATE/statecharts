package org.yakindu.sct.simulation.runtime.sgraph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

/**
 * Representation of a transition. A transition always connects a source node to
 * a target node. It may react on a time trigger and/or multiple signal triggers
 * and may be additionally guarded. In case a transition is taken, its action
 * will be executed.
 */
public class RTTransition extends RTReaction {

	private String id;
	private int priority;

	private RTNode sourceNode;
	private RTNode targetNode;

	private RTRegion commonAncestorRegion;
	private List<RTCompoundState> enclosingStatesToEnter;
	private List<RTCompoundState> enclosingStatesToLeave;

	public RTTransition(String id, int priority, ITrigger trigger, RTAction action,
			RTNode sourceNode, RTNode targetNode) {

		super(trigger, action);
		
		this.id = id;
		this.priority = priority;

		this.trigger = trigger;
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

		return (trigger != null) ? trigger.isEnabled(events) : true ;
	}

	public String getId() {
		return id;
	}

	public int getPriority() {
		return priority;
	}


	public RTTimeEvent getTimeTrigger() {
		return trigger.getTimeTrigger();
	}

	protected boolean isTimeTriggered() {
		return (trigger != null) ? trigger.getTimeTrigger() != null : false;
	}

	protected void take() {

		// first perform all local reactions of non effected parent states...
		if (getCommonParentState() != null) getCommonParentState().performLocalReactions(commonAncestorRegion.getStatechart().currentEvents);
		
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

	public RTState getCommonParentState() {
		return (commonAncestorRegion != null)  
				? commonAncestorRegion.getOwningState()
				: null;
	}
}
