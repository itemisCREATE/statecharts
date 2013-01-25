package org.yakindu.sct.refactoring.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.sct.model.sgraph.CompositeElement;
import org.yakindu.sct.model.sgraph.Effect;
import org.yakindu.sct.model.sgraph.Reaction;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Trigger;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.stext.stext.EntryEvent;
import org.yakindu.sct.model.stext.stext.EventSpec;
import org.yakindu.sct.model.stext.stext.ExitEvent;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;

/**
 * Utility class providing several methods useful for refactoring commands.
 * 
 * TODO should be split up if it gets too big
 * 
 * @author kutz
 *
 */
public class RefactoringHelper {

	
	/**
	 * Collects all actions of the given transitions and returns them.
	 * 
	 * @param transitions
	 * @return
	 */
	public List<EList<Expression>> getAllActions(EList<Transition> transitions) {
		List<EList<Expression>> allActions = new ArrayList<EList<Expression>>();
		for (Transition transition : transitions) {
			Effect effect = transition.getEffect();
			if (effect instanceof ReactionEffect) {
				ReactionEffect reactionEffect = (ReactionEffect) effect;
				allActions.add(reactionEffect.getActions());
			}
			else {
				allActions.add(new BasicEList<Expression>());
			}
		}
		return allActions;
	}
	
	// TODO are hierarchies of regions possible?
	public Set<State> getParentStates(Vertex state) {
		Set<State> parentStates = new HashSet<State>();
		CompositeElement composite = state.getParentRegion().getComposite();
		if (composite instanceof State) {
			State parentState = (State) composite;
			parentStates.add(parentState);
			parentStates.addAll(getParentStates(parentState));
		}
		return parentStates;
	}
	
	public boolean hasEntryAction(State state) {
		EList<Expression> entryActions = getFirstEntryActions(state);
		if (entryActions != null && !entryActions.isEmpty()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Returns the entry actions of a state.
	 * Returns null if no entry block is defined.
	 * If multiple entry blocks are defined, only the actions of the first one are returned.
	 * 
	 * @param state
	 * @return
	 */
	public EList<Expression> getFirstEntryActions(State state) {
		EList<Reaction> localReactions = state.getLocalReactions();
		for (Reaction reaction : localReactions) {
			Trigger trigger = reaction.getTrigger();
			if (trigger instanceof ReactionTrigger) {
				ReactionTrigger reactionTrigger = (ReactionTrigger) trigger;
				EList<EventSpec> triggers = reactionTrigger.getTriggers();
				for (EventSpec eventSpec : triggers) {
					if (eventSpec instanceof EntryEvent && reaction.getEffect() instanceof ReactionEffect) {
						return ((ReactionEffect)reaction.getEffect()).getActions();
					}
				}
			}
		}
		return null;
	}

	public boolean hasExitAction(State state) {
		EList<Expression> exitActions = getFirstExitActions(state);
		if (exitActions != null && !exitActions.isEmpty()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Returns the exit actions of a state.
	 * Returns null if no exit block is defined.
	 * If multiple exit blocks are defined, only the actions of the first one are returned.
	 * 
	 * @param state
	 * @return
	 */
	public EList<Expression> getFirstExitActions(State state) {
		EList<Reaction> localReactions = state.getLocalReactions();
		for (Reaction reaction : localReactions) {
			Trigger trigger = reaction.getTrigger();
			if (trigger instanceof ReactionTrigger) {
				ReactionTrigger reactionTrigger = (ReactionTrigger) trigger;
				EList<EventSpec> triggers = reactionTrigger.getTriggers();
				for (EventSpec eventSpec : triggers) {
					if (eventSpec instanceof ExitEvent && reaction.getEffect() instanceof ReactionEffect) {
						return ((ReactionEffect)reaction.getEffect()).getActions();
					}
				}
			}
		}
		return null;
	}
	/**
	 * Checks if the effect definition of a transition contains at least one action.
	 * @param transition
	 * @return
	 */
	public boolean hasAtLeastOneAction(Transition transition) {
		Effect effect = transition.getEffect();
		if (effect instanceof ReactionEffect) {
			ReactionEffect reactionEffect = (ReactionEffect) effect;
			EList<Expression> actions = reactionEffect.getActions();
			return !actions.isEmpty();
		}
		return false;
	}

	public <T extends EObject> void removeAll(List<T> elementsToRemove) {
		// creating new collection to ensure that removing makes no problems inside loop
		List<EObject> elemList = new ArrayList<EObject>(elementsToRemove);
		for (EObject element : elemList) {
			EcoreUtil.remove(element);
		}
	}
	
	
	public List<Expression> getAllLocalActionsForEventType(State state, Class<? extends EventSpec> eventType) {
		// creating new collection required to delete its elements with EcoreUtil 
		List<Reaction> localReactions = new ArrayList<Reaction>(state.getLocalReactions());
		List<Expression> resultActions = new ArrayList<Expression>();
		for (Reaction reaction : localReactions) {
			if (!(reaction.getEffect() instanceof ReactionEffect) || !(reaction.getTrigger() instanceof ReactionTrigger)) {
				continue;
			}
			
			ReactionTrigger reactionTrigger = (ReactionTrigger) reaction.getTrigger();
			ReactionEffect reactionEffect = (ReactionEffect)reaction.getEffect();
			List<EventSpec> triggers = new ArrayList<EventSpec>(reactionTrigger.getTriggers());
			
			if (containsOnlyEventsOfType(triggers, eventType)) {
				EList<Expression> entryActions = reactionEffect.getActions();
				resultActions.addAll(entryActions);
				EcoreUtil.remove(reaction);
			}
			else if (containsAtLeastOneEventOfType(triggers, eventType)) {
				EList<Expression> entryActions = reactionEffect.getActions();
				resultActions.addAll(entryActions);
				deleteAllEventsOfType(triggers, eventType);
			}
		}
		return resultActions;
	}
	
	public void deleteAllEventsOfType(List<EventSpec> events, Class<? extends EventSpec> eventType) {
		for (EventSpec event : events) {
			if (event.getClass().getName().equals(eventType.getName())) {
				EcoreUtil.remove(event);
			}
		}
	}

	public boolean containsAtLeastOneEventOfType(List<EventSpec> events, Class<? extends EventSpec> eventType) {
		for (EventSpec event : events) {
			if (event.getClass().getName().equals(eventType.getName())) {
				return true;
			}
		}
		return false;
	}

	public boolean containsOnlyEventsOfType(List<EventSpec> events, Class<? extends EventSpec> eventType) {
		for (EventSpec event : events) {
			if (!event.getClass().getName().equals(eventType.getName())) {
				return false;
			}
		}
		return true;
	}
	
}
