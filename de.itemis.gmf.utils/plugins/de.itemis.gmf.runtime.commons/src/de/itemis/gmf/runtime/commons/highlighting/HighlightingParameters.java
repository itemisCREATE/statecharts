package de.itemis.gmf.runtime.commons.highlighting;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.graphics.Color;

/**
 * 
 * @author Alexander Nyssen
 * 
 */
public class HighlightingParameters {

	public long fadingTime = 500;
	public Color foregroundFadingColor = ColorConstants.red;
	// light red
	public Color backgroundFadingColor = new Color(null, 255, 128, 128);

	public HighlightingParameters() {
	}

	public HighlightingParameters(long fadingTime, Color foregroundFadingColor,
			Color backgroundFadingColor) {
		this.fadingTime = fadingTime; // used for fade-in and fade-out
		this.foregroundFadingColor = foregroundFadingColor;
		this.backgroundFadingColor = backgroundFadingColor;
	}

}