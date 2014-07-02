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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Exit;
import org.yakindu.sct.model.sgraph.ReactionProperty;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.stext.stext.EntryPointSpec;
import org.yakindu.sct.model.stext.stext.ExitPointSpec;
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
		setPreferredSize();
	}

	@Override
	protected boolean internalDoUndo() {
		boolean close = DiagramPartitioningUtil.closeSubdiagramEditors((State) subdiagram.getElement());
		if (!close)
			return false;
		// Since the canonical edit policy creates edges for the semantic
		// transitions and it is not done within the TransactionalCommand we
		// have to delete the created edges manually when undo is executed.
		while (subdiagram.getEdges().size() > 0) {
			EcoreUtil.delete((EObject) subdiagram.getEdges().get(0));
		}
		return true;
	}

	@SuppressWarnings("unchecked")
	protected void createEntryExitPoints(Diagram subdiagram) {
		TreeIterator<EObject> eAllContents = subdiagram.eAllContents();
		List<Edge> entryPointsToCreate = new ArrayList<Edge>();
		List<Edge> exitPointstoCreate = new ArrayList<Edge>();
		while (eAllContents.hasNext()) {
			EObject next = eAllContents.next();
			if (next instanceof View) {
				EList<Edge> targetEdges = ((View) next).getTargetEdges();
				for (Edge edge : targetEdges) {
					if (!EcoreUtil.isAncestor(subdiagram, edge.getSource()))
						entryPointsToCreate.add(edge);
				}
				EList<Edge> sourceEdges = ((View) next).getSourceEdges();
				for (Edge edge : sourceEdges) {
					if (!EcoreUtil.isAncestor(subdiagram, edge.getTarget()))
						exitPointstoCreate.add(edge);
				}
			}
		}
		for (Edge edge : entryPointsToCreate) {
			createEntryPoint(edge, subdiagram);
		}
		for (Edge edge : exitPointstoCreate) {
			createExitPoint(edge, subdiagram);
		}
	}

	protected void createEntryPoint(Edge edge, Diagram subdiagram) {
		Transition transition = (Transition) edge.getElement();
		String name = getEntryPointName(transition);
		Region entryPointContainer = getEntryPointContainer(transition);
		Entry entryPoint = createSemanticEntryPoint(transition, name);
		// re-wire old transition to targeting the selected state
		transition.setTarget((State) subdiagram.getElement());
		View oldTarget = edge.getTarget();
		edge.setTarget(getContextObject());
		EList<ReactionProperty> properties = transition.getProperties();
		EntryPointSpec entryPointSpec = StextFactory.eINSTANCE.createEntryPointSpec();
		// A transition can only have one entry point so alter the existing
		for (ReactionProperty reactionProperty : properties) {
			if (reactionProperty instanceof EntryPointSpec) {
				entryPointSpec = (EntryPointSpec) reactionProperty;
			}
		}
		entryPointSpec.setEntrypoint(name);
		properties.add(entryPointSpec);
		
		// create node for entry point
		View entryPointContainerView = helper.getViewForSemanticElement(entryPointContainer, subdiagram);
		View entryPointRegionCompartment = ViewUtil.getChildBySemanticHint(entryPointContainerView, SemanticHints.REGION_COMPARTMENT);
		Node entryNode = ViewService.createNode(entryPointRegionCompartment, entryPoint, SemanticHints.EXIT, preferencesHint);
		ViewService.createEdge(entryNode, oldTarget, entryPoint.getOutgoingTransitions().get(0), SemanticHints.TRANSITION,
				preferencesHint);

	}

	protected String getEntryPointName(Transition transition) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("entry_");
		stringBuilder.append(transition.getTarget().getName());
		int index = transition.getSource().getOutgoingTransitions().indexOf(transition);
		stringBuilder.append(index);
		return stringBuilder.toString();
	}

	protected String getExitPointName(Transition transition) {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("exit_");
		stringBuilder.append(transition.getSource().getName());
		int index = transition.getSource().getOutgoingTransitions().indexOf(transition);
		stringBuilder.append(index);
		return stringBuilder.toString();
	}

	protected Entry createSemanticEntryPoint(Transition transition, String name) {
		Region entryPointTarget = getEntryPointContainer(transition);
		Entry entryPoint = null;
		Iterator<Vertex> iterator = entryPointTarget.getVertices().iterator();
		while (iterator.hasNext()) {
			Vertex next = iterator.next();
			if (next instanceof Entry) {
				Entry current = (Entry) next;
				if (name.equals(current.getName())) {
					// Do nothing, there already exists an entry point
					return current;
				}
			}
		}
		entryPoint = SGraphFactory.eINSTANCE.createEntry();
		entryPoint.setName(name);
		entryPointTarget.getVertices().add(entryPoint);
		Transition entryPointTransition = SGraphFactory.eINSTANCE.createTransition();
		entryPointTransition.setSource(entryPoint);
		entryPointTransition.setTarget(transition.getTarget());
		
		return entryPoint;
	}

	private Region getEntryPointContainer(Transition transition) {
		// entry point container is the subdiagram's state's region which contains the transition target
		EObject firstParentRegion = transition.getTarget().getParentRegion();
		return getOutermostParentRegion(firstParentRegion);
	}
	
	private Region getExitPointContainer(Transition transition) {
		// exit point container is the subdiagram's state's region which contains the transition source
		EObject firstParentRegion = transition.getSource().getParentRegion();
		return getOutermostParentRegion(firstParentRegion);
	}

	private Region getOutermostParentRegion(EObject element) {
		while (!(element.eContainer() instanceof Statechart)) {
			EObject container = element.eContainer();
			if (container instanceof State) {
				State parentState = (State) container;
				if (parentState.equals(subdiagram.getElement())) {
					return (Region) element;
				}
				element = parentState.getParentRegion();
			}
			else {
				element = element.eContainer();
			}
		}
		return null;
	}
	
	protected void createExitPoint(Edge edge, Diagram subdiagram) {
		Transition transition = (Transition) edge.getElement();
		// create semantic exit point
		String name = getExitPointName(transition);
		Region exitPointContainer = getExitPointContainer(transition);
		Exit exitPoint = SGraphFactory.eINSTANCE.createExit();
		exitPoint.setName(name);
		exitPointContainer.getVertices().add(exitPoint);
		// create node for exit point
		View exitPointContainerView = helper.getViewForSemanticElement(exitPointContainer, subdiagram);
		View exitPointRegionCompartment = ViewUtil.getChildBySemanticHint(exitPointContainerView, SemanticHints.REGION_COMPARTMENT);
		Node exitNode = ViewService.createNode(exitPointRegionCompartment, exitPoint, SemanticHints.EXIT, preferencesHint);
		// re-wire existing transition to new exit point
		Vertex oldTarget = transition.getTarget();
		transition.setTarget(exitPoint);
		ViewService.createEdge(edge.getSource(), exitNode, transition, SemanticHints.TRANSITION,
				preferencesHint);
		// create transition from selected state to former transition target
		Transition exitPointTransition = SGraphFactory.eINSTANCE.createTransition();
		exitPointTransition.setSource((State) subdiagram.getElement());
		exitPointTransition.setTarget(oldTarget);
		ViewService.createEdge(getContextObject(), edge.getTarget(), exitPointTransition, SemanticHints.TRANSITION,
				preferencesHint);
		EList<ReactionProperty> properties = exitPointTransition.getProperties();
		ExitPointSpec exitPointSpec = StextFactory.eINSTANCE.createExitPointSpec();
		// A transition can only have one exit point so alter the existing
		for (ReactionProperty reactionProperty : properties) {
			if (reactionProperty instanceof ExitPointSpec) {
				exitPointSpec = (ExitPointSpec) reactionProperty;
			}
		}
		exitPointSpec.setExitpoint(name);
		properties.add(exitPointSpec);
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
		getResource().getContents().add(subdiagram);
		while (figureCompartment.getChildren().size() > 0) {
			subdiagram.insertChild((View) figureCompartment.getChildren().get(0));
		}
		return subdiagram;
	}

	protected void setPreferredSize() {
		Node node = (Node) getContextObject();
		Bounds bounds = (Bounds) node.getLayoutConstraint();
		bounds.setWidth(-1);
		bounds.setHeight(-1);
	}
}
