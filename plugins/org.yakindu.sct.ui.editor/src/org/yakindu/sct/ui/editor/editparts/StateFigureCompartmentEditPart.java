/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.editparts;

import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.IFigure;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.CompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.base.gmf.runtime.editpolicies.CompartmentLayoutEditPolicy;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.factories.StateViewFactory;
import org.yakindu.sct.ui.editor.policies.StateCompartmentCanonicalEditPolicy;
import org.yakindu.sct.ui.editor.policies.StateCompartmentCreationEditPolicy;
import org.yakindu.sct.ui.editor.utils.GMFNotationUtil;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class StateFigureCompartmentEditPart extends CompartmentEditPart {

	public StateFigureCompartmentEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new StateCompartmentCreationEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new StateCompartmentCanonicalEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new CompartmentLayoutEditPolicy(
				SGraphPackage.Literals.COMPOSITE_ELEMENT__REGIONS));
		removeEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE);
	}

	@Override
	protected void addNotationalListeners() {
		super.addNotationalListeners();
		  addListenerFilter("ParentView", this,((View)getModel()).eContainer());
		
	}
	
	@Override
	protected void removeNotationalListeners() {
		super.removeNotationalListeners();
		removeListenerFilter("ParentView"); 
	}
	
	@Override
	public boolean isSelectable() {
		return false;
	}

	@Override
	public State resolveSemanticElement() {
		return (State) super.resolveSemanticElement();
	}

	@Override
	protected IFigure createFigure() {
		figure = new Figure();
		figure.setLayoutManager(new StateFigureCompartmentLayout(getAlignment()));
		return figure;
	}

	@Override
	public StateEditPart getParent() {
		return (StateEditPart) super.getParent();
	}

	protected boolean getAlignment() {
		BooleanValueStyle style = GMFNotationUtil.getBooleanValueStyle(getParent().getNotationView(),
				StateViewFactory.ALIGNMENT_ORIENTATION);
		return (style != null) ? style.isBooleanValue() : true;
	}

	@Override
	protected void handleNotificationEvent(Notification event) {
		if (event.getFeature() == NotationPackage.Literals.BOOLEAN_VALUE_STYLE__BOOLEAN_VALUE) {
			updateLayout();
		}
		super.handleNotificationEvent(event);
	}

	private void updateLayout() {
		getFigure().setLayoutManager(new StateFigureCompartmentLayout(getAlignment()));
	}

	private static final class StateFigureCompartmentLayout extends ConstrainedToolbarLayout {
		public StateFigureCompartmentLayout(boolean isHorizontal) {
			super(isHorizontal);
			setSpacing(-1); // make lines overlap so it looks like a shared line
		}
	}

	@Override
	public PreferencesHint getDiagramPreferencesHint() {
		return DiagramActivator.DIAGRAM_PREFERENCES_HINT;
	}
}
