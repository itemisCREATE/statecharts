/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 *
 */
package org.yakindu.sct.ui.editor.preferences;

import org.eclipse.gef.ui.palette.DefaultPaletteViewerPreferences;
import org.eclipse.gmf.runtime.diagram.ui.figures.DiagramColorConstants;
import org.eclipse.gmf.runtime.diagram.ui.preferences.DiagramPreferenceInitializer;
import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;
import org.eclipse.gmf.runtime.notation.Routing;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.FontData;
import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.editor.themes.IStatechartsTheme;
import org.yakindu.sct.ui.editor.editor.themes.ThemeProvider;

/**
 *
 * @author andreas muelder
 *
 */
public class PreferenceInitializer extends DiagramPreferenceInitializer {
	@Override
	public void initializeDefaultPreferences() {

		super.initializeDefaultPreferences();
		IStatechartsTheme theme = ThemeProvider.getInstance().getTheme();
		// Line colors
		Color lineColor = DiagramColorConstants.darkGray;
		PreferenceConverter.setDefault(getPreferenceStore(), IPreferenceConstants.PREF_LINE_COLOR, lineColor.getRGB());

		getPreferenceStore().setDefault(IPreferenceConstants.PREF_LINE_STYLE, Routing.RECTILINEAR);

		// rulers and grid defaults
		getPreferenceStore().setDefault(IPreferenceConstants.PREF_SNAP_TO_GEOMETRY, true);

		// set default font
		FontData defaultFont = new FontData("Verdana", 9, SWT.NONE);
		PreferenceConverter.setDefault(getPreferenceStore(), IPreferenceConstants.PREF_DEFAULT_FONT, defaultFont);

		// set preferences for tool palette.
		DefaultPaletteViewerPreferences prefs = new DefaultPaletteViewerPreferences();
		prefs.setLayoutSetting(DefaultPaletteViewerPreferences.LAYOUT_LIST);
		prefs.setCurrentUseLargeIcons(true);

		// State line and background color
		PreferenceConverter.setDefault(getPreferenceStore(), StatechartPreferenceConstants.PREF_STATE_BACKGROUND,
				theme.getStateBgColor().getRGB());
		PreferenceConverter.setDefault(getPreferenceStore(), StatechartPreferenceConstants.PREF_STATE_LINE,
				theme.getStateOutlineColor().getRGB());

		// Region fill color
		PreferenceConverter.setDefault(getPreferenceStore(), StatechartPreferenceConstants.PREF_REGION_BACKGROUND,
				theme.getRegionBgColor().getRGB());
		PreferenceConverter.setDefault(getPreferenceStore(), StatechartPreferenceConstants.PREF_REGION_LINE,
				theme.getRegionOutlineColor().getRGB());

		// Transition Priority Labels
		getPreferenceStore().setDefault(StatechartPreferenceConstants.PREF_PRIORITY_LABELS, true);
		// Live validation
		getPreferenceStore().setDefault(StatechartPreferenceConstants.PREF_LIVE_VALIDATION, true);
		// Syntax coloring
		getPreferenceStore().setDefault(StatechartPreferenceConstants.PREF_SYNTAX_COLORING, false);
		//Font scaling
		getPreferenceStore().setDefault(StatechartPreferenceConstants.PREF_FONT_SCALING, false);

		// Theme
		getPreferenceStore().setDefault(StatechartPreferenceConstants.PREF_SCT_THEME, ThemeProvider.CLASSIC_THEME);

	}

	@Override
	protected IPreferenceStore getPreferenceStore() {
		return DiagramActivator.getDefault().getPreferenceStore();
	}

}
