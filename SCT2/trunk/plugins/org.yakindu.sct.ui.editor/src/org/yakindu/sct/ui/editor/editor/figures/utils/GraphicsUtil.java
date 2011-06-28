/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 *     
 *     Axel Terfloth
 *
 */
package org.yakindu.sct.ui.editor.editor.figures.utils;

import org.eclipse.draw2d.Graphics;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Path;

/**
 * 
 * @author Axel Terfloth
 */
public class GraphicsUtil {

	
	/**
	 * This function fills a rectangle with a vertical gradient. This implementation does not use the 
	 * gradient mechanism based on background patterns since they do not work stable on all systems.
	 *   
	 * @param graphics
	 * @param bounds
	 * @param c1
	 * @param c2
	 */
	public static void fillVerticalGradientRectangle(Graphics graphics, Rectangle bounds, Color c1, Color c2) {
		
		graphics.pushState();
		
		graphics.setForegroundColor(c2);
		graphics.setBackgroundColor(c1);
				
		graphics.fillGradient(bounds.x, bounds.y, bounds.width, bounds.height, true);
						
		graphics.popState();
	}

	

	/**
	 * This function fills a rounded rectangle with a vertical gradient. This
	 * implementation does not use the gradient mechanism based on background
	 * patterns since they do not work stable on all systems.
	 * 
	 * @param graphics
	 * @param bounds
	 * @param corner
	 * @param c1
	 * @param c2
	 */
	public static void fillVerticalGradientRoundedRectangle(Graphics graphics, Rectangle bounds, Dimension corner,
			Color c1, Color c2) {

		graphics.pushState();

		graphics.setForegroundColor(c2);
		graphics.setBackgroundColor(c1);

		graphics.fillGradient(bounds.x, bounds.y + (corner.height >> 1), bounds.width, bounds.height - corner.height,
				true);

		Path p = new Path(null);
		p.addArc(bounds.x, bounds.y + bounds.height - corner.height - 1, corner.width, corner.height, 180, 90);
		p.addArc(bounds.x + bounds.width - corner.width - 1, bounds.y + bounds.height - corner.height - 1,
				corner.width, corner.height, 270, 90);
		graphics.fillPath(p);
		p.dispose();

		p = new Path(null);
		graphics.setBackgroundColor(c2);
		p.addArc(bounds.x + bounds.width - corner.width - 1, bounds.y, corner.width, corner.height, 0, 90);
		p.addArc(bounds.x, bounds.y, corner.width, corner.height, 90, 90);
		graphics.fillPath(p);
		p.dispose();

		graphics.popState();
	}

	/**
	 * Calculates a mixed color from two colors by interpolating the rgb parts
	 * using a mix ratio.
	 * 
	 * @param baseColor
	 * @param mixinColor
	 * @param ratio
	 *            a value from 0 to 255 that defines the mix ratio. Using 0 will
	 *            return the base color and 255 the mixin color.
	 * @return
	 */
	public static Color mixColor(Color baseColor, Color mixinColor, int ratio) {
		return new Color(baseColor.getDevice(), baseColor.getRed() + (mixinColor.getRed() - baseColor.getRed()) * ratio
				/ 255, baseColor.getGreen() + (mixinColor.getGreen() - baseColor.getGreen()) * ratio / 255,
				baseColor.getBlue() + (mixinColor.getBlue() - baseColor.getBlue()) * ratio / 255);
	}
}
