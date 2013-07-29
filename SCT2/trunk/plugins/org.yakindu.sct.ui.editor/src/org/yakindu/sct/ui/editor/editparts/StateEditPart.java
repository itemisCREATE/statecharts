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

import java.util.List;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.core.util.ViewUtil;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.Compartment;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.ui.editor.editor.figures.StateFigure;
import org.yakindu.sct.ui.editor.editor.figures.utils.GridDataFactory;
import org.yakindu.sct.ui.editor.editor.figures.utils.MapModeUtils;
import org.yakindu.sct.ui.editor.partitioning.DiagramPartitioningUtil;
import org.yakindu.sct.ui.editor.policies.EnlargeContainerEditPolicy;
import org.yakindu.sct.ui.editor.policies.PreferredSizeHandlerEditPolicy;
import org.yakindu.sct.ui.editor.preferences.StatechartColorConstants;
import org.yakindu.sct.ui.editor.providers.SemanticHints;

/**
 * The EditPart for the State.
 * 
 * 
 * @author andreas muelder
 * @author alexander nyssen
 * @author markus muehlbrandt
 * 
 */
public class StateEditPart extends ShapeNodeEditPart implements IPrimaryEditPart {

	private EditPart figureCompartmentEditPart;

	public StateEditPart(View view) {
		super(view);
	}

	/**
	 * Delegates all {@link CreateViewAndElementRequest}s to the figure
	 * compartment.
	 */
	@Override
	public EditPart getTargetEditPart(Request request) {
		if (request instanceof CreateViewAndElementRequest) {
			return figureCompartmentEditPart;
		}
		if (request instanceof GroupRequest && request.getType() == RequestConstants.REQ_DROP) {
			GroupRequest req = (GroupRequest) request;
			if (areInsertableChildren(req.getEditParts())) {
				return figureCompartmentEditPart;
			}
		}

		return super.getTargetEditPart(request);
	}

	private boolean areInsertableChildren(List<?> editParts) {
		for (Object object : editParts) {
			if (!(object instanceof RegionEditPart)) {
				return false;
			}
		}
		return true;
	}

	@Override
	protected NodeFigure createNodeFigure() {
		NodeFigure figure = new DefaultSizeNodeFigure(getDefaultSize()) {
			@Override
			// StateFigure is drawed smaller (Blurshadow size)
			public Rectangle getHandleBounds() {
				Insets insets = new Insets(0, 0, StateFigure.BLUR_SHADOW_WIDTH, StateFigure.BLUR_SHADOW_WIDTH);
				return new Rectangle(getBounds().x + insets.left, getBounds().y + insets.top, getBounds().width
						- (insets.right + insets.left), getBounds().height - (insets.bottom + insets.top));
			}

		};
		figure.setLayoutManager(new StackLayout());
		figure.setMinimumSize(getDefaultSize());
		figure.add(createPrimaryShape());
		return figure;
	}

	protected Dimension getDefaultSize() {
		return MapModeUtils.getDefaultSizeDimension(getMapMode());
	}

