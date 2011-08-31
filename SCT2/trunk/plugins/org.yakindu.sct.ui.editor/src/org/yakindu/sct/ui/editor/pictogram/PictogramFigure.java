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
 * @author Alexander Nyssen
 */
public class PictogramFigure extends ImageFigure {

	private static final int ENABLED_ALPHA_VALUE = 255;

	private static final int DISABLED_ALPHA_VALUE = 20;

	private static final int MIN_WIDTH = 50;

	private final IFigure hostFigure;

	public PictogramFigure(final Pictogram pictogram, IFigure hostFigure) {
		super(pictogram.getImage());
		this.hostFigure = hostFigure;
		setToolTip(new Label(pictogram.getDescription()));
	}

	@Override
	public void paint(Graphics graphics) {

		if (hostFigure.getParent().isVisible()
				&& hostFigure.getBounds().width >= MIN_WIDTH) {
			graphics.pushState();
			graphics.setAlpha(isEnabled() ? ENABLED_ALPHA_VALUE
					: DISABLED_ALPHA_VALUE);
			super.paint(graphics);
			graphics.popState();
		}
	}

	public IFigure getHostFigure() {
		return hostFigure;
	}

}
