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
package org.yakindu.sct.examples.java.trafficlight;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.Figure;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.XYLayout;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * Draw2d figure for the crossing. Used by CrossingDemo. 
 * 
 * @author a.nyssen
 *
 */
public class CrossingFigure extends Figure {

	public CrossingFigure() {
		this.setLayoutManager(new XYLayout());

	}

	@Override
	protected void paintFigure(Graphics graphics) {
		Rectangle bounds = getBounds();

		graphics
				.setBackgroundColor(org.eclipse.draw2d.ColorConstants.lightGreen); // street
																					// is
																					// within
																					// countryside
																					// :-)
		graphics.fillRectangle(bounds);

		// paint street
		graphics.setBackgroundColor(ColorConstants.lightGray);
		graphics.fillRectangle(bounds.x + bounds.width / 3, bounds.y,
				bounds.width / 3, bounds.height);

		// paint crossing
		graphics.setBackgroundColor(ColorConstants.white);
		for (int i = 0; i <= 10; i += 2) {
			graphics.fillRectangle(bounds.x + bounds.width / 3 + i
					* bounds.width / 33, bounds.y + bounds.height / 11,
					bounds.width / 30, bounds.height / 10);
		}

	}
}
