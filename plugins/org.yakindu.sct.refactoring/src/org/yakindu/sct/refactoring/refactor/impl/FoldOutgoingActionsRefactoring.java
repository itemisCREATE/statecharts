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
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.sct.model.sgraph.Effect;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.stext.ExitEvent;
import org.yakindu.sct.model.stext.stext.LocalReaction;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.ReactionTrigger;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.refactoring.refactor.AbstractRefactoring;

/**
 * This refactoring moves actions of outgoing transitions to the exit block of a state. Actions can only be moved if 
 * they are used at all outgoing transitions in the same order (checked from front to back). 
 * <br><br>
 * Context:
 * <ul>
 * <li>Exactly one state.</li>
 * </ul>
 * Preconditions:
 * <ul>
 * <li>Each outgoing transition has at least one action.</li>
 * <li>No outgoing transition leaves a composite state which has exit actions.</li>
 * </ul>
 * @author thomas kutz - Initial contribution and API
 * 
 */
public class FoldOutgoingActionsRefactoring extends AbstractRefactoring<State> {

	@Override
	protected void internalExecute() {
		EList<Transition> outgoingTransitions = getContextObject()
				.getOutgoingTransitions();
		List<Expression> actionsToFold = getFoldableActions(outgoingTransitions);
		addActionsToExitReaction(actionsToFold);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isExecutable() {
		return super.isExecutable()
				&& allOutgoingTransitionsHaveAtLeastOneAction()
				&& noOutgoingTransitionLeavesCompositeWithExitActions();
	}

	private boolean noOutgoingTransitionLeavesCompositeWithExitActions() {
		return !helper.oneOutgoingTransitionLeavesCompositeWithExitActions(getContextObject());
	}

	private boolean allOutgoingTransitionsHaveAtLeastOneAction() {
		return helper.haveAllAtLeastOneAction(getContextObject().getOutgoingTransitions());
	}

	private List<Expression> getFoldableActions(EList<Transition> transitions) {

		List<Expression> foldableActions = new ArrayList<Expression>();

		Expression firstFoldableAction;
		int index = 0;
		while ((firstFoldableAction = getFirstFoldableAction(
				helper.getAllActions(transitions), index)) != null) {
			foldableActions.add(firstFoldableAction);
			index++;
		}
		removeFirstActions(transitions, index);

		return foldableActions;
	}

	private void addActionsToExitReaction(final List<Expression> actionsToAdd) {

		if (actionsToAdd.isEmpty()) {
			return;
		}

		EList<Expression> actionsOriginal = helper
				.getFirstExitActions(getContextObject());

		if (actionsOriginal == null) {
			actionsOriginal = createExitBlock();
		}

		actionsOriginal.addAll(actionsToAdd);
	}

	private EList<Expression> createExitBlock() {
		EList<Expression> actionsOriginal;
		LocalReaction newLocalReaction = StextFactory.eINSTANCE
				.createLocalReaction();
		ReactionTrigger newReactionTrigger = StextFactory.eINSTANCE
				.createReactionTrigger();
		ExitEvent exitEvent = StextFactory.eINSTANCE.createExitEvent();
		ReactionEffect newReactionEffect = StextFactory.eINSTANCE
				.createReactionEffect();

		newLocalReaction.setTrigger(newReactionTrigger);
		newReactionTrigger.getTriggers().add(exitEvent);
		newLocalReaction.setEffect(newReactionEffect);

		Scope scope = getContextObject().getScopes().get(0);
		scope.getReactions().add(newLocalReaction);

		actionsOriginal = newReactionEffect.getActions();
		return actionsOriginal;
	}

	private void removeFirstActions(EList<Transition> transitions, int number) {

		for (Transition transition : transitions) {
			List<Expression> actionsToRemove = getFirstActions(transition,
					number);
			for (Expression action : actionsToRemove) {
				EcoreUtil.delete(action);
			}
			// delete transition's effect when no more actions left
			Effect effect = transition.getEffect();
			if (!helper.hasAtLeastOneAction(transition) && effect != null) {
				EcoreUtil.delete(effect);
			}
		}
	}

	private List<Expression> getFirstActions(Transition transition, int number) {
		List<Expression> firstActions = new ArrayList<Expression>();
		Effect effect = transition.getEffect();
		if (effect instanceof ReactionEffect) {
			ReactionEffect reactionEffect = (ReactionEffect) effect;
			List<Expression> actions = reactionEffect.getActions();
			for (int i = 0; i < number; i++) {
				firstActions.add(actions.get(i));
			}
		}
		return firstActions;
	}

	private Expression getFirstFoldableAction(
			List<List<Expression>> allActions, int index) {
		Expression actionToCheck = null;
		for (List<Expression> actionList : allActions) {
			if (index >= actionList.size()) {
				return null;
			}
			Expression firstAction = actionList.get(index);
			if (actionToCheck == null) {
				actionToCheck = firstAction;
			} else if (!EcoreUtil.equals(actionToCheck, firstAction)) {
				return null;
			}
		}
		return actionToCheck;
	}

	@Override
	protected String getCommandLabel() {
		return "Fold Outgoing Actions";
	}

}
