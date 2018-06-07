package org.yakindu.sct.ui.editor.editor.themes;

import org.eclipse.swt.graphics.Color;

public interface IStatechartsTheme {
	/** Draw state shadows */
	public boolean getDrawStateShadows();

	/** Draw region shadows */
	public boolean getDrawRegionShadows();

	/** Opaque (white) background for transition expression labels */
	public boolean getTransitionExpressionOpaque();
	/** Radius of transition bendpoints - no bend when 0 */
	public int getTransitionBendpointRadius();

	/**
	 * Overrides the state outline color and automatically calculates the
	 * outline color, using the factor specified in
	 * {@link #getRelativeStateOutlineFactor()}.
	 */
	public boolean getDrawRelativeStateOutline();
	/** The factor used to darken the states bg color in the HSL color space */
	public double getRelativeStateOutlineFactor();

	/** Fill states with a gradient instead of a solid color */
	public boolean getDrawStateBgGradient();
	/** Fill regions with a gradient instead of a solid color */
	public boolean getDrawRegionBgGradient();

	/**
	 * Blur width of the state shadow Only active with
	 * {@link #getDrawStateShadows()}
	 */
	public int getStateBlurShadowWidth();
	/**
	 * Blur width of the region shadow Only active with
	 * {@link #getDrawRegionShadows()}
	 */
	public int getRegionBlurShadowWidth();

	/** Background color of the canvas on which regions are drawn */
	public Color getCanvasBgColor();
	/** Background / fill color of states */
	public Color getStateBgColor();
	/** Background / fill color of regions */
	public Color getRegionBgColor();

	/** Outline color of regions */
	public Color getRegionOutlineColor();
	/**
	 * Outline color of states overridden by
	 * {@link #getDrawRelativeStateOutline()}
	 */
	public Color getStateOutlineColor();

	/**
	 * Helper method to generate the outline color when
	 * {@link #getDrawRelativeStateOutline()} returns true
	 */
	public Color getStateOutlineColor(Color stateBgColor);
}
