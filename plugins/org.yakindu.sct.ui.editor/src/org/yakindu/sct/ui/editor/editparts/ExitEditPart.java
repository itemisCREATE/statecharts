/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.editparts;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableEditPolicyEx;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandle.HandleDirection;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.yakindu.sct.ui.editor.editor.figures.ExitFigure;
import org.yakindu.sct.ui.editor.editor.figures.utils.MapModeUtils;
import org.yakindu.sct.ui.editor.policies.EnlargeContainerEditPolicy;

import de.itemis.gmf.runtime.commons.editpolicies.OneWayConnectionHandlesEditPolicy;
import de.itemis.gmf.runtime.commons.figures.EllipseAnchorDefaultSizeNodeFigure;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ExitEditPart extends BorderedShapeEditPart {

	public ExitEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE, new OneWayConnectionHandlesEditPolicy(
				HandleDirection.INCOMING));
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new NonResizableEditPolicyEx());
		installEditPolicy(EnlargeContainerEditPolicy.ROLE, new EnlargeContainerEditPolicy());
	}

	@Override
	protected NodeFigure createMainFigure() {
		final NodeFigure figure = new EllipseAnchorDefaultSizeNodeFigure(MapModeUtils.DEFAULT_SMALL_NODE_DIMENSION);
		figure.setLayoutManager(new StackLayout());
		figure.add(new ExitFigure(getMapMode()));
		figure.setForegroundColor(ColorConstants.black);
		figure.setBackgroundColor(ColorConstants.white);
		return figure;
	}

	@Override
	protected void setBackgroundColor(Color c) {
		getMainFigure().setBackgroundColor(c);
		super.setBackgroundColor(c);
	}

	@Override
	protected void setForegroundColor(Color color) {
		getMainFigure().setForegroundColor(color);
		super.setForegroundColor(color);
	}

}
