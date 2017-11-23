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

import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.TerminalRule;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.impl.HiddenLeafNode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
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

import com.google.common.collect.Maps;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StextResource extends AbstractSCTResource {

	private static final String SINGLELINE_COMMENT_TERMINAL = "SL";
	private static final String MULTILINE_COMMENT_TERMINAL = "ML";
	private static final String WHITESPACE_TERMINAL = "WS";
	private static final String NEW_LINE = System.lineSeparator();

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
			builder.append(NEW_LINE);
		}
		for (Annotation annotation : statechart.getAnnotations()) {
			builder.append(serialize(annotation));
			builder.append(NEW_LINE);
		}
		for (Scope scope : statechart.getScopes()) {
			builder.append(serializeScope(scope));
			builder.append(NEW_LINE);
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
		Map<Integer, EObject> specificationElements = Maps.newTreeMap();
		for (Declaration declaration : internalScope.getDeclarations()) {
			int lineNumber = getNodeLineNumber(declaration);
			specificationElements.put(lineNumber, declaration);
		}
		for (Reaction reaction : internalScope.getReactions()) {
			int lineNumber = getNodeLineNumber(reaction);
			specificationElements.put(lineNumber, reaction);
		}

		for (Integer lineNumber : specificationElements.keySet()) {
			EObject node = specificationElements.get(lineNumber);
			Iterable<ILeafNode> leafNodes = NodeModelUtils.findActualNodeFor(node).getLeafNodes();
			for (ILeafNode iLeafNode : leafNodes) {
				if (iLeafNode instanceof HiddenLeafNode) {
					HiddenLeafNode hiddenLeafNode = (HiddenLeafNode) iLeafNode;
					if (hiddenLeafNode.getGrammarElement() instanceof TerminalRule) {
						TerminalRule terminalRule = (TerminalRule) hiddenLeafNode.getGrammarElement();
						int startLine = hiddenLeafNode.getStartLine();
						int endLine = hiddenLeafNode.getEndLine();

						if (!terminalRule.getName().contains(SINGLELINE_COMMENT_TERMINAL)) {
							if (terminalRule.getName().contains(MULTILINE_COMMENT_TERMINAL)) {
								if (endLine - startLine == 0) { // Multiline comment in single line
									builder.append(NEW_LINE); // add linebreak between contiguous comments
								}
								break;
							}
						} else {
							if (nextNodesAreWhitespace(hiddenLeafNode)) {
								builder.append(NEW_LINE); // add linebreak if there are contiguous whitespaces
								break;
							}
							endLine--; // reduces new lines if single line comment is present
						}
						for (int i = startLine; i < endLine; i++)
							builder.append(NEW_LINE);

					} else
						break; // break on first non-hidden leaf node
				}
			}
			builder.append(serializeInteralScopeContents(node));
		}
		return builder.toString();
	}

	private boolean nextNodesAreWhitespace(HiddenLeafNode hiddenLeafNode) {
		if (hiddenLeafNode.getNextSibling() != null && hiddenLeafNode.getNextSibling().getNextSibling() != null) {
			EObject next = hiddenLeafNode.getNextSibling().getGrammarElement();
			EObject secondNext = hiddenLeafNode.getNextSibling().getNextSibling().getGrammarElement();
			if (next != null && next instanceof TerminalRule && secondNext != null
					&& secondNext instanceof TerminalRule) {
				TerminalRule nextRule = (TerminalRule) next;
				TerminalRule secondNextRule = (TerminalRule) secondNext;
				if (nextRule.getName().contains(WHITESPACE_TERMINAL)
						&& secondNextRule.getName().contains(WHITESPACE_TERMINAL)) {
					return true;
				}
			}
		}
		return false;
	}

	private String serializeInteralScopeContents(EObject node) {
		StringBuilder builder = new StringBuilder();
		if (node instanceof Reaction) {
			builder.append(serializeReaction((Reaction) node).trim());
		} else {
			builder.append(serialize(node));
		}
		return builder.toString();
	}

	protected int getNodeLineNumber(EObject object) {
		ICompositeNode node = NodeModelUtils.getNode(object);
		int lineNumber = node.getStartLine();
		return lineNumber;
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
				builder.append(NEW_LINE);
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
