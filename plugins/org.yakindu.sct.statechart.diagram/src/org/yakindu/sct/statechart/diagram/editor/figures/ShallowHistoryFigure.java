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
package org.yakindu.sct.statechart.diagram.editor.figures;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;

public class ShallowHistoryFigure extends Ellipse {

	public ShallowHistoryFigure() {
		this.setSize(new Dimension(10, 10));
		this.setForegroundColor(org.eclipse.draw2d.ColorConstants.black);
		this.setBackgroundColor(org.eclipse.draw2d.ColorConstants.white);
	}

	/**
	 * @see org.eclipse.draw2d.Ellipse#outlineShape(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void outlineShape(Graphics graphics) {
		super.outlineShape(graphics);

		// draw the 'H' letter
		graphics.drawLine(
				bounds.getCenter().getTranslated((int) (-bounds.width * 0.15), (int) (-bounds.height * 0.25)), bounds
						.getCenter().getTranslated((int) (-bounds.width * 0.15), (int) (bounds.height * 0.25)));
		graphics.drawLine(bounds.getCenter().getTranslated((int) (bounds.width * 0.15), (int) (-bounds.height * 0.25)),
				bounds.getCenter().getTranslated((int) (bounds.width * 0.15), (int) (bounds.height * 0.25)));
		graphics.drawLine(bounds.getCenter().getTranslated((int) (-bounds.width * 0.15), 0), bounds.getCenter()
				.getTranslated((int) (bounds.width * 0.15), 0));
	}
}