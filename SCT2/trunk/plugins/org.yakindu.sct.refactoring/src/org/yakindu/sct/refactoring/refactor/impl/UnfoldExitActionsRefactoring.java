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
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.sct.model.sgraph.Effect;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.model.stext.stext.impl.ExitEventImpl;
import org.yakindu.sct.refactoring.refactor.AbstractRefactoring;
/**
 * This refactoring moves exit actions of a state to its outgoing transitions.
 * <br><br>
 * Context:
 * <ul>
 * <li>Exactly one state</li>
 * </ul>
 * Preconditions:
 * <ul>
 * <li>At least one exit action exists.</li>
 * <li>At least one outgoing transition exists.</li>
 * <li>No outgoing transition leaves a parent composite state of the context state with exit actions.</li>
 * </ul>
 * 
 * @author thomas kutz - Initial contribution and API
 * 
 */
public class UnfoldExitActionsRefactoring extends AbstractRefactoring<State> {

	@Override
	protected void internalExecute() {
		unfoldExitActions();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isExecutable() {
		return super.isExecutable()
				&& hasAtLeastOneExitAction()
				&& hasAtLeastOneOutgoingTransition()
				&& noOutgoingTransitionLeavesCompositeWithExitActions();
	}

	private boolean hasAtLeastOneExitAction() {
		return helper.hasExitAction(getContextObject());
	}

	private boolean noOutgoingTransitionLeavesCompositeWithExitActions() {
		return !helper.oneOutgoingTransitionLeavesCompositeWithExitActions(getContextObject());
	}

	private boolean hasAtLeastOneOutgoingTransition() {
		return !getContextObject().getOutgoingTransitions().isEmpty();
	}

	private void unfoldExitActions() {
		List<Expression> actionsToUnfold = new ArrayList<Expression>(
				helper.extractAllLocalActionsForEventType(getContextObject(),
						ExitEventImpl.class));
		addActionsToOutgoingTransitions(actionsToUnfold);
	}

	private void addActionsToOutgoingTransitions(List<Expression> actionsToAdd) {
		for (Transition transition : getContextObject()
				.getOutgoingTransitions()) {
			addActionsToTransition(transition, EcoreUtil.copyAll(actionsToAdd));
		}
	}

	private void addActionsToTransition(final Transition transition,
			final Collection<Expression> actionsToAdd) {

		Effect effect = transition.getEffect();
		if (effect instanceof ReactionEffect) {
			ReactionEffect reactionEffect = (ReactionEffect) effect;
			reactionEffect.getActions().addAll(0, actionsToAdd);
		} else {
			ReactionEffect reactionEffect = StextFactory.eINSTANCE
					.createReactionEffect();
			transition.setEffect(reactionEffect);
			reactionEffect.getActions().addAll(actionsToAdd);
		}
	}

	@Override
	protected String getCommandLabel() {
		return "Unfold Exit Actions";
	}

}