	public StateFigure createPrimaryShape() {
		return new StateFigure(getMapMode());
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(EditPolicyRoles.CREATION_ROLE);
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE, new PreferredSizeHandlerEditPolicy());
		installEditPolicy(EnlargeContainerEditPolicy.ROLE, new EnlargeContainerEditPolicy());
	}

	@Override
	protected void refreshVisuals() {
		refreshCompartmentLayout();
		super.refreshVisuals();
	}

	private void refreshCompartmentLayout() {
		if (getTextCompartment().isCollapsed()) {
			getPrimaryShape().setConstraint(getPrimaryShape().getTextCompartmentPane(), getCollapsedData());
		} else {
			GridData expandedData = getExpandedData();
			if (figureCompartmentVisible())
				expandedData.grabExcessVerticalSpace = false;
			getPrimaryShape().setConstraint(getPrimaryShape().getTextCompartmentPane(), expandedData);
		}
		if (!figureCompartmentVisible()) {
			getPrimaryShape().setConstraint(getPrimaryShape().getFigureCompartmentPane(), getCollapsedData());
		} else {
			getPrimaryShape().setConstraint(getPrimaryShape().getFigureCompartmentPane(), getExpandedData());
		}
	}

	private boolean figureCompartmentVisible() {
		BooleanValueStyle inlineStyle = DiagramPartitioningUtil.getInlineStyle(getNotationView());
		return resolveSemanticElement().getRegions().size() > 0
				&& (inlineStyle == null || inlineStyle.isBooleanValue());
	}

	private GridData getExpandedData() {
		return GridDataFactory.fillDefaults().grab(true, true).getData();
	}

	private GridData getCollapsedData() {
		return GridDataFactory.fillDefaults().grab(false, false).getData();
	}

	private Compartment getTextCompartment() {
		return (Compartment) ViewUtil.getChildBySemanticHint(getNotationView(), SemanticHints.STATE_TEXT_COMPARTMENT);
	}

	@Override
	public IFigure getContentPane() {
		return getPrimaryShape().getFigureCompartmentPane();
	}

	public StateFigure getPrimaryShape() {
		return (StateFigure) getFigure().getChildren().get(0);
	}

	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (childEditPart instanceof StateFigureCompartmentEditPart) {
			figureCompartmentEditPart = childEditPart;
			IFigure pane = getPrimaryShape().getFigureCompartmentPane();
			IFigure compartmentFigure = ((StateFigureCompartmentEditPart) childEditPart).getFigure();
			pane.add(compartmentFigure);
		} else if (childEditPart instanceof StateNameEditPart) {
			((StateNameEditPart) childEditPart).setLabel(getPrimaryShape().getNameFigure());
		} else if (childEditPart instanceof StateTextCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getTextCompartmentPane();
			IFigure compartmentFigure = ((StateTextCompartmentEditPart) childEditPart).getFigure();
			pane.add(compartmentFigure);
		} else {
			super.addChildVisual(childEditPart, index);
		}
	}

	@Override
	protected void removeChildVisual(EditPart childEditPart) {
		if (childEditPart instanceof StateFigureCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getFigureCompartmentPane();
			IFigure compartmentFigure = ((StateFigureCompartmentEditPart) childEditPart).getFigure();
			pane.remove(compartmentFigure);
		} else if (childEditPart instanceof StateTextCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getTextCompartmentPane();
			IFigure compartmentFigure = ((StateTextCompartmentEditPart) childEditPart).getFigure();
			pane.remove(compartmentFigure);
		} else {
			super.removeChildVisual(childEditPart);
		}
	}

	@Override
	protected void addNotationalListeners() {
		super.addNotationalListeners();
		addListenerFilter("TextCompartmentView", this,
				ViewUtil.getChildBySemanticHint(getNotationView(), SemanticHints.STATE_TEXT_COMPARTMENT));
	}

	@Override
	protected void removeNotationalListeners() {
		super.removeNotationalListeners();
		removeListenerFilter("TextCompartmentView");
	}

	/**
	 * Returns the default background color for states
	 */
	@Override
	public Object getPreferredValue(EStructuralFeature feature) {
		if (feature == NotationPackage.eINSTANCE.getLineStyle_LineColor()) {
			return FigureUtilities.RGBToInteger(StatechartColorConstants.STATE_LINE_COLOR.getRGB());
		} else if (feature == NotationPackage.eINSTANCE.getFillStyle_FillColor()) {
			return FigureUtilities.RGBToInteger(StatechartColorConstants.STATE_BG_COLOR.getRGB());
		}
		return super.getPreferredValue(feature);
	}

	@Override
	public State resolveSemanticElement() {
		return (State) super.resolveSemanticElement();
	}

	@Override
	protected void handleNotificationEvent(Notification notification) {
		if (notification.getFeature() == NotationPackage.Literals.BOOLEAN_VALUE_STYLE__BOOLEAN_VALUE) {
			refresh();
		}
		if (notification.getFeature() == NotationPackage.Literals.DRAWER_STYLE__COLLAPSED) {
			refreshVisuals();
		}
		if (notification.getFeature() == SGraphPackage.Literals.COMPOSITE_ELEMENT__REGIONS) {
			refreshVisuals();
		}
		super.handleNotificationEvent(notification);
	}
}