package org.yakindu.sct.ui.editor.utils;

import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class FontScalingUtil {

	public static FontData scaleFont(FontData fontData) {
		return scaleFont(fontData, 0);
	}

	public static FontData scaleFont(FontData fontData, int style) {
		int DPI = Display.getCurrent().getDPI().y;
		if (DPI != 96) {
			double factor = (double) 96 / DPI;
			return new FontData(fontData.getName(), (int) (fontData.getHeight() * factor), fontData.getStyle() | style);
		}
		return fontData;

	}
}
