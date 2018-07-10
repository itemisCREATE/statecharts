/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.preferences;

import org.eclipse.gmf.runtime.diagram.ui.preferences.IPreferenceConstants;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public interface StatechartPreferenceConstants extends IPreferenceConstants {

	String PREF_STATE_BACKGROUND = "Appearance.state.background";
	String PREF_STATE_LINE = "Appearance.state.line";
	String PREF_REGION_BACKGROUND = "Appearance.region.background";
	String PREF_REGION_LINE = "Appearance.region.line";
	String PREF_PRIORITY_LABELS = "Appearance.transition.priority";
	String PREF_LIVE_VALIDATION = "Appearance.live.validation";
	String PREF_SYNTAX_COLORING = "Appearance.diagram.syntaxcoloring";
	String PREF_FONT_SCALING = "Appearance.diagram.fontscaling";
}
