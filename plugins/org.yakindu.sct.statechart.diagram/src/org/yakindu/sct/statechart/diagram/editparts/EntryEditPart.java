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

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandle.HandleDirection;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.model.sct.statechart.Entry;
import org.yakindu.model.sct.statechart.StatechartPackage;
import org.yakindu.sct.statechart.diagram.editor.figures.DeepHistoryFigure;
import org.yakindu.sct.statechart.diagram.editor.figures.InitialStateFigure;
import org.yakindu.sct.statechart.diagram.editor.figures.ShallowHistoryFigure;
import org.yakindu.sct.statechart.diagram.editor.figures.utils.MapModeUtils;
import org.yakindu.sct.statechart.diagram.policies.RelationshipSemanticEditPolicy;

import de.itemis.gmf.runtime.commons.editparts.EllipseFixedSizeShapeNodeEditPart;
import de.itemis.gmf.runtime.commons.editpolicies.OneWayConnectionHandlesEditPolicy;

/**
 * 
 * @author andreas muelder
 */
public class EntryEditPart extends EllipseFixedSizeShapeNodeEditPart {

	public EntryEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
				new RelationshipSemanticEditPolicy());
		installEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE,
				new OneWayConnectionHandlesEditPolicy(HandleDirection.OUTGOING));
	}

	@Override
	public Dimension getDefaultSize() {
		return MapModeUtils.getMappedDimensions(getMapMode(),
				MapModeUtils.DEFAULT_SMALL_NODE_DIMENSION);
	}

	@Override
	public Entry resolveSemanticElement() {
		return (Entry) super.resolveSemanticElement();
	}

	@Override
	public Ellipse getPrimaryShape() {
		switch (resolveSemanticElement().getKind()) {
		case DEEP_HISTORY:
			return new DeepHistoryFigure();
		case SHALLOW_HISTORY:
			return new ShallowHistoryFigure();
		case INITIAL:
			return new InitialStateFigure();
		}
		throw new IllegalStateException();
	}

	@Override
	protected void handleNotificationEvent(Notification notification) {
		// We have to update the primary shape when the entry kind changes
		if (StatechartPackage.eINSTANCE.getEntry_Kind().equals(
				notification.getFeature())) {
			// TODO: We have to remove the old figure, this does not work
			// currently because the connections get broken then.
			getNodeFigure().add(getPrimaryShape());
		}
		super.handleNotificationEvent(notification);
	}

	@Override
	public Node getNotationView() {
		return (Node) super.getNotationView();
	}

}
