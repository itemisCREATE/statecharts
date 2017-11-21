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

package org.yakindu.sct.model.stext.resource;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.parser.IParseResult;
import org.yakindu.base.types.Annotation;
import org.yakindu.base.types.Declaration;
import org.yakindu.sct.model.sgraph.Reaction;
import org.yakindu.sct.model.sgraph.ReactionProperty;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;
import org.yakindu.sct.model.stext.stext.ArgumentedAnnotation;
import org.yakindu.sct.model.stext.stext.InternalScope;
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

	public StextResource() {
		this(null);
	}

	public StextResource(URI uri) {
		super(uri);
		setTrackingModification(true);
	}

	protected void serializeStatechart(Statechart statechart) {
		StringBuilder builder = new StringBuilder();
		if (statechart.getNamespace() != null) {
			builder.append("namespace " + statechart.getNamespace());
			builder.append("\n");
		}
		for (Annotation annotation : statechart.getAnnotations()) {
			builder.append(serialize(annotation));
			builder.append("\n");
		}
		for (Scope scope : statechart.getScopes()) {
			builder.append(serializeScope(scope));
			builder.append("\n");
		}
		statechart.setSpecification(builder.toString());
	}

	protected String serializeScope(Scope scope) {
		StringBuilder builder = new StringBuilder();
		if (scope instanceof InternalScope) {
			builder.append(serializeInternalScope((InternalScope) scope));
		} else {
			builder.append(serialize(scope));
		}
		return builder.toString();
	}

	protected String serializeInternalScope(InternalScope internalScope) {
		StringBuilder builder = new StringBuilder();
		InternalScope copiedScope = copyAndStripInternalScope(internalScope);
		builder.append(serialize(copiedScope));
		builder.append("\n");

		for (Declaration declaration : internalScope.getDeclarations()) {	
			builder.append(serialize(declaration));
			builder.append("\n");
		}
		builder.append("\n");
		for (Reaction reaction : internalScope.getReactions()) {
			builder.append(serializeReaction(reaction));
			builder.append("\n");
		}
		return builder.toString();
	}

	/**
	 * Copies and strips the given internal scope to only contain the comments and
	 * the "internal" keyword for serializing.
	 * 
	 * @param internalScope
	 *            the internal scope to be copied and stripped
	 * @return a copied internal scope with stripped contents
	 */
	protected InternalScope copyAndStripInternalScope(InternalScope internalScope) {
		InternalScope copiedScope = EcoreUtil2.copy(internalScope);
		copiedScope.getReactions().clear();
		copiedScope.getDeclarations().clear();
		copiedScope.eAdapters().addAll(internalScope.eAdapters());
		EcoreUtil2.resolveAll(copiedScope);
		return copiedScope;
	}

	protected void serializeState(State state) {
		if (state.getScopes().size() != 1)
			return;
		Scope scope = state.getScopes().get(0);
		EList<Reaction> reactions = scope.getReactions();
		StringBuilder builder = new StringBuilder();
		for (Reaction reaction : reactions) {
			if (builder.length() > 0)
				builder.append("\n");
			builder.append(serializeReaction(reaction));
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
		statechart.setNamespace(rootASTElement.getNamespace());
		statechart.getScopes().clear();
		EList<Scope> definitionScopes = rootASTElement.getScopes();
		if (definitionScopes != null) {
			statechart.getScopes().addAll(definitionScopes);
		}

		statechart.getAnnotations().clear();
		EList<ArgumentedAnnotation> annotations = rootASTElement.getAnnotations();
		if (annotations != null) {
			statechart.getAnnotations().addAll(annotations);
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
		transition.getProperties().clear();
		if (rootASTElement.getReaction() != null) {
			TransitionReaction reaction = rootASTElement.getReaction();
			transition.setEffect(reaction.getEffect());
			transition.setTrigger(reaction.getTrigger());
			transition.getProperties().addAll(reaction.getProperties());
		}
	}

}
