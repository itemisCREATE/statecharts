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
package org.yakindu.base.gmf.runtime.highlighting;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.graphics.Color;

/**
 * 
 * @author Alexander Nyssen
 * @author Andreas Muelder - removed grayscaling and fadingtime due to
 *         performance issues
 * 
 */
public class HighlightingParameters {

	public static final HighlightingParameters DEFAULT = new HighlightingParameters();

	public Color foregroundFadingColor = ColorConstants.red;

	public Color backgroundFadingColor = new Color(null, 245, 216, 0);

	public HighlightingParameters() {
	}

	public HighlightingParameters(Color foregroundFadingColor, Color backgroundFadingColor) {
		this.foregroundFadingColor = foregroundFadingColor;
		this.backgroundFadingColor = backgroundFadingColor;
	}

}