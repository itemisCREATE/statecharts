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

public class FlatTheme extends AbstractTheme {

	private static final Color STATE_OUTLINE_COLOR = new Color(null, 163, 163, 163);
	private static final Color REGION_OUTLINE_COLOR = new Color(null, 220, 220, 220);
	private static final Color STATE_BG_COLOR = new Color(null, 205, 220, 243);
	private static final Color CANVAS_BG_COLOR = new Color(null, 245, 245, 245);

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
		return CANVAS_BG_COLOR;
	}

	@Override
	public Color getStateBgColor() {
		return STATE_BG_COLOR;
	}

	@Override
	public Color getRegionBgColor() {
		return ColorConstants.white;
	}

	@Override
	public Color getRegionOutlineColor() {
		return REGION_OUTLINE_COLOR;
	}

	@Override
	public Color getInternalStateOutlineColor() {
		return STATE_OUTLINE_COLOR;
	}

	@Override
	public boolean getDrawRelativeStateOutline() {
		return true;
	}

	@Override
	public double getRelativeStateOutlineFactor() {
		return 0.85;
	}

	@Override
	public int getTransitionBendpointRadius() {
		return 10;
	}

}
