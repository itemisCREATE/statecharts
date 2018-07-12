/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 *
 */

package org.yakindu.sct.ui.editor.editor.themes;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.swt.graphics.Color;

public class ClassicTheme extends AbstractTheme {
	private static final Color REGION_BG_COLOR = new Color(null, 240, 240, 240);
	private static final Color STATE_BG_COLOR = new Color(null, 205, 220, 243);

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
		// TODO constant static
		return STATE_BG_COLOR;
	}

	@Override
	public Color getRegionBgColor() {
		return REGION_BG_COLOR;
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
