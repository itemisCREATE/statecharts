package org.yakindu.sct.simulation.runtime.sgraph;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Representation of a state (i.e. abstract base class for CompoundState, SimpleState,
 * and FinalState). A state has the unique property, that the system may be "in"
 * it, i.e. the state will - if being entered - react to incoming events of its
 * Statechart until it has been left again (although FinalStates will not show any reaction). 
 * When being entered or left, a state may execute an Action, i.e. its entry or exit action 
 * respectively.
 */
public abstract class RTState extends RTNode {

	private RTAction entryAction;
	private RTAction exitAction;
	private String name;

	protected List<RTReaction> localReactions = new ArrayList<RTReaction>();

	public RTState(String id, String name, RTRegion owningRegion,
			RTAction entryAction, RTAction exitAction) {
		super(id, owningRegion);
		this.name = name;
		this.entryAction = entryAction;
		this.exitAction = exitAction;
		
	}

	public void addLocalReaction(RTReaction reaction) {
		localReactions.add(reaction);
	}
	
	public String getName() {
		return name;
	}

	protected AbstractStatechart getStatechart() {
		return owningRegion.getStatechart();
	}

	protected void enter() {

		owningRegion.setCurrentState(this);

		// see if we have transitions that are time-triggered
		for (RTTransition transition : outgoingTransitions) {
			if (transition.isTimeTriggered()) {
				// register timer with timing service
				getStatechart().requestTimeEvent(transition.getTimeTrigger());
			}
		}

		// execute entry action
		if (entryAction != null) {
			entryAction.execute();
		}

		((RTStatechart) getStatechart()).stateEntered(this);

	}

	protected void reenter(HistoryMode history) {

		enter();

	}

	protected void reactOn(Set<RTEvent> events) {

		RTTransition transition = getEnabledOutgoingTransitionOfHighestPriority(events);
		if (transition != null) {
			// if there is an enabled transition, take it
			transition.take();
		} else {
			// otherwise this state might react to it (by executing a do action
			// or by delegating to nested regions)
			reactLocallyOn(events);
		}

	}

	private RTTransition getEnabledOutgoingTransitionOfHighestPriority(
			Set<RTEvent> events) {

		for (RTTransition transition : outgoingTransitions /* sorted by priority */) {
			if (transition.isTriggeredBy(events)) {
				return transition;
			}
		}
		return null;

	}

	protected abstract void reactLocallyOn(Set<RTEvent> events);

	protected void leave() {

		// see if we have transitions that are time-triggered
		for (RTTransition transition : outgoingTransitions) {
			if (transition.isTimeTriggered()) {
				// cancel all time events that could have been requested
				getStatechart().cancelTimeEvent(transition.getTimeTrigger());
			}
		}

		if (exitAction != null) {
			exitAction.execute();
		}

		((RTStatechart) getStatechart()).stateLeft(this);

	}

	public RTAction getEntryAction() {
		return entryAction;
	}

	public RTAction getExitAction() {
		return exitAction;
	}

	
	protected void performLocalReactions(Set<RTEvent> events) {
		perfotmParentReactions(events);
		for (RTReaction reaction : localReactions) {
			if (reaction.getTrigger().isEnabled(events)) reaction.getAction().execute();
		}
	}

	protected void perfotmParentReactions(Set<RTEvent> events) {
		RTState state = getOwningRegion().getOwningState();
		if (state != null) {
			state.performLocalReactions(events);
		}
	}

}
