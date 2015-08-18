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
import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableEditPolicyEx;
import org.eclipse.gmf.runtime.diagram.ui.handles.ConnectionHandle.HandleDirection;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NamedStyle;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.swt.graphics.Color;
import org.yakindu.gmf.runtime.editpolicies.OneWayConnectionHandlesEditPolicy;
import org.yakindu.gmf.runtime.figures.EllipseAnchorDefaultSizeNodeFigure;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.ui.editor.editor.figures.DeepHistoryFigure;
import org.yakindu.sct.ui.editor.editor.figures.InitialStateFigure;
import org.yakindu.sct.ui.editor.editor.figures.ShallowHistoryFigure;
import org.yakindu.sct.ui.editor.editor.figures.utils.MapModeUtils;
import org.yakindu.sct.ui.editor.factories.EntryViewFactory;
import org.yakindu.sct.ui.editor.policies.ContextSensitiveHelpPolicy;
import org.yakindu.sct.ui.editor.policies.EnlargeContainerEditPolicy;
import org.yakindu.sct.ui.editor.utils.GMFNotationUtil;
import org.yakindu.sct.ui.editor.utils.HelpContextIds;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class EntryEditPart extends BorderedShapeEditPart {

	public EntryEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE, new OneWayConnectionHandlesEditPolicy(
				HandleDirection.OUTGOING));
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new NonResizableEditPolicyEx());
		installEditPolicy(EditPolicy.SELECTION_FEEDBACK_ROLE, new ContextSensitiveHelpPolicy(
				HelpContextIds.SC_PROPERTIES_ENTRY_ENTRYKIND));
		installEditPolicy(EnlargeContainerEditPolicy.ROLE, new EnlargeContainerEditPolicy());
	}

	@Override
	public Entry resolveSemanticElement() {
		return (Entry) super.resolveSemanticElement();
	}

	protected Ellipse createPrimaryShape() {
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
		if (SGraphPackage.eINSTANCE.getEntry_Kind().equals(notification.getFeature())) {
			// TODO: We have to remove the old figure, this does not work
			// currently because the connections get broken then.
			getMainFigure().add(createPrimaryShape());
		}
		super.handleNotificationEvent(notification);
	}

	@Override
	public Node getNotationView() {
		return (Node) super.getNotationView();
	}

	@Override
	protected NodeFigure createMainFigure() {
		final NodeFigure figure = new EllipseAnchorDefaultSizeNodeFigure(MapModeUtils.DEFAULT_SMALL_NODE_DIMENSION);
		figure.setLayoutManager(new StackLayout());
		figure.add(createPrimaryShape());
		figure.setBackgroundColor(ColorConstants.black);
		figure.setForegroundColor(ColorConstants.white);
		return figure;
	}

	@Override
	protected void setBackgroundColor(Color c) {
		if (null != GMFNotationUtil.getNamedStyle(getNotationView(), NamedStyle.class, EntryViewFactory.ALLOW_COLORS)) {
			getMainFigure().setBackgroundColor(c);
		}
		super.setBackgroundColor(c);
	}

	@Override
	protected void setForegroundColor(Color color) {
		if (null != GMFNotationUtil.getNamedStyle(getNotationView(), NamedStyle.class, EntryViewFactory.ALLOW_COLORS)) {
			getMainFigure().setForegroundColor(color);
		}
		super.setForegroundColor(color);
	}

	@Override
	public Object getPreferredValue(EStructuralFeature feature) {
		if (feature == NotationPackage.eINSTANCE.getLineStyle_LineColor()) {
			return FigureUtilities.RGBToInteger(ColorConstants.white.getRGB());
		} else if (feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
			return FigureUtilities.RGBToInteger(ColorConstants.black.getRGB());
		}
		return super.getPreferredValue(feature);
	}

}
