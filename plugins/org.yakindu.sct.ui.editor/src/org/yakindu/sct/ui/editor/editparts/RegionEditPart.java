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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConstrainedToolbarLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.EditPolicyRoles;
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.ui.editor.editor.figures.RegionFigure;
import org.yakindu.sct.ui.editor.policies.NoOverlapResizableEditPolicy;
import org.yakindu.sct.ui.editor.preferences.StatechartColorConstants;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class RegionEditPart extends ShapeNodeEditPart {

	public RegionEditPart(View view) {
		super(view);
	}

	@Override
	protected NodeFigure createNodeFigure() {
		final NodeFigure figure = new NodeFigure();
		figure.setLayoutManager(new StackLayout());
		figure.setMinimumSize(new Dimension(0, 0));
		figure.add(new RegionFigure(getMapMode()));
		return figure;
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		removeEditPolicy(EditPolicyRoles.CONNECTION_HANDLES_ROLE);
		installEditPolicy(EditPolicy.LAYOUT_ROLE,
				new ConstrainedToolbarLayoutEditPolicy() {
					@Override
					protected Command getAutoSizeCommand(Request request) {
						return UnexecutableCommand.INSTANCE;
					}
				});
		installEditPolicy(EditPolicy.PRIMARY_DRAG_ROLE,
				new NoOverlapResizableEditPolicy() {

					@SuppressWarnings("unchecked")
					protected boolean isRequestValid(ChangeBoundsRequest request) {
						// Overlapping of nodes is not allowed
						final IGraphicalEditPart parent = (IGraphicalEditPart) getHost()
								.getParent();
						final Rectangle newBounds = request
								.getTransformedRectangle(getHostFigure()
										.getBounds());
						final List<IGraphicalEditPart> children = parent
								.getChildren();
						for (final IGraphicalEditPart child : children) {

							if (!(child instanceof RegionEditPart)
									&& child.getFigure().getBounds()
											.intersects(newBounds)) {
								Rectangle intersection = child.getFigure()
										.getBounds().getIntersection(newBounds);
								// allow snapping to StatechartTextEditPart
								if (intersection.width() > 1
										&& intersection.height() > 1) {
									return false;
								}
							}
						}
						return true;
					}

				});
	}

	@Override
	public EditPart getTargetEditPart(Request request) {

		if (RequestConstants.REQ_PASTE.equals(request.getType().toString())) {
			for (Object object : getChildren()) {
				if (object instanceof RegionCompartmentEditPart) {
					return (EditPart) object;
				}
			}
		}
		return super.getTargetEditPart(request);
	}

	@Override
	public IFigure getContentPane() {
		return getPrimaryShape().getCompartmentPane();
	}

	private RegionFigure getPrimaryShape() {
		return (RegionFigure) getFigure().getChildren().get(0);
	}

	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (childEditPart instanceof RegionCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getCompartmentPane();
			pane.setLayoutManager(new StackLayout());
			IFigure figure2 = ((RegionCompartmentEditPart) childEditPart)
					.getFigure();
			pane.add(figure2);
		} else if (childEditPart instanceof RegionNameEditPart) {
			((RegionNameEditPart) childEditPart).setLabel(getPrimaryShape()
					.getNameLabel());
		} else
			super.addChildVisual(childEditPart, index);
	}

	@Override
	protected void removeChildVisual(EditPart childEditPart) {
		if (childEditPart instanceof RegionCompartmentEditPart) {
			IFigure pane = getPrimaryShape().getCompartmentPane();
			IFigure figure = ((RegionCompartmentEditPart) childEditPart)
					.getFigure();
			pane.remove(figure);
		} else
			super.removeChildVisual(childEditPart);
	}

	/**
	 * Returns the default background color for states
	 */
	@Override
	public Object getPreferredValue(EStructuralFeature feature) {
		if (feature == NotationPackage.eINSTANCE.getLineStyle_LineColor()) {
			return FigureUtilities
					.RGBToInteger(StatechartColorConstants.REGION_LINE_COLOR
							.getRGB());
		} else if (feature == NotationPackage.eINSTANCE
				.getFillStyle_FillColor()) {
			return FigureUtilities
					.RGBToInteger(StatechartColorConstants.REGION_BG_COLOR
							.getRGB());
		}
		return super.getPreferredValue(feature);
	}
}
