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

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.Shape;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;

public class ChoiceFigure extends Shape {

	public ChoiceFigure() {
		this.setSize(new Dimension(15, 15));
		setLineWidth(2);
	}

	/**
	 * @see org.eclipse.draw2d.Shape#fillShape(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void fillShape(Graphics graphics) {
		graphics.pushState();
		graphics.setForegroundColor(getForegroundColor());
		graphics.setBackgroundColor(getBackgroundColor());
		PointList pl = new PointList();
		pl.addPoint(getBounds().getTop());
		pl.addPoint(getBounds().getRight());
		pl.addPoint(getBounds().getBottom());
		pl.addPoint(getBounds().getLeft());
		graphics.fillPolygon(pl);
		graphics.popState();
	}

	/**
	 * @see org.eclipse.draw2d.Shape#outlineShape(org.eclipse.draw2d.Graphics)
	 */
	@Override
	protected void outlineShape(Graphics graphics) {
		graphics.pushState();
		graphics.setForegroundColor(getForegroundColor());
		graphics.setBackgroundColor(getBackgroundColor());
		Rectangle f = Rectangle.SINGLETON;
		Rectangle r = getBounds();
		f.x = r.x + getLineWidth() / 2;
		f.y = r.y + getLineWidth() / 2;
		f.width = r.width - getLineWidth() - 1;
		f.height = r.height - getLineWidth() - 1;

		PointList pl = new PointList();
		pl.addPoint(f.getTop());
		pl.addPoint(f.getRight());
		pl.addPoint(f.getBottom());
		pl.addPoint(f.getLeft());

		graphics.drawPolygon(pl);
		graphics.popState();
	}

}