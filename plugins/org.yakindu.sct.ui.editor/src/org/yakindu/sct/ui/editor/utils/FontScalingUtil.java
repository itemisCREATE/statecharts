package org.yakindu.sct.ui.editor.utils;

import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.widgets.Display;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.preferences.StatechartPreferenceConstants;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class FontScalingUtil {

	private static final int WINDOWS_DEFAULT_DPI = 96;

	public static FontData scaleFont(FontData fontData) {
		return scaleFont(fontData, 0);
	}

	public static FontData scaleFont(FontData fontData, int style) {
		if (DiagramActivator.getDefault().getPreferenceStore()
				.getBoolean(StatechartPreferenceConstants.PREF_FONT_SCALING)) {
			return fontData;
		}
		int DPI = Display.getCurrent().getDPI().y;
		if (DPI != WINDOWS_DEFAULT_DPI) {
			double factor = (double) WINDOWS_DEFAULT_DPI / DPI;
			return new FontData(fontData.getName(), (int) (fontData.getHeight() * factor), fontData.getStyle() | style);
		}
		return fontData;

	}
}
