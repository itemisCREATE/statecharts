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

import java.util.List;

import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.GraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.SGraphFactory;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.refactoring.refactor.AbstractRefactoring;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.editparts.StateEditPart;
import org.yakindu.sct.ui.editor.providers.SemanticHints;

import com.google.common.collect.Lists;
/**
 * Groups a set of states into one composite state. All transitions to and from this set of state are preserved, i.e.
 * the new composite state itself will have no incoming or outgoing transitions.
 * <br><br>
 * Context:
 * <ul>
 * <li>A set of states</li>
 * </ul>
 * Preconditions:
 * <ul>
 * <li>All states are in the same region.</li>
 * </ul>
 * @author thomas kutz - Initial contribution and API
 * 
 */
public class GroupStatesIntoCompositeRefactoring extends
		AbstractRefactoring<GraphicalEditPart> {

	private View parentRegion;
	private PreferencesHint preferencesHint = DiagramActivator.DIAGRAM_PREFERENCES_HINT;

	private final int PADDING = 55;

	@Override
	protected void internalExecute() {
		groupSelectedStatesIntoNewCompositeState();
	}

	@Override
	public boolean isExecutable() {
		return super.isExecutable() && allStatesHaveSameParentRegion();
	}

	protected void groupSelectedStatesIntoNewCompositeState() {

		State compositeState = createCompositeState();
		
		Region innerRegion = SGraphFactory.eINSTANCE.createRegion();
		innerRegion.setName("r1"); // TODO check for uniqueness
		compositeState.getRegions().add(innerRegion);
		
		for (State state : getSelectedStates()) {
			innerRegion.getVertices().add(state);
		}
		
		Node compositeStateView = createNodeForCompositeState(compositeState);
		Node innerRegionNode = ViewService.createNode(
				getStateFigureCompartmentView(compositeStateView), innerRegion,
				SemanticHints.REGION, preferencesHint);
		
		View regionCompartment = ViewUtil.getChildBySemanticHint(innerRegionNode, SemanticHints.REGION_COMPARTMENT);
		moveSelectedStateNodesTo(regionCompartment, (Bounds)compositeStateView.getLayoutConstraint());
	}

	protected State createCompositeState() {
		State compositeState = SGraphFactory.eINSTANCE.createState();
		compositeState.setName(getNameForCompositeState());
		((Region)parentRegion.getElement()).getVertices().add(compositeState);
		return compositeState;
	}

	protected Node createNodeForCompositeState(State compositeState) {
		Node compositeStateNode = ViewService.createNode(parentRegion,
				compositeState, SemanticHints.STATE, preferencesHint);
		setCompositeStateLayoutConstraint(compositeStateNode);
		return compositeStateNode;
	}

	protected List<State> getSelectedStates() {
		List<GraphicalEditPart> contextObjects = getContextObjects();
		List<State> result = Lists.newArrayList();
		for (GraphicalEditPart editPart : contextObjects) {
			EObject element = editPart.resolveSemanticElement();
			result.add((State) element);
		}
		return result;
	}
	
	protected void moveSelectedStateNodesTo(View containerView, Bounds compositeBounds) {

		for (GraphicalEditPart editPart : getContextObjects()) {
			Node stateNode = (Node)editPart.getNotationView();
			ViewUtil.insertChildView(containerView, stateNode, ViewUtil.APPEND, true);
			Bounds newBounds = NotationFactory.eINSTANCE.createBounds();
			Bounds oldBounds = (Bounds)stateNode.getLayoutConstraint();
			newBounds.setX(oldBounds.getX() - compositeBounds.getX() - 7); //FIXME use bounds of region view
			newBounds.setY(oldBounds.getY() - compositeBounds.getY() - 34); //FIXME use bounds of region view
			
			((Node)editPart.getNotationView()).setLayoutConstraint(newBounds);
		}
	}
	
	/**
	 * Iterates through all {@link StateEditPart}s of the current selection and
	 * computes layout constraints for the composite node.
	 * 
	 * @param compositeStateNode
	 *            node of the composite state
	 */
	protected void setCompositeStateLayoutConstraint(Node compositeStateNode) {

		Rectangle newbounds = null;
		
		for (GraphicalEditPart editPart : getContextObjects()) {
			Rectangle childBounds = editPart.getFigure().getBounds();
			if (newbounds == null)
				newbounds = childBounds.getCopy();
			
			newbounds.union(childBounds);
		}
		newbounds.expand(new Insets(PADDING, PADDING, PADDING, PADDING));

		Bounds bounds = NotationFactory.eINSTANCE.createBounds();
		bounds.setX(newbounds.x);
		bounds.setY(newbounds.y);
		bounds.setWidth(newbounds.width);
		bounds.setHeight(newbounds.height);
		compositeStateNode.setLayoutConstraint(bounds);
	}

	protected View getStateFigureCompartmentView(Node compositeStateView) {
		return ViewUtil.getChildBySemanticHint(compositeStateView,
				SemanticHints.STATE_FIGURE_COMPARTMENT);
	}

	protected String getNameForCompositeState() {
		StringBuilder nameBuilder = new StringBuilder("Composite");
		for (State state : getSelectedStates()) {
			nameBuilder.append("_");
			nameBuilder.append(state.getName());
		}
		return nameBuilder.toString();
	}

	protected boolean allStatesHaveSameParentRegion() {
		parentRegion = null;
		for (IGraphicalEditPart editPart : getContextObjects()) {
			if (parentRegion == null) {
				parentRegion = (Node) ((Node)editPart.getNotationView()).eContainer();
			} else {
				Node nextParentRegion = (Node) ((Node)editPart.getNotationView()).eContainer();
				if (!nextParentRegion.equals(parentRegion)) {
					return false;
				}
			}
		}
		return true;
	}

	@Override
	protected String getCommandLabel() {
		return "Group states into composite state";
	}
	
	@Override
	protected Resource getResource() {
		return getContextObject().resolveSemanticElement().eResource();
	}

}
