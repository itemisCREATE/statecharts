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
import org.eclipse.draw2d.LayoutManager;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableEditPolicyEx;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;

/**
 * EditPart fpr Shapes that should not be resized.
 * 
 * @author muelder
 * 
 */
public abstract class FixedSizeShapeNodeEditPart extends ShapeNodeEditPart {

	public FixedSizeShapeNodeEditPart(View view) {
		super(view);
	}

	public abstract Dimension getDefaultSize();

	public abstract IFigure getPrimaryShape();

	@Override
	protected NodeFigure createNodeFigure() {
		final NodeFigure figure = new DefaultSizeNodeFigure(getDefaultSize());
		figure.setLayoutManager(getLayoutManager());
		figure.add(getPrimaryShape());
		return figure;
	}

	protected LayoutManager getLayoutManager() {
		return new StackLayout();
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new NonResizableEditPolicyEx());
	}

}
