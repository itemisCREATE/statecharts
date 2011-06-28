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

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandle.HandleDirection;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.ui.editor.editor.figures.ExitFigure;
import org.yakindu.sct.ui.editor.editor.figures.utils.MapModeUtils;
import org.yakindu.sct.ui.editor.policies.RelationshipSemanticEditPolicy;

import de.itemis.gmf.runtime.commons.editparts.EllipseFixedSizeShapeNodeEditPart;
import de.itemis.gmf.runtime.commons.editpolicies.OneWayConnectionHandlesEditPolicy;

/**
 * 
 * @author andreas muelder
 * 
 */
public class ExitEditPart extends EllipseFixedSizeShapeNodeEditPart {

	public ExitEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new RelationshipSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE,
				new OneWayConnectionHandlesEditPolicy(HandleDirection.INCOMING));
	}

	@Override
	public Dimension getDefaultSize() {
		return MapModeUtils.getMappedDimensions(getMapMode(),
				MapModeUtils.DEFAULT_SMALL_NODE_DIMENSION);
	}

	@Override
	public Ellipse getPrimaryShape() {
		return new ExitFigure(getMapMode());
	}

}
