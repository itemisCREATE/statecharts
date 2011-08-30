/*******************************************************************************
 * Copyright (c) 2010  itemis AG (http://www.itemis.de)
 * All rights reserved. 
 * 
 * Contributors:
 *     itemis AG - initial API and implementation
 *******************************************************************************/
package org.yakindu.sct.ui.editor.pictogram;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.ImageFigure;
import org.eclipse.draw2d.Label;

/**
 * An image figure used to display a {@link Pictogram}.
 * 
 * @author Alexander Nyssen <a
 *         href="mailto:alexander.nyssen@itemis.de">alexander
 *         .nyssen@itemis.de</a>
 */
public class PictogramFigure extends ImageFigure {

	private static final int MIN_WIDTH = 50;

	private final IFigure hostFigure;

	public PictogramFigure(final Pictogram pictogram, IFigure hostFigure) {
		super(pictogram.getImage());
		this.hostFigure = hostFigure;
		Label tooltipLabel = new Label(pictogram.getDescription());
		tooltipLabel.setIcon(pictogram.getImage());
		setToolTip(tooltipLabel);
	}

	@Override
	public void paint(Graphics graphics) {
		if (hostFigure.getParent().isVisible()
				&& hostFigure.getBounds().width >= MIN_WIDTH) {
			graphics.pushState();
			if (isEnabled()) {
				super.paint(graphics);
			}
			graphics.popState();
		}
	}

	public IFigure getHostFigure() {
		return hostFigure;
	}

}
