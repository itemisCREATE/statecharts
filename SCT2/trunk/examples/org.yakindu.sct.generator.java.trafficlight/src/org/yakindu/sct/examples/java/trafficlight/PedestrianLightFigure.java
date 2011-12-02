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
import org.eclipse.draw2d.geometry.Insets;
import org.eclipse.draw2d.geometry.Rectangle;

/**
 * Draw2d figure for the pedestrian traffic light. Used by CrossingDemo. 
 * 
 * @author a.nyssen
 *
 */
public class PedestrianLightFigure extends Figure {

	boolean white = false;
	boolean red = false;
	boolean green = false;

	public boolean isWhite() {
		return white;
	}

	public void setWhite(boolean white) {
		this.white = white;
	}

	public boolean isRed() {
		return red;
	}

	public void setRed(boolean red) {
		this.red = red;
	}

	public boolean isGreen() {
		return green;
	}

	public void setGreen(boolean green) {
		this.green = green;
	}

	@Override
	protected void paintFigure(Graphics graphics) {
		Rectangle bounds = getBounds().getShrinked(new Insets(4, 4, 4, 4));

		graphics.setBackgroundColor(ColorConstants.darkGray);
		graphics.fillRectangle(getBounds());

		graphics.setBackgroundColor(white ? ColorConstants.white
				: ColorConstants.black);
		graphics.fillRectangle(bounds.x, bounds.y, bounds.width / 5,
				bounds.width / 5);

		graphics.setBackgroundColor(red ? ColorConstants.red
				: ColorConstants.black);
		graphics.fillOval(bounds.x + 2 * bounds.width / 5, bounds.y,
				bounds.width / 5, bounds.width / 5);

		graphics.setBackgroundColor(green ? ColorConstants.green
				: ColorConstants.black);
		graphics.fillOval(bounds.x + 4 * bounds.width / 5, bounds.y,
				bounds.width / 5, bounds.width / 5);

	}
}
