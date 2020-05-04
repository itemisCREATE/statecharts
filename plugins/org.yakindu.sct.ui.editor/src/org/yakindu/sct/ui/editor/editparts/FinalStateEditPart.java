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

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandle.HandleDirection;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.base.gmf.runtime.editparts.EllipseFixedSizeShapeNodeEditPart;
import org.yakindu.base.gmf.runtime.editpolicies.OneWayConnectionHandlesEditPolicy;
import org.yakindu.sct.ui.editor.editor.figures.FinalStateFigure;
import org.yakindu.sct.ui.editor.editor.figures.utils.MapModeUtils;
import org.yakindu.sct.ui.editor.policies.EnlargeContainerEditPolicy;
import org.yakindu.sct.ui.editor.policies.FeedbackGraphicalNodeEditPolicy;
import org.yakindu.sct.ui.editor.policies.FixedBendpointEditPolicy;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class FinalStateEditPart extends EllipseFixedSizeShapeNodeEditPart {

	public FinalStateEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE, new OneWayConnectionHandlesEditPolicy(
				HandleDirection.INCOMING));
		installEditPolicy(EnlargeContainerEditPolicy.ROLE, new EnlargeContainerEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new FeedbackGraphicalNodeEditPolicy());
		installEditPolicy(FixedBendpointEditPolicy.ROLE, new FixedBendpointEditPolicy());
	}

	@Override
	public Dimension getDefaultSize() {
		return MapModeUtils.getMappedDimensions(getMapMode(), MapModeUtils.DEFAULT_SMALL_NODE_DIMENSION);
	}

	@Override
	public Ellipse createPrimaryShape() {
		return new FinalStateFigure(getMapMode());
	}

}
