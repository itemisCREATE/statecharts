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

import static org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil.createInlineStyle;
import static org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil.getInlineStyle;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
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
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.stext.stext.EntryPointSpec;
import org.yakindu.sct.model.stext.stext.StextFactory;
import org.yakindu.sct.refactoring.refactor.AbstractRefactoring;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;
import org.yakindu.sct.ui.editor.providers.SemanticHints;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExtractSubdiagramRefactoring extends AbstractRefactoring<View> {

	protected PreferencesHint preferencesHint = DiagramActivator.DIAGRAM_PREFERENCES_HINT;
	private Diagram subdiagram;

	@Override
	public boolean isExecutable() {
		State state = (State) getContextObject().getElement();
		BooleanValueStyle inlineStyle = getInlineStyle(getContextObject());
		return super.isExecutable() && state.isComposite() && (inlineStyle == null || inlineStyle.isBooleanValue());
	}

	@Override
	protected void internalExecute() {
		setNotationStyle();
		subdiagram = createSubdiagram();
		createEntryExitPoints(subdiagram);
	}

	@Override
	protected boolean internalDoUndo() {
		return DiagramPartitioningUtil.closeSubdiagramEditors((State) subdiagram.getElement());
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
		// Semantic refactoring
		Transition transition = (Transition) edge.getElement();
		String prefix = "entry_" + transition.getSource().getName();
		createSemanticEntryPoint(transition, prefix);
		transition.setTarget((State) subdiagram.getElement());
		EList<ReactionProperty> properties = transition.getProperties();
		EntryPointSpec entryPointSpec = StextFactory.eINSTANCE.createEntryPointSpec();
		entryPointSpec.setEntrypoint(getUniquePointName(prefix, transition));
		properties.add(entryPointSpec);
		// Notation refactoring
		edge.setTarget(getContextObject());
	}

	protected String getUniquePointName(String prefix, Transition transition) {
		Vertex source = transition.getSource();
		StringBuilder builder = new StringBuilder();
		builder.append(prefix);
		int index = source.getOutgoingTransitions().indexOf(transition);
		builder.append(index);
		return builder.toString();
	}

	protected void createSemanticEntryPoint(Transition transition, String prefix) {
		Region entryPointTarget = transition.getTarget().getParentRegion();
		Entry entryPoint = SGraphFactory.eINSTANCE.createEntry();
		entryPoint.setName(getUniquePointName(prefix, transition));
		entryPointTarget.getVertices().add(entryPoint);
		Transition entryPointTransition = SGraphFactory.eINSTANCE.createTransition();
		entryPointTransition.setSource(entryPoint);
		entryPointTransition.setTarget(transition.getTarget());
	}

	protected void createExitPoint(Edge edge, Diagram subdiagram) {
		// Semantic refactoring
		Transition transition = (Transition) edge.getElement();
		String prefix = "exit_" + transition.getSource().getName();
		createSemanticExitPoint(transition, prefix);
		transition.setSource((State) subdiagram.getElement());
		EList<ReactionProperty> properties = transition.getProperties();
		EntryPointSpec entryPointSpec = StextFactory.eINSTANCE.createEntryPointSpec();
		entryPointSpec.setEntrypoint(getUniquePointName(prefix, transition));
		properties.add(entryPointSpec);
		// Notation refactoring
		edge.setSource(getContextObject());
	}

	protected void createSemanticExitPoint(Transition transition, String prefix) {
		Region exitPointTarget = transition.getSource().getParentRegion();
		Exit exitPoint = SGraphFactory.eINSTANCE.createExit();
		exitPoint.setName(getUniquePointName(prefix, transition));
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
		BooleanValueStyle inlineStyle = getInlineStyle(getContextObject());
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
