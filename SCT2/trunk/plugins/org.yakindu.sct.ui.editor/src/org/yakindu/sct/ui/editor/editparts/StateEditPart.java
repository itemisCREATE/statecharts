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
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Handle;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.handles.AbstractHandle;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gef.tools.ResizeTracker;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableEditPolicyEx;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableEditPolicyEx;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.diagram.ui.tools.DragEditPartsTrackerEx;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Compartment;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.ui.editor.editor.figures.StateFigure;
import org.yakindu.sct.ui.editor.editor.figures.utils.GridDataFactory;
import org.yakindu.sct.ui.editor.editor.figures.utils.MapModeUtils;
import org.yakindu.sct.ui.editor.preferences.StatechartColorConstants;

/**
 * The EditPart for the State.
 * 
 * 
 * @author andreas muelder
 * @author alexander nyssen
 * @author markus muehlbrandt
 * 
 */
public class StateEditPart extends ShapeNodeEditPart implements
		IPrimaryEditPart {

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
		if (request instanceof GroupRequest
				&& request.getType() == RequestConstants.REQ_DROP) {
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
		NodeFigure figure = new DefaultSizeNodeFigure(getDefaultSize());
		figure.setLayoutManager(new StackLayout());
		figure.setMinimumSize(getDefaultSize());
		figure.add(createPrimaryShape());
		return figure;
	}

	private Dimension getDefaultSize() {
		return MapModeUtils.getDefaultSizeDimension(getMapMode());
	}

	public StateFigure createPrimaryShape() {
		return new StateFigure(getMapMode());
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		// installEditPolicy(EditPolicyRoles.SEMANTIC_ROLE,
		// new RelationshipSemanticEditPolicy());
		// We don't want to allow creation for parent editpart on a State
		installEditPolicy(EditPolicyRoles.CREATION_ROLE,
				new CreationEditPolicy() {
					@Override
					protected Command getCreateElementAndViewCommand(
							CreateViewAndElementRequest request) {
						return UnexecutableCommand.INSTANCE;
					}
				});

		if (isCollapsed()) {
			installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
					getNonResizableEditPolicyEx());
		} else {
			installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
					getResizableEditPolicyEx());
		}
	}

	@Override
	protected void refreshVisuals() {
		refreshCompartmentStates();
		super.refreshVisuals();
	}

	private void refreshCompartmentStates() {
		if (getTextCompartment().isCollapsed()) {
			getPrimaryShape().setConstraint(
					getPrimaryShape().getTextCompartmentPane(),
					getCollapsedData());
		} else {
			GridData expandedData = getExpandedData();
			if (!getFigureCompartment().isCollapsed())
				expandedData.grabExcessVerticalSpace = false;
			getPrimaryShape().setConstraint(
					getPrimaryShape().getTextCompartmentPane(), expandedData);
		}
		if (getFigureCompartment().isCollapsed()) {
			getPrimaryShape().setConstraint(
					getPrimaryShape().getFigureCompartmentPane(),
					getCollapsedData());
		} else {
			GridData expandedData = getExpandedData();

			getPrimaryShape().setConstraint(
					getPrimaryShape().getFigureCompartmentPane(), expandedData);
		}
	}

	private GridData getExpandedData() {
		return GridDataFactory.fillDefaults().grab(true, true).getData();
	}

	private GridData getCollapsedData() {
		return GridDataFactory.fillDefaults().grab(false, false).getData();
	}

	// @Override
	protected void refreshBounds() {
		// mark all figures covered by the blur shadow extended bounds as dirty
		// (an update is enforced at the end of this method to ensure the area
		// gets repainted)
		final NodeFigure nodeFigure = getNodeFigure();
		Rectangle extendedBlurShadowBounds = nodeFigure.getBounds()
				.getExpanded(new Insets(StateFigure.BLUR_SHADOW_WIDTH));
		nodeFigure.translateToAbsolute(extendedBlurShadowBounds);
		markDirtyIfIntersecting(
				org.eclipse.draw2d.FigureUtilities.getRoot(nodeFigure),
				extendedBlurShadowBounds);

		// TODO: Calculate the 'default' size
		int width = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE
				.getSize_Width())).intValue();
		int height = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE
				.getSize_Height())).intValue();

		Dimension size = new Dimension(width, height);
		int x = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE
				.getLocation_X())).intValue();
		int y = ((Integer) getStructuralFeatureValue(NotationPackage.eINSTANCE
				.getLocation_Y())).intValue();
		Point loc = new Point(x, y);

		if (isCollapsed()) {
			((GraphicalEditPart) getParent()).setLayoutConstraint(this,
					getFigure(), new Rectangle(loc, new Dimension(58, 66)));
		} else {
			((GraphicalEditPart) getParent()).setLayoutConstraint(this,
					getFigure(), new Rectangle(loc, size));
		}

	}

	/**
	 * Helper method which descends the figure tree beginning with the given
	 * figure and marks all figures dirty, whose bounds intersect with the given
	 * absolute bounds.
	 * 
	 * @param figure
	 *            The figure whose (transitive) children will be processed
	 * @param absoluteBounds
	 *            The bounds used for intersection testing in absolute
	 *            coordinates
	 */
	private void markDirtyIfIntersecting(IFigure figure,
			Rectangle absoluteBounds) {
		Rectangle translatedBounds = absoluteBounds;
		figure.translateToRelative(translatedBounds);
		if (figure.getBounds().intersects(translatedBounds)) {
			figure.getUpdateManager().addDirtyRegion(figure, translatedBounds);
		}
		// process all children transitively
		for (Object child : figure.getChildren()) {
			markDirtyIfIntersecting((IFigure) child, absoluteBounds);
		}
	}

	private Compartment getFigureCompartment() {
		return (Compartment) getNotationView().getChildren().get(2);
	}

	private Compartment getTextCompartment() {
		return (Compartment) getNotationView().getChildren().get(1);
	}

	public boolean isCollapsed() {
		return getFigureCompartment().isCollapsed()
				&& getTextCompartment().isCollapsed();
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
			IFigure compartmentFigure = ((StateFigureCompartmentEditPart) childEditPart)
					.getFigure();
			pane.add(compartmentFigure);
		} else if (childEditPart instanceof StateNameEditPart) {
			((StateNameEditPart) childEditPart).setLabel(getPrimaryShape()
					.getNameFigure());
		} else if (childEditPart instanceof StateTextCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getTextCompartmentPane();
			IFigure compartmentFigure = ((StateTextCompartmentEditPart) childEditPart)
					.getFigure();
			pane.add(compartmentFigure);
		} else {
			super.addChildVisual(childEditPart, index);
		}
	}

	// TODO: removeChildvisual

	@Override
	protected void addNotationalListeners() {
		super.addNotationalListeners();
		addListenerFilter("TextCompartmentView", this, (Node) getNotationView()
				.getChildren().get(1));
		addListenerFilter("FigureCompartmentView", this,
				(Node) getNotationView().getChildren().get(2));
	}

	@Override
	protected void removeNotationalListeners() {
		super.removeNotationalListeners();
		removeListenerFilter("TextCompartmentView");
		removeListenerFilter("FigureCompartmentView");
	}

	/**
	 * Returns the default background color for states
	 */
	@Override
	public Object getPreferredValue(EStructuralFeature feature) {
		if (feature == NotationPackage.eINSTANCE.getLineStyle_LineColor()) {
			return FigureUtilities
					.RGBToInteger(StatechartColorConstants.STATE_LINE_COLOR
							.getRGB());
		} else if (feature == NotationPackage.eINSTANCE
				.getFillStyle_FillColor()) {
			return FigureUtilities
					.RGBToInteger(StatechartColorConstants.STATE_BG_COLOR
							.getRGB());
		}
		return super.getPreferredValue(feature);
	}

	@Override
	public State resolveSemanticElement() {
		return (State) super.resolveSemanticElement();
	}

	private NonResizableEditPolicyEx getNonResizableEditPolicyEx() {
		return new NonResizableEditPolicyEx() {

			protected void replaceHandleDragEditPartsTracker(Handle handle) {
				if (handle instanceof AbstractHandle) {
					AbstractHandle h = (AbstractHandle) handle;
					h.setDragTracker(new DragEditPartsTrackerEx(getHost()) {
						protected void executeCurrentCommand() {
							super.executeCurrentCommand();
							// ensure repaint is performed (so blur shadow
							// covered area is repainted)
							if (isActive()) {
								getNodeFigure().getUpdateManager()
										.performUpdate();
							}
						};
					});
				}
			}
		};
	}

	private ResizableEditPolicyEx getResizableEditPolicyEx() {
		return new ResizableEditPolicyEx() {
			/**
			 * Replaces the handle's default DragEditPartsTracker with the
			 * extended DragEditPartsTrackerEx
			 * 
			 * @param handle
			 */
			protected void replaceHandleDragEditPartsTracker(Handle handle) {
				if (handle instanceof AbstractHandle) {
					AbstractHandle h = (AbstractHandle) handle;
					h.setDragTracker(new DragEditPartsTrackerEx(getHost()) {
						protected void executeCurrentCommand() {
							super.executeCurrentCommand();
							// ensure repaint is performed (so blur shadow
							// covered area is repainted)
							if (isActive()) {
								getNodeFigure().getUpdateManager()
										.performUpdate();
							}
						};
					});
				}
			}

			protected ResizeTracker getResizeTracker(int direction) {
				return new ResizeTracker((GraphicalEditPart) getHost(),
						direction) {
					@Override
					protected void executeCurrentCommand() {
						super.executeCurrentCommand();
						// ensure repaint is performed (so blur shadow covered
						// area is repainted)
						if (isActive()) {
							getNodeFigure().getUpdateManager().performUpdate();
						}
					}
				};
			}
		};
	}

	@Override
	protected void handleNotificationEvent(Notification notification) {

		if (notification.getFeature() == NotationPackage.Literals.DRAWER_STYLE__COLLAPSED) {

			if (isCollapsed()) {
				installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
						getNonResizableEditPolicyEx());

			} else {

				installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
						getResizableEditPolicyEx());
			}
			refreshVisuals();
		} else if (notification.getFeature() == SGraphPackage.Literals.NAMED_ELEMENT__NAME) {
			// ensure repaint is performed (so blur shadow covered area is
			// repainted) if LabelText changes state bounds
			getNodeFigure().getUpdateManager().performUpdate();
		}

		super.handleNotificationEvent(notification);
	}
}
