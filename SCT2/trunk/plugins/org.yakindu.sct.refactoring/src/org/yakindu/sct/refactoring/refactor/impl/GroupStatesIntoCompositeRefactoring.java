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
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.core.services.ViewService;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.notation.Bounds;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.Shape;
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
		AbstractRefactoring<View> {

	private Region parentRegion;
	private PreferencesHint preferencesHint = DiagramActivator.DIAGRAM_PREFERENCES_HINT;

	private final int PADDING = 40;

	@Override
	protected void internalExecute() {
		groupSelectedStatesIntoNewCompositeState();
	}

	@Override
	public boolean isExecutable() {
		return super.isExecutable() && allStatesHaveSameParentRegion();
	}

	private void groupSelectedStatesIntoNewCompositeState() {

		State compositeState = createCompositeState();
		Node compositeStateView = createNodeForCompositeState(compositeState);
		Region innerRegion = createInnerRegionInCompositeState(compositeState);
		createNodeForInnerRegion(compositeStateView, innerRegion);
		moveSelectedStatesToCompositeState(compositeState);
	}

	private State createCompositeState() {
		State compositeState = SGraphFactory.eINSTANCE.createState();
		compositeState.setName(getNameForCompositeState());
		// add it to parent region
		parentRegion.getVertices().add(compositeState);
		return compositeState;
	}

	private Node createNodeForCompositeState(State compositeState) {
		View parentRegionView = getViewOfParentRegion();
		Node compositeStateView = ViewService.createNode(parentRegionView,
				compositeState, SemanticHints.STATE, preferencesHint);
		setCompositeStateLayoutConstraint(compositeStateView);
		return compositeStateView;
	}

	private View getViewOfParentRegion() {
		// since all states are in same region, only the first state's edit part
		// is taken here
		View stateView = getContextObjects().iterator().next();
		View viewContainerForState = ViewUtil.getViewContainer(stateView);
		return viewContainerForState;
	}

	protected List<State> getSelectedStates() {
		List<View> contextObjects = getContextObjects();
		List<State> result = Lists.newArrayList();
		for (View view : contextObjects) {
			EObject element = view.getElement();
			result.add((State) element);
		}
		return result;
	}

	private void moveSelectedStatesToCompositeState(State compositeState) {
		for (State state : getSelectedStates()) {
			compositeState.getRegions().get(0).getVertices().add(state);
		}
	}

	private void createNodeForInnerRegion(Node compositeStateView,
			Region innerRegion) {
		ViewService.createNode(
				getStateFigureCompartmentView(compositeStateView), innerRegion,
				SemanticHints.REGION, preferencesHint);
	}

	private Region createInnerRegionInCompositeState(State compositeState) {
		Region innerRegion = SGraphFactory.eINSTANCE.createRegion();
		innerRegion.setName("r1");
		// add it to composite state
		compositeState.getRegions().add(innerRegion);
		return innerRegion;
	}

	/**
	 * Iterates through all {@link StateEditPart}s of the current selection and
	 * computes layout constraints for the composite node.
	 * 
	 * @param compositeStateNode
	 *            node of the composite state
	 */
	private void setCompositeStateLayoutConstraint(Node compositeStateNode) {

		Rectangle newbounds = new Rectangle();
		for (View view : getContextObjects()) {
			if (!(view instanceof Shape))
				continue;

			Shape shape = (Shape) view;
			Bounds bounds = (Bounds) shape.getLayoutConstraint();
			Rectangle childBounds = new Rectangle(bounds.getX(), bounds.getY(),
					bounds.getWidth(), bounds.getHeight());
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

	private View getStateFigureCompartmentView(Node compositeStateView) {
		return ViewUtil.getChildBySemanticHint(compositeStateView,
				SemanticHints.STATE_FIGURE_COMPARTMENT);
	}

	private String getNameForCompositeState() {
		StringBuilder nameBuilder = new StringBuilder("Composite");
		for (State state : getSelectedStates()) {
			nameBuilder.append("_");
			nameBuilder.append(state.getName());
		}
		return nameBuilder.toString();
	}

	private boolean allStatesHaveSameParentRegion() {
		for (State state : getSelectedStates()) {
			if (parentRegion == null) {
				parentRegion = state.getParentRegion();
			} else {
				if (!state.getParentRegion().equals(parentRegion)) {
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

}
