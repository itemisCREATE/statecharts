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
package org.yakindu.sct.ui.editor.editor.figures;

import org.eclipse.draw2d.Ellipse;
import org.eclipse.draw2d.Graphics;
import org.eclipse.gmf.runtime.draw2d.ui.mapmode.IMapMode;
import org.eclipse.swt.graphics.Path;
import org.eclipse.swt.widgets.Display;

/**
 * 
 * @author andreas muelder
 * @author axel terfloth
 * 
 */
public class ExitFigure extends Ellipse {

	@SuppressWarnings("unused")
	private IMapMode mapMode;

	public ExitFigure(IMapMode mapMode) {
		this.mapMode = mapMode;
		this.setLineWidth(2);
	}

	@Override
	public void paint(Graphics graphics) {
		graphics.pushState();
		graphics.setForegroundColor(getForegroundColor());
		graphics.setBackgroundColor(getBackgroundColor());
		super.paint(graphics);
		Path path = new Path(Display.getDefault());
		path.addArc(getBounds().x, getBounds().y, getBounds().width - 1, getBounds().height - 1, 0, 360);
		graphics.setClip(path);
		graphics.setLineWidth(2);
		graphics.drawLine(bounds.getTopLeft(), bounds.getBottomRight());
		graphics.drawLine(bounds.getTopRight(), bounds.getBottomLeft());
		path.dispose();
		graphics.popState();
	}
}
