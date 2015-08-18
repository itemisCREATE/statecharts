/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.gmf.runtime.highlighting;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.graphics.Color;

/**
 * 
 * @author Alexander Nyssen
 * 
 */
public class HighlightingParameters {

	public static final HighlightingParameters DEFAULT = new HighlightingParameters();
	
	public long fadingTime = 500;
	public Color foregroundFadingColor = ColorConstants.red;
	// light red
	public Color backgroundFadingColor = new Color(null, 255, 128, 128);

	public boolean grayScale = false;

	public HighlightingParameters() {
	}

	public HighlightingParameters(long fadingTime, Color foregroundFadingColor,
			Color backgroundFadingColor, boolean grayScale) {
		this.fadingTime = fadingTime; // used for fade-in and fade-out
		this.foregroundFadingColor = foregroundFadingColor;
		this.backgroundFadingColor = backgroundFadingColor;
		this.grayScale = grayScale;
	}

}