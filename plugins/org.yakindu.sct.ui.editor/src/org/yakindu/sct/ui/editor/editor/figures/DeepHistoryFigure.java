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
package org.yakindu.sct.ui.editor.editor.figures;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;

public class DeepHistoryFigure extends Ellipse {

	private static final double OFFSET = 0.05;
	private static final double HEIGHT_RATIO = 0.25;
	private static final double WIDTH_RATIO = 0.25;

	public DeepHistoryFigure() {
		this.setSize(new Dimension(10, 10));
	}

	@Override
	protected void outlineShape(Graphics graphics) {
		graphics.pushState();
		//Outline with foreground
		graphics.setForegroundColor(getBackgroundColor());
		super.outlineShape(graphics);
		// draw the 'H' letter
		graphics.setForegroundColor(getForegroundColor());
		graphics.setBackgroundColor(getBackgroundColor());
		graphics.drawLine(
				bounds.getCenter().getTranslated((int) (-bounds.width * WIDTH_RATIO), (int) (-bounds.height * HEIGHT_RATIO)), bounds
						.getCenter().getTranslated((int) (-bounds.width * WIDTH_RATIO), (int) (bounds.height * HEIGHT_RATIO)));
		graphics.drawLine(bounds.getCenter().getTranslated((int) (bounds.width * OFFSET), (int) (-bounds.height * HEIGHT_RATIO)),
				bounds.getCenter().getTranslated((int) (bounds.width * OFFSET), (int) (bounds.height * HEIGHT_RATIO)));
		graphics.drawLine(bounds.getCenter().getTranslated((int) (-bounds.width * WIDTH_RATIO), 0), bounds.getCenter()
				.getTranslated((int) (bounds.width * OFFSET), 0));

		// draw the '*' character
		graphics.drawLine(bounds.getCenter().getTranslated((int) (bounds.width * WIDTH_RATIO), (int) (-bounds.height * HEIGHT_RATIO)),
				bounds.getCenter().getTranslated((int) (bounds.width * WIDTH_RATIO), (int) (-bounds.height * OFFSET)));
		graphics.drawLine(bounds.getCenter().getTranslated((int) (bounds.width * 0.15), (int) (-bounds.height * 0.20)),
				bounds.getCenter().getTranslated((int) (bounds.width * 0.35), (int) (-bounds.height * 0.10)));
		graphics.drawLine(bounds.getCenter().getTranslated((int) (bounds.width * 0.35), (int) (-bounds.height * 0.20)),
				bounds.getCenter().getTranslated((int) (bounds.width * 0.15), (int) (-bounds.height * 0.10)));
		graphics.popState();
	}
}