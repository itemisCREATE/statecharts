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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.StackLayout;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.gef.EditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ShapeNodeEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.FigureUtilities;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.ui.editor.editor.figures.StateFigure;
import org.yakindu.sct.ui.editor.editor.figures.utils.MapModeUtils;
import org.yakindu.sct.ui.editor.preferences.StatechartColorConstants;

/**
 * Base class for {@link StateEditPart}s and {@link SubmachineStateEditPart}s
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractStateEditPart extends ShapeNodeEditPart {

	public AbstractStateEditPart(View view) {
		super(view);
	}

	@Override
	protected NodeFigure createNodeFigure() {
		final NodeFigure figure = new DefaultSizeNodeFigure(getDefaultSize());
		figure.setLayoutManager(new StackLayout());
		figure.setMinimumSize(MapModeUtils
				.getDefaultSizeDimension(getMapMode()));
		figure.add(createPrimaryShape());
		return figure;
	}

	protected Dimension getDefaultSize() {
		return MapModeUtils.getDefaultSizeDimension(getMapMode());
	}

	public StateFigure createPrimaryShape() {
		return new StateFigure(getMapMode());
	}

	public StateFigure getPrimaryShape() {
		return (StateFigure) getFigure().getChildren().get(0);
	}

	@Override
	protected void addChildVisual(EditPart childEditPart, int index) {
		if (childEditPart instanceof StateNameEditPart) {
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

	@Override
	protected void handleNotificationEvent(Notification notification) {
		if (notification.getFeature() == NotationPackage.Literals.DRAWER_STYLE__COLLAPSED) {
			refreshVisuals();
		}
		super.handleNotificationEvent(notification);
	}
}
