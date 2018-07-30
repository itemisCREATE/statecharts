/**
 * Copyright (c) 2011 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package org.yakindu.base.gmf.runtime.figures;

import org.eclipse.draw2d.EllipseAnchor;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.gmf.runtime.gef.ui.figures.DefaultSizeNodeFigure;

/**
 * 
 * {@link DefaultSizeNodeFigure} with fixed anchors on the ellipse child
 * {@link EllipseAnchor} somehow places the transition arrow inside of the
 * figure, thus we calculate the pointlist here.
 * 
 * @author andreas muelder (andreas.muelder@itemis.de)
 * 
 */
public class EllipseAnchorDefaultSizeNodeFigure extends DefaultSizeNodeFigure {

	public EllipseAnchorDefaultSizeNodeFigure(Dimension defSize) {
		super(defSize);
	}

	@Override
	public PointList getPolygonPoints() {
		int points = 64;
		int radius = getSize().width / 2;
		Point center = getHandleBounds().getCenter();
		PointList pointList = new PointList();
		double slice = 2 * Math.PI / points;
		for (int i = 0; i < points; i++) {
			double angle = slice * i;
			int newX = (int) (center.x + radius * Math.cos(angle));
			int newY = (int) (center.y + radius * Math.sin(angle));
			Point p = new Point(newX, newY);
			pointList.addPoint(p);
		}
		return pointList;
	}
}
