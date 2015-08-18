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
package org.yakindu.gmf.runtime.figures;

import org.eclipse.draw2d.AbstractConnectionAnchor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;

public class FixedConnectionAnchor extends AbstractConnectionAnchor {

	private final double xOffset;
	private final double yOffset;

	public FixedConnectionAnchor(IFigure owner, PrecisionPoint offset) {
		this(owner, offset.preciseX(), offset.preciseY());
	}

	public FixedConnectionAnchor(IFigure owner, double xOffset, double yOffset) {
		super(owner);
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}

	public Point getLocation(Point point) {
		return getLocation();
	}

	public Point getLocation() {
		Rectangle r = getOwner().getBounds();
		Point p = new PrecisionPoint(r.x + r.width * xOffset, r.y + r.height
				* yOffset);
		getOwner().translateToAbsolute(p);
		return p;
	}

}
