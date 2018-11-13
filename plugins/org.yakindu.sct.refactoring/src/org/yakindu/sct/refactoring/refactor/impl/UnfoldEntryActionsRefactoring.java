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
import org.yakindu.base.types.Expression;
import org.yakindu.sct.model.sgraph.Effect;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.stext.EntryEvent;
import org.yakindu.sct.model.stext.stext.ReactionEffect;
import org.yakindu.sct.model.stext.stext.StextFactory;
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
	 * {@inheritDoc}
	 */
	@Override
	public boolean isExecutable() {
		return super.isExecutable()
				&& hasAtLeastOneEntryAction()
				&& hasAtLeastOneIncomingTransition()
				&& noIncomingTransitionEntersCompositeWithEntryActions();
	}

	private boolean noIncomingTransitionEntersCompositeWithEntryActions() {
		return !helper.oneIncomingTransitionEntersCompositeWithEntryActions(getContextObject());
	}

	private boolean hasAtLeastOneEntryAction() {
		return helper.hasEntryAction(getContextObject());
	}

	private boolean hasAtLeastOneIncomingTransition() {
		return !getContextObject().getIncomingTransitions().isEmpty();
	}

	private void unfoldEntryActions() {
		List<Expression> actionsToUnfold = new ArrayList<Expression>(
				helper.extractAllLocalActionsForEventType(getContextObject(),
						EntryEvent.class));
		addActionsToIncomingTransitions(actionsToUnfold);
		
		helper.removeReactionsOfEventType(getContextObject().getLocalReactions(), EntryEvent.class);
	}

	private void addActionsToIncomingTransitions(List<Expression> actionsToAdd) {
		for (Transition transition : getContextObject()
				.getIncomingTransitions()) {

			addActionsToTransition(transition,  EcoreUtil.copyAll(actionsToAdd));
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
			reactionEffect.getActions().addAll(actionsToAdd);
			transition.setEffect(reactionEffect);
		}
	}

	@Override
	protected String getCommandLabel() {
		return "Unfold Entry Actions";
	}

}
