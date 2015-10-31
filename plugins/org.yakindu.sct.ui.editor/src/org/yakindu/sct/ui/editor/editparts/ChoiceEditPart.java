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

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;
import org.eclipse.gmf.runtime.gef.ui.figures.NodeFigure;
import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.base.gmf.runtime.editparts.FixedSizeShapeNodeEditPart;
import org.yakindu.sct.ui.editor.editor.figures.ChoiceFigure;
import org.yakindu.sct.ui.editor.editor.figures.utils.MapModeUtils;
import org.yakindu.sct.ui.editor.policies.EnlargeContainerEditPolicy;
import org.yakindu.sct.ui.editor.policies.FeedbackGraphicalNodeEditPolicy;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ChoiceEditPart extends FixedSizeShapeNodeEditPart {

	public ChoiceEditPart(View view) {
		super(view);
	}

	@Override
	protected void createDefaultEditPolicies() {
		super.createDefaultEditPolicies();
		installEditPolicy(EnlargeContainerEditPolicy.ROLE, new EnlargeContainerEditPolicy());
		installEditPolicy(EditPolicy.GRAPHICAL_NODE_ROLE, new FeedbackGraphicalNodeEditPolicy());
	}

	@Override
	protected NodeFigure createNodeFigure() {
		final NodeFigure figure = new DefaultSizeNodeFigure(getDefaultSize()) {
			@Override
			public PointList getPolygonPoints() {
				PointList points = new PointList(5);
				Rectangle handleBounds = getHandleBounds();
				points.addPoint(handleBounds.x + (handleBounds.width / 2), handleBounds.y);
				points.addPoint(handleBounds.x + handleBounds.width, handleBounds.y + (handleBounds.height / 2));
				points.addPoint(handleBounds.x + (handleBounds.width / 2), handleBounds.y + handleBounds.height);
				points.addPoint(handleBounds.x, handleBounds.y + handleBounds.height / 2);
				points.addPoint(handleBounds.x + (handleBounds.width / 2), handleBounds.y);
				return points;
			}
		};
		figure.setLayoutManager(getLayoutManager());
		figure.add(createPrimaryShape());
		figure.setBackgroundColor(org.eclipse.draw2d.ColorConstants.white);
		figure.setForegroundColor(org.eclipse.draw2d.ColorConstants.black);
		return figure;
	}

	@Override
	public Dimension getDefaultSize() {
		return MapModeUtils.getMappedDimensions(getMapMode(), MapModeUtils.DEFAULT_SMALL_NODE_DIMENSION);
	}

	@Override
	public IFigure createPrimaryShape() {
		return new ChoiceFigure();
	}

}
