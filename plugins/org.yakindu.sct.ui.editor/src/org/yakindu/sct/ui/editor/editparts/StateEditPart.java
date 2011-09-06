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

import java.util.Collections;
import java.util.List;

import org.eclipse.draw2d.GridData;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.GroupRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IPrimaryEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.CreationEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.NonResizableEditPolicyEx;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableEditPolicyEx;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.Compartment;
import org.eclipse.gmf.runtime.notation.Node;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.ui.editor.editor.figures.StateFigure;
import org.yakindu.sct.ui.editor.editor.figures.utils.GridDataFactory;
import org.yakindu.sct.ui.editor.pictogram.PictogramEditPolicy;
import org.yakindu.sct.ui.editor.pictogram.SubchartPictogram;

/**
 * The EditPart for the State.
 * 
 * 
 * @author andreas muelder
 * @author alexander nyssen
 * @author markus muehlbrandt
 * 
 */
public class StateEditPart extends AbstractStateEditPart implements
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
		installEditPolicy(PictogramEditPolicy.ROLE, new PictogramEditPolicy(
				Collections.singletonList(new SubchartPictogram())));

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

	@Override
	protected void refreshBounds() {
		// mark all figures covered by the blur shadow extended bounds as dirty
		// (an update is enforced at the end of this method to ensure the area
		// gets repainted)
		NodeFigure nodeFigure = getNodeFigure();
		Rectangle extendedBlurShadowBounds = nodeFigure.getBounds()
				.getExpanded(new Insets(StateFigure.BLUR_SHADOW_WIDTH));
		nodeFigure.translateToAbsolute(extendedBlurShadowBounds);
		markDirtyIfIntersecting(
				org.eclipse.draw2d.FigureUtilities.getRoot(nodeFigure),
				extendedBlurShadowBounds);

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
			// TODO: Calculate the 'default' size
			((GraphicalEditPart) getParent()).setLayoutConstraint(this,
					getFigure(), new Rectangle(loc, new Dimension(58, 66)));
			installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
					new NonResizableEditPolicyEx());
		} else {
			((GraphicalEditPart) getParent()).setLayoutConstraint(this,
					getFigure(), new Rectangle(loc, size));
			installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
					new ResizableEditPolicyEx());
		}

		// ensure repaint is performed (so blur shadow covered area is
		// repainted)
		nodeFigure.getUpdateManager().performUpdate();
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
		} 
//		else if (childEditPart instanceof SubmachineStateNameEditPart) {
//			((SubmachineStateNameEditPart) childEditPart)
//					.setLabel(getPrimaryShape().getNameFigure());
//		} 
		else {
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

}
