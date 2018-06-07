package org.yakindu.sct.ui.editor.editor.themes;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.graphics.Color;

public class ClassicTheme extends AbstractTheme {
	@Override
	public boolean getDrawStateShadows() {
		return true;
	}

	@Override
	public boolean getDrawRegionShadows() {
		return false;
	}

	@Override
	public boolean getTransitionExpressionOpaque() {
		return false;
	}

	@Override
	public boolean getDrawStateBgGradient() {
		return true;
	}

	@Override
	public boolean getDrawRegionBgGradient() {
		return true;
	}

	@Override
	public int getStateBlurShadowWidth() {
		return 5;
	}

	@Override
	public int getRegionBlurShadowWidth() {
		return 0;
	}

	@Override
	public Color getCanvasBgColor() {
		return ColorConstants.white;
	}

	@Override
	public Color getStateBgColor() {
		return new Color(null, 205, 220, 243);
	}

	@Override
	public Color getRegionBgColor() {
		return new Color(null, 240, 240, 240);
	}

	@Override
	public Color getRegionOutlineColor() {
		return ColorConstants.lightGray;
	}

	@Override
	public Color getInternalStateOutlineColor() {
		return ColorConstants.lightGray;
	}

	@Override
	public boolean getDrawRelativeStateOutline() {
		return false;
	}

	@Override
	public double getRelativeStateOutlineFactor() {
		return 0;
	}

}
