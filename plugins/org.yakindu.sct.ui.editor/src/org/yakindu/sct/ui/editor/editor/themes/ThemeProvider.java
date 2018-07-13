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

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.yakindu.sct.ui.editor.DiagramActivator;
import org.yakindu.sct.ui.editor.preferences.StatechartPreferenceConstants;

public class ThemeProvider {

	public static final String CLASSIC_THEME = "Classic";
	public static final String FLAT_THEME = "Flat";

	protected Map<String, IStatechartsTheme> themes = new HashMap<>();

	protected static ThemeProvider instance;

	private ThemeProvider() {
		themes.put(CLASSIC_THEME, new ClassicTheme());
		themes.put(FLAT_THEME, new FlatTheme());
	}

	public static ThemeProvider getInstance() {
		if (instance == null) {
			instance = new ThemeProvider();
		}
		return instance;
	}

	public IStatechartsTheme getTheme() {
		IStatechartsTheme iStatechartsTheme = themes.get(DiagramActivator.getDefault().getPreferenceStore()
				.getString(StatechartPreferenceConstants.PREF_SCT_THEME));
		return iStatechartsTheme;
	}

	public Set<String> getThemes() {
		return themes.keySet();
	}
}
