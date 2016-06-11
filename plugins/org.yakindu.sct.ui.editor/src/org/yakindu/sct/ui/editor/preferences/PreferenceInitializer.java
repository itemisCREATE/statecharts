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
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.FontData;
import org.yakindu.sct.ui.editor.DiagramActivator;

/**
 * 
 * @author andreas muelder
 * 
 */
public class PreferenceInitializer extends DiagramPreferenceInitializer
		implements StatechartColorConstants {

	@Override
	public void initializeDefaultPreferences() {
		super.initializeDefaultPreferences();
		// Line colors
		Color lineColor = DiagramColorConstants.darkGray;
		PreferenceConverter.setDefault(getPreferenceStore(),
				IPreferenceConstants.PREF_LINE_COLOR, lineColor.getRGB());

		// rulers and grid defaults
		getPreferenceStore().setDefault(
				IPreferenceConstants.PREF_SNAP_TO_GEOMETRY, true);

		// set default font
		FontData defaultFont = new FontData("Verdana", 9, SWT.NONE);
		PreferenceConverter.setDefault(getPreferenceStore(),
				IPreferenceConstants.PREF_DEFAULT_FONT, defaultFont);

		// set preferences for tool palette.
		DefaultPaletteViewerPreferences prefs = new DefaultPaletteViewerPreferences();
		prefs.setLayoutSetting(DefaultPaletteViewerPreferences.LAYOUT_LIST);
		prefs.setCurrentUseLargeIcons(true);

		// State line and background color
		PreferenceConverter.setDefault(getPreferenceStore(),
				StatechartPreferenceConstants.PREF_STATE_BACKGROUND,
				StatechartColorConstants.STATE_BG_COLOR.getRGB());
		PreferenceConverter.setDefault(getPreferenceStore(),
				StatechartPreferenceConstants.PREF_STATE_LINE,
				StatechartColorConstants.STATE_LINE_COLOR.getRGB());

		// Region fill color
		PreferenceConverter.setDefault(getPreferenceStore(),
				StatechartPreferenceConstants.PREF_REGION_BACKGROUND,
				StatechartColorConstants.REGION_BG_COLOR.getRGB());
		PreferenceConverter.setDefault(getPreferenceStore(),
				StatechartPreferenceConstants.PREF_REGION_LINE,
				StatechartColorConstants.REGION_LINE_COLOR.getRGB());
		
		//Transition Priority Labels
		getPreferenceStore().setDefault(
				StatechartPreferenceConstants.PREF_PRIORITY_LABELS, false);
		

	}

	@Override
	protected IPreferenceStore getPreferenceStore() {
		return DiagramActivator.getDefault().getPreferenceStore();
	}

}
