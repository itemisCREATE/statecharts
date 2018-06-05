package org.yakindu.sct.ui.editor.editor.themes;

import org.eclipse.swt.graphics.Color;

public interface IStatechartsTheme {
	public abstract boolean getDrawStateShadows();
	public abstract boolean getDrawRegionShadows();
	public abstract boolean getTransitionExpressionOpaque();

	public abstract boolean getDrawStateBgGradient();
	public abstract boolean getDrawRegionBgGradient();

	public abstract int getStateBlurShadowWidth();
	public abstract int getRegionBlurShadowWidth();

	public abstract Color getCanvasBgColor();
	public abstract Color getStateBgColor();
	public abstract Color getRegionBgColor();

	public abstract Color getRegionOutlineColor();
	public abstract Color getStateOutlineColor();
}
