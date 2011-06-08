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
package org.yakindu.sct.statechart.diagram.editparts;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ResizableCompartmentEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.DragDropEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.figures.ResizableCompartmentFigure;
import org.eclipse.gmf.runtime.draw2d.ui.figures.ConstrainedToolbarLayout;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.model.sct.statechart.StatechartPackage;
import org.yakindu.sct.statechart.diagram.policies.CompartmentCreationEditPolicy;
import org.yakindu.sct.statechart.diagram.policies.StateCompartmentCanonicalEditPolicy;

import de.itemis.gmf.runtime.commons.editpolicies.CompartmentEditPolicy;


/**
 * 
 * @author muelder
 * 
 */
public class StateFigureCompartmentEditPart extends
		ResizableCompartmentEditPart {

	public StateFigureCompartmentEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CompartmentCreationEditPolicy());
		installEditPolicy(EditPolicyRoles.CANONICAL_ROLE,
				new StateCompartmentCanonicalEditPolicy());
		installEditPolicy(EditPolicyRoles.DRAG_DROP_ROLE,
				new DragDropEditPolicy());
		installEditPolicy(EditPolicy.LAYOUT_ROLE, new CompartmentEditPolicy(
				StatechartPackage.Literals.STATE__SUB_REGIONS));

	}

	@Override
	public boolean isSelectable() {
		return false;
	}

	@Override
	protected IFigure createFigure() {
		ResizableCompartmentFigure figure = (ResizableCompartmentFigure) super
				.createFigure();
		figure.getContentPane().setLayoutManager(
				new StateFigureCompartmentLayout());
		figure.setBorder(null);
		return figure;
	}

	private static final class StateFigureCompartmentLayout extends
			ConstrainedToolbarLayout {
		public StateFigureCompartmentLayout() {
			super(true);
			setSpacing(-1); // make lines overlap so it looks like a shared line 
			setHorizontal(false);
		}

		@Override
		protected Dimension calculatePreferredSize(IFigure container,
				int wHint, int hHint) {
			return new Dimension(1, 1);
		}

	}
}
