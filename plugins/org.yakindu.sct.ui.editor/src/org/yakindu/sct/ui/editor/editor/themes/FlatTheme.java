package org.yakindu.sct.ui.editor.editor.themes;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.graphics.Color;

public class FlatTheme implements IStatechartsTheme {

	@Override
	public boolean getDrawStateShadows() {
		return false;
	}

	@Override
	public boolean getDrawRegionShadows() {
		return false;
	}

	@Override
	public boolean getTransitionExpressionOpaque() {
		return true;
	}

	@Override
	public boolean getDrawStateBgGradient() {
		return false;
	}

	@Override
	public boolean getDrawRegionBgGradient() {
		return false;
	}

	@Override
	public int getStateBlurShadowWidth() {
		return 0;
	}

	@Override
	public int getRegionBlurShadowWidth() {
		return 0;
	}

	@Override
	public Color getCanvasBgColor() {
		return new Color(null, 245, 245, 245);
	}

	@Override
	public Color getStateBgColor() {
		return new Color(null, 205, 220, 243);
	}

	@Override
	public Color getRegionBgColor() {
		return ColorConstants.white;
	}

	@Override
	public Color getRegionOutlineColor() {
		return ColorConstants.lightGray;
	}

	@Override
	public Color getStateOutlineColor() {
		return new Color(null, 163, 163, 163);
	}

}
