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
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gmf.runtime.diagram.ui.editparts.AbstractBorderedShapeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IBorderItemEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableEditPolicyEx;
import org.eclipse.gmf.runtime.diagram.ui.figures.BorderItemLocator;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandle.HandleDirection;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.ui.editor.editor.figures.DeepHistoryFigure;
import org.yakindu.sct.ui.editor.editor.figures.InitialStateFigure;
import org.yakindu.sct.ui.editor.editor.figures.ShallowHistoryFigure;
import org.yakindu.sct.ui.editor.editor.figures.utils.MapModeUtils;

import de.itemis.gmf.runtime.commons.editpolicies.OneWayConnectionHandlesEditPolicy;
import de.itemis.gmf.runtime.commons.figures.EllipseAnchorDefaultSizeNodeFigure;

/**
 * 
 * @author andreas muelder
 */
public class EntryEditPart extends AbstractBorderedShapeEditPart {

	private IGraphicalEditPart primaryChildEditPart;

	public EntryEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE,
				new OneWayConnectionHandlesEditPolicy(HandleDirection.OUTGOING));
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
				new NonResizableEditPolicyEx());
	}

	@Override
	public Entry resolveSemanticElement() {
		return (Entry) super.resolveSemanticElement();
	}

	protected Ellipse getPrimaryShape() {
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
		if (SGraphPackage.eINSTANCE.getEntry_Kind().equals(
				notification.getFeature())) {
			// TODO: We have to remove the old figure, this does not work
			// currently because the connections get broken then.
			getMainFigure().add(getPrimaryShape());
		}
		super.handleNotificationEvent(notification);
	}

	@Override
	public Node getNotationView() {
		return (Node) super.getNotationView();
	}

	protected void addBorderItem(IFigure borderItemContainer,
			IBorderItemEditPart borderItemEditPart) {
		if (primaryChildEditPart == null) {
			primaryChildEditPart = borderItemEditPart;
		}
		BorderItemLocator locator = new BorderItemLocator(getMainFigure()) {
			protected Rectangle getParentBorder() {
				Rectangle bounds = getParentFigure().getBounds().getCopy();
				bounds.expand(15, 15);
				return bounds;
			}
		};
		borderItemContainer.add(borderItemEditPart.getFigure(), locator);
	}

	@Override
	protected NodeFigure createMainFigure() {
		final NodeFigure figure = new EllipseAnchorDefaultSizeNodeFigure(
				MapModeUtils.DEFAULT_SMALL_NODE_DIMENSION);
		figure.setLayoutManager(new StackLayout());
		figure.add(getPrimaryShape());
		return figure;
	}

	@Override
	protected void performDirectEditRequest(Request request) {
		primaryChildEditPart.performRequest(request);
	}

}
