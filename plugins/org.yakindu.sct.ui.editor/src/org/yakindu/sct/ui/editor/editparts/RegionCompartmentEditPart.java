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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.LayoutAnimator;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.core.preferences.PreferencesHint;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableEditPolicyEx;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.diagram.ui.figures.ShapeCompartmentFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.policies.CompartmentCreationEditPolicy;
import org.yakindu.sct.ui.editor.policies.RegionCompartmentCanonicalEditPolicy;

import de.itemis.gmf.runtime.commons.editparts.FixedXYLayoutEditPolicy;

/**
 * @author muelder
 * @author muehlbrandt
 */
public class RegionCompartmentEditPart extends ShapeCompartmentEditPart {

	public RegionCompartmentEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.CREATION_ROLE, new CompartmentCreationEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE, new RegionCompartmentCanonicalEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE, new DragDropEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new FixedXYLayoutEditPolicy());
		// Removes the collapse expand handler
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new ResizableEditPolicyEx());
	}

	@Override
	public PreferencesHint getDiagramPreferencesHint() {
		return DiagramActivator.DIAGRAM_PREFERENCES_HINT;
	}

	@Override
	protected IFigure createFigure() {
		ShapeCompartmentFigure figure = new ShapeCompartmentFigure(getCompartmentName(), getMapMode());
		figure.getContentPane().setLayoutManager(getLayoutManager());
		figure.getContentPane().addLayoutListener(LayoutAnimator.getDefault());
		figure.setBorder(null);
		figure.setFitContents(true);
		figure.setToolTip((String) null);
		return figure;
	}

	@Override
	public boolean isSelectable() {
		return false;
	}

	@Override
	protected void refreshVisuals() {
		super.refreshVisuals();
		((ResizableCompartmentFigure) getFigure()).getScrollPane().setScrollBarVisibility(
				org.eclipse.draw2d.ScrollPane.NEVER);
	}
}
