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
package org.yakindu.sct.refactoring.refactor.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.sct.model.sgraph.Effect;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.impl.EntryEventImpl;
import org.yakindu.sct.refactoring.refactor.AbstractRefactoring;
/**
 * This refactoring moves entry actions of a state to its incoming transitions.
 * <br><br>
 * Context:
 * <ul>
 * <li>Exactly one state</li>
 * </ul>
 * Preconditions:
 * <ul>
 * <li>At least one entry action exists.</li>
 * <li>No incoming transition enters a parent composite state of the context state with entry actions.</li>
 * </ul>
 * 
 * @author thomas kutz - Initial contribution and API
 * 
 */
public class UnfoldEntryActionsRefactoring extends AbstractRefactoring<State> {

	@Override
	protected void internalExecute() {
		unfoldEntryActions();
	}

	/**
	 * Checks if one of the incoming transitions enters a parent composite state
	 * of its target. If so, false is returned if this parent composite state
	 * has entry actions.
	 * 
	 * @return true if all preconditions are fulfilled, false otherwise
	 */
	@Override
	public boolean isExecutable() {
		return super.isExecutable()
				&& noTransitionEntersCompositeWithEntryActions(getContextObject()
						.getIncomingTransitions());
	}

	private void unfoldEntryActions() {
		List<Expression> actionsToUnfold = new ArrayList<Expression>(
				helper.getAllLocalActionsForEventType(getContextObject(),
						EntryEventImpl.class));
		addActionsToIncomingTransitions(actionsToUnfold);
	}

	private void addActionsToIncomingTransitions(List<Expression> actionsToAdd) {

		for (Transition transition : getContextObject()
				.getIncomingTransitions()) {
			addActionsToTransition(transition, EcoreUtil.copyAll(actionsToAdd));
		}

	}

	private void addActionsToTransition(final Transition transition,
			final Collection<Expression> actionsToAdd) {

		Effect effect = transition.getEffect();
		ReactionEffect reactionEffect;
		if (effect instanceof ReactionEffect) {
			reactionEffect = (ReactionEffect) effect;
			reactionEffect.getActions().addAll(actionsToAdd);
		} else {
			reactionEffect = StextFactory.eINSTANCE.createReactionEffect();
			transition.setEffect(reactionEffect);
		}
		reactionEffect.getActions().addAll(actionsToAdd);

	}

	private boolean noTransitionEntersCompositeWithEntryActions(
			EList<Transition> transitions) {

		for (Transition transition : transitions) {
			// all parent states of source need to be contained in the set of
			// the target's parent states
			Set<State> targetParentStates = new HashSet<State>(
					helper.getParentStates(transition.getTarget()));
			Set<State> sourceParentStates = helper.getParentStates(transition
					.getSource());

			targetParentStates.removeAll(sourceParentStates);

			for (State crossedCompositeState : targetParentStates) {
				if (helper.hasEntryAction(crossedCompositeState))
					return false;
			}
		}
		return true;
	}

	@Override
	protected String getCommandLabel() {
		return "Unfold Entry Actions";
	}

}
