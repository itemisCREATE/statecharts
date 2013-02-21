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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Exit;
import org.yakindu.sct.model.sgraph.ReactionProperty;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.stext.EntryPointSpec;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;
import org.yakindu.sct.ui.editor.providers.SemanticHints;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExtractSubdiagramRefactoring extends SubdiagramRefactoring {

	@Override
	public boolean isExecutable() {
		State state = (State) getContextObject().getElement();
		BooleanValueStyle inlineStyle = getInlineStyle();
		return super.isExecutable() && state.isComposite() && (inlineStyle == null || inlineStyle.isBooleanValue());
	}

	@Override
	protected void internalExecute() {
		setNotationStyle();
		Diagram subdiagram = createSubdiagram();
		createEntryExitPoints(subdiagram);
	}

	@SuppressWarnings("unchecked")
	protected void createEntryExitPoints(Diagram subdiagram) {
		TreeIterator<EObject> eAllContents = subdiagram.eAllContents();
		while (eAllContents.hasNext()) {
			EObject next = eAllContents.next();
			if (next instanceof View) {
				EList<Edge> targetEdges = ((View) next).getTargetEdges();
				for (int i = targetEdges.size() - 1; i >= 0; i--) {
					Edge edge = targetEdges.get(i);
					if (!EcoreUtil.isAncestor(subdiagram, edge.getSource()))
						createEntryPoint(edge, subdiagram);
				}
				EList<Edge> sourceEdges = ((View) next).getSourceEdges();
				for (int i = sourceEdges.size() - 1; i >= 0; i--) {
					Edge edge = sourceEdges.get(i);
					if (!EcoreUtil.isAncestor(subdiagram, edge.getTarget())) {
						createExitPoint(edge, subdiagram);
					}
				}
			}
		}
	}

	protected void createEntryPoint(Edge edge, Diagram subdiagram) {
		System.out.println("Create an entry point for edge " + edge + " with source " + edge.getSource().getElement()
				+ " and target " + edge.getTarget().getElement());
		// Semantic refactoring
		Transition transition = (Transition) edge.getElement();
		createSemanticEntryPoint(transition);
		transition.setTarget((State) subdiagram.getElement());
		EList<ReactionProperty> properties = transition.getProperties();
		EntryPointSpec entryPointSpec = StextFactory.eINSTANCE.createEntryPointSpec();
		// TODO: Make unique
		entryPointSpec.setEntrypoint("entry1");
		properties.add(entryPointSpec);
		// Notation refactoring
		edge.setTarget(getContextObject());
	}

	protected void createSemanticEntryPoint(Transition transition) {
		Region entryPointTarget = transition.getTarget().getParentRegion();
		Entry entryPoint = SGraphFactory.eINSTANCE.createEntry();
		// TODO: Make unique
		entryPoint.setName("entry1");
		entryPointTarget.getVertices().add(entryPoint);
		Transition entryPointTransition = SGraphFactory.eINSTANCE.createTransition();
		entryPointTransition.setSource(entryPoint);
		entryPointTransition.setTarget(transition.getTarget());
	}

	protected void createExitPoint(Edge edge, Diagram subdiagram) {
		System.out.println("Create an exit point for edge " + edge + " with source " + edge.getSource().getElement()
				+ " and target " + edge.getTarget().getElement());
		// Semantic refactoring
		Transition transition = (Transition) edge.getElement();
		createSemanticExitPoint(transition);
		transition.setTarget((State) subdiagram.getElement());
		EList<ReactionProperty> properties = transition.getProperties();
		EntryPointSpec entryPointSpec = StextFactory.eINSTANCE.createEntryPointSpec();
		// TODO: Make unique
		entryPointSpec.setEntrypoint("exit1");
		properties.add(entryPointSpec);
		// Notation refactoring
		edge.setSource(getContextObject());
	}

	protected void createSemanticExitPoint(Transition transition) {
		Region exitPointTarget = transition.getSource().getParentRegion();
		Exit exitPoint = SGraphFactory.eINSTANCE.createExit();
		// TODO: Make unique
		exitPoint.setName("exit1");
		exitPointTarget.getVertices().add(exitPoint);
		Transition exitPointTransition = SGraphFactory.eINSTANCE.createTransition();
		exitPointTransition.setTarget(exitPoint);
		exitPointTransition.setSource(transition.getSource());
	}

	/**
	 * Sets the GMF inline {@link Style} to true
	 */
	@SuppressWarnings("unchecked")
	protected void setNotationStyle() {
		BooleanValueStyle inlineStyle = getInlineStyle();
		if (inlineStyle == null) {
			inlineStyle = createInlineStyle();
			getContextObject().getStyles().add(inlineStyle);
		}
		inlineStyle.setBooleanValue(false);
	}

	/**
	 * Creates a new {@link Diagram} and copies child elements
	 */
	protected Diagram createSubdiagram() {
		View contextView = getContextObject();
		State contextElement = (State) contextView.getElement();
		Diagram subdiagram = ViewService.createDiagram(contextElement, StatechartDiagramEditor.ID, preferencesHint);
		View figureCompartment = ViewUtil.getChildBySemanticHint(contextView, SemanticHints.STATE_FIGURE_COMPARTMENT);
		for (int i = figureCompartment.getChildren().size() - 1; i >= 0; i--) {
			subdiagram.insertChild((View) figureCompartment.getChildren().get(i));
		}
		getResource().getContents().add(subdiagram);
		return subdiagram;
	}
}
