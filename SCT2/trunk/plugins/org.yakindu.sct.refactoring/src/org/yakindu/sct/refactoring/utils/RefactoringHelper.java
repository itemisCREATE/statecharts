/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.refactoring.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.base.expressions.expressions.Expression;
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
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;

/**
 * Utility class providing several convenience methods used in refactoring commands.
 * 
 * @author thomas kutz - Initial contribution and API
 *
 */
public class RefactoringHelper {

	
	/**
	 * Collects all actions of the specified transitions and returns them.
	 * 
	 * @param transitions
	 * @return list of list of actions for the specified transitions
	 */
	public List<List<Expression>> getAllActions(List<Transition> transitions) {
		List<List<Expression>> allActions = new ArrayList<List<Expression>>();
		for (Transition transition : transitions) {
			Effect effect = transition.getEffect();
			if (effect instanceof ReactionEffect) {
				ReactionEffect reactionEffect = (ReactionEffect) effect;
				allActions.add(reactionEffect.getActions());
			}
			else {
				allActions.add(Collections.<Expression>emptyList());
			}
		}
		return allActions;
	}
	
	/**
	 * Checks if the specified state has at least one entry action.
	 * @param state
	 * @return true if condition is satisfied, false otherwise.
	 */
	public boolean hasEntryAction(State state) {
		EList<Expression> entryActions = getFirstEntryActions(state);
		if (entryActions != null && !entryActions.isEmpty()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if the specified state has at least one exit action.
	 * @param state
	 * @return true if condition is satisfied, false otherwise.
	 */
	public boolean hasExitAction(State state) {
		EList<Expression> exitActions = getFirstExitActions(state);
		if (exitActions != null && !exitActions.isEmpty()) {
			return true;
		}
		return false;
	}
	
	/**
	 * Checks if at least one of the outgoing transitions of the specified state leaves a parent composite
	 * of this state which has exit actions.
	 * 
	 * @param state 
	 * @return true if condition is satisfied, false otherwise
	 */
	public boolean oneOutgoingTransitionLeavesCompositeWithExitActions(State state) {

		Set<State> sourceParentStates = new HashSet<State>(getParentStates(state));
		
		for (Transition transition : state.getOutgoingTransitions()) {
			// all parent states of target need to be contained in the set of
			// the source's parent states
			Set<State> targetParentStates = getParentStates(transition.getTarget());
			Set<State> crossedStates = new HashSet<State>(sourceParentStates);
			crossedStates.removeAll(targetParentStates);

			for (State crossedCompositeState : crossedStates) {
				if (hasExitAction(crossedCompositeState))
					return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks if at least one of the incoming transitions of the specified state enters a parent composite
	 * of this state which has entry actions. 
	 * @param state
	 * @return true if condition is satisfied, false otherwise
	 */
	public boolean oneIncomingTransitionEntersCompositeWithEntryActions(State state) {

		Set<State> targetParentStates = new HashSet<State>(getParentStates(state));
		
		for (Transition transition : state.getIncomingTransitions()) {
			// all parent states of source need to be contained in the set of
			// the target's parent states
			Set<State> sourceParentStates = getParentStates(transition.getSource());
			Set<State> crossedStates = new HashSet<State>(targetParentStates);
			crossedStates.removeAll(sourceParentStates);

			for (State crossedCompositeState : crossedStates) {
				if (hasEntryAction(crossedCompositeState))
					return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns the entry actions of a state.
	 * Returns null if no entry block is defined.
	 * If multiple entry blocks are defined, only the actions of the first one are returned.
	 * 
	 * @param state
	 * @return list of actions of the first entry block defined in the specified state
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
	
	/**
	 * Returns the exit actions of a state.
	 * Returns null if no exit block is defined.
	 * If multiple exit blocks are defined, only the actions of the first one are returned.
	 * 
	 * @param state
	 * @return list of actions of the first exit block defined in the specified state
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
	 * @return true if the condition is satisfied, false otherwise
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
	
	/**
	 * Collects all actions of the specified state which have the specified type. The collected actions are deleted from their
	 * current containers and returned.
	 * @param state
	 * @param eventType
	 * @return all actions of the specified state which have the specified type
	 */
	public List<Expression> extractAllLocalActionsForEventType(State state, Class<? extends EventSpec> eventType) {
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
	
	/**
	 * Returns all parent states of the specified child state.
	 * 
	 * @param state child state
	 * @return all parent states of the specified child state
	 */
	// TODO are hierarchies of regions possible?
	private Set<State> getParentStates(Vertex state) {
		Set<State> parentStates = new HashSet<State>();
		CompositeElement composite = state.getParentRegion().getComposite();
		if (composite instanceof State) {
			State parentState = (State) composite;
			parentStates.add(parentState);
			parentStates.addAll(getParentStates(parentState));
		}
		return parentStates;
	}
	
	private void deleteAllEventsOfType(List<EventSpec> events, Class<? extends EventSpec> eventType) {
		for (EventSpec event : events) {
			if (event.getClass().getName().equals(eventType.getName())) {
				EcoreUtil.remove(event);
			}
		}
	}

	private boolean containsAtLeastOneEventOfType(List<EventSpec> events, Class<? extends EventSpec> eventType) {
		for (EventSpec event : events) {
			if (event.getClass().getName().equals(eventType.getName())) {
				return true;
			}
		}
		return false;
	}

	private boolean containsOnlyEventsOfType(List<EventSpec> events, Class<? extends EventSpec> eventType) {
		for (EventSpec event : events) {
			if (!event.getClass().getName().equals(eventType.getName())) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Checks if all given transitions have at least one action.
	 * Returns false for empty lists.
	 * 
	 * @param transitions
	 * @return
	 */
	public boolean haveAllAtLeastOneAction(
			EList<Transition> transitions) {
		if (transitions.isEmpty())
			return false;
		
		for (Transition transition : transitions) {
			if (!hasAtLeastOneAction(transition)) {
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Returns for the given semantic element the notation view element in the given diagram
	 * @param semanticElement
	 * @param diagram
	 * @return
	 */
	public View getViewForSemanticElement(EObject semanticElement, Diagram diagram) {
		TreeIterator<EObject> allContents = diagram.eAllContents();
		while (allContents.hasNext()) {
			EObject next = allContents.next();
			if (next instanceof View) {
				View view = (View) next;
				if (EcoreUtil.equals(view.getElement(), semanticElement)) {
					return view;
				}
			}
		}
		throw new IllegalArgumentException("No view found for semantic element "+semanticElement);
	}
	
}
