/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */

package org.yakindu.sct.model.stext.resource.impl;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.parser.IParseResult;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.Reaction;
import org.yakindu.sct.model.sgraph.ReactionProperty;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;
import org.yakindu.sct.model.stext.stext.StateSpecification;
import org.yakindu.sct.model.stext.stext.StatechartSpecification;
import org.yakindu.sct.model.stext.stext.TransitionReaction;
import org.yakindu.sct.model.stext.stext.TransitionSpecification;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StextResource extends AbstractSCTResource {

	public StextResource(URI uri) {
		super(uri);
	}

	protected void serializeStatechart(Statechart statechart) {
		StringBuilder builder = new StringBuilder();
		for (Scope scope : statechart.getScopes()) {
			builder.append(serialize(scope));
			builder.append("\n");
		}
		statechart.setSpecification(builder.toString());
	}

	protected void serializeState(State state) {
		if (state.getScopes().size() != 1)
			return;
		Scope scope = state.getScopes().get(0);
		EList<Declaration> declarations = scope.getDeclarations();
		StringBuilder builder = new StringBuilder();
		for (Declaration declaration : declarations) {
			if (builder.length() > 0)
				builder.append("\n");
			builder.append(serializeReaction((Reaction) declaration));
		}
		state.setSpecification(builder.toString());
	}

	private String serializeReaction(Reaction reaction) {
		StringBuilder builder = new StringBuilder();
		builder.append(serialize(reaction.getTrigger()));
		if (reaction.getEffect() != null) {
			builder.append(" / ");
			builder.append(serialize(reaction.getEffect()));
		}
		if (reaction.getProperties().size() > 0) {
			builder.append(" # ");
			for (ReactionProperty property : reaction.getProperties()) {
				builder.append(serialize(property));
			}
		}
		return builder.toString();
	}

	protected void serializeTransition(Transition transition) {
		transition.setSpecification(serializeReaction(transition));
	}

	protected void parseStatechart(Statechart statechart) {
		IParseResult parseResult = parse(statechart, StatechartSpecification.class.getSimpleName());

		StatechartSpecification rootASTElement = (StatechartSpecification) parseResult.getRootASTElement();

		EList<Scope> definitionScopes = rootASTElement.getScopes();
		statechart.getScopes().clear();
		statechart.setNamespace(rootASTElement.getNamespace());
		if (definitionScopes != null) {
			statechart.getScopes().addAll(definitionScopes);
		}
	}

	protected void parseState(State state) {
		IParseResult parseResult = parse(state, StateSpecification.class.getSimpleName());
		StateSpecification rootASTElement = (StateSpecification) parseResult.getRootASTElement();
		state.getScopes().clear();
		if (rootASTElement.getScope() != null) {
			state.getScopes().add(rootASTElement.getScope());
		}
	}

	protected void parseTransition(Transition transition) {
		IParseResult parseResult = parse(transition, TransitionSpecification.class.getSimpleName());
		TransitionSpecification rootASTElement = (TransitionSpecification) parseResult.getRootASTElement();
		if (rootASTElement.getReaction() != null) {
			TransitionReaction reaction = rootASTElement.getReaction();
			transition.setEffect(reaction.getEffect());
			transition.setTrigger(reaction.getTrigger());
			transition.getProperties().addAll(reaction.getProperties());
		}
	}

}
