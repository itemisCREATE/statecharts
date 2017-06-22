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
package org.yakindu.sct.simulation.ui.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.draw2d.ColorConstants;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.preference.PreferenceConverter;
import org.eclipse.swt.graphics.Color;

import org.yakindu.sct.simulation.ui.SimulationActivator;
import static org.yakindu.sct.simulation.ui.preferences.SimulationPreferenceConstants.*;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author axel terfloth - extensions
 *
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	public void initializeDefaultPreferences() {
		IPreferenceStore store = SimulationActivator.getDefault()
				.getPreferenceStore();
		PreferenceConverter.setDefault(store,
				STATE_FOREGROUND_HIGHLIGHTING_COLOR,
				new Color(null,255,128,0).getRGB());

		PreferenceConverter.setDefault(store,
				STATE_BACKGROUND_HIGHLIGHTING_COLOR, new Color(null,245,216,44).getRGB());

		PreferenceConverter.setDefault(store,
				VERTEX_FOREGROUND_TRANSIENT_COLOR, new Color(null, 255,128,0).getRGB());

		PreferenceConverter.setDefault(store,
				VERTEX_BACKGROUND_TRANSIENT_COLOR, new Color(null,245,216,44).getRGB());

		PreferenceConverter.setDefault(store, TRANSITION_HIGHLIGHTING_COLOR,
				new Color(null, 255,128,0).getRGB());
	}
}
